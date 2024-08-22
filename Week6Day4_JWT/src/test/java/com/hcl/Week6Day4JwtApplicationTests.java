package com.hcl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hcl.model.Course;
import com.hcl.repository.CourseRepository;
import com.hcl.service.CourseService;

@SpringBootTest
class Week6Day4JwtApplicationTests 
{
	
	//Mockito: dummy class to store the data
	//MockBean: dummy place to store data
	//Bean: class which should be activated
	@MockBean
	CourseRepository cRepo;  //dummy copy of Repo is created
	
	@Autowired
	CourseService cService;
	
	@Test
	public void getCourseTest()
	{
		List<Course> courses=new ArrayList<>();
		Course c=new Course(101,"Java",3,3000f);
		courses.add(c);
		courses.add(new Course(102,"Spring",6,12000f));
		courses.add(new Course(103,"React",1,1000f));
		
		when(cRepo.findAll()).thenReturn(courses);
		
		assertEquals(3,cService.getAllCourses().size());
	}
	
	@Test
	public void addTest()
	{
		Course course=new Course(1,"HTML",2,3999f);  //Course data in an object
		when(cRepo.save(course)).thenReturn(course);  //whenever course obj is saved, it should course data
		assertEquals(course,cService.addCourse(course));  //here addCourse calls the repo
	}
	@Test
	public void deleteCourseTest()
	{
		Course c=new Course(105,".NET",4,22000f);
		
		when(cRepo.existsById(105)).thenReturn(true);
		
		assertEquals("Course with "+c.getId()+" deleted successfully",cService.removeCourseById(105));
	}	
		
		
	@Test
	public void updateCourseTest1()
	{
		Course c=new Course(105,".NET",4,22000f);  //old value
		Course c1=new Course(105,"Java",2,22000f);
		
		when(cRepo.existsById(c.getId())).thenReturn(true); //old value with id exists/not
		
		assertEquals("Course with "+c1.getId()+" updated successfully",cService.updateCourseById(c1));
		
	}
	
	
}

