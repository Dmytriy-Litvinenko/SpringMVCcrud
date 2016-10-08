package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    public ModelAndView showAll() {
        List<Department> departments;
        try {
            departments = departmentService.getAll();
        } catch (SQLException e) {
            departments = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.DEPARTMENT_ALL, "departments", departments);
    }

    @RequestMapping(value = "/depAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer id,
                                @RequestParam(required = false) String name) {
        ModelAndView modelAndView = new ModelAndView(JspPath.DEPARTMENT_ADD);
        modelAndView.addObject("department_id",id);
        modelAndView.addObject("department_name",name);
        return modelAndView;
    }

    @RequestMapping(value = "/depSave", method = RequestMethod.POST)
    public String addNewOne(@RequestParam(required = true) Integer id,
            @RequestParam(required = true) String name) {
        Department addedDepartment;
        if(id == null){
            addedDepartment = new Department();
            addedDepartment.setName(name);
            try {
                departmentService.insert(addedDepartment);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try {
                addedDepartment = departmentService.getById(id);
                addedDepartment.setName(name);
                departmentService.update(addedDepartment);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/dep";
    }

    @RequestMapping(value = "/departmentDelete", method = RequestMethod.GET)
    public String deleteDepartment(@RequestParam(required = true) Integer id) {
        Department department;
        try {
            department = departmentService.getById(id);
            departmentService.delete(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/dep";
    }


}
