package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.MtCorrectivoModel;
import com.CENIGRAF.GestorMateriales.ModelBD.MtPreventivoModel;
import com.CENIGRAF.GestorMateriales.Repository.MtCorrectivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MtCorrectivoService {

    @Autowired
    MtCorrectivoRepository mtCorrectivoRepository;

    public List<MtCorrectivoModel> getAll(){
        return mtCorrectivoRepository.getAll();
    }

    public Optional<MtCorrectivoModel> getMtCorrectivoModel(int id){
        return mtCorrectivoRepository.getMtCorrectivoModel(id);
    }

    public MtCorrectivoModel save(MtCorrectivoModel mtCorrectivoModel){
        if (mtCorrectivoModel.getIdMtCorrectivo()==null){
            return mtCorrectivoRepository.save(mtCorrectivoModel);
        }else{
            Optional<MtCorrectivoModel>mtcaux=mtCorrectivoRepository.getMtCorrectivoModel(mtCorrectivoModel.getIdMtCorrectivo());
            if (mtcaux.isEmpty()){
                return mtCorrectivoRepository.save(mtCorrectivoModel);
            }else {
                return mtCorrectivoModel;
            }
        }
    }

    public MtCorrectivoModel update(MtCorrectivoModel mtCorrectivoModel){
        if (mtCorrectivoModel.getIdMtCorrectivo()!=null){
            Optional<MtCorrectivoModel>Mtc=mtCorrectivoRepository.getMtCorrectivoModel(mtCorrectivoModel.getIdMtCorrectivo());
            if (!Mtc.isEmpty()){
                if (mtCorrectivoModel.getIdMtCorrectivo()!=null){
                    Mtc.get().setIdMtCorrectivo(mtCorrectivoModel.getIdMtCorrectivo());
                }
                if (mtCorrectivoModel.getNombreMtCorr()!=null){
                    Mtc.get().setNombreMtCorr(mtCorrectivoModel.getNombreMtCorr());
                }
                if (mtCorrectivoModel.getDescripcion()!=null){
                    Mtc.get().setDescripcion(mtCorrectivoModel.getDescripcion());
                }
                mtCorrectivoRepository.save(Mtc.get());
                return Mtc.get();
            }else {
                return mtCorrectivoModel;
            }
        }else {
            return mtCorrectivoModel;
        }
    }

    public boolean deleteMtCorrectivoModel(int id){
        Boolean dMtc=getMtCorrectivoModel(id).map(mtCorrectivoModel -> {
            mtCorrectivoRepository.delete(mtCorrectivoModel);
            return true;
        }).orElse(false);
        return dMtc;
    }

}
