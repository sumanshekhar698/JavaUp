package dev.codecounty.java.design_patterns.singelton;

import java.io.Serial;
import java.io.Serializable;

public class PrimeMinister implements Serializable, Cloneable {

    //    private static PrimeMinister instance;
    private static volatile PrimeMinister instance;//volatile keyword to ensure visibility of changes made by one thread to other threads immediately.

//    eager loading
//    private static PrimeMinister instance = new PrimeMinister("Narendra Modi", "BJP");

    private String name;
    private String party;

    private PrimeMinister() {
        if (instance != null) {//Prevent from the reflection API
            throw new RuntimeException("Use getInstance() method to create legally");
        }
        // Private constructor to prevent external instantiation
    }

    private PrimeMinister(String name, String party) {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create legally");
        }
        this.name = name;
        this.party = party;
    }


/*    public static synchronized PrimeMinister getInstance() {
        if (instance == null) {
            instance = new PrimeMinister();
        }
        return instance;
    }*/

    //    public synchronized static PrimeMinister getInstance() {//method level synchronization
    public static PrimeMinister getInstance(String name, String party) {//lazy loading using block level synchronization

        //code here
        // Double-check locking for thread safety
        if (instance == null) {
            synchronized (PrimeMinister.class) {//synchronized block to remove the overhead of acquiring a lock every time the method is invoked
                if (instance == null) {
                    instance = new PrimeMinister(name, party);
                }
            }
        }
        //code here
        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getParty() {
        return party;
    }

    //Prevent from the serialization and deserialization
    @Serial
    protected Object readResolve() {//Prevent from the serialization and deserialization
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        return instance;
    }

    /*Double-check locking: This approach improves performance compared to simply synchronizing the entire getInstance method. It only acquires the lock when the instance needs to be created, reducing unnecessary synchronization overhead.
volatile keyword: The instance variable is declared volatile to ensure visibility of changes made by one thread to other threads immediately.
Consistent naming: The class and method names follow common Java naming conventions (PascalCase and camelCase).*/
}