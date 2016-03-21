package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	
	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<Semester> semesterList = new ArrayList<Semester>();
	static ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
	static ArrayList<Section> sectionList = new ArrayList<Section>();
	
	
	public static Date newDate(int year, int month, int day){
		Calendar date = Calendar.getInstance();
		date.set(year, month -1, day);
		return date.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException{
		Course CompSci = new Course("Intro to CompSci", 94, eMajor.COMPSI);
		Course Chemistry = new Course("Chem I", 73, eMajor.CHEM);
		Course Business = new Course("Business 101", 64, eMajor.BUSINESS);
		courseList.add(CompSci);
		courseList.add(Chemistry);
		courseList.add(Business);
		
		Semester fall = new Semester(newDate(2015,8,29), newDate(2015,12,18));
		Semester spring = new Semester(newDate(2015,2,8), newDate(2015, 5, 27));
		semesterList.add(fall);
		semesterList.add(spring);
		
		Section fallCompSci = new Section(CompSci.getCourseID(), fall.getSemesterID(), 100);
		Section fallChemistry = new Section(Chemistry.getCourseID(), fall.getSemesterID(), 121);
		Section fallBusiness = new Section(Business.getCourseID(), fall.getSemesterID(), 131);
		Section springCompSci = new Section(CompSci.getCourseID(), spring.getSemesterID(), 101);
		Section springChemistry = new Section(Chemistry.getCourseID(), spring.getSemesterID(), 120);
		Section springBusiness = new Section(Business.getCourseID(), spring.getSemesterID(), 130);
		sectionList.add(fallCompSci);
		sectionList.add(fallChemistry);
		sectionList.add(fallBusiness);
		sectionList.add(springCompSci);
		sectionList.add(springChemistry);
		sectionList.add(springBusiness);
		
		Student Student1 = new Student("Matt", "Thomas", "Billone", newDate(1997,5,27), eMajor.COMPSI, "358 Academy Street", "(610)-500-3362", "mbillone@udel.edu");
		Student Student2 = new Student("Akash", null, "Sharma", newDate(1996,12,18), eMajor.COMPSI, "101 East Main", "(358)-775-6652", "asharma@udel.edu");
		Student Student3 = new Student("Amjed", null, "Hallak", newDate(1997,2,14), eMajor.PHYSICS, "131 West Main", "(123)-456-7890", "ahall@udel.edu");
		Student Student4 = new Student("Mike", "Thomas", "Henretty", newDate(1996,10,2), eMajor.BUSINESS, "100 South Main", "(444)-987-2233", "mhenretty@udel.edu");
		Student Student5 = new Student("Ryan", null, "Skinner", newDate(1997,1,2), eMajor.CHEM, "321 Central Main", "(321)-333-4444", "rskin@udel.edu");
		Student Student6 = new Student("Sam", null, "Evans", newDate(1995,2,6), eMajor.NURSING, "123 Chapel Street", "(987)-256-6780", "sevans@udel.edu");
		Student Student7 = new Student("Alex", null, "Richards", newDate(1994,6,11), eMajor.PHYSICS, "77 South Main", "(902)-233-6770", "arichards@udel.edu");
		Student Student8 = new Student("Will", null, "Esteves", newDate(1995,8,12), eMajor.CHEM, "54 Gibbons Road", "(654)-146-5466", "westeves@udel.edu");
		Student Student9 = new Student("Matt", null, "Fetty", newDate(1996,6,24), eMajor.COMPSI, "166 Nike Lane", "(155)-655-7782", "mfetty@udel.edu");
		Student Student10 = new Student("Caroline", "Rose", "Nickles", newDate(1996,4,15), eMajor.NURSING, "96 New Street", "(610)-286-4291", "cnick@udel.edu");
		studentList.add(Student1);
		studentList.add(Student2);
		studentList.add(Student3);
		studentList.add(Student4);
		studentList.add(Student5);
		studentList.add(Student6);
		studentList.add(Student7);
		studentList.add(Student8);
		studentList.add(Student9);
		studentList.add(Student10);
		
		
		for (Section section : sectionList){
			for (Student student : studentList){
				enrollmentList.add(new Enrollment(student.getStudentID(), section.getSectionID()));
			}
		}
		
	}
	
	public long calcGPA(UUID studentID){
		long GPA = 0;
		for (Enrollment enrollment : enrollmentList){
			if (enrollment.getStudentID() == studentID){
				if(enrollment.getGrade() >= 90){
					GPA = GPA + 4;
				}
				else if(enrollment.getGrade() >= 80){
					GPA = GPA + 3;
				}
				else if(enrollment.getGrade() >= 70){
					GPA = GPA + 2;
				}
				else if(enrollment.getGrade() >= 60){
					GPA = GPA + 1;
				}
				else{
					GPA = GPA + 0;
				}
			}
		}
		return GPA / sectionList.size();
	}
	
	public double CourseAv(UUID sectionID){
		double courseAv = 0;
		for (Enrollment enrollment : enrollmentList){
			if (enrollment.getSectionID() == sectionID){
				courseAv = (courseAv + enrollment.getGrade());
			}
		}
		return (((courseAv / 10) * 100) / 100);
		
	}

	@Test
	public void Studenttest() {
		for (Enrollment enrollment : enrollmentList){
			if (enrollment.getStudentID() == studentList.get(0).getStudentID() | enrollment.getStudentID() == studentList.get(1).getStudentID()){
				enrollment.setGrade(100);
			}
			else if(enrollment.getStudentID() == studentList.get(2).getStudentID() | enrollment.getStudentID() == studentList.get(3).getStudentID()){
				enrollment.setGrade(90);	
			}
			else if (enrollment.getStudentID() == studentList.get(4).getStudentID() | enrollment.getStudentID() == studentList.get(5).getStudentID()){
				enrollment.setGrade(80);
			}
			else if (enrollment.getStudentID() == studentList.get(6).getStudentID() | enrollment.getStudentID() == studentList.get(7).getStudentID()){
				enrollment.setGrade(70);
			}
			else if (enrollment.getStudentID() == studentList.get(8).getStudentID() | enrollment.getStudentID() == studentList.get(9).getStudentID()){
				enrollment.setGrade(60);
			}
			else{
				if (enrollment.getSectionID() == sectionList.get(0).getSectionID()){
					enrollment.setGrade(50);
				}
			}
		}
		// dont know how to test for gpa and course average
	}
	@Test
	public void MajorTest(){
		assertTrue(studentList.get(0).getMajor() == eMajor.COMPSI);
		assertFalse(studentList.get(0).getMajor() == eMajor.NURSING);
		studentList.get(0).setMajor(eMajor.CHEM);
		assertTrue(studentList.get(0).getMajor() == eMajor.CHEM);
		assertFalse(studentList.get(0).getMajor() == eMajor.BUSINESS);
	}
}