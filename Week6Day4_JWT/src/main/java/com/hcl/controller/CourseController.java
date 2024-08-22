package com.hcl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.AuthRequest;
import com.hcl.model.Course;
import com.hcl.service.CourseService;
import com.hcl.util.JwtUtil;

@RestController
public class CourseController 
{
	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	Course result;
	
	@PostMapping("/addCourse/course")
	public ResponseEntity<?> addCourse(@RequestBody Course cour)
	{
		result=courseService.addCourse(cour);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<?> getAllCourses()
	{
		List<Course> list=courseService.getAllCourses();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}/course")
	public ResponseEntity<?> getCourseById(@PathVariable int id)
	{
		result=courseService.getCourseById(id);
//		if(result==null)
//		{
//			return new ResponseEntity<>("Not Found!", HttpStatus.NOT_FOUND);
//		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletecourse/{id}")
	public ResponseEntity<?> removeCourseById(@PathVariable int id)
	{
		String resultStatus=courseService.removeCourseById(id);
		return new ResponseEntity<>(resultStatus,HttpStatus.OK);
	}
	
	@PutMapping("/updateCourse")
	public ResponseEntity<?> updateCourseById(@RequestBody Course c)
	{
		String resultStatus=courseService.updateCourseById(c);
		return new ResponseEntity<>(resultStatus,HttpStatus.OK);
	}
	
	@PostMapping("/getToken")
	public String getToken(@RequestBody AuthRequest request)
	{
		if(request.getUname().equals("Niti") && request.getPassword().equals("singh123"))
		{
			String token=jwtUtil.generateToken(request.getUname());
			return token;
		}
		else
		{
			return "Bad/Invalid Credential";
		}
	}
}



