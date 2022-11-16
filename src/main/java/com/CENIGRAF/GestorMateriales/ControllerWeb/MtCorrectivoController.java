package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.ModelBD.MtCorrectivoModel;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.MtCorrectivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/MtCorrectivoModel")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class MtCorrectivoController {

    @Autowired
    MtCorrectivoService mtCorrectivoService;

    @GetMapping("/all")
    public List<MtCorrectivoModel> getMtCorrectivoModel(){
        return mtCorrectivoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MtCorrectivoModel> getMtCorrectivoModel(@PathVariable("id")int id){
        return mtCorrectivoService.getMtCorrectivoModel(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MtCorrectivoModel save(@RequestBody MtCorrectivoModel mtCorrectivoModel){
        return mtCorrectivoService.save(mtCorrectivoModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MtCorrectivoModel update(@RequestBody MtCorrectivoModel mtCorrectivoModel){
        return mtCorrectivoService.update(mtCorrectivoModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return mtCorrectivoService.deleteMtCorrectivoModel(id);
    }



}
