package com.infosys.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.infosys.entities.Course;
import com.infosys.exceptions.CourseCannotBeDeletedException;
import com.infosys.exceptions.CourseNotFoundException;

public interface CourseService 
{
	public List<Course> getAllCources();
	public Course getCourse(Integer courseId) throws CourseNotFoundException;
	public Course addCourse(Course course);
	public Course updateCourse(Integer coureseId,Course course);
	public void deleteCourse(Integer courseId) throws CourseCannotBeDeletedException;
	public List<Course> searchCourseByName(String courseName);
}
