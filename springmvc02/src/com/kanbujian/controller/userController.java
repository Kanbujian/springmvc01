package com.kanbujian.controller;

import java.util.HashMap;
import java.util.Map;

import com.kanbujian.model.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class userController {
     static Map<String,user> users=new HashMap<String,user>(); 
	
    
	 public userController() {
		
		users.put("jay", new user("jay","12345","462377353@qq.com"));
		users.put("jolin", new user("jolin","45566","4433333@qq.com"));
		users.put("Eason", new user("Eason","gsgg5","377353dddd@qq.com"));
	}

    /*
     * 展示用户信息
     */
	@RequestMapping(value="/users",method=RequestMethod.GET)
	 public String list(Model model){
		 model.addAttribute("users",users);
    	 return "/user/list";
	 }
	/*
	 * 添加用户信息
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("user1",new user());
		return "/user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated user u,BindingResult br){
		if(br.hasErrors())
			return "redirect:/user/add";
		users.put(u.getUsername(),u);
		return "redirect:/user/users";
		
	}
	/*
	 * 展示单个用户信息
	 */
	@RequestMapping(value="/{username}/show",method=RequestMethod.GET)
	public String show(@PathVariable String username,Model model){
		model.addAttribute(users.get(username));
		return "/user/show";		
		
	}
	
	/*
	 * 修改用户信息
	 */
	@RequestMapping(value="/{username}/update",method=RequestMethod.GET)
	public String update(@PathVariable String username,Model model){
		model.addAttribute(users.get(username));
		System.out.println("dao zhe mei ?");
		return "/user/update";
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.POST)
	public String update(@Validated user u,BindingResult br,Model model){
		if(br.hasErrors())
				return "/user/update";
		users.put(u.getUsername(), u);
		
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="{username}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String username,Model model){
        users.remove(username); 
        return "redirect:/user/users";
	}
	
}
