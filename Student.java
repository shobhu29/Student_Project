package com.capgemini.beans;

public class Student {

		private int rollno;
		private String name;
		private Course[] course;
		private int sizeOfCourse;
		public int getSizeOfCourse() {
			return sizeOfCourse;
		}
		public void setSizeOfCourse(int sizeOfCourse) {
			this.sizeOfCourse = sizeOfCourse;
		}
		public int getRollno() {
			return rollno;
		}
		public void setRollno(int rollno) {
			this.rollno = rollno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Course[] getCourse() {
			return course;
		}
		public void setCourse(Course[] course) {
			this.course = course;
		}
		
		

}
