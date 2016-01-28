package net.org.myinfo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.org.myinfo.api.UserProfileApi;
import net.org.myinfo.model.UserProfile;
import net.org.myinfo.service.UserProfileService;
import net.org.myinfo.service.user.UserService;
import net.org.myinfo.util.RequestMappings;
import net.org.myinfo.util.Util;

@Controller
public class UserProfileApiImpl extends RequestMappings implements UserProfileApi {
	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private UserService userService;

	public String newUserProfile(Model model) {
		UserProfile profile = userProfileService.getUserProfileByUserId(userService.getLoggedInUser().getId());
		model.addAttribute("userProfile", profile);
		return "userprofile";
	}

	public String saveUserProfile(@Valid UserProfile userProfile, @RequestParam("file") MultipartFile file,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("userProfile", userProfile);
			return "userprofileform";
		}
		userProfile.setUserId(userService.getLoggedInUser().getId());
		try {
			if (file.getBytes() == null) {
				userProfile.setContent(Util.getDefaultImage().toByteArray());
			} else {
				userProfile.setContent(file.getBytes());
			}
			userProfileService.saveUserProfile(userProfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// This code for download file and store it locally
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File(System.getProperty("user.home") + File.separator + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				System.out.println("You have successfully uploaded " + fileName);
			} catch (Exception e) {
				System.out.println("You failed to upload " + fileName + ": " + e.getMessage());
			}
		} else {
			System.out.println("Unable to upload. File is empty.");
		}
		return "redirect:/user/home";
	}

	public String delete(@PathVariable Long id) {
		userProfileService.deleteUserProfile(id);
		return "redirect:/userProfile";
	}

}