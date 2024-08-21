package com.infosys.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.infosys.entities.Course;
import com.infosys.exceptions.CourseCannotBeDeletedException;
import com.infosys.exceptions.CourseNotFoundException;
import com.infosys.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository repo;

	@Override
	public List<Course> getAllCources()
	{
	
		Sort sort = Sort.by("coursePrice").descending();
		Pageable pageable = PageRequest.of(1,3,sort);
		
		List<Course> courseList=repo.findAllCourses(pageable);
		return courseList;
	}

	@Override
	public Course getCourse(Integer courseId) throws CourseNotFoundException 
	{
		Optional<Course> opCourse=  repo.findById(courseId);
		Course course =opCourse.orElseThrow(()->new CourseNotFoundException());
		return course;
	}

	@Override
	public Course addCourse(Course course) 
	{
		return repo.save(course);
	}

	@Override
	public Course updateCourse(Integer courseId,Course course)
	{
		Course c=null;

		Optional<Course> opCourse=  repo.findById(courseId);

		if(opCourse.isPresent()) {
			c=	repo.save(course);
		}
		return c;
	}

	@Override
	public void deleteCourse(Integer courseId) throws CourseCannotBeDeletedException 
	{
		Optional<Course> c=null;
		c=repo.findById(courseId);
		Course course=c.orElseThrow(()->new CourseCannotBeDeletedException("course with id "+courseId+" was not found"));
		repo.delete(course);
	}

	@Override
	public List<Course> searchCourseByName(String courseName) {
		
		return repo.findByCourseName(courseName);
	}

}
