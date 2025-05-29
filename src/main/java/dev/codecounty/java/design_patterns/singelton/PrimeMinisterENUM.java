package dev.codecounty.java.design_patterns.singelton;

public enum PrimeMinisterENUM {


    INSTANCE;//volatile keyword to ensure visibility of changes made by one thread to other threads immediately.


    private String name;
    private String party;

    public void setName(String name) {
        this.name = name;
    }
}