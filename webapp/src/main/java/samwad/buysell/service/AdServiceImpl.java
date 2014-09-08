package samwad.buysell.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import samwad.buysell.dao.AdDaoImpl;
import samwad.buysell.model.Ad;

@Service("adService")
public class AdServiceImpl implements AdService {
    
    @Autowired
    private AdDaoImpl adDaoImpl;

    @Override
    public void save(Ad ad) {
        adDaoImpl.saveOrUpdate(ad);
    }

    @Override
    public void update(Ad ad) {
        List<Ad> l = new ArrayList<Ad>();
        l.add(ad);
        adDaoImpl.update(l);
    }

    @Override
    public void delete(Ad ad) {
        List<Ad> l = new ArrayList<Ad>();
        l.add(ad);
        adDaoImpl.deleteAds(l);
    }

    @Override
    public List<Ad> findByCreator(String creator) {
        List<Ad> l = adDaoImpl.getAdsCreatedBy(creator);
        return l;
    }

}
