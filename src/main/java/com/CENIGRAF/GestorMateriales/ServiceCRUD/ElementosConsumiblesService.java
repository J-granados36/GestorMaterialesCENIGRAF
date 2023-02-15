package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.ElementosConsumiblesModel;
import com.CENIGRAF.GestorMateriales.Repository.ElementosConsumiblesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementosConsumiblesService {

    @Autowired
    ElementosConsumiblesRepository elementosConsumiblesRepository;

    public List<ElementosConsumiblesModel>getAll(){
        return elementosConsumiblesRepository.getAll();
    }

    public Optional<ElementosConsumiblesModel>getElementosConsumiblesModel(int id){
        return elementosConsumiblesRepository.getElementosConsumiblesModel(id);
    }

    public ElementosConsumiblesModel save(ElementosConsumiblesModel elementosConsumiblesModel){
        if (elementosConsumiblesModel.getIdEc()==null){
            return elementosConsumiblesRepository.save(elementosConsumiblesModel);
        }else {
            Optional<ElementosConsumiblesModel> ecaux=elementosConsumiblesRepository.getElementosConsumiblesModel(elementosConsumiblesModel.getIdEc());
            if (ecaux.isEmpty()){
                return elementosConsumiblesRepository.save(elementosConsumiblesModel);
            }else {
                return elementosConsumiblesModel;
            }
        }
    }

    public ElementosConsumiblesModel update(ElementosConsumiblesModel elementosConsumiblesModel){
        if (elementosConsumiblesModel.getIdEc()!=null){
            Optional<ElementosConsumiblesModel>ElCo=elementosConsumiblesRepository.getElementosConsumiblesModel(elementosConsumiblesModel.getIdEc());
            if (!ElCo.isEmpty()){
                if (elementosConsumiblesModel.getIdEc()!=null){
                    ElCo.get().setIdEc(elementosConsumiblesModel.getIdEc());
                }
                if (elementosConsumiblesModel.getCodigoSena()!=null){
                    ElCo.get().setCodigoSena(elementosConsumiblesModel.getCodigoSena());
                }
                if (elementosConsumiblesModel.getDecripcionBien()!=null){
                    ElCo.get().setDecripcionBien(elementosConsumiblesModel.getDecripcionBien());
                }
                if (elementosConsumiblesModel.getUnidadMedida()!=null){
                    ElCo.get().setUnidadMedida(elementosConsumiblesModel.getUnidadMedida());
                }
                if (elementosConsumiblesModel.getCantidadAlmacen()!=null){
                    ElCo.get().setCantidadAlmacen(elementosConsumiblesModel.getCantidadAlmacen());
                }
                if (elementosConsumiblesModel.getObservaciones()!=null){
                    ElCo.get().setObservaciones(elementosConsumiblesModel.getObservaciones());
                }
                elementosConsumiblesRepository.save(ElCo.get());
                return ElCo.get();
            }else {
                return elementosConsumiblesModel;
            }

        }else {
            return elementosConsumiblesModel;
        }
    }

    public boolean deleteElementosConsumiblesModel(int id){
        Boolean dElCo=getElementosConsumiblesModel(id).map(elementosConsumiblesModel -> {
            elementosConsumiblesRepository.delete(elementosConsumiblesModel);
            return true;
        }).orElse(false);
        return dElCo;
    }
}
