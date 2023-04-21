package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.RolModel;
import com.CENIGRAF.GestorMateriales.ModelBD.UsuarioModel;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.UsuarioRepository;
import com.CENIGRAF.GestorMateriales.Repository.UsuarioDTO;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Lazy
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Lazy
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UsuarioModel save(UsuarioDTO registro){
        UsuarioModel usuario = new UsuarioModel(registro.getNombre(),passwordEncoder.encode(registro.getContrasena()),Arrays.asList(new     RolModel("ROLE_ALMACEN")));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuario = usuarioRepository.findByNombre(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario o Password inválido");
        }
        return new User(usuario.getNombre(), usuario.getContrasena(), mapearAutoridadesRoles(usuario.getRoles()));
    }
    
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<RolModel> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}