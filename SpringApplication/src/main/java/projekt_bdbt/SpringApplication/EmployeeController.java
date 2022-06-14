package projekt_bdbt.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projekt_bdbt.SpringApplication.CRUD.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeJoinedDAO employeeJoinedDAO;
    @Autowired
    PositionDAO positiondao;
    @Autowired
    EmployeeDAO employeedao;

    @RequestMapping(value = {"/newEmployee"})
    public String showNewFormEmployee(Model model) {
        EmployeeJoined employee = new EmployeeJoined();
        List<Position> positions = positiondao.list();
        model.addAttribute("employee", employee);
        model.addAttribute("positionsList",positions);
        return "CRUD/new_form_employee";
    }
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") EmployeeJoined employee) {
        employeeJoinedDAO.save(employee);
        return "redirect:/pracownicy/1";
    }

    //edycja i update
    @RequestMapping("/editEmployee/{ID_PRACOWNIKA}")
    public ModelAndView showEditFormEmployee(@PathVariable(name = "ID_PRACOWNIKA") int id) {
        ModelAndView mav = new ModelAndView("CRUD/edit_form_employee");
        Employee employee = employeedao.get(id);
        mav.addObject("employee", employee);
        return mav;
    }
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeedao.update(employee);
        return "redirect:/";
    }
    //usun
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int id) {
        employeedao.delete(id);
        return "redirect:/pracownicy";
    }
}
