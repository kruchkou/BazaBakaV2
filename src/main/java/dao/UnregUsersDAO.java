package dao;

import entity.dbEntity.UnregUsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.logging.Logger;

public class UnregUsersDAO {

    public UnregUsersEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UnregUsersEntity.class, id);
    }

    public void save(UnregUsersEntity appuser) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(appuser);
        tx1.commit();
        session.close();
    }

    public void update(UnregUsersEntity appuser) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(appuser);
        tx1.commit();
        session.close();
    }

    public void delete(UnregUsersEntity appuser) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(appuser);
        tx1.commit();
        session.close();
    }

    public List<UnregUsersEntity> findAll() {
        List<UnregUsersEntity> unregUsers = (List<UnregUsersEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From UnregUsersEntity ",UnregUsersEntity.class).list();
        return unregUsers;
    }
}
