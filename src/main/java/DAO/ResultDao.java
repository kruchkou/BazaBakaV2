package DAO;

import Entity.DBEntity.MatchesLEntity;
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

    public List<ResultEntity> byParams(String score, String set1, String set2, String set3, String set4, String set5, String set6, String set7) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session.createNamedQuery("Result.byParams")
                .setParameter("score", score)
                .setParameter("set1", set1)
                .setParameter("set2", set2)
                .setParameter("set3", set3)
                .setParameter("set4", set4)
                .setParameter("set5", set5)
                .setParameter("set6", set6)
                .setParameter("set7", set7)
                .getResultList();
    }
}
