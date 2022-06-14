package projekt_bdbt.SpringApplication;

import oracle.jdbc.OracleDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projekt_bdbt.SpringApplication.CRUD.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractController {
    @Autowired
    private ContractDAO contractDAO;
    @Autowired
    private ClientDAO clientDAO;

    @GetMapping(value = {"/newContract"})
    public String NewContract(Model model, @RequestParam(value = "ClientID") int id) {
        Contract contract = new Contract();
        Client client = clientDAO.get(id);
        model.addAttribute("contract", contract);
        model.addAttribute("client",client);
        return "CRUD/new_form_contract";
    }
    @PostMapping("/saveContract")
    public String saveContract(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult) {
        try {
            if(bindingResult.hasErrors()){
                return "CRUD/new_form_contract";
            }
            contractDAO.save(contract);
            return "redirect:/umowy/1";
        }
        catch (OracleDatabaseException err){
            return "redirect:/error/dataError";
        }

    }

    @GetMapping("/editContract/{ID_UMOWY}")
    public ModelAndView editContract(@PathVariable(name = "ID_UMOWY") int id) {
        ModelAndView mav = new ModelAndView("CRUD/edit_form_contract");
        Contract contract = contractDAO.get(id);
        Client client = clientDAO.get(contract.getID_KLIENTA());
        mav.addObject("contract",contract);
        mav.addObject("client",client);
        return mav;
    }
    @PostMapping("/updateContract")
    public String updateContract(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult) {
        try {
            if(bindingResult.hasErrors()){
                return "CRUD/edit_form_contract";
            }
            contractDAO.update(contract);
            return "redirect:/umowy/1";
        }
        catch (OracleDatabaseException err){
            return "redirect:/error/dataError";
        }

    }
    //usun
    @RequestMapping("/deleteContract")
    public String deleteEmployee(@RequestParam int id) {
        contractDAO.delete(id);
        return "redirect:/umowy";
    }
}
