package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.model.McqCreate;
import com.example.demo.model.McqTest;
import com.example.demo.model.Result;
import com.example.demo.model.Student;
import com.example.demo.model.StudentExam;
import com.example.demo.repository.McqCreateRepo;
import com.example.demo.repository.McqTestRepo;
import com.example.demo.repository.ResultRepo;
import com.example.demo.repository.StudentExamRepository;
import com.example.demo.repository.StudentRepository;


@Controller
public class AddMcqController {
	
	@Autowired
	McqTestRepo mcqtrepo;
	
	@RequestMapping("/mcq/{id}")
	String mcq(Model model,@PathVariable(name = "id") int qid) {
		
	//	McqTestDao db=new McqTestDao();
		McqTest q =mcqtrepo.getReferenceById(qid);
		
		Student s=new Student();
		model.addAttribute("stud", s);
		model.addAttribute("q", q);
		
		return "page-mcq";
	}
	
	@RequestMapping("/test1/{email}/{subject}")
	String myfun1(@PathVariable("email") String email,
			@PathVariable("subject") String subject, Model model) 
	{
		McqCreate mcq = new McqCreate();
		mcq.setEmail(email);
		mcq.setTitel(subject);
		mcq.setSubject(subject);
		model.addAttribute("mcqCobj", mcq);
		mcq.show();
		return "mcqcreate";
	}
	@RequestMapping("/addonemcq/{email}/{subject}/{time}")
	String dir(@PathVariable("email") String email,
			@PathVariable("subject") String subject,@PathVariable("time")String time, Model model) 
	{
		McqCreate mcq = new McqCreate();
		mcq.setTime(time);
		mcq.setEmail(email);
		mcq.setTitel(subject);
		mcq.setSubject(subject);
		model.addAttribute("mcqCobj", mcq);
		mcq.show();
		return "mcqcreate";
	}
	
	@RequestMapping("/addtest")
	String createtest(Model model) 
	{
		McqCreate mcq = new McqCreate();

		model.addAttribute("mcqCobj", mcq);
		return "addtest";
	}
	
	
	@Autowired
	McqCreateRepo mcqcredb;

	@RequestMapping("/test2")
	String myfun2(@ModelAttribute("mcqCobj") McqCreate mc, RedirectAttributes rattrs) {
		System.out.println("myfun2 Test 2");
		mc.show();
	//	McqCreateDao db = new McqCreateDao();
		mcqcredb.save(mc);
		rattrs.addAttribute("mcqCobj", mc.getEmail() + "-" + mc.getTitel());
		return "redirect:/test4";
	}

	@RequestMapping("/test4")
	String myfun4(@ModelAttribute("mcqCobj") String mc, Model model) {
		McqTest mt = new McqTest();
		System.out.println("Data in Test4 MC : " + mc);

		String emailTitel[] = mc.split("-");
		mt.setEmail(emailTitel[0]);
		mt.setTitle(emailTitel[1]);

		mt.show();
		model.addAttribute("mcqobj", mt);
		mt.show();
		System.out.println("Data to build Test");
		return "buildtest";
	}

	@RequestMapping("/AddQue")
	String myfun5(@ModelAttribute("mcqobj") McqTest mt, RedirectAttributes rattrs) {

		mt.show();
	//	McqTestDao db = new McqTestDao();
		mcqtrepo.save(mt);

		rattrs.addAttribute("mcqCobj", mt.getEmail() + "-" + mt.getTitle());

		return "redirect:/test4";
	}

	// preview
	@RequestMapping("/preview")
	public String viewHomePage(Model model) {
	//	McqTestDao db = new McqTestDao();

		List<McqTest> questionlist = mcqtrepo.findAll();
		model.addAttribute("questionlist", questionlist);

		return "testpreview";
	}

	/*
	 * @RequestMapping("/edit/{id}") public ModelAndView
	 * showEditProductPage(@PathVariable(name = "id") int id) { ModelAndView mav =
	 * new ModelAndView("editquestion"); // McqTestDao db = new McqTestDao();
	 * McqTest question = mcqtrepo.getReferenceById(id); mav.addObject("que",
	 * question);
	 * 
	 * return mav; }
	 */
	
	
	@RequestMapping("/editMcq/{id}")
	public String editpage(@PathVariable(name = "id") int id,Model model) {
		/*
		 * McqTest test = // McqTestDao db = new McqTestDao();
		 */		McqTest question = mcqtrepo.getReferenceById(id);
		model.addAttribute("ques", question);

		return "editquestion";
	}

