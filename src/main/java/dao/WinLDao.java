package dao;

import entity.dbEntity.WinLsEntity;
import util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class WinLDao {

    public WinLsEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(WinLsEntity.class, id);
    }

    public void save(WinLsEntity winL) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(winL);
        tx1.commit();
        session.close();
    }

    public void update(WinLsEntity winL) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(winL);
        tx1.commit();
        session.close();
    }

    public void delete(WinLsEntity winL) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(winL);
        tx1.commit();
        session.close();
    }

    public List<WinLsEntity> findAll() {
        List<WinLsEntity> winLs = (List<WinLsEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From WinLsEntity ").list();
        return winLs;
    }

}
