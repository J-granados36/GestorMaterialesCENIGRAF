package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.ModelBD.InventarioModel;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Inventario")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/all")
    public List<InventarioModel> getInventarioModels(){
        return inventarioService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<InventarioModel> getInventarioModel(@PathVariable("id")int id){
        return inventarioService.getInventarioModel(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioModel save(@RequestBody InventarioModel inventarioModel){
        return inventarioService.save(inventarioModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioModel update(@RequestBody InventarioModel inventarioModel){
        return inventarioService.update(inventarioModel);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id")int id){
        return inventarioService.deleteInventarioModel(id);
    }

}
