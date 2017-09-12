package students;

public class Student {
	String name;// Имя студента
	String avPoint;// Средний балл

	public Student(String name, String avPoint) {
		this.name = name;
		this.avPoint = avPoint;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAvPoint() {
		return this.avPoint;
	}

}
