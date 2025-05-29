package dev.codecounty.java.java8.oops.interfaces.default_methods;


class EncryptedKey {
    int keyId;

    public EncryptedKey(int keyId) {
        this.keyId = keyId;
    }
}

interface OperateCar {

    default public int startEngine(EncryptedKey key) {
        // Implementation
        return key.keyId + key.hashCode();
    }
}

interface FlyCar {

    default public int startEngine(EncryptedKey key) {
        // Implementation
        return key.keyId;
    }
}

//A class that implements both OperateCar and FlyCar must override the method startEngine.
// You could invoke any of the default implementations with the super keyword.

public class FlyingCar_3 implements OperateCar, FlyCar {
    public int startEngine(EncryptedKey key) {
//        return FlyCar.super.startEngine(key);
        return OperateCar.super.startEngine(key);
    }

    public static void main(String[] args) {
        FlyingCar_3 f1 = new FlyingCar_3();
        int i = f1.startEngine(new EncryptedKey(10));
        System.out.println(i);
    }
}

/*
    The name preceding super (in this example, FlyCar or OperateCar) must refer to a direct superinterface that defines or inherits a default for the invoked method. This form of method invocation is not restricted to differentiating between multiple implemented interfaces that contain default methods with the same signature.
    You can use the super keyword to invoke a default method in both classes and interfaces.*/


//Note: Static methods in interfaces are never inherited.

/*
    Defining a Method with the Same Signature as a Superclass's Method
                             |  Superclass Instance Method      |	Superclass Static Method
    Subclass Instance Method |	Overrides 	                    |Generates a compile-time error
    Subclass Static Method 	 |  Generates a compile-time error 	|Hides
    */
