package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.InstructorModel;
import com.CENIGRAF.GestorMateriales.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<InstructorModel> getAll(){
        return instructorRepository.getAll();
    }

    public Optional<InstructorModel> getInstructorModel(int id){
        return instructorRepository.getInstructorModel(id);
    }
    //Guardar
    public InstructorModel save(InstructorModel instructorModel){
        if (instructorModel.getIdInstructor()==null){
            return instructorRepository.save(instructorModel);
        }else{
            Optional<InstructorModel> insaux=instructorRepository.getInstructorModel(instructorModel.getIdInstructor());
            if (insaux.isEmpty()){
                return instructorRepository.save(instructorModel);
            }else{
                return instructorModel;
            }
        }
    }

    //Actualizar
    public InstructorModel update(InstructorModel instructorModel){
        if (instructorModel.getIdInstructor() != null){
            Optional<InstructorModel> In=instructorRepository.getInstructorModel(instructorModel.getIdInstructor());
            if (In.isEmpty()){
                if (instructorModel.getIdInstructor()!= null){
                    In.get().setIdInstructor(instructorModel.getIdInstructor());
                }
                if (instructorModel.getNombreInstructor()!=null){
                    In.get().setNombreInstructor(instructorModel.getNombreInstructor());
                }
                if (instructorModel.getCedula()!= null){
                    In.get().setCedula(instructorModel.getCedula());
                }
                if (instructorModel.getCelular()!= null){
                    In.get().setCelular(instructorModel.getCelular());
                }
                if (instructorModel.getCorreo()!=null){
                    In.get().setCorreo(instructorModel.getCorreo());
                }
                instructorRepository.save(In.get());
                return In.get();
            }else {
                return instructorModel;
            }
        }else {
            return instructorModel;
        }
    }

    //Borrar
    public boolean deleteInstructorModel(int id){
        Boolean dIn=getInstructorModel(id).map(instructorModel -> {
            instructorRepository.delete(instructorModel);
            return true;
        }).orElse(false);
        return dIn;
    }
}
