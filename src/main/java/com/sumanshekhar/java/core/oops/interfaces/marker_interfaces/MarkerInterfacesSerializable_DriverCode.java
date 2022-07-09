package com.sumanshekhar.java.core.oops.interfaces.marker_interfaces;

import java.io.*;

public class MarkerInterfacesSerializable_DriverCode {

	public static void main(String[] args) throws IOException {
//		SERIALIZATION
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		String path = "C://Users/suman/eclipse-workspace/java_lessons/src/main/resources/serialized/payment.txt";
		try {
			// Creating the object
			PaymentDetails p1 = new PaymentDetails("Suman", 500, "INR", false);
			System.out.println(p1);
			// Creating stream and writing the object
			fout = new FileOutputStream(path);
			out = new ObjectOutputStream(fout);
			out.writeObject(p1);
			out.flush();

			System.out.println("success S");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// closing the stream
			fout.close();
			out.close();
		}

//		DESERIALIZATION
		try {
			// Creating stream to read the object
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
			PaymentDetails pDS = (PaymentDetails) in.readObject();
			System.out.println("success DS");
			// printing the data of the serialized object
			System.out.println(pDS);
			System.out.println(pDS.counter);// it will show 1 because are using serialization and deserialization in
											// the same class
			// closing the stream
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
