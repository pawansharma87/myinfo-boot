package net.org.myinfo.service;

import net.org.myinfo.model.District;

public interface DistService {
    Iterable<District> listAllDistricts();

    District getDistrictById(Integer id);

    District saveDistrict(District district);

    void deleteDistrict(Integer id);
}
