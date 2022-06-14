package projekt_bdbt.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import projekt_bdbt.SpringApplication.CRUD.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private EmployeeDAO employeedao;
    @Autowired
    private AddressDAO addressdao;
    @Autowired
    private PositionDAO positiondao;
    @Autowired
    private ClientDAO clientdao;
    @Autowired
    private EmployeeJoinedDAO employeeJoinedDAO;


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }

    @Controller
    public class DashboardController {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            } else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            } else if
            (request.isUserInRole
                            ("OPERATOR")) {
                return "redirect:/main_operator";
            } else if
            (request.isUserInRole
                            ("KLIENT")) {
                return "redirect:/main_klient";
            } else if
            (request.isUserInRole
                            ("KONSULTANT")) {
                return "redirect:/main_konsultant";
            } else if
            (request.isUserInRole
                            ("PRACOWNIK")) {
                return "redirect:/main_pracownik";
            } else if
            (request.isUserInRole
                            ("SPRZEDAWCA")) {
                return "redirect:/main_sprzedawca";
            }else {
                return "redirect:/index";
            }
        }




        @RequestMapping(value = {"/"})
        public String showHomePage(Model model){
            List<Employee> listEmployee = employeedao.list();
            model.addAttribute("listEmployee", listEmployee);
            return "index";
        }
        @RequestMapping(value = "/index")
        public String showHomePage(){
            return "redirect:/";
        }


        @RequestMapping(value = {"/newAddress"})
        public String showNewFormAddress(Model model) {
            Address address = new Address();
            model.addAttribute("address", address);
            return "CRUD/new_form_address";
        }
        @RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
        public String saveAddress(@ModelAttribute("address") Address address) {
            addressdao.save(address);
            return "redirect:/";
        }
        //edycja i update
        @RequestMapping("/editAddress/{ID_ADRESU}")
        public ModelAndView showEditFormAddress(@PathVariable(name = "ID_ADRESU") int id) {
            ModelAndView mav = new ModelAndView("CRUD/edit_form_address");
            Address address = addressdao.get(id);
            mav.addObject("address", address);
            return mav;
        }
        @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
        public String updateAddress(@ModelAttribute("address") Address address) {
            addressdao.update(address);
            return "redirect:/";
        }
        //usun
        @RequestMapping("/deleteAddress/{ID_ADRESU}")
        public String deleteAddress(@PathVariable(name = "ID_ADRESU") int id) {
            addressdao.delete(id);
            return "redirect:/";
        }

        //TABELA Stanowiska
        //zapisywanie
        @RequestMapping(value = {"/newPosition"})
        public String showNewFormPosition(Model model) {
            Position position = new Position();
            model.addAttribute("position", position);
            return "CRUD/new_form_position";
        }
        @RequestMapping(value = "/savePosition", method = RequestMethod.POST)
        public String savePosition(@ModelAttribute("position") Position position) {
            positiondao.save(position);
            return "redirect:/";
        }
        //edycja i update
        @RequestMapping("/editPosition/{ID_STANOWISKA}")
        public ModelAndView showEditFormPosition(@PathVariable(name = "ID_STANOWISKA") int id) {
            ModelAndView mav = new ModelAndView("CRUD/edit_form_position");
            Position position = positiondao.get(id);
            mav.addObject("position", position);
            return mav;
        }
        @RequestMapping(value = "/updatePosition", method = RequestMethod.POST)
        public String updatePosition(@ModelAttribute("position") Position position) {
            positiondao.update(position);
            return "redirect:/";
        }
        //usun
        @RequestMapping("/deletePosition/{ID_STANOWISKA}")
        public String deletePosition(@PathVariable(name = "ID_STANOWISKA") int id) {
            positiondao.delete(id);
            return "redirect:/";
        }

        //perspektywy
        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }

        @RequestMapping(value = {"/main_user"})
        public String showUserPage(Model model) {
            return "user/main_user";
        }

        @RequestMapping(value = {"/main_operator"})
        public String showOperatorPage(Model model) {
            return "operator/main_operator";
        }

        @RequestMapping(value = {"/main_klient"})
        public String showKlientPage(Model model) {
            return "klient/main_klient";
        }

        @RequestMapping(value = {"/main_konsultant"})
        public String showKonsultantPage(Model model) {
            return "konsultant/main_konsultant";
        }

        @RequestMapping(value = {"/main_pracownik"})
        public String showPracownikPage(Model model) {
            return "pracownik/main_pracownik";
        }

        @RequestMapping(value = {"/main_sprzedawca"})
        public String showSprzedawcaPage(Model model) {
            return "sprzedawca/main_sprzedawca";
        }
        @GetMapping(value = "/return")
        public String goBack(HttpServletRequest request){
            String referer = request.getHeader("Referer");
            return "redirect:"+referer;
        }
    }

}
