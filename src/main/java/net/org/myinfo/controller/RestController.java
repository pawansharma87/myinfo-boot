package net.org.myinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.org.myinfo.model.UserProfile;
import net.org.myinfo.service.UserProfileService;
import net.org.myinfo.service.user.UserService;
import net.org.myinfo.util.RequestMappings;
import net.org.myinfo.util.Util;

@Controller
public class RestController extends RequestMappings {
	@Autowired
	UserProfileService profileService;
	@Autowired
	UserService userService;

	@RequestMapping("/user/home")
	String home(Model model) {
		String base64Encoded = null;
		UserProfile profile = profileService
				.getUserProfileByUserId(userService.getLoggedInUser().getId());
		if (profile != null && profile.getContent() != null) {
			base64Encoded = Util.getImageEncoded(profile.getContent());
			model.addAttribute("image", base64Encoded);
			return "home";
		} else {
			base64Encoded = Util.getImageEncoded(Util.getDefaultImage().toByteArray());
			model.addAttribute("image", base64Encoded);
			model.addAttribute("userProfile", new UserProfile());
			return "userprofile";
		}
	}

	@RequestMapping("/user/plumber")
	String personeEng(Model model) {
		String base64Encoded = Util.getImageEncoded(Util.getDefaultImage().toByteArray());
		model.addAttribute("image", base64Encoded);
		return "plumber";
	}
}