package repository.repositoryImpl;

import entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import repository.interfaces.IRepository;
import utils.HibernateUtil;

import java.util.List;


@Component
public class GenderRepository implements IRepository<Gender> {

    final private SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public Gender get(int id) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Gender gender = session.get(Gender.class,id);
        session.getTransaction().commit();

        return gender;

    }

    @Override
    public List<Gender> get() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        List<Gender> list = session.createQuery("From Gender").list();
        session.getTransaction().commit();

        return list;
    }

    @Override
    public boolean insert(Gender item) {
        return true;
    }

    @Override
    public boolean update(Gender item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
