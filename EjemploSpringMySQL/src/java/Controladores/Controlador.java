package Controladores;

import Modelos.Conectar;
import Modelos.Conexion;
import Modelos.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author faranzabe
 */
@Controller
public class Controlador {

    //Más información sobre JDBC Template
    //https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    /*
    @RequestMapping("home.htm")
    public ModelAndView home(){
        ModelAndView m = new ModelAndView();
        String sql = "select * from personas";
       
        List datos = this.jdbcTem.queryForList(sql);
        m.addObject("datos", datos);
        m.setViewName("home");
        return m;
    }
     */
    //Usando JDBC Template
    //Más información sobre JDBC Template
    //https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    @RequestMapping(value = "home.htm", method = RequestMethod.GET)
    public String home(Model m) {
        Conectar co = new Conectar("ejemplo", "fernando", "Chubaca2018");
        try {

            List datos = co.Obtener_Datos_Tabla("personas");
            m.addAttribute("datos", datos);

        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "home";
    }

    //Usando la clase Conexión clásica
    @RequestMapping(value = "home2.htm", method = RequestMethod.GET)
    public String home2(Model m) {
        Conexion co = null;
        try {
            co = new Conexion("ejemplo", "fernando", "Chubaca2018");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Persona> datos = null;
        try {
            datos = co.Obtener_Datos_Tabla("personas");
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.addAttribute("datos", datos);
        return "home2";
    }

    //---------------------- Inserción con jDBC -----------------------------
    @RequestMapping(value = "insertarJDBC.htm", method = RequestMethod.GET)
    public String insertarJDBC(Model m) {

        return "formulario";
    }

    @RequestMapping(value = "insertarJDBC.htm", method = RequestMethod.POST)
    public String insertarJDBCRegistrar(@RequestParam("dni") String dni, @RequestParam("nombre") String nombre, @RequestParam("tfno") String tfno, Model m) {
        Conectar co = new Conectar("ejemplo", "fernando", "Chubaca2018");
        String pag = "insercionok";
        if (co.insertar(dni, nombre, tfno)) {

            m.addAttribute("dni", dni);
            m.addAttribute("nombre", nombre);
            m.addAttribute("tfno", tfno);
        } else {
            pag = "errorinsercion";
        }
        return pag;
    }

    
    //---------------------- Inserción clásica -----------------------------
    @RequestMapping(value = "insertarClasico.htm", method = RequestMethod.GET)
    public String insertarClasica(Model m) {

        return "formularioClasico";
    }
    
    @RequestMapping(value = "insertarClasico.htm", method = RequestMethod.POST)
    public String insertarClasicoRegistrar(@RequestParam("dni") String dni, @RequestParam("nombre") String nombre, @RequestParam("tfno") String tfno, Model m) {
        Conexion co = null;
        String pag = "insercionok";
        try {
            co = new Conexion("ejemplo", "fernando", "Chubaca2018");

            if (co.insertar(dni, nombre, tfno)) {
                m.addAttribute("dni", dni);
                m.addAttribute("nombre", nombre);
                m.addAttribute("tfno", tfno);
            } else {
                pag = "errorinsercion";
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            pag = "errorinsercion";
        }
        return pag;
    }

}
