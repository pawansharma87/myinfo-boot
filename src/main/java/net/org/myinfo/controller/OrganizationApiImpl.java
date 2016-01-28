package net.org.myinfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import net.org.myinfo.api.OrganizationApi;
import net.org.myinfo.model.Organization;
import net.org.myinfo.service.OrgService;
import net.org.myinfo.service.user.UserService;
import net.org.myinfo.util.RequestMappings;

@Controller
public class OrganizationApiImpl extends RequestMappings implements OrganizationApi {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	OrgService orgService;

	@Autowired
	UserService userService;

	@Override
	public String getAllOrganization(Model model) {
		model.addAttribute("organizations", orgService.listAllOrganizations());
		return "organizations";
	}

	@Override
	public String getAllOrganizationByType(@PathVariable String type, Model model) {
		List<Organization> listOrganization = new ArrayList<Organization>();
		/*
		 * if (orgService.listAllOrganizations() == null) {
		 * model.addAttribute("message", "Recored not found. Comingsoon."); }
		 */
		for (Organization org : orgService.listAllOrganizations()) {
			if (org.getOrgSubType().equals(type)) {
				listOrganization.add(org);
			}
		}
		model.addAttribute("organizations", listOrganization);
		return "organizations";
	}

	@Override
	public String getAllOrganizationByUserId(Model model) {
		model.addAttribute("organizations",
				orgService.listAllOrganizationByUserId(userService.getLoggedInUser().getId()));
		return "organizations";
	}

	@Override
	public String getOrganizationById(@PathVariable Long id, Model model) {
		model.addAttribute("organization", orgService.getOrgById(id));
		return "organizationview";
	}

	@Override
	public String save(@Valid Organization organization, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("organization", organization);
			return "addorganization";
		}
		Long userId = userService.getLoggedInUser().getId();
		organization.setUserId((userId));
		orgService.saveOrg(organization);
		return "redirect:/user/organization/" + organization.getId();
	}

	@Override
	public String getOrganizationView(Model model) {
		model.addAttribute("organization", new Organization());
		return "addorganization";
	}

	@Override
	public String update(@PathVariable Long id, Model model) throws Exception {
		if (userService.getLoggedInUser().getId() != orgService.getOrgById(id).getUserId()) {
			model.addAttribute("error","You are not authorised to edit this recored.");
			return "error";
		}
		model.addAttribute("organization", orgService.getOrgById(id));
		return "addorganization";
	}

	@Override
	public String delete(@PathVariable Long id) {
		orgService.deleteOrg(id);
		return "redirect:/products";
	}

}
