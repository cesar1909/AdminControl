package mx.ipn.cic.biblioteca.AdminControl.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role =  auth.getAuthorities().toString();
        System.out.println(role);
        if (role.contains("ROLE_ADMIN")){
             return "redirect:/admin/mainAdmin";
        }
        else if (role.contains("ROLE_MONITOR")){
            return "redirect:/monitor/allPatients";
        }
        else if (role.contains("ROLE_DOCTOR")){
            return "redirect:/doctor/allPatients";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

        String role =  authResult.getAuthorities().toString();
        System.out.println("ROL DE ENTRADA: " + role);
        if(role.contains("ROLE_ADMIN")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin"));
        }
        else if(role.contains("ROLE_MONITOR")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/monitor"));
        }
        else if(role.contains("ROLE_DOCTOR")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/doctor"));
        }
    }


//    @GetMapping("/user")
//    public String userIndex() {
//        return "redirect:/mav/";
//    }
    
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public ModelAndView admin() {
//    	ModelAndView model = new ModelAndView();
//    	model.setViewName("mainAdmin");
//    	return model;
//    }

//    @RequestMapping(value = "/monitor", method = RequestMethod.GET)
//    public ModelAndView monitor() {
//    	ModelAndView model = new ModelAndView();
//    	model.setViewName("patientsAndDoctorsList");
//    	return model;
//    }
//    @Secured(value={"DOCTOR"})
//    @GetMapping("/mainAdmin")
//    public String mainAdmin() {
//    	System.out.println("WORK?");
//        return "redirect:/patient/mainAdmin";
//    }
//    public ModelAndView user() {
//    	ModelAndView model = new ModelAndView();
//    	model.setViewName("mainAdmin");
//    	return model;
//    }
}
