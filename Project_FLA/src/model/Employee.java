package model;

public class Employee extends Person{
	
	private int salary;

	public Employee(String id, String name, String gender, String address, String phoneNumber, int age, int salary) {
		super(id, name, gender, address, phoneNumber, age);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
