package net.org.myinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.org.myinfo.model.Organization;
import net.org.myinfo.repository.OrgRepository;
import net.org.myinfo.service.OrgService;

@Service
public class OrgServiceImpl implements OrgService {
	@Autowired
	OrgRepository orgRepository;

	@Override
	public Iterable<Organization> listAllOrganizations() {
		return orgRepository.findAll();
	}

	@Override
	public Organization getOrgById(Long id) {
		return orgRepository.findOne(id);
	}

	@Override
	public Organization saveOrg(Organization org) {
		return orgRepository.save(org);
	}

	@Override
	public void deleteOrg(Long id) {
		orgRepository.delete(id);
	}

	@Override
	public Iterable<Organization> listOrganizationByType(String orgSubType) {
		// return orgRepository.listOrganizationByType(orgSubType);
		return null;
	}

	@Override
	public List<Organization> listAllOrganizationByUserId(Long id) {
		return orgRepository.findAllByUserId(id);
	}
}
