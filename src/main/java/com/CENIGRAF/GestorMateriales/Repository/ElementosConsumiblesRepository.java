package com.CENIGRAF.GestorMateriales.Repository;

import com.CENIGRAF.GestorMateriales.ModelBD.ElementosConsumiblesModel;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.ElementosConsumiblesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ElementosConsumiblesRepository {
    @Autowired
    ElementosConsumiblesCrudRepository elementosConsumiblesCrudRepository;

    public List<ElementosConsumiblesModel> getAll(){
        return (List<ElementosConsumiblesModel>) elementosConsumiblesCrudRepository.findAll();
    }

    public Optional<ElementosConsumiblesModel>getElementosConsumiblesModel(int id){
        return elementosConsumiblesCrudRepository.findById(id);
    }

    public ElementosConsumiblesModel save(ElementosConsumiblesModel elementosConsumiblesModel){
        return elementosConsumiblesCrudRepository.save(elementosConsumiblesModel);
    }

    public void delete(ElementosConsumiblesModel elementosConsumiblesModel){
        elementosConsumiblesCrudRepository.delete(elementosConsumiblesModel);
    }

}
