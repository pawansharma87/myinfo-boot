package net.org.myinfo.api;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.org.myinfo.model.Organization;

public interface OrganizationApi {
	@RequestMapping(value = "**/organizations", method = RequestMethod.GET)
	String getAllOrganization(Model model);

	@RequestMapping(value="**/organizationByType/{type}", method = RequestMethod.GET)
	String getAllOrganizationByType(@PathVariable String type, Model model);

//	@PreAuthorize("hasAuthority('ROLE_USER')")
//	@PreAuthorize("@userServiceImpl.canAccessUser(principal, #id)")
	@RequestMapping(value="/user/myorganizations", method = RequestMethod.GET)
	String getAllOrganizationByUserId(Model model);

//	@PreAuthorize("hasAuthority('ADMIN')")	
	@RequestMapping(value="/user/organization/{id}", method = RequestMethod.GET)
	String getOrganizationById(@PathVariable Long id, Model model);

//	@PostAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping(value = "/user/addorganization", method = RequestMethod.GET)
	String getOrganizationView(Model model);

	//@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping(value = "/user/addorg", method = RequestMethod.POST)
	String save(@Valid Organization organization, BindingResult bindingResult, Model model);

	//@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping(value="/user/organization/edit/{id}", method = RequestMethod.GET)
	String update(@PathVariable Long id, Model model) throws Exception;

	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/user/organization/delete/{id}", method = RequestMethod.GET)
	String delete(@PathVariable Long id);

}
