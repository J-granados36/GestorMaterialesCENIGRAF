package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.ModelBD.InstructorModel;
import com.CENIGRAF.GestorMateriales.ServiceCRUD.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/InsModel")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/all")
    public List<InstructorModel> getInstructorModels(){
        return instructorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<InstructorModel> getInstructorModel(@PathVariable("id")int id){
        return instructorService.getInstructorModel(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public InstructorModel save(@RequestBody InstructorModel instructorModel){
        return instructorService.save(instructorModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public InstructorModel update(@RequestBody InstructorModel instructorModel){
        return instructorService.update(instructorModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return instructorService.deleteInstructorModel(id);

    }

}
