package projekt_bdbt.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import projekt_bdbt.SpringApplication.CRUD.*;

import java.util.List;
import java.util.Objects;

@Controller
public class ListController {
    @Autowired
    private EmployeeDAO employeedao;
    @Autowired
    private EmployeeJoinedDAO employeeJoinedDAO;
    @Autowired
    private AddressDAO addressdao;
    @Autowired
    private PositionDAO positiondao;

    @GetMapping("/pracownicy/{pageid}")
    public String getEmployees(Model model, @PathVariable int pageid){
        int total = 20;
        int maxPage = (int) (Math.ceil((employeedao.getSize()/total))+1);
        if(pageid>0 && pageid<=maxPage){
            model.addAttribute("pageid",pageid);
            if(pageid==1){}
            else {
                pageid=(pageid-1)*total+1;
            }
            List<Employee> list = employeedao.getEmployeesByPage(pageid,total);
            model.addAttribute("listEmployee",list);
            model.addAttribute("maxPage",maxPage);
            return "operator/pracownicy";
        }
        else return "errors/404";

    }
    @GetMapping("/pracownicy")
    public String getEmployees(){
        return "redirect:/pracownicy/1";
    }
    @GetMapping("/pracownik")
    public String getEmployee(Model model, @RequestParam(value = "id", required = true) String id){
        return "/index";
    }

}
