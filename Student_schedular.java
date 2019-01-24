package com.capgemini.bl;
import com.capgemini.beans.*;

public class Student_schedular {
	private Student[] student = new Student[10];
	private int count_stud;
	
	public String addStudent(int rollno,String name){
		
		int f=0;
		for(int i=0;i<count_stud;i++)
		{
			if(student[i].getRollno()==rollno)
			{	
				f=1;
				break;	
			}
		}
		if(f==1)
			return "no";
		else
			{
				student[count_stud] = new Student();
				student[count_stud].setRollno(rollno);
				student[count_stud].setName(name); 
				count_stud++;
			}
		
		return "yes";
}
	
	public Student printStudentDetail(int rollno)
		{
		
			for(int i=0;i<count_stud;i++)
			{
				if(student[i].getRollno()==rollno)
					return student[i];

			}			
			return null;
		}
	
	public Student[] printAllStudentDetails()
		{
			return student;
		}
	
	public String addCourseDetail(int rollno,Course[] course,int size )
		{
		
			for(int i=0;i<count_stud;i++)
			{
				if(student[i].getRollno()==rollno)
				{
					int len=size + student[i].getSizeOfCourse();
					Course[] courses= new Course[len];
					Course[] temp= student[i].getCourse();
					int j;
					for(j=0;j<student[i].getSizeOfCourse();j++)
					{
						courses[j]=new Course();
						courses[j].setCourse_id(temp[j].getCourse_id());
						courses[j].setCourse_name(temp[j].getCourse_name());
					}
					int k=0;
					for(;j<len;j++)
					{
						courses[j]=new Course();
						courses[j].setCourse_id(course[k].getCourse_id());
						courses[j].setCourse_name(course[k].getCourse_name());
						k++;		
					}
					
					student[i].setCourse(courses);
					student[i].setSizeOfCourse(len);
					return "yes";
				}
			}
			
			return "no";
		}	
}
