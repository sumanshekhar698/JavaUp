package dev.codecounty.java.java8.oops.encapsulation;

public class Bird2 {

	private int number;
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private String species;// private is keyword and used as access specifier
	private String color;
	private boolean isEndangered;



	@Override
	public String toString() {
		return "Bird2 [number=" + number + ", species=" + species + ", color=" + color + ", isEndangered="
				+ isEndangered + "]";
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String s) {
		this.species = species;// Overshadow
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isEndangered() {
		return isEndangered;
	}

	public Bird2(int number, String species, String color, boolean isEndangered) {
		super();
		this.number = number;
		this.species = species;
		this.color = color;
		this.isEndangered = isEndangered;
	}

	public void setEndangered(boolean isEndangered) {
		this.isEndangered = isEndangered;
	}

	private void chirp() {
		//methods can also be private, SO it will have nmo outside acceess
		System.out.println("CHIRP CHIRPCHIRP CHIRP CHIRP @@@ ");
	}

}
