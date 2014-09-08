package samwad.buysell.dao;

import java.sql.Date;
import java.util.List;

import samwad.buysell.model.Ad;

/**
 * DAO to save and fetch Ads
 * 
 * @author Sumit Mundra
 * @since 21 Aug 2014
 */
public interface AdDao {
    public void saveOrUpdate(Ad ad);

    public void saveOrUpdateAds(List<Ad> ads);

    public List<Ad> listAllAds();

    public void update(List<Ad> ads);

    public List<Ad> getAdsCreatedBy(String user);

    public List<Ad> getAdsPostedAfter(Date date);

    public List<Ad> getAllBuyAds();

    public List<Ad> getAllBuyAdsPostedAfter(Date date);

    public List<Ad> getAllSellAds();

    public List<Ad> getAllSellAdsPostedAfter(Date date);

    public List<Ad> getAllRentalAds();

    public List<Ad> getAllRentalAdsPostedAfter(Date date);

    public void deleteAds(List<Ad> ads);

    public void deleteAdsCreatedBy(String creator);

    public void deleteAdsPostedAfter(Date date);

    public void deleteAdsPostedBefore(Date date);
}
