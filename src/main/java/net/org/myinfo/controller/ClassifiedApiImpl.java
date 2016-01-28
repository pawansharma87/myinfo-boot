package net.org.myinfo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import net.org.myinfo.api.ClassifiedApi;
import net.org.myinfo.model.Classified;
import net.org.myinfo.model.user.User;
import net.org.myinfo.service.ClassifiedService;
import net.org.myinfo.service.user.UserService;
import net.org.myinfo.util.RequestMappings;

@Controller
public class ClassifiedApiImpl extends RequestMappings implements ClassifiedApi {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ClassifiedService classifiedService;

	@Autowired
	UserService userService;

	@Override
	public String getAllClassified(Model model) {
		model.addAttribute("classifieds", classifiedService.listAllClassifieds());
		return "classifieds";
	}

	@Override
	public String getAllClassifiedByType(String type, Model model) {
		List<Classified> listOrganization = new ArrayList<Classified>();
		for (Classified classified : classifiedService.listAllClassifieds()) {
			if (classified.getRoomType().equals(type)) {
				listOrganization.add(classified);
			}
		}
		model.addAttribute("classifieds", listOrganization);
		return "classifieds";
	}

	@Override
	public String getAllClassifiedByUserId(Model model) {
		User user = userService.getLoggedInUser();
		model.addAttribute("classifieds", classifiedService.listAllClassifiedByUserId(user.getId()));
		return "classifieds";
	}

	@Override
	public String getClassifiedById(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClassifiedView(Model model) {
		model.addAttribute("classified", new Classified());
		return "addclassifieds";
	}

	@Override
	public String getClassifiedDetail(Long id, Model model) {
		model.addAttribute("classifieds", classifiedService.getClassifiedById(id));
		return "classifiedsview";
	}

	@Override
	public String save(Classified classified, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("classifieds", classified);
			return "addclassifieds";
		}
		classified.setUserId(userService.getLoggedInUser().getId());
		classifiedService.saveClassified(classified);
		return "redirect:/user/classifieds/" + classified.getClassified_id();
	}

	@Override
	public String update(Long id, Model model) {
		model.addAttribute("classifieds", classifiedService.getClassifiedById(id));
		return "addclassifieds";
	}

	@Override
	public String delete(Long id) {
		classifiedService.deleteClassified(id);
		return "redirect:/user/classifieds";
	}
}