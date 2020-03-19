package com.example.demo;

import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.ToDo;

@RunWith(SpringRunner.class)
@SpringBootTest()
@WebAppConfiguration
public class MyServiceTest{
	protected MockMvc mvc;
	
	@Autowired
	protected WebApplicationContext wac;
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
 
    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }
	@Test
	public void testGetToDoById() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/task/1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print()).andReturn()
        .getResponse()
        .getContentAsString();
	}
	@Test
	public void testPost() throws Exception {
		ToDo todo = new ToDo(1,"Hello");
        mvc.perform(MockMvcRequestBuilders.post("/api/task/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(todo)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn()
                .getResponse()
                .getContentAsString();
	}
}
