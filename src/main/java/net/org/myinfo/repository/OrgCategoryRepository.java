package net.org.myinfo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import net.org.myinfo.model.OrgCategory;
@Transactional
public interface OrgCategoryRepository extends CrudRepository<OrgCategory, Integer>{
	
	
}