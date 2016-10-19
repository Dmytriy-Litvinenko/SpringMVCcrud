package evg.testt.model;

import evg.testt.util.validation.Unique;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "employees")
public class Employee extends BaseModel{

    @NotBlank(message="Employee cannot have empty name!")
    @Size(min = 3, message = "your name cannot be shorter than 3 symbols")
    private String firstName;

    @NotBlank(message="Employee cannot have empty surname!")
    private String secondName;

    @NotEmpty(message = "Email cannot be empty!")
    //@Unique(message = "This email is already in use!")
    @Email(message = "Input valid email, please!")
    private String email;

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

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    /*@Override
    public int hashCode() {
        if (this.getId()==null){
            return firstName.hashCode()+secondName.hashCode();
        }else{
            return super.hashCode();
        }

    }*/
}
