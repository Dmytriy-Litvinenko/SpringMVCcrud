package evg.testt.util.validation;

import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueImpl implements ConstraintValidator<Unique, String> {

    @Autowired
    EmployeeService employeeService;

    private String message;

    @Override
    public void initialize(Unique unique) {
        this.message = unique.message();
    }

    @Override
    public boolean isValid(String target, ConstraintValidatorContext context) {
        try {
            Employee employee = employeeService.getByEmail(target);
            if(employee != null) return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
