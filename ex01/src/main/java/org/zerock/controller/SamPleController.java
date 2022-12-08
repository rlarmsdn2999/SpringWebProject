package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

@Controller
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
		return "board/ex01";
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
	public String ex03_get(TodoDTO todo) {
//		Log.info("todo : "+todo);
		return "ex03";
	}
	
	@PostMapping("/ex03")
	public String ex03_post(TodoDTO todo) {
//		Log.info("todo : "+todo);
		return "ex03";
	}
	
	@GetMapping("ex04")
	public String ex04(SampleDTO dto, int page) {
//		Log.info("dto : "+dto);
//		Log.info("page : " + page);
		return "/sample/ex04";
	}
	
	@ResponseBody
	@RequestMapping("test")
	public String test(HttpServletRequest req) {
		String value1 = req.getParameter("my");
		String value2 = req.getParameter("p");
		String value3 = req.getParameter("name");
		return value1 + ", " + value2 + ", " + value3;
	}
}
