package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.AlmacenModel;
import com.CENIGRAF.GestorMateriales.Repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {

    @Autowired
    AlmacenRepository almacenRepository;

    public List<AlmacenModel>getAll(){
        return almacenRepository.getAll();
    }

    public Optional<AlmacenModel>getAlmacenModel(int id){
        return almacenRepository.getAlmacenModel(id);
    }

    public AlmacenModel save(AlmacenModel almacenModel){
        if (almacenModel.getIdAlmacen()==null){
            return almacenRepository.save(almacenModel);
        }else{
            Optional<AlmacenModel>almaux=almacenRepository.getAlmacenModel(almacenModel.getIdAlmacen());
            if (almaux.isEmpty()){
                return almacenRepository.save(almacenModel);
            }else{
                return almacenModel;
            }
        }
    }

    public AlmacenModel update(AlmacenModel almacenModel){
        if (almacenModel.getIdAlmacen()!=null){
            Optional<AlmacenModel> Al=almacenRepository.getAlmacenModel(almacenModel.getIdAlmacen());
            if (Al.isEmpty()){
                if (almacenModel.getIdAlmacen()!=null){
                    Al.get().setIdAlmacen(almacenModel.getIdAlmacen());
                }
                almacenRepository.save(Al.get());
                return Al.get();
            }else{
                return almacenModel;
            }
        }else {
            return almacenModel;
        }
    }

    public boolean deleteAlmacenModel(int id){
        Boolean dAl=getAlmacenModel(id).map(almacenModel -> {
            almacenRepository.delete(almacenModel);
            return true;
        }).orElse(false);
        return dAl;
    }

}
