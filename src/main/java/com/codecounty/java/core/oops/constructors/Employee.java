package com.codecounty.java.core.oops.constructors;

//Design patterns
//Gang Of Four

//Singleton Pattern
public class Employee {

	static Employee emp;// null
	int id;// instance variable | object variable

	// 1. make the constructor Private
	private Employee(int id) {
		super();
		this.id = id;
	}

	static Employee getObject(int id) {
		if (emp == null)// if no object is created
			emp = new Employee(id);
		return emp;
	}

	void shoutId() {
		System.out.println("ID => " + id);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + "]";
	}

}
