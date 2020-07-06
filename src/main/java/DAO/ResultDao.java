package DAO;

import Entity.DBEntity.ResultEntity;
import Util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ResultDao {

    public ResultEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ResultEntity.class, id);
    }

    public void save(ResultEntity result) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(result);
        tx1.commit();
        session.close();
    }

    public void update(ResultEntity result) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(result);
        tx1.commit();
        session.close();
    }

    public void delete(ResultEntity result) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(result);
        tx1.commit();
        session.close();
    }

    public List<ResultEntity> findAll() {
        List<ResultEntity> results = (List<ResultEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From ResultEntity ").list();
        return results;
    }

}
