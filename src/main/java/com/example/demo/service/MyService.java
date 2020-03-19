package com.example.demo.service;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ToDo;
@Service
public class MyService {
	List<ToDo> list;
	public MyService() {
		list = new LinkedList<ToDo>();
	}
	public List<ToDo> getAllToDo() {
		return list;
	}
	public ToDo getToDoById(int id) {
		Iterator<ToDo> iterator = list.iterator();
		while(iterator.hasNext()) {
			ToDo curDo = iterator.next();
			if(curDo.getId()==id) {
				return curDo;
			}
		}
		return null;
	}

	public String deleteAToDO(int id) {
		Iterator<ToDo> iterator = list.iterator();
		while(iterator.hasNext()) {
			ToDo curDo = iterator.next();
			if(curDo.getId()==id) {
				list.remove(curDo);
				return "Success";
			}
		}
		return "No toDo of id "+id;
	}
	public void postAToDo(int id, String content) {
		list.add(new ToDo(id, content));
	}
	public void postAToDo(ToDo todo) {
		list.add(todo);
	}
}
