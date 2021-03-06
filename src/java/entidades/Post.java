package entidades;
// Generated 03-31-2022 02:20:20 PM by Hibernate Tools 4.3.1


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Post generated by hbm2java
 */
@Entity
@Table(name="post" ,catalog="blog")
public class Post  implements java.io.Serializable {


     private Integer idPost;
     private Category category;
     private User user;
     private String title;
     private String brief;
     private String content;
     private String image;
     private Date createdAt;
     private Integer status;
     private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(Category category, User user, String title, String brief, String content, String image, Date createdAt, Integer status, List<Comment> comments) {
       this.category = category;
       this.user = user;
       this.title = title;
       this.brief = brief;
       this.content = content;
       this.image = image;
       this.createdAt = createdAt;
       this.status = status;
       this.comments = comments;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPost", unique=true, nullable=false)
    public Integer getIdPost() {
        return this.idPost;
    }
    
    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    @JsonbTransient
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonbTransient
   @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="title", length=250)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    
    @Column(name="brief", length=250)
    public String getBrief() {
        return this.brief;
    }
    
    public void setBrief(String brief) {
        this.brief = brief;
    }

    
    @Column(name="content", length=65535)
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    
    @Column(name="image", length=250)
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
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

   @OneToMany(fetch=FetchType.LAZY, mappedBy="post", cascade = CascadeType.ALL)
    public List<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }




}


