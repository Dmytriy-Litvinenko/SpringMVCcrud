package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public ModelAndView showAll(@RequestParam(required = true) Integer id) {
        List<Employee> employeeList= null;//
        Department department;
        try {
            department=departmentService.getById(id);
            employeeList=department.getEmployees();
            //employeeList =employeeService.getByDepartment(department);//.getByDepartment//g.getById(id);
        } catch (SQLException e) {
            //employeeList = Collections.emptyList();
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView(JspPath.EMPLOYEE_ALL);
        modelAndView.addObject("employees", employeeList);
        modelAndView.addObject("department_id",id);
        return modelAndView;

    }
    @RequestMapping(value = "/empAdd", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = false) Integer id,
                                @RequestParam(required = false) Integer department_id)  {
        ModelAndView modelAndView=new ModelAndView(JspPath.EMPLOYEE_ADD);
        Department department=null;
        Employee employee=null;
        if (department_id!=null){
            try {
                department = departmentService.getById(department_id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /**/if (id!=null){
            try {
                employee=employeeService.getById(id);
                department=employee.getDepartment();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        modelAndView.addObject("employee",employee);
        modelAndView.addObject("department",department);
        return modelAndView;

    }

    @RequestMapping(value = "/empSave", method = RequestMethod.POST)
    public String addNewOne(
                            @RequestParam(required = true) String firstName,
                            @RequestParam(required = true) String secondName,
                            @RequestParam(required = true) Integer department_id,
                            @RequestParam(required = true) Integer employee_id) {
        Employee employee;
        Department department ;
        if (employee_id==null){
            employee = new Employee();
            employee.setFirstName(firstName);
            employee.setSecondName(secondName);
            //= departmentService;
            //employee.
            try {
                department=departmentService.getById(department_id);
                employee.setDepartment(department);
                employeeService.insert(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try {
                department=departmentService.getById(department_id);
                employee=employeeService.getById(employee_id);
                employee.setFirstName(firstName);
                employee.setSecondName(secondName);
                employee.setDepartment(department);
                employeeService.update(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/emp?id="+department_id;
    }

    @RequestMapping(value = "/employeeDelete", method = RequestMethod.GET)
    //@ResponseBody
    public String deleteEmployee(@RequestParam(required = true) Integer id) {
        //List list= new LinkedList<Integer>();
        Integer departmentId=null;
        Employee employee=null;
        try {
            employee = employeeService.getById(id);
            departmentId =employee.getDepartment().getId();
            employeeService.delete(employee);
            employee.getId();
            String s="hello";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return "idemp = "+employee.getId()+", id_dep ="+departmentId;
        return "redirect:/emp?id="+departmentId;
    }


    @RequestMapping(value = "/empAddAndValidate", method = RequestMethod.GET)
    public ModelAndView showAdd(@RequestParam(required = true) Integer department_id
            //,Model model
    )  {
        //ModelAndView modelAndView=new ModelAndView(JspPath.EMPLOYEE_ADD_AND_VALIDATE);
        ModelAndView modelAndView=new ModelAndView(JspPath.EMPLOYEE_ADD_AND_VALIDATE);
                /*Department department= null;
        try {
            department = departmentService.getById(department_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        Employee employee=new Employee();
        //employee.setDepartment(department);
        //
        //model.addAttribute(employee);//.addAttribute("employee",employee);
        //model.addAttribute("department_id",department_id);//.addObject();
        modelAndView.addObject(employee);
        modelAndView.addObject("department_id",department_id);
        return modelAndView;
        //return ""+employee.getId();
    }

    @RequestMapping(value = "/empAddAndValidate", method = RequestMethod.POST)//value = "/empSaveAfterValidation"
    //@ResponseBody
    public String addAndValidateNewOne(@RequestParam(required = true) Integer department_id,
                                       @Valid Employee employee,BindingResult result  // atedresult@ModelAttribute("employee")
            /*@RequestParam(required = true) String firstName,
            @RequestParam(required = true) String secondName,*/
                                       ////
    ) {
        if(result.hasErrors()){
            //return "redirect:/empAddAndValidate?department_id="+department_id;
           return JspPath.EMPLOYEE_ADD_AND_VALIDATE;//?id="+employee.getDepartment().getId();
        }
        Department department= null;
        try {
            department = departmentService.getById(department_id);
            employee.setDepartment(department);
            employeeService.insert(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/emp?id="+department_id;

        // return "ok, depName="+employee.getFirstName()+", result = "+result.hasErrors();
    }
}
