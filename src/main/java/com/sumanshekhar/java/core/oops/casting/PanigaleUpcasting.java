package com.sumanshekhar.java.core.oops.casting;

public class PanigaleUpcasting extends Bike {
	static String brand = "Panigale";
	int speed = 250;
	int speedlimit = 96;

	@Override
	public String toString() {
		return "PanigaleUpcasting [speed=" + speed + ", speedlimit=" + speedlimit + "]" + PanigaleUpcasting.brand
				+ color;
	}

	public static void main(String[] args) {
//		NORMAL
		System.out.println("BIKE 00 ------------------>");
		PanigaleUpcasting bike00 = new PanigaleUpcasting();
		bike00.printFuel();// inheritted printFuel()
		System.out.println(bike00);// overrided toString()
		bike00.onRoadPrice();// specialsed method trigger

//		System.out.println(bike00.brand);//Very bad standard

		System.out.println("BIKE 01 ------------------>");
//		UPCASTING
		Bike bike01 = new PanigaleUpcasting();// everything will be belong to Parent variable
		bike01.printFuel();// inheritted
		System.out.println(bike01);// overrided
//		bike01.onRoadPrice();//all specialized method blocked

//		variables//1st preference to PARENT
		System.out.println(bike01.color);// default
		System.out.println(bike01.speedlimit);// 90
//		System.out.println(bike01.speed);//all specialized variable blocked
		System.out.println(bike01);

		System.out.println("BIKE 02 ------------------>");
//		PanigaleUpcasting bike03 = (PanigaleUpcasting) new Bike();//runtime error

		PanigaleUpcasting bike02 = (PanigaleUpcasting) bike01;
		bike02 = new PanigaleUpcasting();
		bike02.printFuel();// inheritted printFuel()
		System.out.println(bike02);// overrided toString()
		bike02.onRoadPrice();// specialsed method trigger
	}

	void onRoadPrice() {
		System.out.println("PRICE " + System.currentTimeMillis() + " 4 CRORE");
	}
}

class Bike {
	int speedlimit = 90;
	String color = "default";

	@Override
	public String toString() {// toString preferred to the class in which it recides
		return "Bike [speedlimit=" + speedlimit + ", color=" + color + "]";
	}

	void printFuel() {
		System.out.println("FUEL " + 95);
	}
}
