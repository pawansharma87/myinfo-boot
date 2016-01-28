package net.org.myinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.org.myinfo.model.OrgSubCategory;
import net.org.myinfo.repository.OrgSubCategoryRepository;
import net.org.myinfo.service.OrgSubCategoryService;
@Service
public class OrgSubCategoryServiceImpl implements OrgSubCategoryService {
 @Autowired
 OrgSubCategoryRepository orgSubCategoryRepository ;
	@Override
	public Iterable<OrgSubCategory> listAllOrgSubCategories() {
		return orgSubCategoryRepository.findAll();
	} 
     
}
