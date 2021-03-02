package Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author faranzabe
 */
@Controller
public class Controlador {
    
    //Para informar que este método será usado como una vista. La clase ModelAndView permite construir la vista y llamarla.
    @RequestMapping("home.htm")
    public ModelAndView home(){
        ModelAndView m = new ModelAndView();
        m.setViewName("home"); //Sin extensión. La extensión se pone en dispatcher-servlet.
        return m;
    }
    
    @RequestMapping("otro.htm")
    public ModelAndView otro(){
        ModelAndView m = new ModelAndView();
        m.setViewName("otro"); //Sin extensión. La extensión se pone en dispatcher-servlet.
        return m;
    }
}
