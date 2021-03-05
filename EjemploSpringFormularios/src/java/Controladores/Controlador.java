/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Beans.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author faranzabe
 */
@Controller
public class Controlador {
    
    //--------------------------------------------------------------------------------
    //Primera forma: el GET muestra el formulario y el POST recoge la información.
//    @RequestMapping(value="form.htm", method=RequestMethod.GET)
//    public ModelAndView recogerDatos(){
//        
//        return new ModelAndView("form","command",new Persona());
//    }
    
    @RequestMapping(value="form.htm", method=RequestMethod.GET)
    public String recogerDatos(){
        
        return "form";
    }
    
    @RequestMapping(value="form.htm", method=RequestMethod.POST)
    public String recogerDatos(Persona p, Model modelo){
        modelo.addAttribute("nombre", p.getNombre());
        modelo.addAttribute("email", p.getEmail());
        modelo.addAttribute("edad", p.getEdad());
        return "mostrar";
    }
    
    //--------------------------------------------------------------------------------
    //Otra forma: el GET muestra el formulario y el POST recoge la información.
    @RequestMapping(value="formclasico.htm", method=RequestMethod.GET)
    public ModelAndView mostrarClasico(){
        
        return new ModelAndView("formclasico");
    }
    
//    @RequestMapping(value="formclasico.htm", method=RequestMethod.POST)
//    public ModelAndView mostrarClasicoRecoger(HttpServletRequest request){
//        
//        Persona p = new Persona(request.getParameter("nombre"), request.getParameter("email"), Integer.parseInt(request.getParameter("edad")));
//        
//        ModelAndView m = new ModelAndView();
//        m.setViewName("mostrarClasico");
//        m.addObject("Persona", p);
//        return m;
//        
//    }
    
    @RequestMapping(value="formclasico.htm", method=RequestMethod.POST)
    public String mostrarClasicoRecoger(HttpServletRequest request, Model m){
        
        Persona p = new Persona(request.getParameter("nombre"), request.getParameter("email"), Integer.parseInt(request.getParameter("edad")));
 
        m.addAttribute("Persona", p);
        return "mostrarClasico";
        
    }
    
    
    //--------------------------------------------------------------------------------
    //Forma 3: el GET muestra el formulario y el POST recoge la información.
    @RequestMapping(value="formclasico3.htm", method=RequestMethod.GET)
    public ModelAndView mostrarClasico3(){
        
        return new ModelAndView("formclasico3");
    }
    
    @RequestMapping(value="formclasico3.htm", method=RequestMethod.POST)
    public String mostrarClasico3Recoger(@RequestParam("nombre") String nombre, @RequestParam("email") String email, @RequestParam("edad") String edad, Model m){
        Persona p = new Persona(nombre, email, Integer.parseInt(edad));
        m.addAttribute("Persona", p);
        return "mostrarClasico3";
    }
    
    
    
    //--------------------------------------------------------------------------------
    //Forma vector: el GET muestra el formulario y el POST recoge la información.
    @RequestMapping(value="formvector.htm", method=RequestMethod.GET)
    public ModelAndView mostrarector(){
        
        return new ModelAndView("formvector");
    }
    
    @RequestMapping(value="formvector.htm", method=RequestMethod.POST)
    public String mostrarClasico3Recoger(@RequestParam("cuantos") String cuantos, Model m){
         List<Integer> ejemploLista = new ArrayList<Integer>();
         int ctos = Integer.parseInt(cuantos);
         for (int i = 0; i < ctos; i++) {
            ejemploLista.add(i);
        }
        m.addAttribute("lista", ejemploLista);
        return "mostrarvector";
    }
}
