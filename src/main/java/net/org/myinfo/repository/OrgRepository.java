package net.org.myinfo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.org.myinfo.model.Organization;

@Transactional
public interface OrgRepository extends JpaRepository<Organization, Long> {

	/**
	 * Return the user having the passed email or null if no user is found.
	 * 
	 * @param email
	 *            the user email.
	 */
//	Iterable<Organization> listOrganizationByOrgSubType(String orgSubType);
	List<Organization> findAllByUserId(Long userId);
}