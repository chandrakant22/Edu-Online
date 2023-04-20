package com.example.demo.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Course;
import com.example.demo.model.CourseTopic;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CourseTopicRepository;

@Controller
public class CourseController {
	
	private String courseTitleImage; 
	private String fileName;
	private String UPLOAD_FOLDER;
	
	//Add Course Details
	
		@RequestMapping("/addCourse")	
		String addCourse(Model  model, HttpSession session) {
			
			if(session.getAttribute("sessionTeacher") != null) {
			
			Course course = new Course();
			model.addAttribute("course",course);
			return "addCourse";
			}
			else
			{
				return "redirect:/login-teacher";
			}
		
		}
		
		
		@Autowired
		CourseRepository courseRepo;
		@RequestMapping("/addCourseData" )
		String addCourseData(@ModelAttribute("course") Course course,
				@RequestParam("courseTitle") String courseTitle) {
			
			courseRepo.save(course);
			System.out.println("Course Added.");
			
			//System.out.println("The ct is =" + courseTitle);
			
			courseTitleImage = courseTitle;
			
			return "redirect:/addCourseImage";
		}
		
		
		/** Adding Course Image **/
		
		@RequestMapping("/addCourseImage")
		String addImagePage( Model model, HttpSession session) {
			if(session.getAttribute("sessionTeacher") != null) {
				
				model.addAttribute("courseTitle",courseTitleImage);
				
				return "addCourseImage";
			}
			else {
				return "redirect:/login-teacher";
			}
			
		}
		
		
		@RequestMapping("/addImage")
		String addCourseImage(@RequestParam("courseImage") MultipartFile file, 
				RedirectAttributes attributes) {
	
			UPLOAD_FOLDER = "C://Users//91797//Documents//workspace-sts-3.9.12.RELEASE//Online-Education-Webapp//src//main//resources//static//course_Title_Images//" ;
			fileName = file.getOriginalFilename();
			
			
			if(file.isEmpty()) {
				attributes.addFlashAttribute("message", "Please select a file to upload.");
	            return "redirect:/addCourseImage";
			}
			
			try {
				// read and write the file to the selected location-
				byte[] bytes = file.getBytes();
				
				Path path = Paths.get(UPLOAD_FOLDER + fileName);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("File uploded");
			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
			
			 // return success response
	        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
	        
	        updateCourse();
			
			return "redirect:/teacher-dashboard";
		}
		
		
		/**Function to update course data after inserting image**/
		void updateCourse() {
			
			Course course = courseRepo.findBycourseTitle(courseTitleImage);
			
			course.setCourseImage(fileName);
			
			courseRepo.save(course);
			
			System.out.println(course);		
		}
		
		
		@RequestMapping("/allCoursesTeacher")	
		String allCourses(Model model, HttpSession session) {
			
			if(session.getAttribute("sessionTeacher") != null) {
			
				List<Course> list = courseRepo.findAll();
				
				model.addAttribute("allCoursesList",list);
				
				return "allCoursesTeacher";
			
			}
			else {
				return "redirect:/login-teacher";
			}
		}
		
		
		
		@RequestMapping("/allCoursesHomepage")	
		String allCoursesHomepage(Model model, HttpSession session) {
			
//			if(session.getAttribute("sessionStudent") != null) {
			
			List<Course> list = courseRepo.findByStatus("Published");
			
			model.addAttribute("allCoursesListHomepage",list);
			
			return "coursesHomepage";
//			}
//			else
//			{
//				return "redirect:/login-student";
//			}
		}
		
		
		/** Add Topics **/
		@RequestMapping("/addTopic/{title}")
		String addCourseTopicPage(@PathVariable("title") String title, Model model) {
			
			System.out.println("Course Name : "+ title);
			Course course = courseRepo.findBycourseTitle(title);
			//System.out.println(course);
			model.addAttribute("courseKey", course);
			
			//Creating Empty Object
			CourseTopic topic = new CourseTopic();
			model.addAttribute("topicKey", topic);
			System.out.println("Topic,s empty object created.");
			
			return "addCourseTopic";
		}

		
		@Autowired
		CourseTopicRepository topicRepo;
		
		@RequestMapping("/setTopic")
		String setCourseTopicPage(@ModelAttribute("topicKey") CourseTopic topic) {
			
			//Breaking youTube Link
			String url=topic.getYoutubeLink();
			String urlId[]=url.split("=");
			topic.setYoutubeLink(urlId[1]);
			
			topicRepo.save(topic);
			System.out.println("Topics added.");
		
			return "redirect:allCoursesTeacher";
		}
		
	
		
		/** All Courses titles **/
		@RequestMapping("/courseSingle/{courseTitle}")
		String openSingleCourse(@PathVariable("courseTitle") String courseTitle,
				HttpSession session, Model model ) {
			
			if(session.getAttribute("sessionStudent") != null) {
			
				List<CourseTopic> list = topicRepo.findBycourseTitle(courseTitle);
				model.addAttribute("courseTopics",list);
				
				for (CourseTopic courseTopic : list) {
					
					model.addAttribute("coursename",courseTopic.getCourseTitle());
					model.addAttribute("authoremail",courseTopic.getAuthorEmail());
					
					System.out.println(courseTopic);
				}
				
				return "courseSingle";
			
			}
			else
			{
				return "redirect:/login-student";
			}
		}
}
