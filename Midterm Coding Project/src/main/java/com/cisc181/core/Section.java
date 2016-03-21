package com.cisc181.core;
import java.util.UUID;
public class Section {
	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public Section(){
		SectionID = UUID.randomUUID();
	}
	
	public Section(UUID courseID, UUID semesterID, int roomID){
		SectionID = UUID.randomUUID();
		CourseID = courseID;
		SemesterID = semesterID;
		RoomID = roomID;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
}
