package com.CENIGRAF.GestorMateriales.ControllerWeb;

import com.CENIGRAF.GestorMateriales.ModelBD.ElementoSolicitado;
import com.CENIGRAF.GestorMateriales.ModelBD.ElementosConsumiblesModel;
import com.CENIGRAF.GestorMateriales.ModelBD.ElementosParaSolicitar;
import com.CENIGRAF.GestorMateriales.ModelBD.RepoPeriModel;

import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.ElementosConsumiblesCrudRepository;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.ElementosSolicitadosCrudRepository;
import com.CENIGRAF.GestorMateriales.Repository.CrudRepository.RepoPerisCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/reporte")
public class ReporteController {

    @Autowired
    private ElementosConsumiblesCrudRepository elementosConsumiblesCrudRepository;
    @Autowired
    private RepoPerisCrudRepository repoPerisCrudRepository;
    @Autowired
    private ElementosSolicitadosCrudRepository elementosSolicitadosCrudRepository;

    private ArrayList<ElementosParaSolicitar> obtenerConjunto(HttpServletRequest request){
        ArrayList<ElementosParaSolicitar> conjunto = (ArrayList<ElementosParaSolicitar>) request.getSession().getAttribute("conjunto");
        if (conjunto==null){
            conjunto = new ArrayList<>();
        }
        return conjunto;
    }

    private void guardarConjunto(ArrayList<ElementosParaSolicitar> conjunto, HttpServletRequest request){
        request.getSession().setAttribute("conjunto", conjunto);
    }
    @PostMapping(value = "/quitar/{indice}")
    public String quitarDeLaSolicitud(@PathVariable int indice, HttpServletRequest request){
        ArrayList<ElementosParaSolicitar> conjunto = this.obtenerConjunto(request);
        if (conjunto != null && conjunto.size() >0 && conjunto.get(indice) != null){
            conjunto.remove(indice);
            this.guardarConjunto(conjunto, request);
        }
        return "redirect:/reporte/";
    }

    private void limpiarConjunto(HttpServletRequest request){
        this.guardarConjunto(new ArrayList<>(),request);
    }

    @GetMapping(value = "/Limpiar")
    public String cancelarSolicitud(HttpServletRequest request, RedirectAttributes redirectAttrs){
        this.limpiarConjunto(request);
        redirectAttrs
                .addFlashAttribute("mensaje", "solicitud cancelada")
                .addFlashAttribute("clase", "info");
        return "redirect:/reporte/";
    }

    @PostMapping(value = "/terminar")
    public String terminarSolicitud(HttpServletRequest request, RedirectAttributes redirectAttrs){
        ArrayList<ElementosParaSolicitar> conjunto = this.obtenerConjunto(request);

        if (conjunto==null || conjunto.size() <=0){
            return "redirect:/reporte/";
        }
        RepoPeriModel s = repoPerisCrudRepository.save(new RepoPeriModel());
        for (ElementosParaSolicitar elementosParaSolicitar : conjunto){
            ElementosConsumiblesModel e = elementosConsumiblesCrudRepository.findFirstByCodigoSena(elementosParaSolicitar.getCodigoSena());
            if (e == null) continue;
            e.restarExistencia(elementosParaSolicitar.getCantidad());
            elementosConsumiblesCrudRepository.save(e);
            ElementoSolicitado elementoSolicitado = new ElementoSolicitado(elementosParaSolicitar.getCantidad(), elementosParaSolicitar.getUnidadMedida(), elementosParaSolicitar.getCantidadSolicitada(),elementosParaSolicitar.getExistenciaAlmacen(),elementosParaSolicitar.getObservaciones(),elementosParaSolicitar.getDecripcionBien(),elementosParaSolicitar.getCodigoSena(),s);
            elementosSolicitadosCrudRepository.save(elementoSolicitado);
        }
        this.limpiarConjunto(request);
        redirectAttrs
                .addFlashAttribute("mensaje", "solicitud realizada correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/reporte/";
    }


    @GetMapping(value = "/")
    public String interfazSolicitud(Model model, HttpServletRequest request){
        model.addAttribute("elementosConsumiblesModel",new ElementosConsumiblesModel());
        int total = 0 ;
        ArrayList<ElementosParaSolicitar> conjunto = this.obtenerConjunto(request);
        for (ElementosParaSolicitar p:conjunto) total += p.getTotal();
        model.addAttribute("total", total);
        return "reporte/reporte";
    }

    @PostMapping(value = "/agregar")
    public String agregarAlConjunto(@ModelAttribute ElementosConsumiblesModel elemento, HttpServletRequest request,RedirectAttributes redirectAttrs){
        ArrayList<ElementosParaSolicitar> conjunto = this.obtenerConjunto(request);
        ElementosConsumiblesModel elementoBuscadoPorCodigo = elementosConsumiblesCrudRepository.findFirstByCodigoSena(elemento.getIdEc());
        if (elementoBuscadoPorCodigo == null){
            redirectAttrs
                    .addFlashAttribute("mensaje", "el producto con el codigo"+ elemento.getCodigoSena() + "no existe")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/reporte/";
        }
        if (elementoBuscadoPorCodigo.sinExistencia()){
            redirectAttrs
                    .addFlashAttribute("mensaje", "el elemento esta agotado")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/reporte/";
        }
        boolean encontrado = false;
        for (ElementosParaSolicitar elementosParaSolicitarActual : conjunto){
            if (elementosParaSolicitarActual.getCodigoSena().equals(elementoBuscadoPorCodigo.getCodigoSena())){
                elementosParaSolicitarActual.aumentarCantidad();
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            conjunto.add(new ElementosParaSolicitar(elementoBuscadoPorCodigo.getCodigoSena(),elementoBuscadoPorCodigo.getDecripcionBien(),elementoBuscadoPorCodigo.getUnidadMedida(),elementoBuscadoPorCodigo.getObservaciones(),elementoBuscadoPorCodigo.getCantidadSolicitada(),elementoBuscadoPorCodigo.getExistenciaAlmacen(),1));
        }
        this.guardarConjunto(conjunto, request);
        return "redirect:/reporte/";
    }

    //observacion:codigo sena es long y id es integer


}
