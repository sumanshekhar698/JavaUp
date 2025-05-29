package dev.codecounty.java.java8.core.enums;

interface Beverages{
	
}

enum Beer implements Beverages{
Bira , Magnum , ThunderBolt ; // semicolon is optional
}


public class EnumExample {


enum Soda{ // inner enum declaration
Haywards , Rogers , Kinley ; // semicolon is optional
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * enum Salads{ Mexican , Fruit , Green ; 
		 * }
		 * enums type can't be local to method
		 */
		
		
		Beer beer1 = Beer. Magnum;
		System.out.println(beer1); //  Magnum
		System.out.println(Soda.Kinley);
		
		switch (beer1) {
		case Bira: 
			System.out.println("Light beer");
			break;
			
		case Magnum: 
			System.out.println("Premium beer");
			break;
			
		case ThunderBolt: 
			System.out.println("Classic beer");
			break;
			
		/*
		 * case CarlsBerg: 
		 * System.out.println("Young Beer"); // unqualified enumeration constant required
		 * break;
		 */
			
		default:
			System.out.println("No beer for you");
		}
		
		
		Beer[] brands = Beer.values();

		
		System.out.println("Beer brands list");
		for (Beer beer : brands) {
			System.out.println(beer+" "+beer.ordinal());
		}
	}
}
