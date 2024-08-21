package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.entities.Course;
import com.infosys.exceptions.CourseCannotBeDeletedException;
import com.infosys.exceptions.CourseNotFoundException;
import com.infosys.service.CourseService;

@RestController//= @Controller + @ResponseBody
@RequestMapping("/infosys.com")
public class CourseController 
{
	@Autowired
	CourseService service;

	@PostMapping(value="/course")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) 
	{
		Course course1 =service.addCourse(course);
		return new ResponseEntity<>(course1,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/searchCourse/{courseName}")
	public ResponseEntity<List<Course>> searchByCourseName(@PathVariable String courseName) 
	{
		List<Course> course1 =service.searchCourseByName(courseName);
		return new ResponseEntity<>(course1,HttpStatus.OK);
	}

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCources()
	{
		List<Course> courseList= service.getAllCources();
		return new ResponseEntity<>(courseList,HttpStatus.OK);
	}

	@GetMapping("/course/{courseId}")
	public ResponseEntity getCourse(@PathVariable String courseId) throws CourseNotFoundException 
	{
		ResponseEntity responseEntity=null;

		Course course= service.getCourse(Integer.parseInt(courseId));
		if(course!=null) {
			responseEntity = new ResponseEntity<>(course,HttpStatus.OK);


		}
		else {
			responseEntity=  new ResponseEntity<>("course is unavailible",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PutMapping("/course/{courseId}")
	public Course updateCourse(@PathVariable String courseId,@RequestBody Course course)
	{
		return service.updateCourse(Integer.parseInt(courseId), course);
	}
	@DeleteMapping("course/{courseId}")
	public ResponseEntity<String> deleteCourse(@PathVariable String courseId) throws CourseCannotBeDeletedException 
	{
		service.deleteCourse(Integer.parseInt(courseId));
		return new ResponseEntity<>("the course is deleted successfully",HttpStatus.OK);
	}
}
