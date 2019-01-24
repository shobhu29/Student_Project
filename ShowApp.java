package com.capgemini.view;
import java.util.Scanner;
import com.capgemini.beans.*;
import com.capgemini.bl.*;

public class ShowApp {
	
	static Scanner sc= new Scanner(System.in);
	static Student_schedular std_sch = new Student_schedular(); 
	
	public static void showMenu()
	{	
		while(true)
		{
			
		
			System.out.println("Type 1 to Add Student Details");
			System.out.println("Type 2 to Print Student Details");
			System.out.println("Type 3 to Print All Student Details");
			System.out.println("Type 4 to Add Course Details");
			System.out.println("Type 5 to exit status");
			System.out.println("Enter Your choice");
			
			int choice =sc.nextInt();
			
			switch(choice)
			{
				case 1: addStudent();
						break;
				case 2: printStudentDetail();
						break;
				case 3:	printAllStudentDetails();
						break;	
				case 4:	addCourse();
						break;
				case 5: System.exit(0);
						break;
				default: System.out.println("Wrong Choice");
			}
		}
	}
	
	public static void addStudent()
		{
		
			System.out.println("Enter Roll Number");
			int rollno=sc.nextInt();
			System.out.println("Enter Student Name ");
			String name=sc.next();
			
			String msg= std_sch.addStudent(rollno,name);
			if(msg == "yes")
			{
				System.out.println("Student added successfully");
			}
			else
				System.out.println("Your roll number is already present. ");
			
		}
	public static void addCourse()
		{
			System.out.println("Enter Roll Number");
			int rollno=sc.nextInt();
			System.out.println("In how many courses you want to enroll");
			int size=sc.nextInt();
			Course[] courses=new Course[size];
			for(int i=0;i<size;i++)
			{	
				courses[i]=new Course();
				System.out.println("Enter Course id");
				int course_id=sc.nextInt();
				System.out.println("Enter Course name");
				String course_name=sc.next();
				courses[i].setCourse_id(course_id);
				courses[i].setCourse_name(course_name);
			}
			
			String msg =std_sch.addCourseDetail(rollno, courses, size);
			if (msg == "yes")
				System.out.println("course detail added successfully");
			else
				System.out.println("Incorrect Roll Number");
		}
	
	
	public static void printStudentDetail()
		{
			System.out.println("Enter roll number");
			int rollno=sc.nextInt();
			Student student =std_sch.printStudentDetail(rollno);
			if(student != null)
				{
					System.out.println("roll no " + student.getRollno());
					System.out.println("Student Name " + student.getName());
					Course[] courses=student.getCourse(); 
					for(int i=0;i<student.getSizeOfCourse();i++)
						
						{
							System.out.println(courses[i].getCourse_id() + "  " + courses[i].getCourse_name());
						
						}				
				}
			else
				System.out.println("Invalid Roll number");
		}

	public static void printAllStudentDetails()
		{
			Student[] student=std_sch.printAllStudentDetails();
			for(int i=0;student[i]!=null;i++)
				{
					System.out.println("Roll No is " + student[i].getRollno());
					System.out.println("Student Name is " + student[i].getName());
					Course[] courses=student[i].getCourse();
					for(int j=0;j<student[i].getSizeOfCourse();j++)
						{
							System.out.println("ID : " + courses[j].getCourse_id() + " " + courses[j].getCourse_name());
						}
				}
		}
	
	
	public static void main(String[] args) {
		
		showMenu();
	}

}
