package DAO;

import Entity.DBEntity.AppusersEntity;
import Util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AppuserDao {

    public AppusersEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AppusersEntity.class, id);
    }

    public void save(AppusersEntity appuser) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(appuser);
        tx1.commit();
        session.close();
    }

    public void update(AppusersEntity appuser) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(appuser);
        tx1.commit();
        session.close();
    }

    public void delete(AppusersEntity appuser) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(appuser);
        tx1.commit();
        session.close();
    }

    public List<AppusersEntity> findAll() {
        List<AppusersEntity> appusers = (List<AppusersEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From AppusersEntity ").list();
        return appusers;
    }

}
