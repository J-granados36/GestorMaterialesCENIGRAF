package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.ReportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterfazControllerPersonal {
    @Autowired
    ReportesRepository reportesRepository; 
    
    @GetMapping("/personal")
    public String inicio() {
        return "personal/PrincipalPersonalCENIGRAF";
    }
    @GetMapping("/personal/periodico")
    public String periodico(Model model) {
        model.addAttribute("contador", reportesRepository.count()+1);
        return "personal/Solicitud_periodica";
    }
    @GetMapping("/personal/anual")
    public String anual() {
        return "personal/Solicitud_anual";
    }
    @GetMapping("/personal/mantenimiento")
    public String mantenimiento() {
        return "personal/Solicitud_mantenimiento";
    }
}
