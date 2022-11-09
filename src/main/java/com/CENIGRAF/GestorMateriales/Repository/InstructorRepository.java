package com.CENIGRAF.GestorMateriales.Repository;


import com.CENIGRAF.GestorMateriales.ModelBD.InstructorModel;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.InstructorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InstructorRepository {

    @Autowired
    private InstructorCrudRepository instructorCrudRepository;

    public List<InstructorModel> getAll(){
        return (List<InstructorModel>) instructorCrudRepository.findAll();
    }

    public Optional<InstructorModel> getInstructorModel(int id){
        return instructorCrudRepository.findById(id);
    }

    public InstructorModel save(InstructorModel instructorModel){
        return instructorCrudRepository.save(instructorModel);
    }

    public  void delete(InstructorModel instructorModel){
        instructorCrudRepository.delete(instructorModel);
    }

}
