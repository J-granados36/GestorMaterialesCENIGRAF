package com.CENIGRAF.GestorMateriales.Repository;


import com.CENIGRAF.GestorMateriales.ModelBD.MtCorrectivoModel;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.MtCorrectivoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MtCorrectivoRepository {

    @Autowired
    private MtCorrectivoCrudRepository mtCorrectivoCrudRepository;

    public List<MtCorrectivoModel>getAll(){
        return (List<MtCorrectivoModel>) mtCorrectivoCrudRepository.findAll();
    }

    public Optional<MtCorrectivoModel>getMtCorrectivoModel(int id){
        return mtCorrectivoCrudRepository.findById(id);
    }
    public MtCorrectivoModel save(MtCorrectivoModel mtCorrectivoModel){
        return mtCorrectivoCrudRepository.save(mtCorrectivoModel);
    }

    public  void delete(MtCorrectivoModel mtCorrectivoModel){
        mtCorrectivoCrudRepository.delete(mtCorrectivoModel);
    }

}


