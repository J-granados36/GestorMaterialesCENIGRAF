package com.CENIGRAF.GestorMateriales.ServiceCRUD;

import com.CENIGRAF.GestorMateriales.ModelBD.InventarioModel;
import com.CENIGRAF.GestorMateriales.Repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<InventarioModel> getAll(){
        return inventarioRepository.getAll();
    }

    public Optional<InventarioModel> getInventarioModel(int id){
        return inventarioRepository.getInventarioModel(id);
    }

    public InventarioModel save(InventarioModel inventarioModel){
        if (inventarioModel.getIdInventario()==null){
            return inventarioRepository.save(inventarioModel);
        }else{
            Optional<InventarioModel> invaux=inventarioRepository.getInventarioModel(inventarioModel.getIdInventario());
            if (invaux.isEmpty()){
                return inventarioRepository.save(inventarioModel);
            }else{
                return inventarioModel;
            }
        }
    }

    public InventarioModel update(InventarioModel inventarioModel){
        if (inventarioModel.getIdInventario()!=null){
            Optional<InventarioModel> Inv=inventarioRepository.getInventarioModel(inventarioModel.getIdInventario());
            if (!Inv.isEmpty()){
                if (inventarioModel.getIdInventario()!=null){
                    Inv.get().setIdInventario(inventarioModel.getIdInventario());
                }
                if (inventarioModel.getNombreElemento()!=null){
                    Inv.get().setNombreElemento(inventarioModel.getNombreElemento());
                }
                if (inventarioModel.getDescripcionElemento()!=null){
                    Inv.get().setDescripcionElemento(inventarioModel.getDescripcionElemento());
                }
                if (inventarioModel.getUndMedida()!=null){
                    Inv.get().setUndMedida(inventarioModel.getUndMedida());
                }
                if (inventarioModel.getCantidadAlmacen()!=null){
                    Inv.get().setCantidadAlmacen(inventarioModel.getCantidadAlmacen());
                }
                if (inventarioModel.getEstado()!=null){
                    Inv.get().setEstado(inventarioModel.getEstado());
                }
                inventarioRepository.save(Inv.get());
                return Inv.get();
            }else{
                return inventarioModel;
            }
        }else{
            return inventarioModel;
        }
    }

    public boolean deleteInventarioModel(int id){
        Boolean dInv=getInventarioModel(id).map(inventarioModel -> {
            inventarioRepository.delete(inventarioModel);
            return true;
        }).orElse(false);
        return dInv;
    }
}
