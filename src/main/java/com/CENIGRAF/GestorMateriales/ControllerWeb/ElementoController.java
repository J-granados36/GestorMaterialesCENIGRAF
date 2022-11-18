package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.ModelBD.ElementoModel;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ElementoModel")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ElementoController {

    @Autowired
    ElementoService elementoService;

    @GetMapping("/all")
    public List<ElementoModel> getElementoModels(){
        return elementoService.getAll();
    }

    @GetMapping("{id}")
    public Optional<ElementoModel>getElementoModel(@PathVariable("id")int id){
        return elementoService.getElementoModel(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ElementoModel save(@RequestBody ElementoModel elementoModel){
        return elementoService.save(elementoModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ElementoModel update(@RequestBody ElementoModel elementoModel){
        return elementoService.update(elementoModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return elementoService.deleteElementoModel(id);
    }


}