	@RequestMapping("/UpdateQue")
	String update(@ModelAttribute("ques") McqTest mt)
	{
		System.out.println("Done 1");
		mcqtrepo.save(mt);
		return "redirect:/preview";
	}
	
	
	/*String updatque(@ModelAttribute("que") McqTest mt, RedirectAttributes rattrs) {

		System.out.println("Done 1");
		mt.show();
		//McqTestDao db = new McqTestDao();
		mcqtrepo.save(mt);

		rattrs.addAttribute("mcqCobj", mt.getEmail() + "-" + mt.getTitle());

		return "redirect:/preview";
	}*/

	@RequestMapping("/deleteMcq/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	//	McqTestDao db = new McqTestDao();
		mcqtrepo.deleteById(id);
		return "redirect:/preview";
	}

	@RequestMapping("/done")
	String done() {
		return "done";
	}
	
	
	//////////////////////////////////////////////////////////////
	
	@Autowired
	private McqTestRepo mcqRepo;
	private List<McqTest> mct;
	
	private String title;
	private String subject;
	private static int count = 0;
	private static int score = 0;
	private static int correctQues = 0;
	private static int incorrectQues = 0;
	private String studentEmail;
	
	@RequestMapping("/showmcq/{title}/{subject}")
	String showMCQS(@PathVariable("title") String title,
			@PathVariable("subject") String subject, Model model) {
		
		this.title = title;
		this.subject = subject;
		int id=0;
		return "redirect:/mcqtest/"+id;
	}
	
	@RequestMapping("/mcqtest/{id}")
	String McqTest(@PathVariable ("id") int id ,Model model,HttpSession session) {
		
	 	model.addAttribute("title", title);
		model.addAttribute("subject", subject);
		
		//list of questions by title
		mct = mcqRepo.findBytitle(title);
		model.addAttribute("mcqs",mct);	
		
		//getting single question from the list
		McqTest mcqTest = mct.get(id);
		
		model.addAttribute("mcqTest", mcqTest);
		model.addAttribute("id", id);
		studentEmail = (String) session.getAttribute("sessionStudent");
		
		StudentExam stud_exam = examRepo.findByQueidAndStudentEmail(Integer.toString(mcqTest.getqId()), studentEmail);
		System.out.println("stud_exam : "+ stud_exam);
		
		if(stud_exam==null) {
			model.addAttribute("stud_exam","null");
		}else if(stud_exam!=null) {
			model.addAttribute("stud_exam","notnull");
			model.addAttribute("stud_obj",stud_exam );	
		}
		
		//to go previous
		model.addAttribute("pid", id-1);
		count = mct.size()-1;
		 
//		System.out.println("No of question"+mct.size());
		model.addAttribute("count",mct.size()-1);
		
		return "/showMCQs";
	} 
	
	@Autowired
	StudentExamRepository examRepo;
	
	@Autowired
	ResultRepo resultRepo;
	
