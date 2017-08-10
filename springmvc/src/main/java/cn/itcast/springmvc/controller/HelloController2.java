package cn.itcast.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.springmvc.pojo.User;
import cn.itcast.springmvc.pojo.UserVO;

@RequestMapping("hello")
@Controller
public class HelloController2{

	@RequestMapping(value="show1")
	public ModelAndView test1(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("msg","注解方式的springmvc");
		return mv;
	}
	
	@RequestMapping(value="/sss*/show2")
	public ModelAndView test2(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("msg","注解方式的springmvc:sss");
		return mv;
	}
	
	@RequestMapping(value="show3/{name}/{id}")
	public ModelAndView test3(@PathVariable("name") String name, @PathVariable("id") Long id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("msg","注解方式的springmvc:占位符"+"name="+name+"id="+id);
		return mv;
	}
	
	@RequestMapping(value="show4", method=RequestMethod.POST)
	public ModelAndView test4(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("msg","注解方式的springmvc:限定请求方法");
		return mv;
	}
	
	@RequestMapping(value="show5", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView test5(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("msg","注解方式的springmvc:限定多种请求方法");
		return mv;
	}
	
	@RequestMapping(value="show8", params="id")
	public ModelAndView test8(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "springmvc的映射之限定请求参数，id");
		return mv;
	}
	
	@RequestMapping(value="show9", params="!id")
	public ModelAndView test9(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "springmvc的映射之限定请求参数，!id");
		return mv;
	}
	
	@RequestMapping(value="show10", params="id=1")
	public ModelAndView test10(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "springmvc的映射之限定请求参数，id=1");
		return mv;
	}
	
	@RequestMapping(value="show11", params="id!=1")
	public ModelAndView test11(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "springmvc的映射之限定请求参数，id!=1");
		return mv;
	}
	
	@RequestMapping(value="show12", params={"id","name"})
	public ModelAndView test12(){
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("msg", "springmvc的映射之限定请求参数，id,name");
		return mv;
	}

	@RequestMapping(value="show13")
	public ModelAndView test13(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		ModelAndView mv = new ModelAndView("hello");
		StringBuffer sb = new StringBuffer();
		sb.append("request:" + request + "<br/>");
		sb.append("response:" + response + "<br/>");
		sb.append("session:" + session + "<br/>");
		mv.addObject("msg", "springmvc接收servlet内置对象" + sb.toString());
		return mv;
	}

	@RequestMapping(value="show14")
	public String test14(Model model, ModelMap map){
		model.addAttribute("msg1", "springmvc接收servlet内置对象:特有内置对象");
		map.addAttribute("msg", "springmvc接收servlet内置对象：特有内置对象2");
		return "hello";
	}
	
	@RequestMapping(value="show15/{name}")
	public String test15(Model model, @PathVariable(value = "name")String  name){
		model.addAttribute("msg", "springmvc接收占位符请求参数:"+name);
		return "hello";
	}
	
	@RequestMapping(value="/show16")
	public String test16(Model model, @RequestParam(value = "ss")String  ssd){
		model.addAttribute("msg", "springmvc接收请求参数:"+ssd);
		return "hello";
	}
	
	@RequestMapping(value="/show17")
	public String test17(Model model, @RequestParam(value = "ss",required=false)String  ssd){
		model.addAttribute("msg", "springmvc接收请求参数:"+ssd);
		return "hello";
	}
	
	@RequestMapping(value="/show18")
	public String test18(Model model, @RequestParam(value = "ss",required=true,defaultValue="haha")String  ssd){
		model.addAttribute("msg", "springmvc接收请求参数:"+ssd);
		return "hello";
	}
	
	@RequestMapping(value="show19")
	public String test19(Model model, @CookieValue(value="JSESSIONID")String  jsessionID){
		model.addAttribute("msg", "springmvc的cookie:"+jsessionID);
		return "hello";
	}
	
	@RequestMapping(value="show20")
	@ResponseStatus(value=HttpStatus.OK)
	public void test20(
			@RequestParam(value="name") String name,
			@RequestParam(value="age") Integer age,
			@RequestParam(value="income") Double income,
			@RequestParam(value="isMarry") Boolean isMarry,
			@RequestParam(value="interests") String[] interests
			){
		System.out.println(name);
		System.out.println(age);
		System.out.println(income);
		System.out.println(isMarry);
		for (String i : interests) {
			System.out.println(i);
		}
	}
	
	@RequestMapping(value="show21")
	public String test21(Model model, User user){
		model.addAttribute("msg", user);
		return "hello";
	}
	
	@RequestMapping(value="show22")
	public String test22(Model model, UserVO userVO){
		model.addAttribute("msg", userVO.getUsers().toString());
		return "hello";
	}
	
	@RequestMapping(value="show23")
	public String test23(Model model){
		List<User> userlist = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId(i);
			user.setAge(18+i);
			user.setName("zzz"+i);
			user.setUserName("bbb"+i);
			userlist.add(user);
		}
		model.addAttribute("userlist",userlist);
		return "users";
	}
	
	@RequestMapping(value="show24")
	@ResponseBody
	public List<User> test24(){
		List<User> userlist = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId(i);
			user.setAge(18+i);
			user.setName("zzz"+i);
			user.setUserName("bbb"+i);
			userlist.add(user);
		}
		
		return userlist;
	}
	
	@RequestMapping(value="show25")
	public String test25(Model model, @RequestParam("file")MultipartFile file) 
			throws IllegalStateException, IOException{
		if (file!=null) {
			file.transferTo(new File("f:\\tmp\\" + file.getOriginalFilename()));
		}
		return "redirect:/success.html";
	}
	
	@RequestMapping(value="show26")
	public String test26(){
		return "redirect:show24.do";
	}
	
	@RequestMapping(value="show27")
	public String test27(){
		return "forward:show24.do";
	}

}
