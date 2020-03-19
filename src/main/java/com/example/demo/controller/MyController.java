package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ToDo;
import com.example.demo.service.MyService;

@RestController
@RequestMapping("/api/task")
public class MyController {
	@Resource
	MyService myService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Object getAlltoDos() {
		List<ToDo> l = myService.getAllToDo();
		return l.isEmpty()?new String("No ToDo on list"):l;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void postAtoDo(@RequestParam("id")Integer id,@RequestParam("content")String content) {
		myService.postAToDo(id,content);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Object getToDobyId(@PathVariable int id) {
		ToDo toDo = myService.getToDoById(id);
		return toDo==null?String.format("Don't find ToDo of id %d", id):toDo;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Object deleteToDobyId(@PathVariable int id) {
		return myService.deleteAToDO(id);
	}
}
