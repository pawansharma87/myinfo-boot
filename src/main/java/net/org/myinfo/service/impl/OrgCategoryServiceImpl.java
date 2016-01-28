package net.org.myinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.org.myinfo.model.OrgCategory;
import net.org.myinfo.repository.OrgCategoryRepository;
import net.org.myinfo.service.OrgCategoryService;
@Service
public class OrgCategoryServiceImpl implements OrgCategoryService {
 @Autowired
 OrgCategoryRepository orgCategoryRepository ;
	@Override
	public Iterable<OrgCategory> listAllOrgCategorys() {
		return orgCategoryRepository.findAll();
	}
     
}
