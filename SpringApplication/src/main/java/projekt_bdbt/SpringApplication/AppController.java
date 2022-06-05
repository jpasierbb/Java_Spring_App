package projekt_bdbt.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import projekt_bdbt.SpringApplication.CRUD.Employee;
import projekt_bdbt.SpringApplication.CRUD.EmployeeDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private EmployeeDAO employeedao;


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/main_operator").setViewName("operator/main_operator");
        registry.addViewController("/main_klient").setViewName("klient/main_klient");
        registry.addViewController("/main_konsultant").setViewName("konsultant/main_konsultant");
        registry.addViewController("/main_pracownik").setViewName("pracownik/main_pracownik");
        registry.addViewController("/main_sprzedawca").setViewName("sprzedawca/main_sprzedawca");
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

        //wczytywanie
        @RequestMapping(value = {"/"})
        public String showHomePage(Model model) {
            List<Employee> listEmployee = employeedao.list();
            model.addAttribute("listEmployee", listEmployee);
            return "index";
        }

        //zapisywanie
        @RequestMapping(value = {"/new"})
        public String showNewForm(Model model) {
            Employee employee = new Employee();
            model.addAttribute("employee", employee);
            return "CRUD/new_form";
        }
        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("employee") Employee employee) {
            employeedao.save(employee);
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
    }

}
