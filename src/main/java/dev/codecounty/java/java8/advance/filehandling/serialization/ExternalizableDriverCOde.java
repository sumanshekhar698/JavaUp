package dev.codecounty.java.java8.advance.filehandling.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableDriverCOde {
	public static void main(String[] args) {
		Car car = new Car("Shubham", 1995);
		Car newcar = null;
		String path = "C://Users/suman/eclipse-workspace/java_lessons/src/main/resources/serialized/car.txt";
		// Serialize the car
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream so = new ObjectOutputStream(fo);
			so.writeObject(car);
			so.flush();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Deserialization the car
		try {
			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream si = new ObjectInputStream(fi);
			newcar = (Car) si.readObject();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("The original car is:\n" + car);
		System.out.println("\n\nThe new car is:\n" + newcar);
	}
}