package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.ModelBD.AlmacenModel;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/AlmacenModel")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @GetMapping("/all")
    public List<AlmacenModel>getAlmacenModels(){
        return almacenService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AlmacenModel>getAlmacenModel(@PathVariable("id")int id){
        return almacenService.getAlmacenModel(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AlmacenModel save(@RequestBody AlmacenModel almacenModel){
        return almacenService.save(almacenModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public AlmacenModel update(@RequestBody AlmacenModel almacenModel){
        return almacenService.update(almacenModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return almacenService.deleteAlmacenModel(id);
    }

}
