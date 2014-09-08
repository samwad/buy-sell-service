package samwad.buysell.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import samwad.buysell.dao.AdDaoImpl;
import samwad.buysell.model.Ad;

@RestController
@RequestMapping(value = "/service")
public class ListAdRestController {

    @Autowired
    public AdDaoImpl adDaoImpl;

    @RequestMapping(value = "/listAds")
    @ResponseStatus(HttpStatus.OK)
    public List<Ad> listAllAds() {
        return adDaoImpl.listAllAds();
    }
    
    @RequestMapping(value = "/listAdsByCreator")
    @ResponseStatus(HttpStatus.OK)
    public List<Ad> listAllAdsByCreator(@RequestParam(required=true, value="user") String creator) {
        return adDaoImpl.getAdsCreatedBy(creator);
    }

    @RequestMapping(value = "/listBuyAds")
    @ResponseStatus(HttpStatus.OK)
    public List<Ad> listAllBuyAds() {
        return adDaoImpl.getAllBuyAds();
    }
    
    
    @RequestMapping(value = "/listSellAds")
    @ResponseStatus(HttpStatus.OK)
    public List<Ad> listAllSellAds() {
        return adDaoImpl.getAllSellAds();
    }
    
    @RequestMapping(value = "/listRentalAds")
    @ResponseStatus(HttpStatus.OK)
    public List<Ad> listAllRentalAds() {
        return adDaoImpl.getAllRentalAds();
    }
}
