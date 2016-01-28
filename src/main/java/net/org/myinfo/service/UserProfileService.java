package net.org.myinfo.service;

import net.org.myinfo.model.UserProfile;

public interface UserProfileService {
    Iterable<UserProfile> listAllUserProfile();

    UserProfile getUserProfileById(Long id);
    
    UserProfile getUserProfileByUserId(Long id);
    
    UserProfile getUserProfileByName(String Name);

    UserProfile saveUserProfile(UserProfile userProfile);

    void deleteUserProfile(Long id);
}
