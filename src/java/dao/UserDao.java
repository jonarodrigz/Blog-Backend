
package dao;

import dominio.HibernateUtil;
import entidades.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDao {
     public List<User> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from User").list();

    }
    public User getUserById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        User cat = (User)sesion.get(User.class, id);
        return cat;
    }

    public boolean Insertar(User ca) {
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

    public boolean Actualizar(User cat) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            User c = (User) sesion.get(User.class, cat.getIdUser());
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
            User p = (User) sesion.get(User.class, id);
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
