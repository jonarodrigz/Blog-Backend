package dao;

import dominio.HibernateUtil;
import entidades.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CategoryDao {
     public List<Category> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Category").list();

    }
    public Category getCategoryById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Category cat = (Category)sesion.get(Category.class, id);
        return cat;
    }

    public boolean Insertar(Category ca) {
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

    public boolean Actualizar(Category cat) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Category c = (Category) sesion.get(Category.class, cat.getIdCategory());
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
            Category p = (Category) sesion.get(Category.class, id);
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
