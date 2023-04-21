package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Chat;
import com.example.demo.model.Course;
import com.example.demo.model.CourseTopic;
import com.example.demo.model.McqCreate;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CourseTopicRepository;
import com.example.demo.repository.McqCreateRepo;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.AuthenticateService;
import com.example.demo.service.TeacherServiceImpl;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherServiceImpl db;

	@RequestMapping("teacher-dashboard")	
	String home() {
		return "teacher-dashboard";
	}
	
	@GetMapping("/all")	
	String showDetailsPage(Model m) {
		List<Teacher> list = db.getAllTeachers();	 
	    m.addAttribute("teachers", list);
		return "all_teachers";
	}
	
	@RequestMapping("/addteacher")
	String addTeacherPage(Model m) {
		Teacher teacher = new Teacher();
		m.addAttribute("teacher", teacher);
		return "add-teacher";
	}
	
//	@RequestMapping("/saveteacher")
//	String saveTeacher (@ModelAttribute ("teacher") Teacher t, RedirectAttributes redirAttrs) {
//		db.saveTeacher(t);
//	    redirAttrs.addFlashAttribute("success", "Everything went just fine.");
//		return "redirect:/all";
//	}
	
	@RequestMapping("/saveteacher")
	String saveTeacher (@ModelAttribute ("teacher") Teacher t) {
		db.saveTeacher(t);
		System.out.println("Saved successfully!");
		return "redirect:/all";
	}
	
	@GetMapping("/editPage")
	public String editPage() {
		return "redirect:/all";
	}
	
	@GetMapping("/edit/{id}")	
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    Teacher teacher = db.getTeacherById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//	    System.out.println("Updated! "+teacher);
	    model.addAttribute("teacher", teacher);
	    return "add-teacher2";
	}
	
	@RequestMapping("/update/{id}")
	public String updateTeacher(@PathVariable("id") int id, Teacher teacher, BindingResult result) {
	    if (result.hasErrors()) {
	        teacher.setId(id);
	        return "redirect:/all";
	    }
	        
	    db.saveTeacher(teacher);
		System.out.println("Updated successfully!");

	    return "redirect:/all";
	}
	
	
	
	@GetMapping("/deletePage")
	public String deletePage() {
		return "redirect:/all";
	}
	
	
	
	@RequestMapping("/delete/{id}")
	public String deleteTeacher(@PathVariable("id") int id) {
		Teacher user = db.getTeacherById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    db.deleteTeacher(user);
		System.out.println("Deleted successfully!");
	    return "redirect:/all";
	}
	
	
	
	@RequestMapping("/login-teacher")
	public String OpenTeacherloginPage() {
		return "teacher-login";
	}
	
	
	
	@Autowired
	AuthenticateService authserv;
	
	@RequestMapping("/check-teacher")
	public String AuthenticateTeacherlogin(@RequestParam("email") String email,
							@RequestParam("password") String password,
							HttpSession session, Model model) {
		if(authserv.teacherAuthenticate(email, password)) {
			session.setAttribute("sessionTeacher", email);
			return "redirect:/teacher-dashboard";
		}else {
			System.out.println("Login Failed !");

			session.setAttribute("errMsg", "Invalid Credentials !!");
			return "redirect:/login-teacher";
		}
	}
	
	
	
	@RequestMapping("/logout-teacher")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login-teacher";
    }
	
	
	
	//Publish Course Page Access
	@Autowired
	CourseRepository courseRepo;
	@RequestMapping("/publishCourse")
	String publishCoursePage(Model model) {
		List<Course> list = courseRepo.findAll();
		
		model.addAttribute("allCoursesList",list);
	
		return "publishCourse";
	}
	
	//Publish Course Functionality 
	@RequestMapping("/publish/{id}")
	String publishCourse(@PathVariable("id") int id, Course course) {
		
		course = courseRepo.getReferenceById(id);
		
		course.setStatus("Published");
		
		courseRepo.save(course);
		
		System.out.println(course);
		System.out.println("Course Published.");
		
		return "redirect:/publishCourse";
		
	}
	
	
	@Autowired
	private McqCreateRepo mcqcredb;
	@RequestMapping("/allPublishedCoursesTeacher")
	String allPublishedCourses(Model model, HttpSession session){
		
		String teacherEmail = (String) session.getAttribute("sessionTeacher") ;
		
		if( teacherEmail != null) {
			
			//Fetching all published courses for students
			List<Course> list = courseRepo.findByStatus("Published");
			model.addAttribute("allCoursesList",list);
			List<McqCreate>  c=mcqcredb.findAll();
			model.addAttribute("alltest",c);
			return "allPublishedCoursesTeacher";
		}
		else {
			return "redirect:/login-teacher";
		}
		
	}
	
	
/**************** Chat Functionalities ****************/
	
	
	
	@Autowired
	ChatRepository chatRepo;
	@RequestMapping("/teacherChatPage1")
	String teacherChatPage1open(Model model, HttpSession session){
		
		String teacherEmail = (String) session.getAttribute("sessionTeacher") ;
		
		if( teacherEmail != null) {
			
			List<String> chats = chatRepo.getDistinctStudentByTeacherName(teacherEmail);
			model.addAttribute("chats", chats);
			
			return "/teacherChatPage1";
		}
		else {
			return "redirect:/login-teacher";
		}
		
	}
	
	private String student;
	
	@RequestMapping("/teacherChatPage2/{student}")
	String teacherChatPage2(Model model, HttpSession session,
			@PathVariable("student") String student){
		
		this.student=student;
		model.addAttribute("student",student);
		
		String teacherEmail = (String) session.getAttribute("sessionTeacher") ;
		
		if( teacherEmail != null) {
			
			List<Chat> allChats = chatRepo.findByStudentNameAndTeacherName(student, teacherEmail);
			System.out.println(allChats);
			model.addAttribute("allChats",allChats);
			
			Chat chat = new Chat();
			model.addAttribute("chat",chat);
			System.out.println("Khali Chat Object Created.");
			
			return "/teacherChatPage2";
		}
		else {
			return "redirect:/login-teacher";
		}
		
	}
	
	
	@RequestMapping("/savechatTeacher")
	String savechat(@ModelAttribute("chat") Chat chat) {
		
		/*
		 System.out.println(chat.getId()); System.out.println(chat.getTeacherName());
		 System.out.println(chat.getStudentName());
		 System.out.println(chat.getStudentMessage());
		 */
		
		chatRepo.save(chat);
		System.out.println("chat saved");
		return "redirect:/teacherChatPage2/"+student;
	}
}
