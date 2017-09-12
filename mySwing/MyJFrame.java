package mySwing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyJFrame extends JFrame {

	private JLabel label;
	private Container c;
	private MyArray mas;
	
	public MyJFrame() {
		setTitle("Отображение метки");
		setSize(800,450);
		setVisible(true);
		label = new JLabel();		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
		mas = new MyArray();
		setLabel();
		makeToolTipText();
	}
	
	//Создаем строку для вывода на экран
	public void setLabel() {

		StringBuilder stb = new StringBuilder("Посчитайте среднее геометрическое чисел: ");

		for(int i = 0; i < mas.size(); i++) {
			stb.append(mas.get(i) + "  ");
		}
		label.setText(stb.toString().trim());
		c.add(label);
	}
	
	//Создаем подсказку
	public void makeToolTipText() {
		label.setToolTipText("" + mas.getG());
	}

}
