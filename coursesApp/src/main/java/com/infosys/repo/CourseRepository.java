package com.infosys.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> 
{
   List<Course> findByCourseName(String courseName);
   
//   @Query(value="Select * from course where course_price = ?", nativeQuery=true)
//   List<Course> findByPrice(int price);
//   
//   @Query("SELECT b FROM Book b WHERE b.title = :title and b.author= :author")
//  Course findBookByTitleAndAuthorNamedJpql(@Param("title") String title, @Param("author") String author);
//  
//   @Query(value = "SELECT * FROM Book WHERE title = :title and author= :author", nativeQuery = true)
//   Course findBookByTitleAndAuthorNamedNative(@Param("title") String title, @Param("author") String author);
      
       @Query("SELECT c FROM Course c")
      List<Course> findAllCourses(Pageable pageable);

}