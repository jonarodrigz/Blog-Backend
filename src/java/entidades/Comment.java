package entidades;
// Generated 03-31-2022 02:20:20 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name="comment"
    ,catalog="blog"
)
public class Comment  implements java.io.Serializable {


     private Integer idComment;
     private Post post;
     private String name;
     private String comment;
     private String email;
     private Date createdAt;
     private Integer status;

    public Comment() {
    }

    public Comment(Post post, String name, String comment, String email, Date createdAt, Integer status) {
       this.post = post;
       this.name = name;
       this.comment = comment;
       this.email = email;
       this.createdAt = createdAt;
       this.status = status;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idComment", unique=true, nullable=false)
    public Integer getIdComment() {
        return this.idComment;
    }
    
    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    @JsonbTransient
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="post_id")
    public Post getPost() {
        return this.post;
    }
    
    public void setPost(Post post) {
        this.post = post;
    }

    
    @Column(name="name", length=250)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="comment", length=250)
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }

    
    @Column(name="email", length=250)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

//    @Temporal(TemporalType.DATE)
//    @Column(name="created_at", length=10)
//    public Date getCreatedAt() {
//        return this.createdAt;
//    }
//    
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }

    
    @Column(name="status")
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }




}


