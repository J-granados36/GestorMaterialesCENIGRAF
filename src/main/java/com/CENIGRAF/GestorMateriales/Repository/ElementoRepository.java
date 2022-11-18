package com.CENIGRAF.GestorMateriales.Repository;

import com.CENIGRAF.GestorMateriales.ModelBD.ElementoModel;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.ElementoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ElementoRepository {

    @Autowired
    private ElementoCrudRepository elementoCrudRepository;

    public List<ElementoModel> getAll(){
        return (List<ElementoModel>) elementoCrudRepository.findAll();
    }

    public Optional<ElementoModel>getElementoModel(int id){
        return elementoCrudRepository.findById(id);
    }

    public ElementoModel save(ElementoModel elementoModel){
        return elementoCrudRepository.save(elementoModel);
    }

    public void delete(ElementoModel elementoModel){
        elementoCrudRepository.delete(elementoModel);
    }

}
