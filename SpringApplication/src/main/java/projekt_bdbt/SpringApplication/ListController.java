package projekt_bdbt.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import projekt_bdbt.SpringApplication.CRUD.*;

import java.sql.SQLException;
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
    @Autowired
    private ContractDAO contractDAO;
    @Autowired
    ClientJoinedDAO clientJoinedDAO;

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
    @GetMapping("/pracownik/{id}")
    public String getEmployee(Model model, @PathVariable(value = "id") int id){
        try {
            EmployeeJoined employeeJoined = employeeJoinedDAO.get(id);
            model.addAttribute("employee",employeeJoined);
            return "operator/pracownik";
        }
        catch (EmptyResultDataAccessException err){
            return "errors/404";
        }
    }

    @GetMapping("/umowy/{id}")
    public String getContracts(Model model, @PathVariable(value = "id") int pageid){
        int total = 20;
        int maxPage = (int) (Math.ceil((contractDAO.getSize()/total))+1);
        if(pageid>0 && pageid<=maxPage){
            model.addAttribute("pageid",pageid);
            if(pageid==1){}
            else {
                pageid=(pageid-1)*total+1;
            }
            List<Contract> list = contractDAO.getContractsByPage(pageid,total);
            model.addAttribute("listContracts",list);
            model.addAttribute("maxPage",maxPage);
            return "pracownik/umowy";
        }
        else return "errors/404";
    }
    @GetMapping("/umowy")
    public String getContracts(){
        return "redirect:/umowy/1";
    }

    @GetMapping("/klienci/{id}")
    public String getClients(Model model, @PathVariable(value = "id") int pageid){
       int total = 20;
       int maxPage = (int) (Math.ceil((clientJoinedDAO.getSize()/total))+1);
       if(pageid>0 && pageid<=maxPage){
           model.addAttribute("pageid",pageid);
           if(pageid==1){}
           else {
               pageid=(pageid-1)*total+1;
           }
           List<ClientJoined> list = clientJoinedDAO.getClientsByPage(pageid,total);
           model.addAttribute("listClientJoined",list);
           model.addAttribute("maxPage",maxPage);
           return "pracownik/klienci";
       }
       else return "errors/404";
   }
   @GetMapping("/klienci")
   public String getClients(){
        return "redirect:/klienci/1";
   }

    @GetMapping("/klient/{id}")
    public String getClient(Model model, @PathVariable(value = "id") int id){
        try {
            ClientJoined clientJoined = clientJoinedDAO.get(id);
            model.addAttribute("client",clientJoined);
            return "pracownik/klient";
        }
        catch (EmptyResultDataAccessException err){
            return "errors/404";
        }
    }

}
