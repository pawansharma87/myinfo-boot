package net.org.myinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.org.myinfo.model.Classified;
import net.org.myinfo.repository.ClassifiedRepository;
import net.org.myinfo.service.ClassifiedService;
@Service
public class ClassifiedServiceImpl implements ClassifiedService {
	@Autowired
	ClassifiedRepository classifiedRepository;

	@Override
	public List<Classified> listAllClassifieds() {
		return classifiedRepository.findAll();
	}

	@Override
	public Classified getClassifiedById(Long id) {
		return classifiedRepository.findOne(id);
	}

	@Override
	public Classified saveClassified(Classified roomRentClassified) {
		return classifiedRepository.save(roomRentClassified);
	}

	@Override
	public void deleteClassified(Long id) {
		classifiedRepository.delete(id);
	}

	@Override
	public List<Classified> listAllClassifiedByUserId(Long userId) {
		return classifiedRepository.findAllByUserId(userId);
	}

	@Override
	public List<Classified> listAllClassifiedByType(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
