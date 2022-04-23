
package dao;

import dominio.HibernateUtil;
import entidades.Post;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PostDao {
     public List<Post> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Post").list();

    }
    public Post getPostById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Post cat = (Post)sesion.get(Post.class, id);
        return cat;
    }

    public boolean Insertar(Post ca) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            sesion.save(ca);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Actualizar(Post cat) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Post c = (Post) sesion.get(Post.class, cat.getIdPost());
           c.setTitle(cat.getTitle());
           c.setBrief(cat.getBrief());
                      
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Eliminar(int id) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Post p = (Post) sesion.get(Post.class, id);
            sesion.delete(p);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }
}
