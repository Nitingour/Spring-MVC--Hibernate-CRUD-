package com.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bean.EmployeeBean;
import dao.MyDAO;

@Controller
@SessionAttributes("user")
public class SpringController {

	@RequestMapping("/")
	public String index()
	{
		return "login";
	}
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	
	@RequestMapping("/Logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	
	
	@RequestMapping("/LoginCheck")
	//public ModelAndView check(HttpServletRequest request)
	public ModelAndView check(@RequestParam("uid") String u,@RequestParam("pwd") String p)
	{
		//String u=request.getParameter("uid");
		//String p=request.getParameter("pwd");
		//int pp=Integer.parseInt(p);
		MyDAO m=new MyDAO();
		int x=m.checkLogin(u, p);
		ModelAndView mv=null;
		if(x==1)
		//if(u.equals("admin") && p==123)
		{
			mv=new ModelAndView("home","msg","Login Success, Welcome at Admin Home");
		   	mv.addObject("user",u);
			return mv;
		}
		else
		{
		   	return new ModelAndView("login","msg","Login Fail,Try again...");
		}
		
	}
	
	@RequestMapping("/Emp")
	public String CreateEmp()
	{
		return "Emp";
	}
	@RequestMapping("/View")
	public ModelAndView ViewEmp()
	{
		ArrayList<EmployeeBean>list=new MyDAO(). viewAllEmp();
		ModelAndView mv=new ModelAndView("View","LIST",list);
		return mv;
	}
	

	@RequestMapping("/insert")
//public ModelAndView insertEmp(@RequestParam("eid") Integer eid,@RequestParam("ename") String ename,
//@RequestParam("salary") Double salary,@RequestParam("city") String city,@RequestParam("address") String address)
	public ModelAndView insertEmp(@ModelAttribute("EmployeeBean") EmployeeBean e)
				
	{
		System.out.println("Insert Method......");
	/*EmployeeBean e=new EmployeeBean();
	e.setEid(eid);
	e.setEname(ename);
	e.setSalary(salary);
	e.setCity(city);
	e.setAddress(address);*/
		
	MyDAO m= new MyDAO();
	int x=m.insertEmp(e);
	ModelAndView mv=null;	
	if(x!=0)
		{
		    mv=new ModelAndView("Emp","msg","Data Inserted Successfully...");
			return mv;
		}
	mv=new ModelAndView("Emp","msg","Data Not Inserted...");
	return mv;
	
	}
	
	
	@RequestMapping("/DeleteEmp")
	public ModelAndView deleteEmp(@RequestParam("empid") Integer eid)
	{
		int x=new MyDAO(). deleteEmployee(eid);
		ModelAndView mv=null;
		if(x!=0)
		{
			ArrayList<EmployeeBean>list=new MyDAO(). viewAllEmp();
			mv=new ModelAndView("View","msg","Data Deleted");
			mv.addObject("LIST",list);
		}
		else {
			ArrayList<EmployeeBean>list=new MyDAO(). viewAllEmp();
			mv=new ModelAndView("View","msg","Data Not Deleted");
			mv.addObject("LIST",list);
		}
			return mv;
	}
	
	
	@RequestMapping("/UpdateEmp")
	public ModelAndView updateEmp(@RequestParam("empid") Integer eid)
	{
		EmployeeBean ee=new MyDAO().getEmployeeByEmpID(eid);
		
		ModelAndView mv=new ModelAndView("updateEmp","EMP",ee);
			return mv;
	}
	
	
	@RequestMapping("/EmpUpdateInsert")
public ModelAndView updateEmp(@ModelAttribute("EmployeeBean") EmployeeBean e)
		{
		MyDAO m= new MyDAO();
		int x=m.updateEmp(e);
		ModelAndView mv=null;	
		ArrayList<EmployeeBean>list=new MyDAO(). viewAllEmp();
		if(x!=0)
			{
			   mv=new ModelAndView("View","msg","Data Updated Successfully...");
			    mv.addObject("LIST",list);
				return mv;
			}
		mv=new ModelAndView("View","msg","Data Not Updated...");
		  mv.addObject("LIST",list);
			
		return mv;
		
		}
	
}
