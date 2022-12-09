package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		System.out.println("basic......");
	}
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		System.out.println("basic get.....");
	}
	
	@GetMapping("/bacisOnlyGet")
	public void basicGet2() {
		System.out.println("basic get only get......");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println(""+dto.getName());
		System.out.println(""+dto.getAge());
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		System.out.println("name : "+name);
		System.out.println("age : "+age);
		return "ex02";
	}
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		System.out.println("ids : "+ids);
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		System.out.println("list dtos : "+list);
		return "ex01Bean";
	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		System.out.println("title : "+todo.getTitle());
		System.out.println("dueDate : "+todo.getDueDate());
		return "ex03";
	}
}
