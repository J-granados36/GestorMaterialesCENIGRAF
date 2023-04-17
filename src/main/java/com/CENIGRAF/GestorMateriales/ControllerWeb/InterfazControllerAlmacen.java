package com.CENIGRAF.GestorMateriales.ControllerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterfazControllerAlmacen {
    
    @GetMapping("/rolalmacen")
    public String inicio() {
        return "/almacen/PrincipalAlmacen";
    }
    
    @GetMapping("/rolalmacen/maquinas")
    public String ambiente(){
        return "/almacen/MaquinasAlmacen";
    }
    
    @GetMapping("/rolalmacen/solicitud")
    public String fichas(){
        return "/almacen/SolicitudPerAlmacen";
    }
}
