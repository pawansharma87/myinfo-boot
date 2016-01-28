package net.org.myinfo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import net.org.myinfo.model.OrgSubCategory;
@Transactional
public interface OrgSubCategoryRepository extends CrudRepository<OrgSubCategory, Integer>{
	
	
}