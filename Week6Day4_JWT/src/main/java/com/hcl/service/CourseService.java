package com.hcl.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.exception.CourseAlreadyExistsException;
import com.hcl.exception.CourseIdDoesNotExistException;
import com.hcl.model.Course;
import com.hcl.repository.CourseRepository;

@Service
public class CourseService 
{
	@Autowired
	private CourseRepository courseRepo;

	public Course addCourse(Course c)
	{
		boolean existValue=courseRepo.existsById(c.getId());
		if(existValue==false)
		{
			return courseRepo.save(c);
		}
		else
		{
			throw new CourseAlreadyExistsException("Course with id "+c.getId()+" already exists");
		}
		
	}

	public List<Course> getAllCourses()
	{
		return courseRepo.findAll();
	}

	public Course getCourseById(int id)
	{
		Optional<Course> op= courseRepo.findById(id);
		try
		{
			return op.get();
		}
		catch(NoSuchElementException e)
		{
			throw new CourseIdDoesNotExistException("Course with "+id+" does not exist");
		}
	}
	public String removeCourseById(int id)
	{
		boolean b=courseRepo.existsById(id);
		
			if(b==true)
			{
				courseRepo.deleteById(id);
				return "Course with "+id+" deleted successfully";
			}
			else
			{
				throw new CourseIdDoesNotExistException("Course with "+id+" does not exist");
			}
		
	}
	public String updateCourseById(Course c)
	{
		boolean existValue=courseRepo.existsById(c.getId());
		if(existValue==true)
		{
			courseRepo.save(c);
			return "Course with "+c.getId()+" updated successfully";
		}
		else
		{
			throw new CourseIdDoesNotExistException("Course with "+c.getId()+" does not exist");
		}
		
	}
}
