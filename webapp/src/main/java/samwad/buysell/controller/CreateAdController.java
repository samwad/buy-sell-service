package samwad.buysell.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import samwad.buysell.model.Ad;
import samwad.buysell.service.AdServiceImpl;

@Controller
public class CreateAdController {

    @Autowired
    private AdServiceImpl adService;
    static final long SECONDS_IN_SIX_MONTHS=15552000000L;

    @RequestMapping("/createAd")
    public ModelAndView submit(Object command, @RequestParam(value = "price", required = false)
    String price, @RequestParam(value = "description", required = false)
    String description, @RequestParam(value = "timeOfExpiry", required = false)
    String timeOfExpiry, @RequestParam(value = "createdBy", required = false)
    String createdBy, @RequestParam(value = "location", required = false)
    String location, @RequestParam(value = "contact", required = false)
    String contact, @RequestParam(value = "adType", required = false)
    String adType, Model model) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resultPage");
        try {
            Ad ad = buildAd(price, description, timeOfExpiry, createdBy, location, contact, adType);
            System.out.println(ad.toString());
            adService.save(ad);
            mv.addObject("result", "success");
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("result", "failure");
        }
        return mv;
    }

    private Ad buildAd(String price, String description, String timeOfExpiry, String createdBy,
            String location, String contact, String adType) {
        Ad ad = new Ad();
        if (adType == null) {
            System.out.println("Kya macha rahe ho!");
            return null;
        }
        if (adType.equalsIgnoreCase("buy")) {
            ad.setAdType(Ad.AdType.BUY);
        } else if (adType.equalsIgnoreCase("sell")) {
            ad.setAdType(Ad.AdType.SELL);
        } else if (adType.equalsIgnoreCase("rental")) {
            ad.setAdType(Ad.AdType.RENTAL);
        } else {
            return null;
        }

        ad.setContact(contact);
        ad.setCreatedBy(createdBy);
        ad.setDescription(description);
        ad.setLocation(location);
        ad.setPrice(Integer.parseInt(price));
        // FIXME set time of expiry
        ad.setTimeOfExpiry(new Timestamp(System.currentTimeMillis() + SECONDS_IN_SIX_MONTHS));
        return ad;
    }
}
