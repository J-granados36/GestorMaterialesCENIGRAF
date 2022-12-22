package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.MtPreventivoModel;
import com.CENIGRAF.GestorMateriales.Repository.MtPreventivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MtPreventivoService {

    @Autowired
    MtPreventivoRepository mtPreventivoRepository;

    public List<MtPreventivoModel>getAll(){
        return mtPreventivoRepository.getAll();
    }

    public Optional<MtPreventivoModel>getMtPreventivoModel(int id){
        return mtPreventivoRepository.getMtPreventivoModel(id);
    }

    public MtPreventivoModel save(MtPreventivoModel mtPreventivoModel){
        if (mtPreventivoModel.getIdMtPreventivo()==null){
            return mtPreventivoRepository.save(mtPreventivoModel);
        }else{
            Optional<MtPreventivoModel>mtpaux=mtPreventivoRepository.getMtPreventivoModel(mtPreventivoModel.getIdMtPreventivo());
            if (mtpaux.isEmpty()){
                return mtPreventivoRepository.save(mtPreventivoModel);
            }else {
                return mtPreventivoModel;
            }
        }
    }

    public MtPreventivoModel update(MtPreventivoModel mtPreventivoModel){
        if (mtPreventivoModel.getIdMtPreventivo()!=null){
            Optional<MtPreventivoModel>Mtp=mtPreventivoRepository.getMtPreventivoModel(mtPreventivoModel.getIdMtPreventivo());
            if (Mtp.isEmpty()){
                if (mtPreventivoModel.getIdMtPreventivo()!=null){
                    Mtp.get().setIdMtPreventivo(mtPreventivoModel.getIdMtPreventivo());
                }
                if (mtPreventivoModel.getNombreMtPrev()!=null){
                    Mtp.get().setNombreMtPrev(mtPreventivoModel.getNombreMtPrev());
                }
                if (mtPreventivoModel.getDescripcion()!=null){
                    Mtp.get().setDescripcion(mtPreventivoModel.getDescripcion());
                }
                mtPreventivoRepository.save(Mtp.get());
                return Mtp.get();
            }else {
                return mtPreventivoModel;
            }
        }else {
            return mtPreventivoModel;
        }
    }

    public boolean deleteMtPreventivoModel(int id){
        Boolean dMtp=getMtPreventivoModel(id).map(mtPreventivoModel -> {
            mtPreventivoRepository.delete(mtPreventivoModel);
            return true;
        }).orElse(false);
        return dMtp;
    }

}
