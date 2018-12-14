package pl.rafalab.rafalworld.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class MainController {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
    @GET
    @RequestMapping(value = {"/","/index"})
    public String showMainPage(){
    	LOG.debug("**** Wywołano -> showMainPage()");
        return "index";
    }
}

