package com.example.springboot.web.springBootDemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.web.springBootDemo.model.TaskToDo;

import com.example.springboot.web.springBootDemo.service.TaskToDoRepository;

@Controller
public class TaskToDoController {
	
	@Autowired
	TaskToDoRepository repository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/list-tasks", method = RequestMethod.GET)
	public String showTasksToDo(ModelMap model) {
		 model.addAttribute("activeTasksToDo", "active");
		 String name = getLoggedInUserName(model);
		model.put("tasksToDo", repository.findByUser(name));
		return "list-tasks";
	}
	
	@RequestMapping(value = "/add-task", method = RequestMethod.GET)
	public String showAddedTaskToDo(ModelMap model) {
		model.addAttribute("taskToDo", new TaskToDo(0, getLoggedInUserName(model), " ", new Date(), false));
		return "taskToDo";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		}
		return principal.toString();
	}
	
	@RequestMapping(value = "/delete-task", method = RequestMethod.GET)
	public String deleteTaskTodo(@RequestParam int id) {
		repository.deleteById(id);
		return "redirect:/list-tasks";
	}
	
	@RequestMapping(value = "/update-task", method = RequestMethod.GET)
	public String showTaskToUpdate(@RequestParam int id, ModelMap model) {

		/*TODO: better to use Optional<TaskToDo> aTask = repository.findById(id);
		later I will change this for not using getOne. 
		if no entity in database, it will throw EntityNotFoundException*/
		TaskToDo aTask = repository.getOne(id);
		model.put("taskToDo", aTask);
		return "taskToDo";
	}
	
	@RequestMapping(value = "/update-task", method = RequestMethod.POST)
	public String updateTaskTodo(ModelMap model, @Valid TaskToDo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "taskToDo";
		}
		todo.setUser(getLoggedInUserName(model));
		repository.save(todo);
		
		return "redirect:/list-tasks";
	}
	
	@RequestMapping(value = "/add-task", method = RequestMethod.POST)
	public String addTaskToDo(ModelMap model, @Valid TaskToDo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "taskToDo";
		}
		todo.setUser(getLoggedInUserName(model));
		repository.save(todo);
		return "redirect:/list-tasks";
	}

}

