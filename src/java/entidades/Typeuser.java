package entidades;
// Generated 03-31-2022 02:20:20 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Typeuser generated by hbm2java
 */
@Entity
@Table(name="typeuser"
    ,catalog="blog"
)
public class Typeuser  implements java.io.Serializable {


     private Integer idTypeuser;
     private String name;
     private String detail;
     private List<User> users = new ArrayList<>();

    public Typeuser() {
    }

    public Typeuser(String name, String detail, List<User> users) {
       this.name = name;
       this.detail = detail;
       this.users = users;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idTypeuser", unique=true, nullable=false)
    public Integer getIdTypeuser() {
        return this.idTypeuser;
    }
    
    public void setIdTypeuser(Integer idTypeuser) {
        this.idTypeuser = idTypeuser;
    }

    
    @Column(name="name", length=50)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="detail", length=250)
    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }

 
   @OneToMany(fetch=FetchType.LAZY, mappedBy="typeuser", cascade = CascadeType.ALL)
    public List<User> getUsers() {
        return this.users;
    }

        
    public void setUsers(List<User> users) {
        this.users = users;
    }


@Override
    public String toString() {
        return "Typeuser{" + "idTypeuser=" + idTypeuser + ", name=" + name + '}';
    }

}

