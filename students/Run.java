/*Сделать коллекцию студентов. Она характеризуется ФИО и средним баллом.
 *При вводе в консоле слова LIST должна выводиться информация о всех 
 *студентах и их средней оценке. При вводе команды Sort необходимо 
 *спрашивать: ”По какому полю требуется сортировка”. 
 *При вводе FIO – сортируем по ФИО. При вводе “GRADE” – сортируем по 
 *среднему баллу. 
 */

package students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Run {
	private BufferedReader reader;
	private LinkedList<Student> students;
	private Random random;
	
	public Run() throws IOException {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.students = new LinkedList<Student>();
		this.random = new Random();
		this.makeCollectionOfStudents();
	}
	//Создаем коллекцию студентов
	public void makeCollectionOfStudents() throws IOException {
				
		for(;;) {
			System.out.println("Введите фамили. Что бы закончить ввод нажмите \"Y\"");
			String student = reader.readLine().trim();//Вводим фамилию студента
			//Делаем выход
			if(student.toUpperCase().equals("Y")) {
				break;
			}
			//Ввыставляем средний балл
			String avPoint = Integer.toString(random.nextInt(5)+1);
			if(!avPoint.equals("5")) {
				avPoint = avPoint + "." + (random.nextInt(9));
			}
			
			students.add(new Student(student, avPoint));			
		}
	}
	
	//Показ студентов
	public void showStudents() {
		for(Student student : students ) {
			System.out.println("Cтудент " + student.getName() + " : " + student.getAvPoint());
		}
	}
	
	//Сортируем по имени
	public void sortName() {
		Collections.sort(students,new NameComparator());
		for(Student student : students ) {
			System.out.println("Cтудент " + student.getName() + " : " + student.getAvPoint());
		}
	}
	
	//Сортируем ро баллам
	public void sortAvPoint() {
		Collections.sort(students,new AvPointComparator());
		for(Student student : students ) {
			System.out.println("Cтудент " + student.getName() + " : " + student.getAvPoint());
		}
	}
	
	//Выводим информацию по запросам
	public void show() throws Exception {
		System.out.println("LIST - информация о всех студентах и их средней оценке\n"
				+ "SORT - отсортировать данные\n"
				+ "EXIT - выход");
		for(;;) {
			String ansver = reader.readLine().trim();
			if(ansver.toUpperCase().equals("LIST")) {
				this.showStudents();
			}
			else if(ansver.toUpperCase().equals("SORT")) {
				System.out.println("FIO - сортируем по ФИО\n"
						+ "GRADE - сортируем по среднему баллу");
				ansver = reader.readLine().trim();
				if(ansver.toUpperCase().equals("FIO")) {
					this.sortName();
				}
				else if(ansver.toUpperCase().equals("GRADE")) {
					this.sortAvPoint();
				}
				else {
					continue;
				}
			}
			else if(ansver.toUpperCase().equals("EXIT")) {
				break;
			}
			else {
				continue;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Run a = new Run();
		a.show();

	}

}
