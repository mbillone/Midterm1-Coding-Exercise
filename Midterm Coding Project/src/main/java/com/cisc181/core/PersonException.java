package com.cisc181.core;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonException extends Exception {

	private Person Person;
	
	public PersonException(Person person){
		this.Person = person;
	}
	
	public Person getPerson(){
		return Person;
	}
	
}
