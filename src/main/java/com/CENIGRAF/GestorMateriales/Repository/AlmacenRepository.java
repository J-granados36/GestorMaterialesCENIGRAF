package com.CENIGRAF.GestorMateriales.Repository;

import com.CENIGRAF.GestorMateriales.ModelBD.AlmacenModel;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.AlmacenCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlmacenRepository {

    @Autowired
    private AlmacenCrudRepository almacenCrudRepository;

    public List<AlmacenModel>getAll(){
        return (List<AlmacenModel>) almacenCrudRepository.findAll();
    }

    public Optional<AlmacenModel>getAlmacenModel(int id){
        return almacenCrudRepository.findById(id);
    }

    public AlmacenModel save (AlmacenModel almacenModel){
        return almacenCrudRepository.save(almacenModel);
    }

    public void delete(AlmacenModel almacenModel){
        almacenCrudRepository.delete(almacenModel);
    }

}
