package dev.codecounty.java.java8.core.exception_handling;

public class CheckedException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(0/0);//Unchecked

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);// Checked Exception
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);

		}

	}

}
