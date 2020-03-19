package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ToDo;
import com.example.demo.service.MyService;

@RestController
@RequestMapping("/api/task")
public class MyController {
	@Resource
	MyService myService;
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ToDo> getAlltoDos() {
		return myService.getAllToDo();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void postAtoDo(@RequestBody ToDo toDo) {
		myService.postAToDo(toDo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ToDo getToDobyId(@PathVariable int id) {
		System.out.println("id is " + id);
		return myService.getToDoById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteToDobyId(@PathVariable int id) {
		System.out.println("id is " + id);
		myService.deleteAToDO(id);
	}
}
