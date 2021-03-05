/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Beans.Conectar;
import Beans.Conexion;
import Beans.Datos_BD;
import java.awt.AWTEventMulticaster;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author maria
 */
@Controller 
public class Controlador {
    
    @RequestMapping(value = "profesor.htm", method = RequestMethod.POST)
    public String home(Model m, @RequestParam("email") String email, @RequestParam("pass") String pass) throws ClassNotFoundException {
        String pag = "profesor";
        try {
            Conectar co = new Conectar();
            Conexion con = new Conexion(Datos_BD.bbdd,Datos_BD.usuario,Datos_BD.clave);
            
            try {
                
                List usuario = co.buscarUsuario("personas", email, pass);
                m.addAttribute("usuario", usuario);
                if(usuario.isEmpty()) pag = "errorRegistro";
                else{
                    String rol =  (String) con.obtenerDato("personas", "rol", email, "email");
                    if(rol.equals("profesor")) pag = "profesor";
                    else {
                        List preguntas = co.Obtener_Datos_Tabla("preguntas");
                        m.addAttribute("preguntas", preguntas);
                        List respuesta = co.Obtener_Datos_Tabla("respuesta");
                        m.addAttribute("respuesta", respuesta);
                        pag = "alumno";
                    }
                }
            } catch (SQLException ex) {
                pag = "error";
            }
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pag;
    }
    
    @RequestMapping(value = "registro.htm", method = RequestMethod.GET)
    public String formuRegistro(Model m) {
        String pag = "registro";
        
        return pag;
    }
    
    @RequestMapping(value = "registrado.htm", method = RequestMethod.POST)
    public String registrado(Model m, @RequestParam("email") String email, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,@RequestParam("pass") String pass, @RequestParam("rol") String rol) throws SQLException {
        Conectar co = new Conectar();
        String pag = "registrado";

        co.insertar("personas", email, nombre, apellido, pass, rol);
        try {

            List usuario = co.obtenerPersona("personas", email);
            m.addAttribute("usuario", usuario);

        } catch (SQLException ex) {
            pag = "error";
        }
        
        return pag;
    }
    
    @RequestMapping(value = "radio.htm", method = RequestMethod.GET)
    public String radio(Model m) {
        String pag = "radio";
        
        return pag;
    }
    
    @RequestMapping(value = "radio.htm", method = RequestMethod.POST)
    public String pregRadio(Model m, HttpServletRequest req) {
        Conectar co = new Conectar();
        String pag = "profesor";
        String enun = req.getParameter("enunciado");
        int num = Integer.parseInt(req.getParameter("num"));
        co.insertarPreg("preguntas", enun, "radio");
        int correcta = 0;
        try {
            Conexion con = new Conexion(Datos_BD.bbdd,Datos_BD.usuario,Datos_BD.clave);
            int id_preg = Integer.parseInt(String.valueOf(con.obtenerDato("preguntas", "id_preg", enun, "enunciado")));
            String resp = req.getParameter("res"); 
            for(int i=0; i < num; i++){
                String resul = req.getParameter("preg"+i);
                if(resp.equals(String.valueOf(i))){
                    correcta = 1;
                }else correcta = 0;
                    
                co.insertarResp("respuesta", id_preg, resul, correcta);
            }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("mensaje", "Pregunta añadida");
        return pag;
    }
    
    @RequestMapping(value = "check.htm", method = RequestMethod.GET)
    public String check(Model m) {
        String pag = "check";
        
        return pag;
    }
    
    @RequestMapping(value = "check.htm", method = RequestMethod.POST)
    public String pregCheck(Model m, HttpServletRequest req) {
        Conectar co = new Conectar();
        String pag = "profesor";
        String enun = req.getParameter("enunciado");
        int num = Integer.parseInt(req.getParameter("num"));
        co.insertarPreg("preguntas", enun, "check");
        int correcta = 0;
        try {
            Conexion con = new Conexion(Datos_BD.bbdd,Datos_BD.usuario,Datos_BD.clave);
            int id_preg = Integer.parseInt(String.valueOf(con.obtenerDato("preguntas", "id_preg", enun, "enunciado")));
            String resp[] = req.getParameterValues("res"); 
            for(int i=0; i < num; i++){
                String resul = req.getParameter("preg"+i);
                correcta = 0;
                for (int j = 0; j < resp.length; j++) {
                    if(resp[j].equals(String.valueOf(i)))
                        correcta = 1;
                }
                co.insertarResp("respuesta", id_preg, resul, correcta);
            }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("mensaje", "Pregunta añadida");
        return pag;
    }
    
    @RequestMapping(value = "desarrollo.htm", method = RequestMethod.GET)
    public String desarrollo(Model m) {
        String pag = "desarrollo";
        
        return pag;
    }
    
    @RequestMapping(value = "desarrollo.htm", method = RequestMethod.POST)
    public String insertarDesarrollo(Model m, @RequestParam("enunciado") String enun, @RequestParam("respuesta") String resul) {
        Conectar co = new Conectar();
        String pag = "profesor";
        co.insertarPreg("preguntas", enun, "desarrollo");
        
        try {
            Conexion con = new Conexion(Datos_BD.bbdd,Datos_BD.usuario,Datos_BD.clave);
            int id_preg = Integer.parseInt(String.valueOf(con.obtenerDato("preguntas", "id_preg", enun, "enunciado")));
            co.insertarResp("respuesta", id_preg, resul, 1);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("mensaje", "Pregunta añadida");
        return pag;
    }
    
    @RequestMapping(value = "profesor.htm", method = RequestMethod.GET)
    public String volver(Model m) {
        String pag = "profesor";
        
        return pag;
    }
    

    @RequestMapping(value = "examen.htm", method = RequestMethod.GET)
    public String verExamen(Model m) throws SQLException {
        Conectar co = new Conectar();
        String pag = "examen";
        
        List preguntas = co.Obtener_Datos_Tabla("preguntas");
        m.addAttribute("preguntas", preguntas);
        List respuesta = co.Obtener_Datos_Tabla("respuesta");
        m.addAttribute("respuesta", respuesta);
        
        return pag;
    }
    
    @RequestMapping(value = "examen.htm", method = RequestMethod.POST)
    public String eliminaPreg(Model m, HttpServletRequest req) throws SQLException{
        Conectar co = new Conectar();
        String pag = "examen";
        int id_preg = Integer.parseInt(req.getParameter("id_preg"));
        co.eliminarPreg("preguntas", id_preg);
        
        m.addAttribute("mensaje", "Pregunta eliminada");
        List preguntas = co.Obtener_Datos_Tabla("preguntas");
        m.addAttribute("preguntas", preguntas);
        List respuesta = co.Obtener_Datos_Tabla("respuesta");
        m.addAttribute("respuesta", respuesta);
        
        return pag;
    }
    
    @RequestMapping(value = "alumno.htm", method = RequestMethod.GET)
    public String irAlumno(Model m) throws SQLException {
        Conectar co = new Conectar();
        String pag = "alumno";
        
        List preguntas = co.Obtener_Datos_Tabla("preguntas");
        m.addAttribute("preguntas", preguntas);
        List respuesta = co.Obtener_Datos_Tabla("respuesta");
        m.addAttribute("respuesta", respuesta);
        
        return pag;
    }
    
    
    @RequestMapping(value = "corregir.htm", method = RequestMethod.POST)
    public String corregirExamen(Model m, HttpServletRequest req) throws SQLException{
        Conectar co = new Conectar();
        String pag = "corregir";
        String email = req.getParameter("email");
        int puntos = 0;
        try {
            Conexion con = new Conexion(Datos_BD.bbdd,Datos_BD.usuario,Datos_BD.clave);
            List preguntas = co.Obtener_Datos_Tabla("preguntas");
            
            for (int i = 0; i < preguntas.size() ; i++) {
                con.Obtener_Datos_Tabla("preguntas");
                int id = Integer.parseInt(con.sacarDatos(i, "id_preg"));
                String tipo = String.valueOf(con.sacarDatos(i, "tipo"));
                if(tipo.equals("check")){
                    String resp[] = req.getParameterValues("res"+i);
                    int cont = 0;
                    int num = con.sacarNumRespu("respuesta", id);
                    for (int j = 0; j < resp.length; j++) {
                        List correc = co.corregir("respuesta", id, Integer.parseInt(resp[j]));
                        if(correc.isEmpty()){
                            
                        }else cont++;
                    }
                    if(cont == num) puntos ++;
                }else{
                    String resp = req.getParameter("res"+i);
                    String correc = con.sacarRespu("respuesta", "descripcion", id);
                    if(correc.equals(resp)){
                        puntos++;
                    }
                }
            }//Fin del for que recorre todas las preguntas
            float notafinal = (puntos*10)/preguntas.size();
            List existe = co.obtenerPersona("notas", email);
            if(existe.isEmpty()) co.guardarNota(email, notafinal);
            else co.modificarNota(email, notafinal);
            
            List usuario = co.obtenerPersona("notas", email);
            m.addAttribute("usuario", usuario);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pag;
    }


    
    
}
