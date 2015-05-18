package com.kanbujian.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kanbujian.exception.UserException;
import com.kanbujian.model.user;

@Controller
public class helloController {
    
	@RequestMapping("index")
	public String hello(){
		return "index";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		System.out.println("here 1");
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session){
		System.out.println(username+"  "+password);
		Map<String,user> users=new userController().users;
		System.out.println(users.containsKey("jay"));
		if(!users.containsKey(username)){
			System.out.println("用户名不存在");
			throw new UserException("用户名不存在");
			/*return "login";*/
		}
		if(!users.get(username).getPassword().equals(password)){
			System.out.println("密码不正确");
			throw new UserException("密码不正确");
			/*return "login";*/
		}
		session.setAttribute("LoginUser", users.get(username));
		return "redirect:user/users";
	}
	/*
	 * 局部异常处理
	 * 只能处理这个控制器中的异常
	 */
	/*@ExceptionHandler(value=UserException.class)
	public String handlerException(UserException u,HttpServletRequest request){
		request.setAttribute("errorMessage", u);
		return "error";		
	}*/
}
