package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.service.UserService;
import com.ssm.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		List<User> list = userService.getAllUsers();
		model.addAttribute("list", list);
		return "list.jsp";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, User user) throws Exception {
		request.setCharacterEncoding("utf-8");
		user = new User();
		String name = request.getParameter("name");
		System.out.println(name);
		String pwd = request.getParameter("pwd");
		if (name != null && pwd != null) {
			user.setName(name);
			user.setPwd(pwd);
			if (userService.add(user)) {
				return "redirect:/user/list.do";
			}
		}
		return "/user/add.jsp";
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id") int id) {
		ModelAndView mv = new ModelAndView("/user/edit.jsp");
		User user = userService.findById(id);
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, User user) {
		userService.update(user);
		return "redirect:/user/list.do";
	}

	@RequestMapping("/delete")
	public String delete(int id) {
		userService.delete(id);
		return "redirect:/user/list.do";

	}
}
