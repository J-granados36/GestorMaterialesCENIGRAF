package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.ModelBD.MtPreventivoModel;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.MtPreventivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/MtPreventivoModel")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class MtPreventivoController {

    @Autowired
    MtPreventivoService mtPreventivoService;

    @GetMapping("/all")
    public List<MtPreventivoModel>getMtPreventivoModel(){
        return mtPreventivoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MtPreventivoModel>getMtPreventivoModel(@PathVariable("id")int id){
        return mtPreventivoService.getMtPreventivoModel(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MtPreventivoModel save(@RequestBody MtPreventivoModel mtPreventivoModel){
        return mtPreventivoService.save(mtPreventivoModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MtPreventivoModel update(@RequestBody MtPreventivoModel mtPreventivoModel){
        return mtPreventivoService.update(mtPreventivoModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return mtPreventivoService.deleteMtPreventivoModel(id);
    }

}
