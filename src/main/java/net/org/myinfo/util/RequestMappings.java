package net.org.myinfo.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.org.myinfo.model.District;
import net.org.myinfo.model.OrgCategory;
import net.org.myinfo.model.OrgSubCategory;
import net.org.myinfo.model.State;
import net.org.myinfo.model.UserProfile;
import net.org.myinfo.service.DistService;
import net.org.myinfo.service.OrgCategoryService;
import net.org.myinfo.service.OrgSubCategoryService;
import net.org.myinfo.service.StateService;
import net.org.myinfo.service.UserProfileService;
import net.org.myinfo.service.user.UserService;

public class RequestMappings {

	@Autowired
	UserService userService;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	StateService stateService;

	@Autowired
	DistService distService;

	@Autowired
	OrgCategoryService orgCategoryService;

	@Autowired
	OrgSubCategoryService orgSubCategoryService;

	@ModelAttribute("state")
	public List<State> populateStates() {
		List<State> listStates = new ArrayList<State>();
		for (State e : stateService.listAllStates()) {
			listStates.add(e);
		}
		return listStates;
	}

	@ModelAttribute("distt")
	public List<District> populateDist() {
		List<District> listDistricts = new ArrayList<District>();
		for (District dist : distService.listAllDistricts()) {
			listDistricts.add(dist);
		}
		return listDistricts;
	}

	@ModelAttribute("orgType")
	public List<OrgCategory> populateorgType() {
		List<OrgCategory> listOrgCategory = new ArrayList<OrgCategory>();
		for (OrgCategory type : orgCategoryService.listAllOrgCategorys()) {
			listOrgCategory.add(type);
		}
		return listOrgCategory;
	}

	@ModelAttribute("orgSubType")
	public List<OrgSubCategory> populateorgSubType() {
		List<OrgSubCategory> listOrgSubCategory = new ArrayList<OrgSubCategory>();
		for (OrgSubCategory type : orgSubCategoryService.listAllOrgSubCategories()) {
			listOrgSubCategory.add(type);
		}
		return listOrgSubCategory;
	}

	@ModelAttribute("roomType")
	public List<String> populateRoomType() {
		List<String> listRoomType = new ArrayList<String>();
		listRoomType.add("1BHK");
		listRoomType.add("2BHK");
		listRoomType.add("Single Room");
		listRoomType.add("Single Room Kitchen");
		listRoomType.add("Double Room");
		listRoomType.add("Double Room Kitchen");
		listRoomType.add("Shop");
		return listRoomType;
	}

	@ModelAttribute("city")
	public List<String> populateCity() {
		List<String> listCity = new ArrayList<String>();
		listCity.add("Dholpur");
		listCity.add("Bari");
		listCity.add("Baseri");
		listCity.add("Rajakhera");
		listCity.add("Sarmathura");
		return listCity;
	}

	@ModelAttribute("engType")
	public Map<String, String> populateEngType() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("PL", "Plumber");
		map.put("ELC", "Electrician");
		return map;
	}

	@ModelAttribute("image")
	public String image() {
		ByteArrayOutputStream baos = null;
		UserProfile profile = null;
		try {
			Long userId = userService.getLoggedInUser().getId();
			if (userId != null)
				profile = userProfileService.getUserProfileByUserId(userId);
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
		}

		if (profile != null && profile.getContent() != null) {
			byte image[] = profile.getContent();
			return Util.getImageEncoded(image);
		} else {
			baos = Util.getDefaultImage();
		}
		return Util.getImageEncoded(baos.toByteArray());
	}
}
