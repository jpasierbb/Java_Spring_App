package projekt_bdbt.SpringApplication;

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
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeJoined employee, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "CRUD/new_form_employee";
        }
        employeeJoinedDAO.save(employee);
        return "redirect:/pracownicy/1";
    }

    //edycja i update
    @RequestMapping("/editEmployee/{ID_PRACOWNIKA}")
    public ModelAndView showEditFormEmployee(@PathVariable(name = "ID_PRACOWNIKA") int id) {
        ModelAndView mav = new ModelAndView("CRUD/edit_form_employee");
        EmployeeJoined employee = employeeJoinedDAO.get(id);
        List<Position> positionsList = positiondao.list();
        mav.addObject("employee", employee);
        mav.addObject("positionsList", positionsList);
        return mav;
    }
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(@Valid @ModelAttribute("employee") EmployeeJoined employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "CRUD/edit_form_employee";
        }
        employeeJoinedDAO.update(employee);
        return "redirect:/pracownicy";
    }
    //usun
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int id) {
        employeeJoinedDAO.delete(id);
        return "redirect:/pracownicy";
    }
}
