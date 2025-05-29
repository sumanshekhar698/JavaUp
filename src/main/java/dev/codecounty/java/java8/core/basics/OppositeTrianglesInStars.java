package dev.codecounty.java.java8.core.basics;

public class OppositeTrianglesInStars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i, j;
		int rows = 10;
		for (i = 1; i <= rows; i++) {
			
			/* Print star in increasing order or row */
			for (j = 1; j <= i; j++) {
				System.out.print("$");
			}
			/* Print spaces in decreasing order of row */
			for (j = i; j < rows; j++) {
				System.out.print("%");
			}



			/* Move to next line */
			System.out.println();
		}
	}

}
