package cn.yugaguo.Sort;
/**
 * 综合排序
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Student {
     

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
	}

	private String name;
       private int id;
       private int age;
	public Student(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
 static class IdAscendingComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			 return o1.id - o2.id;
		}
		
	}
	
    public static void main(String[] args) {
		Student s1=new Student("a", 1, 28);
		Student s2=new Student("b", 4, 17);
		Student s3=new Student("r", 3, 24);
        Student[] students=new Student[] {s3,s1,s2};
        Arrays.sort(students, new IdAscendingComparator());
        System.out.println(Arrays.toString(students));
	}    
}