	@RequestMapping("/chkmcq")
	String checkMcq(@RequestParam("radio") String radio,
			@RequestParam("id") int id,
			@RequestParam("queId") String queId,
			HttpSession session, Model model) {
		
		studentEmail = (String) session.getAttribute("sessionStudent"); 
		//System.out.println(studentEmail);
		
		System.out.println("Id before increment = "+ id);
		System.out.println("Question Id : "+ queId);
		System.out.println("Seleted Ans : " + radio);
		
		StudentExam stud_exam = examRepo.findByQueidAndStudentEmail(queId, studentEmail);
		System.out.println("student ans : " + stud_exam);
		
		if(stud_exam==null) {
			StudentExam exam =new StudentExam(queId, radio, studentEmail);
			examRepo.save(exam);
			System.out.println("Inserted because it was null");
		}
		else if(stud_exam!=null && stud_exam.getQueid().equals(queId) && stud_exam.getStudentEmail().equals(studentEmail)){
			StudentExam exam = examRepo.findByQueid(queId);
			
			exam =new StudentExam(exam.getId(),queId, radio, studentEmail);
			examRepo.save(exam);
			System.out.println("Cant insert because already exists");
		}
		else if(stud_exam!=null && !stud_exam.getQueid().equals(queId) && !stud_exam.getStudentEmail().equals(studentEmail)) {
			
			StudentExam exam =new StudentExam(queId, radio, studentEmail);
			examRepo.save(exam);
			System.out.println("Inserted because 3rd condition");
		}
		
//		model.addAttribute("stud_exam", stud_exam);
		
		//generating result
		Result result;
		
		String selectedAns = radio;
		
		McqTest mcqTest = mct.get(id);
		
		result = resultRepo.findByUsernameAndSubject(studentEmail, title);
		
		StudentExam exam = examRepo.findByQueid(queId);
		
		if(selectedAns.equals(mcqTest.getAns())) {
			
			
			
			if(result==null) {
				score=score+Integer.parseInt(mcqTest.getMrk());
				
				correctQues++;
				
				result = new Result(studentEmail, title, score,correctQues);
				System.out.println("Result: "+ result);
				
				resultRepo.save(result);
				
			}
			else if (result!=null && selectedAns.equals(mcqTest.getAns())) {
				
				score=score+Integer.parseInt(mcqTest.getMrk());
				
				result = new Result(result.getId(), studentEmail, title, score,correctQues);
				System.out.println("Result: "+ result);
				resultRepo.save(result);
				
				//correctQues++;
//				if(selectedAns.equals(exam.getSelectedAns())) {
//					
//					result = new Result(result.getId(), studentEmail, title, score,correctQues);
//					System.out.println("Result: "+ result);
//					resultRepo.save(result);
//				}
				
				
				
				
			}
			
			/*
			 * else if (result!=null && !selectedAns.equals(mcqTest.getAns())){
			 * 
			 * //score=score+Integer.parseInt(mcqTest.getMrk());
			 * 
			 * //correctQues++;
			 * 
			 * result = new Result(result.getId(), studentEmail, title, score,correctQues);
			 * System.out.println("Result: "+ result);
			 * 
			 * resultRepo.save(result);
			 * 
			 * }
			 */
			 
			
		}
		else if (!selectedAns.equals(mcqTest.getAns())){
			
			if(result==null) {
				
				//score=score-Integer.parseInt(mcqTest.getMrk());
				
				incorrectQues++;
				
				result = new Result(studentEmail, title, score,correctQues);
				System.out.println("Result: "+ result);
				
				resultRepo.save(result);
				
			}else if(result!=null && !selectedAns.equals(mcqTest.getAns())) {
				
				/*
				 * if(score!=0 && score>0) { score=score-Integer.parseInt(mcqTest.getMrk()); }
				 */
				incorrectQues++;
				//correctQues++;
				
				result = new Result(result.getId(), studentEmail, title, score,correctQues);
				System.out.println("Result: "+ result);
				
				resultRepo.save(result);
				
			}
			
			
		}
		
		System.out.println("Count:"+count);
		
		id++;
		
		System.out.println("Id after increment = "+ id);
		
		if(id>count) 
		{ 
			return "redirect:/resultPage"; 
		}
		
		return "redirect:/mcqtest/"+id;
		
	}
	
	
	
	
	
	
	
	@RequestMapping("/resultPage")
	String resultPage(Model model) {
		
		System.out.println("Correct Questions : "+ score);
		System.out.println("InCorrect Questions : "+ incorrectQues);
		model.addAttribute("score",score);
		model.addAttribute("Incorrect",incorrectQues);
		return "result";
	}
	
	

	
	
	@Autowired
	private McqCreateRepo createRepo;
	
	@Autowired
	private StudentRepository studRepo;
	
	@RequestMapping("/tests")
	String takeTest(Model model, HttpSession session) {
		
		String studentEmail = (String) session.getAttribute("sessionStudent") ;
		
		if(studentEmail != null) {
			
			List<McqCreate> mcq = createRepo.findAll();
			model.addAttribute("tobj", mcq);
			
			//Fetching no. of courses enrolled by students
			Student student = studRepo.findByEmail(studentEmail);
			model.addAttribute("student",student);
			
			return "takeTest";
		}
		else {
			return "redirect:/login-student";
		}
		
		
	}
	
	
}
