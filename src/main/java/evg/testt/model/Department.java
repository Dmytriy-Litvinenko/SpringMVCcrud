package evg.testt.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "departments")
public class Department extends BaseModel{

    private String name;
    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//, mappedBy = "user"
    //@JoinTable(name = "user_pictures", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "picture_id")})

   //  = HashSet<Employee>;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
