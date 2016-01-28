package net.org.myinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.org.myinfo.model.UserProfile;
import net.org.myinfo.repository.UserProfileRepository;
import net.org.myinfo.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	private UserProfileRepository userProfileRepository;

    
    @Override
    public Iterable<UserProfile> listAllUserProfile() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        return userProfileRepository.findOne(id);
    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public void deleteUserProfile(Long id) {
        userProfileRepository.delete(id);
    }

	@Override
	public UserProfile getUserProfileByName(String name) {
		return userProfileRepository.findByName(name);
	}

	@Override
	public UserProfile getUserProfileByUserId(Long id) {
		return userProfileRepository.findByUserId(id);
	}

    
}