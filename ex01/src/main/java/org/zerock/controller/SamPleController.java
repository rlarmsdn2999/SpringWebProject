package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
//@Log4j
public class SamPleController {
	@InitBinder
	public void intitBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	public void basic() {
//		Log.info("basic get.......");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basic2() {
//		Log.info("basic get only get......");
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println(dto.getAge());
		System.out.println(dto.getName());
//		Log.info(""+dto);
		return "ex01";
	}
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
//		Log.info("name: " +name);
//		Log.info("age: "+age);
		return "ex02";
	}
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
//		Log.info("ids : "+ids);
		return "ex02List";
	}
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
//		Log.info("array ids : "+Arrays.toString(ids));
		return "ex02Array";
	}
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
//		Log.info("list dtos : " +list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
//		Log.info("todo : "+todo);
		return "ex03";
	}
	@GetMapping("ex04")
	public String ex04(SampleDTO dto, int page) {
//		Log.info("dto : "+dto);
//		Log.info("page : " + page);
		return "/sample/ex04";
	}
}
