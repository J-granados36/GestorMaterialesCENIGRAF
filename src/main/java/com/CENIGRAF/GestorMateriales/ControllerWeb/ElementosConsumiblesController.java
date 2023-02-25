package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.ModelBD.ElementosConsumiblesModel;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.ElementosConsumiblesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ElementosConsumibles")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ElementosConsumiblesController {

    @Autowired
    ElementosConsumiblesService elementosConsumiblesService;

    @GetMapping("/all")
    public List<ElementosConsumiblesModel> getElementosConsumiblesModels(){
        return elementosConsumiblesService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<ElementosConsumiblesModel>getElementosConsumiblesModel(@PathVariable("id")int id){
        return elementosConsumiblesService.getElementosConsumiblesModel(id);
    }
    @PostMapping("/save")
    public ElementosConsumiblesModel save(@RequestBody ElementosConsumiblesModel elementosConsumiblesModel){
        return elementosConsumiblesService.save(elementosConsumiblesModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ElementosConsumiblesModel update(@RequestBody ElementosConsumiblesModel elementosConsumiblesModel){
        return elementosConsumiblesService.update(elementosConsumiblesModel);
    }
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id")int id){
        return elementosConsumiblesService.deleteElementosConsumiblesModel(id);
    }
}
