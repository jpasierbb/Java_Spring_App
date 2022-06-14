package projekt_bdbt.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import projekt_bdbt.SpringApplication.CRUD.Client;
import projekt_bdbt.SpringApplication.CRUD.ClientDAO;

@Controller
public class ClientController {
    @Autowired
    ClientDAO clientdao;

    @RequestMapping(value = {"/newClient"})
    public String showNewFormClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "CRUD/new_form_client";
    }
    @RequestMapping("/editClient/{ID_Klienta}")
    public ModelAndView showEditFormClient(@PathVariable(name = "ID_Klienta") int id) {
        ModelAndView mav = new ModelAndView("CRUD/edit_form_client");
        Client client = clientdao.get(id);
        mav.addObject("client", client);
        return mav;
    }
    @RequestMapping(value = "/updateClient", method = RequestMethod.POST)
    public String updateClient(@ModelAttribute("client") Client client) {
        clientdao.update(client);
        return "redirect:/";
    }
    //usun
    @RequestMapping("/deleteClient/{ID_Klienta}")
    public String deleteClient(@PathVariable(name = "ID_Klienta") int id) {
        clientdao.delete(id);
        return "redirect:/";
    }
}
