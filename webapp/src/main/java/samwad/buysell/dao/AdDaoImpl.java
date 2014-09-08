package samwad.buysell.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import samwad.buysell.model.Ad;

@Component("adDao")
public class AdDaoImpl implements AdDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            return sessionFactory.openSession();
        }
    }

    @Override
    public void saveOrUpdate(Ad ad) {
        getCurrentSession().saveOrUpdate(ad);
    }

    @Override
    public void saveOrUpdateAds(List<Ad> ads) {
        for (Ad ad : ads) {
            saveOrUpdate(ad);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Ad> listAllAds() {
        return getCurrentSession().createCriteria(Ad.class).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Ad> getAdsCreatedBy(String user) {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.like("createdBy", user));
        return c.list();
    }

    @Override
    public List<Ad> getAdsPostedAfter(Date date) {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.gt("timeOfSubmission", date));
        return c.list();
    }

    @Override
    public List<Ad> getAllBuyAds() {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.eq("adType", Ad.AdType.BUY));
        return c.list();
    }

    @Override
    public List<Ad> getAllBuyAdsPostedAfter(Date date) {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.eq("adType", Ad.AdType.BUY)).add(Restrictions.gt("timeOfSubmission", date));
        return c.list();
    }

    @Override
    public List<Ad> getAllSellAds() {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.eq("adType", Ad.AdType.SELL));
        return c.list();
    }

    @Override
    public List<Ad> getAllSellAdsPostedAfter(Date date) {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.eq("adType", Ad.AdType.SELL)).add(Restrictions.gt("timeOfSubmission", date));
        return c.list();
    }

    @Override
    public List<Ad> getAllRentalAds() {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.eq("adType", Ad.AdType.RENTAL));
        return c.list();
    }

    @Override
    public List<Ad> getAllRentalAdsPostedAfter(Date date) {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.eq("adType", Ad.AdType.RENTAL)).add(Restrictions.gt("timeOfSubmission", date));
        return c.list();
    }

    @Override
    public void deleteAds(List<Ad> ads) {
        getCurrentSession().delete(ads);
        getCurrentSession().getTransaction().commit();
        getCurrentSession().close();
    }

    @Override
    public void deleteAdsCreatedBy(String creator) {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.eq("createdBy", creator));
        deleteAds(c.list());
    }

    @Override
    public void deleteAdsPostedAfter(Date date) {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.gt("timeOfSubmission", date));
        deleteAds(c.list());
    }

    @Override
    public void deleteAdsPostedBefore(Date date) {
        Criteria c = getCurrentSession().createCriteria(Ad.class);
        c.add(Restrictions.lt("timeOfSubmission", date));
        deleteAds(c.list());
    }

    @Override
    public void update(List<Ad> ads) {
        //TODO
    }

}
