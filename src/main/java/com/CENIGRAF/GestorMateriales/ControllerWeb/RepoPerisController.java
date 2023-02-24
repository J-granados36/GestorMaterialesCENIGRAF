package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.RepoPerisCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api/solicitudes")
public class RepoPerisController {
    @Autowired
    RepoPerisCrudRepository repoPerisCrudRepository;

    @GetMapping("/")
    public String mostrarVentas(Model model){
        model.addAttribute("api/solicitudes", repoPerisCrudRepository.findAll());
        return "api/solicitudes/ver";
    }
}
