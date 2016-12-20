package com.ssm.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.dao.UserDao;
import com.ssm.vo.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/xx")
	@ResponseBody
	public void saveUsers(@RequestBody List<String> list) {
		System.out.println("**************************");
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		List<User> list = userDao.findAll();
		System.out.println(list);
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
			userDao.save(user);
			System.out.println(user);
			return "redirect:/list.do";
		} else {
			return "add.jsp";
		}
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id") int id) {
		ModelAndView mv = new ModelAndView("edit.jsp");
		User user = userDao.findById(id);
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, User user) {
		userDao.update(user);
		return "redirect:/list.do";
	}

	@RequestMapping("/delete")
	public String delete(int id) {
		userDao.delete(id);
		return "redirect:/list.do";

	}

	public UserDao getUserService() {
		return userDao;
	}

	public void setUserService(UserDao userDao) {
		this.userDao = userDao;
	}
}
