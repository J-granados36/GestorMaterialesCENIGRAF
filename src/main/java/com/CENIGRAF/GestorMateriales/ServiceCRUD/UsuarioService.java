package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.UsuarioModel;
import com.CENIGRAF.GestorMateriales.Repository.UsuarioDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService{
    public UsuarioModel save(UsuarioDTO registro);
}
