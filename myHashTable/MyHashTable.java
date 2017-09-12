package myHashTable;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;


public class MyHashTable {
	class Men{
		String name;
		int oklad;
		
		public Men(String name,int oklad) {
			this.name = name;
			this.oklad = oklad;
		}		
	}
	
	Hashtable ht = new Hashtable<Object, Object>();
	private String minM;//переменная для человека с мин зарплатой
	private int minZ;//переменная для  мин зарплаты
	private String maxM;//переменная для человека с макс зарплатой
	private int maxZ;//переменная для  макс зарплаты
	
	public MyHashTable() {
		ht.put(1, new Men("Иванов",20000));
		ht.put(2, new Men("Петров",10000));
		ht.put(3, new Men("Сидоров",30000));
	}
	
	//имя с наименьшим окладом
	String getMinMen() {		
		myMin();
		return minM;
	}
	
	//наименьший оклад
	int getMin() {
		myMin();
		return minZ;
	}
	
	//имя с наибольшим окладом
	String getMaxMen() {		
		myMax();
		return maxM;
	}
	
	//наибольший оклад
	int getMax() {
		myMax();
		return maxZ;
	}
	
	
	private void myMin(){
		int r=-1;
		Enumeration e = ht.elements();//получили все элементы коллекции
		Men m;
		while(e.hasMoreElements()){
			m = (Men)e.nextElement();
			if(m.oklad<r || r==-1){
				minZ = r=m.oklad;//получили наименьший оклад
				minM = m.name;//получили имя с наименьшим окладом
			}
		}
	}
	
	private void myMax(){
		int r=-1;
		Enumeration e = ht.elements();//получили все элементы коллекции
		Men m;
		while(e.hasMoreElements()){
			m = (Men)e.nextElement();
			if(r<m.oklad){
				maxZ = r=m.oklad;//получили макс оклад
				maxM = m.name;//получили имя с наибольшим окладом
			}
		}
	}
	
	int getAllOklad(){
		int sum=0;
		Enumeration e = ht.elements();
		Men m;
		while(e.hasMoreElements()){
			m = (Men)e.nextElement();
			sum+=m.oklad;
		}
		return sum;		
	}
	
	int getOkladByName(String name) throws Exception{
		int r=-1;
		Enumeration e = ht.elements();
		Men m;
		while(e.hasMoreElements()){
			m = (Men)e.nextElement();
			if(name.equals(m.name)){
				r=m.oklad;
				break;
			}
		}
		if(r==-1){
			throw new Exception(name +" не работает в нашей компании!");
		}
		return r;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		MyHashTable mht = new MyHashTable();
		System.out.println("Мин з/п составляет "+mht.getMin() + " у " + mht.getMinMen());
		System.out.println("Макс з/п составляет "+mht.getMax() + " у " + mht.getMaxMen());
		System.out.println("з/п всех сотрудников за 1 месяц составляет "+mht.getAllOklad());
		System.out.println("з/п всех сотрудников за 12 месяцев составляет "+mht.getAllOklad()*12);
		
		System.out.println("Введите имя сотрудника");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()){
			String name = sc.next();
			System.out.println("Сотрудник "+name+" зарабатывает "+mht.getOkladByName(name));
		}
		sc.close();
		
	}

}
