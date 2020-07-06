package DAO;

import Entity.DBEntity.MatchesUpdatesEntity;
import Entity.Match;
import Util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MatchesUpdateDao {

    public MatchesUpdatesEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(MatchesUpdatesEntity.class, id);
    }

    public void save(MatchesUpdatesEntity matchesUpdate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(matchesUpdate);
        tx1.commit();
        session.close();
    }

    public void update(MatchesUpdatesEntity matchesUpdate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(matchesUpdate);
        tx1.commit();
        session.close();
    }

    public void delete(MatchesUpdatesEntity matchesUpdate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(matchesUpdate);
        tx1.commit();
        session.close();
    }

    public List<MatchesUpdatesEntity> findAll() {
        List<MatchesUpdatesEntity> matchesUpdates = (List<MatchesUpdatesEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From MatchesUpdatesEntity ").list();
        return matchesUpdates;
    }

}
