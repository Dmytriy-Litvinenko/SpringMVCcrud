package evg.testt.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "employees")
public class Employee extends BaseModel{

    @NotBlank(message="Employee cannot have empty name!")
    //@Size(min = 3, message = "your name cannot be shorter than 3 symbols")
    private String firstName;
    @NotBlank(message="Employee cannot have empty surname!")
    private String secondName;

    @ManyToOne//(fetch= FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;




    public String getFirstName() {return firstName;    }
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    /*@Override
    public int hashCode() {
        if (this.getId()==null){
            return firstName.hashCode()+secondName.hashCode();
        }else{
            return super.hashCode();
        }

    }*/
}
