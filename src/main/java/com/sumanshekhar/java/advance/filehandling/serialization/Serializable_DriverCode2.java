package com.sumanshekhar.java.advance.filehandling.serialization;

import java.io.*;

public class Serializable_DriverCode2 {

	public static void main(String[] args) throws IOException {
//		SERIALIZATION
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		String path = "C://Users/suman/eclipse-workspace/java_lessons/src/main/resources/serialized/payment2.txt";
		try {
			// Creating the object
			PaymentDetails2 p1 = new PaymentDetails2("Suman", 500, "INR", false);
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
			PaymentDetails2 pDS = (PaymentDetails2) in.readObject();
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
