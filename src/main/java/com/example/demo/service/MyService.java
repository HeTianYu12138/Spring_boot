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
		return null;
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
	public void postAToDo(ToDo toDo) {
		list.add(toDo);
	}
	public void deleteAToDO(int id) {
		return;
	}
}
