package net.org.myinfo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.org.myinfo.model.Classified;
@Transactional
public interface ClassifiedRepository extends JpaRepository<Classified, Long>{
	List<Classified> findAllByUserId(Long userId);
	
}