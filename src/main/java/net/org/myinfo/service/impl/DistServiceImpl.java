package net.org.myinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.org.myinfo.model.District;
import net.org.myinfo.repository.DisttRepository;
import net.org.myinfo.service.DistService;
@Service
public class DistServiceImpl implements DistService {
	@Autowired
	DisttRepository distRepository;

	@Override
	public Iterable<District> listAllDistricts() {
		return distRepository.findAll();
	}

	@Override
	public District getDistrictById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public District saveDistrict(District district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDistrict(Integer id) {
		// TODO Auto-generated method stub

	}

}
