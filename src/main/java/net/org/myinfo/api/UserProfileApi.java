package net.org.myinfo.api;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.org.myinfo.model.UserProfile;

public interface UserProfileApi {
	
	@RequestMapping("userProfile/delete/{id}")
	String delete(@PathVariable Long id);

	@RequestMapping(value = "user/userProfile", method = RequestMethod.POST)
	String saveUserProfile(@Valid UserProfile userProfile, @RequestParam("file") MultipartFile file,
			BindingResult bindingResult, Model model);

	@RequestMapping("/user/userProfile/new")
	String newUserProfile(Model model);
}
