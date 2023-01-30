import java.io.*;
import java.util.*;

// class Student {
	// private String firstName;
	// private String lastName;
	// private int age;
	// public Student(String fn, String ln, int a) {
		// firstName=fn;
		// lastName=ln;
		// age=a;
	// }
	
	// public String getFirstName() {return firstName;}
	// public String getLastName() {return lastName;}
	// public int getAge() {return age;}
	// public String toString() {
		// return firstName+" "+lastName+" is "+age+" years old";
	// }
// }

public class A0p3 {
	private String name;
	private int age;
	public A0p3(String s, int a) {
		name=s;
		age=a;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	public String toString() {
		return name+" is "+age+" years old.";
	}
	public static void main(String [] args) {
		System.out.print("How many students do you want to input? ");
		String Name;
		int numOfStudents,age;
		Scanner input = new Scanner(System.in);   
		numOfStudents = input.nextInt();
		A0p3 [] slist = new A0p3[numOfStudents];
		for(int i=0;i<numOfStudents;i++) {
			System.out.println("\nEnter information for student "+(i+1)+":");
			System.out.print("Name: ");
			Name=input.next();
			System.out.print("Age: ");
			age=input.nextInt();
			slist[i]=new A0p3(Name,age);
		}//for

		System.out.println("\nThe students you entered are:");
		for (int i = 0; i < slist.length; i++) {
			System.out.println(slist[i]);
		}
	}//main
}//class