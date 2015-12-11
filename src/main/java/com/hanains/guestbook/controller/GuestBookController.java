package com.hanains.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.guestbook.dao.GuestBookDao;
import com.hanains.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	
	@Autowired //자동주입
	private GuestBookDao guestbookDao;
	
	
	@RequestMapping("/")
	public String index(Model model){
		List<GuestBookVo> list = guestbookDao.getList();
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/deleteform")
	public String form(Model model){
		List<GuestBookVo> list = guestbookDao.getList();
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam ("no") long no, @RequestParam("password") String password){
		List<GuestBookVo> list = guestbookDao.getList();
		//model.addAttribute("list",list);
		
		guestbookDao.Delete(no, password);
		return "/WEB-INF/views/";
	}
	
	//vo 전달하는 방법
	/*@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestBookVo vo){
		List<GuestBookVo> list = guestbookDao.getList();
		//model.addAttribute("list",list);
		System.out.println(vo.getNo()+" "+vo.getPassword());
		
		//guestbookDao.Delete(no, password);
		return "/WEB-INF/views/";
	}*/
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestBookVo vo){ //이름 통일성있게 잘정해줘야 함. 주의사항.
		
		guestbookDao.insert(vo);
		//System.out.println(vo);
		return "redirect:/";
	}
}
