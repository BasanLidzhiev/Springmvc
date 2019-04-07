package repository.repositoryImpl;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import repository.interfaces.IRepository;
import utils.HibernateUtil;

import java.util.List;

@Component
public class StudentRepository implements IRepository<Student> {
    @Override
    public Student get(int id) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    @Override
    public List<Student> get() {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        List<Student> list =  session.createQuery( "from Student" ).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public boolean insert(Student item) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            session.save(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Student item) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            session.saveOrUpdate(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        try{
            Student item = session.get(Student.class, id);
            session.delete(item);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
