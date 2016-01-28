package net.org.myinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import net.org.myinfo.api.AdminApi;
import net.org.myinfo.model.ChangePassword;
import net.org.myinfo.model.user.User;
import net.org.myinfo.service.user.UserService;
import net.org.myinfo.util.RequestMappings;
@Controller
public class AdminApiImpl extends RequestMappings implements AdminApi {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminApiImpl.class);
	@Autowired
	UserService userService;

	@Override
	public String getchangePasswordView(Model model) {
		return "changepassword";
	}

	@Override
	public String chanepassword(ChangePassword changePassword, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "home";
		}
		User tempUser = userService.getLoggedInUser();
		if (new BCryptPasswordEncoder().matches(changePassword.getOldpassword(), tempUser.getPassword())) {
			if (changePassword.getNewpassword().equals(changePassword.getCnfpassword())) {
				tempUser.setPassword(changePassword.getNewpassword());
				userService.create(tempUser);
			} else {
				model.addAttribute("error", "Password and Confirm password doesn't match");
				return "home";
			}
		} else {
			model.addAttribute("error", "Password and old password doesn't match");
			return "home";
		}
		model.addAttribute("message", "Password changed successfully.");
		return "home";
	}

	@Override
	public String userRegistration(User user, BindingResult bindingResult, Model model) {
		LOGGER.debug("Processing user create form={}, bindingResult={}", user, bindingResult);
		if (bindingResult.hasErrors() || !user.getPassword().equals(user.getCnfpassword())) {
			model.addAttribute("error", "Password and Confirm password doesn't match");
			return "index";
		} else if (userService.getUserByUsername(user.getUsername()) != null) {
			model.addAttribute("error", "User already exist with " + user.getUsername() + " name.");
			return "index";
		}
		try {
			userService.create(user);
			userService.autoLogin(user.getUsername());
		} catch (Exception e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same user
			// at the same time and form validation has passed for more than one
			// of them.
			LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
			model.addAttribute("error", e.getMessage());
			return "index";
		}
		model.addAttribute("message", "Congratulation ! Part of Dholpur info femily.<br/> Login please.");
		return "redirect:/user/home";
	}

}
