package samwad.buysell.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import samwad.buysell.dao.AdDaoImpl;

public class CreateAdRestController {

    @Autowired
    public AdDaoImpl adDaoImpl;
    
}
