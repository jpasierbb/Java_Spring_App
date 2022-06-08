package projekt_bdbt.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import projekt_bdbt.SpringApplication.CRUD.*;

import java.util.List;

@Controller
public class ListController {
    @Autowired
    private EmployeeDAO employeedao;
    @Autowired
    private AddressDAO addressdao;
    @Autowired
    private PositionDAO positiondao;

    @GetMapping("/pracownicy/{pageid}")
    public String getEmployees(Model model, @PathVariable int pageid){
        int total = 10;
        model.addAttribute("pageid",pageid);
        if(pageid==1){}
        else {
            pageid=(pageid-1)*total+1;
        }
        List<Employee> list = employeedao.getEmployeesByPage(pageid,total);
        int maxPage = (list.size()/total)+1;
        model.addAttribute("listEmployee",list);
        model.addAttribute("maxPage",maxPage);

        return "operator/pracownicy";
    }
}
