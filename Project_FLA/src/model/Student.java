package model;

public class Student extends Person{
	
	private int kelas, score;

	public Student(String id, String name, String gender, String address, String phoneNumber, int age, int kelas, int score) {
		super(id, name, gender, address, phoneNumber, age);
		this.kelas = kelas;
		this.score = score;
	}

	public int getKelas() {
		return kelas;
	}

	public void setKelas(int kelas) {
		this.kelas = kelas;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
    
}