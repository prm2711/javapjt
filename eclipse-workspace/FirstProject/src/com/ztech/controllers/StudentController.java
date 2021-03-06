package com.ztech.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ztech.dao.*;
import com.ztech.dto.*;

@Controller

public class StudentController
{
	InsertData insertData = new InsertData();

	
	@RequestMapping(value="/")
	public String display()
	{
		return "index";
	}
	
	@RequestMapping(value = "/save")
	public ModelAndView save(@RequestParam("roll_no")int roll_no,@RequestParam("student_name")String student_name,
			@RequestParam("marks")int marks,@RequestParam("marksphy")int marksphy,
			@RequestParam("markschem")int markschem) {
		Student student=new Student();
		student.setRollNo(roll_no);
		student.setName(student_name);
		student.setMarks(marks);
		student.setMarksPhy(marksphy);
		student.setMarksChem(markschem);
		insertData.insertStudent(student);
		//ModelAndView model=new ModelAndView("index");
		//model.addObject("msg", "Data inserted successfully");
		return new ModelAndView("index","msg","Inserted Data");
	}

}
