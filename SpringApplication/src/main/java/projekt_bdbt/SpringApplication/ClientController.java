package projekt_bdbt.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projekt_bdbt.SpringApplication.CRUD.*;

@Controller
public class ClientController {
    @Autowired
    ClientDAO clientdao;
    @Autowired
    ClientJoinedDAO clientjoineddao;

    @RequestMapping(value = {"/newClient"})
    public String showNewFormClient(Model model) {
        ClientJoined client = new ClientJoined();
        model.addAttribute("client", client);
        return "CRUD/new_form_client";
    }

    @RequestMapping(value = "/saveClient", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("client") ClientJoined client) {
        clientjoineddao.simpleSave(client);
        return "redirect:/klienci";
    }

    @RequestMapping("/editClient/{ID_Klienta}")
    public ModelAndView showEditFormClient(@PathVariable(name = "ID_Klienta") int id) {
        ModelAndView mav = new ModelAndView("CRUD/edit_form_client");
        ClientJoined client = clientjoineddao.get(id);
        mav.addObject("client", client);
        return mav;
    }
    @RequestMapping(value = "/updateClient", method = RequestMethod.POST)
    public String updateClient(@ModelAttribute("client") ClientJoined client) {
        clientjoineddao.update(client);
        return "redirect:/klienci";
    }
    //usun
    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam(name = "id") int id) {
        clientjoineddao.delete(id);
        return "redirect:/klienci";
    }
}
