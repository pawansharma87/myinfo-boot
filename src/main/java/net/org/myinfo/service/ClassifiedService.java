package net.org.myinfo.service;

import java.util.List;

import net.org.myinfo.model.Classified;


public interface ClassifiedService {
    List<Classified> listAllClassifieds();
    
    List<Classified> listAllClassifiedByUserId(Long userId);
    
    List<Classified> listAllClassifiedByType(Long userId);
    
    Classified getClassifiedById(Long id);

    Classified saveClassified(Classified roomRentClassified);

    void deleteClassified(Long id);
}
