package com.CENIGRAF.GestorMateriales.ControllerWeb;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLogin {
    
    @GetMapping("/login")
    public String login(){
        return "index";
    }
    
    @RequestMapping("/")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        else if (request.isUserInRole("ROLE_ALMACEN")) {
            return "redirect:/rolalmacen";
        }
        else if (request.isUserInRole("ROLE_PERSONAL")) {
            return "redirect:/personal";
        }
        else if (request.isUserInRole("ROLE_COORDINACION")) {
            return "redirect:/coordinacion";
        }
        return "redirect:/user/";
    }
}
