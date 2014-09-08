package samwad.buysell.service;

import java.util.List;

import samwad.buysell.model.Ad;

public interface AdService {
    void save(Ad ad);
    
    void update(Ad ad);
    
    void delete(Ad ad);
    
    List<Ad> findByCreator(String createdBy);
}
