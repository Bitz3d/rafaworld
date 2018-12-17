package pl.rafalab.rafalworld.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @GetMapping(value = {"/","/index"})
    public String showMainPage(){
    	LOG.debug("**** Wywołano -> showMainPage()");
        return "index";
    }
}

