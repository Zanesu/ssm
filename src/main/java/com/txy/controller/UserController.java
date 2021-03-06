package com.txy.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.txy.model.User;
import com.txy.service.IUserService;
import com.txy.util.ShiroUtil;

@Controller
@RequestMapping("/user")
// /user/**
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource
	private IUserService userService;

	// /user/test?id=1
	@RequiresRoles(value = "admin")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("userId:" + userId);
		User user = null;
		if (userId == 1) {
			user = new User();
			
			user.setUserName("javen");
			// userService.save(user);
		}

		log.debug(user.toString());
		model.addAttribute("user", user);
		return "index";
	}

	// /user/showUser?id=1
//	@RequiresRoles(value = "admin")
//	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
//	public String toIndex(HttpServletRequest request, Model model) {
//		String userId = request.getParameter("id");
//		System.out.println("userId:" + userId);
//		User user = this.userService.getUserById(inteuserId);
//		log.debug(user.toString());
//		model.addAttribute("user", user);
//		System.out.println(ShiroUtil.getShiroUser().getName());
//		return "showUser";
//	}
//
//	// /user/showUser2?id=1
//	@RequestMapping(value = "/showUser2", method = RequestMethod.GET)
//	public String toIndex2(@RequestParam("id") String id, Model model) {
//		String userId = id;
//		System.out.println("userId:" + userId);
//		User user = this.userService.getUserById(userId);
//		log.debug(user.toString());
//		model.addAttribute("user", user);
//		return "showUser";
//	}
//
//	// /user/showUser3/{id}
//	@RequestMapping(value = "/showUser3/{id}", method = RequestMethod.GET)
//	public String toIndex3(@PathVariable("id") String id, Map<String, Object> model) {
//
//		User user = this.userService.getUserById(id);
//		log.debug(user.toString());
//		model.put("user", user);
//		SecurityUtils.getSubject().checkRole("admin");
//
//		return "showUser";
//	}
//
//	// /user/{id}
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public @ResponseBody User getUserInJson(@PathVariable String id, Map<String, Object> model) {
//		User user = this.userService.getUserById(id);
//		log.info(user.toString());
//		return user;
//	}
//
//	// /user/{id}
//	@RequestMapping(value = "/jsontype/{id}", method = RequestMethod.GET)
//	public ResponseEntity<User> getUserInJson2(@PathVariable String id, Map<String, Object> model) {
//		User user = this.userService.getUserById(id);
//		log.info(user.toString());
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//	}

	// @RequestMapping(value="/upload")
	public String showUploadPage() {
		return "user_admin/file";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			log.info("Process file:{}", file.getOriginalFilename());
		}
		FileUtils.copyInputStreamToFile(file.getInputStream(),
				new File("E:\\", System.currentTimeMillis() + file.getOriginalFilename()));
		return "succes";
	}
}