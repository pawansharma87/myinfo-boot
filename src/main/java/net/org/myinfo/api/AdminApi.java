package net.org.myinfo.api;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.org.myinfo.model.ChangePassword;
import net.org.myinfo.model.user.User;

public interface AdminApi {

	@RequestMapping(value = "/user/changepassword")
	String getchangePasswordView(Model model);

	@RequestMapping(value = "/user/changepassword", method = RequestMethod.POST)
	String chanepassword(@Valid ChangePassword changePassword, BindingResult bindingResult, Model model);

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	String userRegistration(@Valid User user, BindingResult bindingResult, Model model);
}
