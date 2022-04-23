
package dao;

import dominio.HibernateUtil;
import entidades.Typeuser;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TypeUserDao {
     public List<Typeuser> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Typeuser").list();

    }
    public Typeuser getTypeuserById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Typeuser cat = (Typeuser)sesion.get(Typeuser.class, id);
        return cat;
    }

    public boolean Insertar(Typeuser ca) {
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

    public boolean Actualizar(Typeuser cat) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Typeuser c = (Typeuser) sesion.get(Typeuser.class, cat.getIdTypeuser());
            c.setName(cat.getName());
            c.setDetail(cat.getDetail());
                      
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
            Typeuser p = (Typeuser) sesion.get(Typeuser.class, id);
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
