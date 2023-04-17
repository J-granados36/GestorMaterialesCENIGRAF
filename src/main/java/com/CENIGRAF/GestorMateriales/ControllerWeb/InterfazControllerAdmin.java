package com.CENIGRAF.GestorMateriales.ControllerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterfazControllerAdmin { 
    
    @GetMapping("/admin")
    public String inicio() {
        return "/administradores/PrincipalAdmin";
    }
    
    @GetMapping("/admin/ambientes")
    public String ambiente(){
        return "/administradores/AmbientesAdmin";
    }
    
    @GetMapping("/admin/fichas")
    public String fichas(){
        return "/administradores/FichasAdmin";
    }
    
    @GetMapping("/admin/personal")
    public String personal(){
        return "/administradores/PersonalCenigrafAdmin";
    }
    
    @GetMapping("/admin/programas")
    public String programas(){
        return "/administradores/ProgramasAdmin";
    }
    
    @GetMapping("/admin/usuarios")
    public String usuarios(){
        return "/administradores/UsuariosAdmin";
    }
}
