package fr.sij.tp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import fr.sij.tp.dto.TaskDto;
import fr.sij.tp.dto.TodoListDto;
import fr.sij.tp.repository.MockRepository;

@RestController
@RequestMapping("/TodoListController")
public class MyController {

	@Autowired
	MockRepository mr;
	Logger logger;

	public MyController() {
		this.logger = LoggerFactory.getLogger(MyController.class);
	}

	@GetMapping(value = "/hello")
	public String Affiche() {
		Date date = new Date();
		return "Hello " + date;
	}

	@GetMapping(value = "/motivation")
	public String motivation() {

		return "Motivé\nMotivé\nMotivé";
	}

	@GetMapping(value = "/")
	public String todoLists() {
		String str = "";
		for (TodoListDto toDo : mr.getAll()) {
			str = str + toDo.toString();
		}
		return str;
	}

	@GetMapping(value = "/{id}")
	public String todoLists(@PathVariable int id) {
		return mr.get(id).toString();
	}

	@GetMapping(value = "/jsons")
	public List<TodoListDto> todoListsJson() {

		return mr.getAll();
	}

	@GetMapping(value = "/json/{id}")
	public TodoListDto todoListsJson(@PathVariable int id) {
		return mr.get(id);
	}

	@GetMapping(value = "/json")
	public TodoListDto todoListsJsonId(@RequestParam(required = false, name = "id") int id) {
		return mr.get(id);
	}

	@GetMapping(value = "/date")
	public String getDate(@RequestParam("date") String date) {

		SimpleDateFormat originalFormat = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat toPrint = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		String res = "";
		try {
			res = toPrint.format(originalFormat.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error(e.getLocalizedMessage());
			res = "Wrong date format " + date;
		}
		return res;
	}

	// POST
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int createList(@RequestBody TodoListDto todoList) {
		if (mr.get(todoList.id) == null) {
			mr.add(todoList);
		} else {
			String errorStr = "Object is already added.";
			IllegalArgumentException e = new IllegalArgumentException(errorStr);
			logger.error(errorStr, e);
			throw e;
			// return -1;
		}

		System.out.println(todoList.toString());
		return todoList.id;
	}

	// PUT
	@PutMapping(value = "/")
	public int putlist(@RequestBody TodoListDto todoList) {
		int id = -1;
		if (mr.get(todoList.id) == null) {
			String errorStr = "Id not found.";
			IllegalArgumentException e = new IllegalArgumentException(errorStr);
			logger.error(errorStr, e);
			throw e;
		}
		if (mr.get(todoList.id).equals(todoList)) {
			String errorStr = "New object is equals to old Object.";
			IllegalArgumentException e = new IllegalArgumentException(errorStr);
			logger.error(errorStr, e);
			throw e;
		}
		mr.add(todoList);
		return todoList.id;

	}

	// POST
	@PostMapping(value = "/{id}/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int createList(@RequestBody TaskDto task, @PathVariable("id") int id) {
		if (mr.get(id) == null) {
			String errorStr = "No todoList found.";
			IllegalArgumentException e = new IllegalArgumentException(errorStr);
			logger.error(errorStr, e);
			throw e;
		}
		if (!mr.get(id).tasks.contains(task)) {
			mr.get(id).tasks.add(task);
			return id;
		}
		String errorStr = "Task already exist.";
		IllegalArgumentException e = new IllegalArgumentException(errorStr);
		logger.error(errorStr, e);
		throw e;
	}

	// PUT
	@PutMapping(value = "/{idList}/task")
	public int putTask(@RequestBody TaskDto task, @PathVariable("idList") int idList) {
		int id = -1;
		if (mr.get(idList) == null) {
			String errorStr = "Id not found.";
			IllegalArgumentException e = new IllegalArgumentException(errorStr);
			logger.error(errorStr, e);
			throw e;
		}
		int index = mr.get(idList).tasks.indexOf(task);
		if (index >= 0) {
			mr.get(idList).tasks.set(index, task);
		}
		String errorStr = "No Task found.";
		IllegalArgumentException e = new IllegalArgumentException(errorStr);
		logger.error(errorStr, e);
		throw e;
	}

	// DELET
	@DeleteMapping(value = "/{idList}/task/{idTask}")
	public boolean delete(@PathVariable("idTask") int idTask, @PathVariable("idList") int idList) {
		if (mr.get(idList) == null) {
			String errorStr = "No todoList found.";
			IllegalArgumentException e = new IllegalArgumentException(errorStr);
			logger.error(errorStr, e);
			throw e;
		}

		TaskDto task = mr.get(idList).getTask(idTask);
		if(task == null) {

			String errorStr = "Task not foud.";
			IllegalArgumentException e = new IllegalArgumentException(errorStr);
			logger.error(errorStr, e);
			throw e;
		}
		
		else {
			return mr.get(idList).tasks.remove(task);
		}
		
		/*
		
		TaskDto task = new TaskDto();
		task.id = idTask;
		if (mr.get(idList).tasks.remove(task)) {
			
			return true;
		}
		/*
		 * List<TaskDto> tasks = mr.get(idList).tasks; for(int i =0; i<
		 * tasks.size();i++) { if(tasks.get(i).id == idTask) {
		 * mr.get(idList).tasks.remove(i);
		 * 
		 * return true; } }
		 */

	/*	String errorStr = "Task not foud.";
		IllegalArgumentException e = new IllegalArgumentException(errorStr);
		logger.error(errorStr, e);
		throw e;*/
	}

}
