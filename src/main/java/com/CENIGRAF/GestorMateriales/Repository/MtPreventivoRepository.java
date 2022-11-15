package com.CENIGRAF.GestorMateriales.Repository;

import com.CENIGRAF.GestorMateriales.ModelBD.MtPreventivoModel;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.MtPreventivoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MtPreventivoRepository {

    @Autowired
    private MtPreventivoCrudRepository mtPreventivoCrudRepository;

    public List<MtPreventivoModel> getAll(){
        return (List<MtPreventivoModel>) mtPreventivoCrudRepository.findAll();
    }

    public Optional<MtPreventivoModel>getMtPreventivoModel(int id){
        return mtPreventivoCrudRepository.findById(id);
    }

    public MtPreventivoModel save(MtPreventivoModel mtPreventivoModel){
    return mtPreventivoCrudRepository.save(mtPreventivoModel);
    }

    public void delete(MtPreventivoModel mtPreventivoModel){
        mtPreventivoCrudRepository.delete(mtPreventivoModel);
    }

}
