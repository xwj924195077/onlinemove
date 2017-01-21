package com.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ssm.service.UserService;
import com.ssm.tool.MailUtils;
import com.ssm.vo.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");

		response.setCharacterEncoding("utf-8");

		response.getWriter().write("{\"success\":true }");
		response.getWriter().flush();
	}

	@RequestMapping("/regist")
	public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			String userEmail = request.getParameter("Email");
			String password = request.getParameter("Password");
			String verificationCode = request.getParameter("verificationCode");
			String checkcode = request.getSession().getAttribute("checkcode").toString();
			//判断验证码是否正确
			if (checkcode.equalsIgnoreCase(verificationCode)) {
				if (userEmail != null && password != null) {
					UserInfo user = new UserInfo();
					user.setUserName(userEmail);
					user.setPassword(userEmail);
					//保存数据库
					if (userService.add(user)) {
						//发送邮件
						MailUtils cn = new MailUtils();
						String context = "";
						String title = "在线电影院账号激活";
						// 设置发件人地址、收件人地址和邮件标题
						cn.setAddress("xwj6115@163.com", userEmail, title, context);
						//设置发送方的邮箱信息
						cn.send("smtp.163.com", "xwj6115@163.com", "xu199498");
						//邮件日志记录
					} else {
						//服务器内部错误
					}
						
				}
			} else {
				//验证码错误
			}
			System.out.println("verificationCode = "+verificationCode);
			System.out.println("checkcode = "+checkcode);
			
			StringBuffer sb = new StringBuffer("<h2>请您激活账号</h2>");
			sb.append("<p>系统已发送激活邮件到您的邮箱，请检查您的收件箱并按提示完成注册。</p>");
			sb.append("<p>未收到激活邮件？请<a class='js-send-email-btn' style='display: inline-block; color: blue; text-decoration: underline;' href='javascript:void(0)'>点击此处</a>重新获取激活邮件。</p>");
			sb.append("<a href='http://webinar.huawei.com/cn' id='redirecturla' style='display: none;' class='update-btn js-personal-information-form-submit'>返回</a>");
			
			resultMap.put("status", 1);
			resultMap.put("msg", sb.toString());
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSON.toJSONString(resultMap));
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		List<UserInfo> list = userService.getAllUsers();
		model.addAttribute("list", list);
		return "list.jsp";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, UserInfo user) throws Exception {
//		request.setCharacterEncoding("utf-8");
		user = new UserInfo();
		String name = request.getParameter("name");
		//解决乱码问题
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String pwd = request.getParameter("pwd");
		if (name != null && pwd != null) {
			user.setUserName(name);
			user.setPassword(pwd);
			if (userService.add(user)) {
				return "redirect:/user/list.do";
			}
		}
		return "/user/add.jsp";
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id") int id) {
		ModelAndView mv = new ModelAndView("/user/edit.jsp");
		UserInfo user = userService.findById(id);
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, UserInfo user) {
		userService.update(user);
		return "redirect:/user/list.do";
	}

	@RequestMapping("/delete")
	public String delete(int id) {
		userService.delete(id);
		return "redirect:/user/list.do";

	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
