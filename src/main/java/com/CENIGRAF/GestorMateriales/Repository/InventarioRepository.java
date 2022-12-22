package com.CENIGRAF.GestorMateriales.Repository;

import com.CENIGRAF.GestorMateriales.ModelBD.InventarioModel;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.InventarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InventarioRepository {

    @Autowired
    private InventarioCrudRepository inventarioCrudRepository;

    public List<InventarioModel> getAll(){
        return (List<InventarioModel>) inventarioCrudRepository.findAll();
    }

    public Optional<InventarioModel>getInventarioModel(int id){
        return inventarioCrudRepository.findById(id);
    }

    public InventarioModel save(InventarioModel inventarioModel){
        return inventarioCrudRepository.save(inventarioModel);
    }

    public void delete(InventarioModel inventarioModel){
        inventarioCrudRepository.delete(inventarioModel);
    }

}
