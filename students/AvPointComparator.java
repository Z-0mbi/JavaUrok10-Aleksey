package students;

import java.util.Comparator;

public class AvPointComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getAvPoint().compareTo(o2.getAvPoint());
	}


}
