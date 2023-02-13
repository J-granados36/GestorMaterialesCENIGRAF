package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.personalCenigrafModel;
import com.CENIGRAF.GestorMateriales.Repository.personalCenigrafRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class personalCenigrafService {

    @Autowired
    private personalCenigrafRepository personalCenigrafRepository;

    public List<personalCenigrafModel> getAll(){
        return personalCenigrafRepository.getAll();
    }

    public Optional<personalCenigrafModel> getInstructorModel(int id){
        return personalCenigrafRepository.getInstructorModel(id);
    }
    //Guardar
    public personalCenigrafModel save(personalCenigrafModel personalCenigrafModel){
        if (personalCenigrafModel.getIdInstructor()==null){
            return personalCenigrafRepository.save(personalCenigrafModel);
        }else{
            Optional<personalCenigrafModel> insaux= personalCenigrafRepository.getInstructorModel(personalCenigrafModel.getIdInstructor());
            if (insaux.isEmpty()){
                return personalCenigrafRepository.save(personalCenigrafModel);
            }else{
                return personalCenigrafModel;
            }
        }
    }

    //Actualizar
    public personalCenigrafModel update(personalCenigrafModel personalCenigrafModel){
        if (personalCenigrafModel.getIdInstructor() != null){
            Optional<personalCenigrafModel> In= personalCenigrafRepository.getInstructorModel(personalCenigrafModel.getIdInstructor());
            if (!In.isEmpty()){
                if (personalCenigrafModel.getIdInstructor()!= null){
                    In.get().setIdInstructor(personalCenigrafModel.getIdInstructor());
                }
                if (personalCenigrafModel.getNombreInstructor()!=null){
                    In.get().setNombreInstructor(personalCenigrafModel.getNombreInstructor());
                }
                if (personalCenigrafModel.getCedula()!= null){
                    In.get().setCedula(personalCenigrafModel.getCedula());
                }
                if (personalCenigrafModel.getCelular()!= null){
                    In.get().setCelular(personalCenigrafModel.getCelular());
                }
                if (personalCenigrafModel.getCorreo()!=null){
                    In.get().setCorreo(personalCenigrafModel.getCorreo());
                }
                personalCenigrafRepository.save(In.get());
                return In.get();
            }else {
                return personalCenigrafModel;
            }
        }else {
            return personalCenigrafModel;
        }
    }

    //Borrar
    public boolean deleteInstructorModel(int id){
        Boolean dIn=getInstructorModel(id).map(instructorModel -> {
            personalCenigrafRepository.delete(instructorModel);
            return true;
        }).orElse(false);
        return dIn;
    }
}
