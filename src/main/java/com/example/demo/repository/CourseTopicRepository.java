package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CourseTopic;

@Repository
public interface CourseTopicRepository extends JpaRepository<CourseTopic, Integer>{
	
	List<CourseTopic> findBycourseTitle(String courseTitle);
	
	List<CourseTopic> findBycourseId(int id);
	
//	@Query(value = "delete from CourseTopic ct where ct.courseId=:courseId")
//	void deleteAllByCourseId(@Param("courseId") int courseId);
	
	//void deleteAllByCourseId(int id);
	
}
