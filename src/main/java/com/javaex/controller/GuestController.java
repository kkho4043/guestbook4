package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller
@RequestMapping(value = "/guest")
public class GuestController {

	@Autowired
	private GuestDao guestDao;
	
	@RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {

		System.out.println("ok");

		List<GuestVo> guestVo = guestDao.getguestList();

		System.out.println(guestVo.toString());

		model.addAttribute("gList", guestVo);

		return "list";
	}

	@RequestMapping(value = "write", method = { RequestMethod.GET, RequestMethod.POST })
	public String wtire(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("write");
	
		guestDao.guestInsert(guestVo);
		return "redirect:/guest/list";
	}
	
	@RequestMapping(value = "confirmpassword/{where}/{guestno}", method = { RequestMethod.GET, RequestMethod.POST })
	public String confirmpassword(@PathVariable("where")String where, 
								  @PathVariable("guestno") int no,
								  Model model) {
		System.out.print("confirmpassword:");

		System.out.println(where);
		
		model.addAttribute("where",where);
		model.addAttribute("no",no);
		return "confirmpassword";
	}
	
	@RequestMapping(value = "notsamepwd/{where}/{guestno}", method = { RequestMethod.GET, RequestMethod.POST })
	public String notsamepwd(@PathVariable("where")String where, 
						 	 @PathVariable("guestno") int no, 
						 	 @RequestParam("pwd") String pwd,Model model) {
		
		System.out.print("notsamepwd:");
		System.out.println(where);
		
		GuestVo guestVo = guestDao.getList(no);
		String pwd2= guestVo.getPassword();
		
		System.out.println("pwd = "+pwd);
		System.out.println("pwd2 = "+pwd2);
		if(pwd.equals(pwd2)) {
			return "redirect:/guest/"+where+"/"+no;
		}else {
			model.addAttribute("where",where);
			model.addAttribute("no",no);
			return "notsamepwd";
		}
	}
	
	@RequestMapping(value = "modifyForm/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyform(@PathVariable("no") int no,Model model) {
		
		System.out.println("modifyForm");
		
		GuestVo guestVo = guestDao.getList(no);
	
		model.addAttribute("gList", guestVo);
		return "modify";
	}
	
	@RequestMapping(value = "modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("modify");
		guestDao.guestupdate(guestVo);
		return "redirect:/guest/list";
	}
	
	@RequestMapping(value = "delete/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("no") int no) {
		
		System.out.println("delete");


		guestDao.guestDelete(no);
	
		return "redirect:/guest/list";
	}
	

}