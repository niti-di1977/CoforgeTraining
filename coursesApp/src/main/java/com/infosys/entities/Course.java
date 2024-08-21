package com.infosys.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Course 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer courseId;
	private String  courseName;
	private String  courseDescription;
	private Integer coursePrice;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseDescription, courseId, courseName, coursePrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseDescription, other.courseDescription) && Objects.equals(courseId, other.courseId)
				&& Objects.equals(courseName, other.courseName) && Objects.equals(coursePrice, other.coursePrice);
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", coursePrice=" + coursePrice + "]";
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public Integer getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(Integer coursePrice) {
		this.coursePrice = coursePrice;
	}
	public Course(String courseName, String courseDescription, Integer coursePrice) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.coursePrice = coursePrice;
	}
}
