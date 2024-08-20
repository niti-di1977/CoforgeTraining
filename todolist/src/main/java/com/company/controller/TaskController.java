package com.company.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.model.Task;
import com.company.model.User;
import com.company.service.TaskService;
import com.company.service.UserServiceImpl;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired 
	private UserServiceImpl userService;
	
	@PostMapping("/authenticate")
	public String AuthenticateUser(@RequestParam("username")String username,@RequestParam("pword")String password, Model model,
									HttpServletRequest req)
	{
		User u = new User(username,password);
		if(userService.findUser(u))
		{
			
			//session is a timeperiod in between login and logout
			//session tracking :  the server application keeping the track user's sensitive infor for a time period
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
		     return "redirect:/service.html";	
		}
		   
		model.addAttribute("message","invalid UserName/password");
			  return "redirect:/display.html";
			
		
	}
	
	
	@GetMapping("/home")
	public String index(Model model)
	{
		model.addAttribute("tasks",taskService.getAllTasks());
		return "index"; 
	}
	
	
	
	
	@GetMapping("/add")
	public String addTaskForm(Model model)
	{
		model.addAttribute("task",new Task());
		System.out.println("Add Task");
		return "add"; 
	}
	
	@PostMapping("/save")
	public String saveTask(@ModelAttribute Task task)
	{
		
		taskService.saveTask(task);
		return "redirect:/";
	}
}
