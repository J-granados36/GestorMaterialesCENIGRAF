package com.CENIGRAF.GestorMateriales.ControllerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterfazControllerCoordinacion { 
    
    @GetMapping("/coordinacion")
    public String inicio() {
        return "/coordinador/SolicitudPerCoordi";
    }
}
