package com.groupal.libreriaPrismaBackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@CrossOrigin(origins = "https://shopping-library.herokuapp.com")
@Controller
@RequestMapping("/")
public class HomeController {
	
	public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
        return new ModelAndView("redirect:/index.html", model);
    }
	
	
}
