package repository.repositoryImpl;

import entity.SGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import repository.interfaces.IRepository;
import utils.HibernateUtil;

import java.util.List;

@Component
public class SGroupRepository implements IRepository<SGroup> {
    @Override
    public SGroup get(int id) {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        SGroup sGroup = session.get(SGroup.class, id);
        session.getTransaction().commit();
        return sGroup;
    }

    @Override
    public List<SGroup> get() {
        SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        List<SGroup> list =  session.createQuery( "from SGroup" ).list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public boolean insert(SGroup item) {
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
    public boolean update(SGroup item) {
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
            SGroup item = session.get(SGroup.class, id);
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