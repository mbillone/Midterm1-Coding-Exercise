package com.cisc181.core;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	
	static ArrayList<Staff> staffMembers = new ArrayList<Staff>();
	
	public static Date newDate(int year, int month, int day){
		Calendar date = Calendar.getInstance();
		date.set(year,month - 1, day);
		return date.getTime();
	}

	@BeforeClass
	public static void setup() throws PersonException{
		staffMembers.add(new Staff("Jill", "Sam", "Williams", newDate(1960, 2,18), "123 Udel Lane", "(610)-223-2214", "jsw@udel.udu", "3 to 5", 1, 6000, newDate(1994,8,24), eTitle.MRS));
		staffMembers.add(new Staff("Mike", "Thomas", "Dickerson", newDate(1970,1,15),"450 Green Crossing", "(135)-456-7890", "mdickerson@udel.edu", "1:30 to 4:30", 2, 5000, newDate(1997,9,10), eTitle.MR));
		staffMembers.add(new Staff("Liz", null, "Garcia", newDate(1965,5,30), "234 West Main", "(321)-443-5678", "lizG@udel.edu", "6 to 7", 3, 3000, newDate(2000,7,15), eTitle.MS));
		staffMembers.add(new Staff("Jeremy", null, "Young", newDate(1975,4,23), "67 Weslian Road", "(456)-757-3425", "Jyoung@udel.edu", "12 to 2", 4, 2000, newDate(2005,8,25), eTitle.MR));
		staffMembers.add(new Staff("Bill", "Bob", "Joe", newDate(1977,6,7), "45 Cisc Lane", "(789)-343,2110", "billjoe@udel.edu", "2 to 4", 5, 1500, newDate(2006, 6,2), eTitle.MR));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void StaffSalaryAvTest(){
		double sum = 0;
		for (Staff staff : staffMembers){
			sum = (sum + staff.getSalary());
		}
		double averageSalary = sum / staffMembers.size();
		assertEquals(averageSalary, 2500);
		
	}
	@Test
	public void DateOfBirthExceptionTest(){
		try{
			Staff staff = new Staff("Jill", "Sam", "Williams", newDate(1860, 2,18), "123 Udel Lane", "(610)-223-2214", "jsw@udel.udu", "3 to 5", 1, 6000, newDate(1994,8,24), eTitle.MRS);
		}
		catch (PersonException e){
			assertTrue(true);
			System.out.println("Date of birth not accepted");
		}
		
		try{
			Staff staff = new Staff("Jill", "Sam", "Williams", newDate(1960, 2,18), "123 Udel Lane", "(610)-2233-2214", "jsw@udel.udu", "3 to 5", 1, 6000, newDate(1994,8,24), eTitle.MRS);
			
		}
		catch (PersonException e){
			assertTrue(true);
			System.out.println("Phone number is not valid, please use proper format");
		}
			
			
		}
	@Test
	public final void PhoneNumberExceptionTest(){
		
	}
		
	}
