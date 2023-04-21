package com.CENIGRAF.GestorMateriales.ControllerWeb;


import com.CENIGRAF.GestorMateriales.Repository.UsuarioDTO;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {
    
    @Lazy
    @Autowired
    private UsuarioService usuarioService;
    
    @ModelAttribute("usuario")
    public UsuarioDTO nuevoUsuarioDTO(){
        return new UsuarioDTO();
    }

    @GetMapping
    public String formularioRegistro(){
        return "/administradores/UsuariosAdmin";
    }
    
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioDTO registroDTO){
        usuarioService.save(registroDTO);
        return "redirect:/admin/usuarios";
    }
}
