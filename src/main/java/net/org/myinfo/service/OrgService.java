package net.org.myinfo.service;

import java.util.List;

import net.org.myinfo.model.Organization;

public interface OrgService {
	Iterable<Organization> listAllOrganizations();
	
	List<Organization> listAllOrganizationByUserId(Long id);

	Organization getOrgById(Long id);

	Organization saveOrg(Organization org);

	void deleteOrg(Long id);
	
	Iterable<Organization> listOrganizationByType(String type);	
}
