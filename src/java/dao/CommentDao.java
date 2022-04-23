package dao;

import dominio.HibernateUtil;
import entidades.Comment;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CommentDao {
     public List<Comment> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Comment").list();

    }
    public Comment getCommentById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Comment cat = (Comment)sesion.get(Comment.class, id);
        return cat;
    }

    public boolean Insertar(Comment ca) {
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

    public boolean Actualizar(Comment cat) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Comment c = (Comment) sesion.get(Comment.class, cat.getIdComment());
            c.setName(cat.getName());
           
                      
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
            Comment p = (Comment) sesion.get(Comment.class, id);
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
