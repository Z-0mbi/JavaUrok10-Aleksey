package mySwing;

import java.util.ArrayList;
import java.util.Random;

public class MyArray  extends ArrayList<Integer>{
	private Random random;
	private double avG;
	
	public MyArray() {
		random = new Random();
		this.putValue();		
	}
	
	//Заполняем ммассив числами
	public void putValue() {
		int count = 5;
		for (int i = 0; i < count; i++) {
			this.add(random.nextInt(100));
		}
	}
	
	//Получаем среднее геометрическое
	public double getG() {
		for (int i = 0; i < this.size(); i++) {
			avG += this.get(i) * this.get(i);
		}
		
		return Math.pow(avG, 1.0/this.size());
	}

}
