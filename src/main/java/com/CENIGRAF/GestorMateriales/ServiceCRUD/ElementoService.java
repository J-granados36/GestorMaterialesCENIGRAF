package com.CENIGRAF.GestorMateriales.ServiceCRUD;


import com.CENIGRAF.GestorMateriales.ModelBD.ElementoModel;
import com.CENIGRAF.GestorMateriales.Repository.ElementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementoService {

    @Autowired
    ElementoRepository elementoRepository;

    public List<ElementoModel>getAll(){
        return elementoRepository.getAll();
    }

    public Optional<ElementoModel>getElementoModel(int id){
        return elementoRepository.getElementoModel(id);
    }

    public ElementoModel save(ElementoModel elementoModel){
        if (elementoModel.getIdElemento()==null){
            return elementoRepository.save(elementoModel);
        }else{
            Optional<ElementoModel>elaux=elementoRepository.getElementoModel(elementoModel.getIdElemento());
            if (elaux.isEmpty()){
                return elementoRepository.save(elementoModel);
            }else{
                return elementoModel;
            }
        }
    }

    public ElementoModel update(ElementoModel elementoModel){
        if(elementoModel.getIdElemento()!=null){
            Optional<ElementoModel> El=elementoRepository.getElementoModel(elementoModel.getIdElemento());
            if (!El.isEmpty()){
                if (elementoModel.getIdElemento()!=null){
                    El.get().setIdElemento(elementoModel.getIdElemento());
                }
                if (elementoModel.getNombreElemento()!=null){
                    El.get().setNombreElemento(elementoModel.getNombreElemento());
                }
                if (elementoModel.getDescripcion()!=null){
                    El.get().setDescripcion(elementoModel.getDescripcion());
                }
                if (elementoModel.getUndMedida()!=null){
                    El.get().setUndMedida(elementoModel.getUndMedida());
                }
//atributos cantidad de elemento borrado
                elementoRepository.save(El.get());
                return El.get();
            }else {
                return elementoModel;
            }
        }else {
            return elementoModel;
        }
    }

    public boolean deleteElementoModel(int id){
        Boolean dEl=getElementoModel(id).map((elementoModel -> {
            elementoRepository.delete(elementoModel);
            return true;
        })).orElse(false);
        return dEl;
    }

}
