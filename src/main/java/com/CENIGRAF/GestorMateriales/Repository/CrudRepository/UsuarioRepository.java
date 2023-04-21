package com.CENIGRAF.GestorMateriales.Repository.CrudRepository;

import com.CENIGRAF.GestorMateriales.ModelBD.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{
    public UsuarioModel findByNombre(String nombre);
}
