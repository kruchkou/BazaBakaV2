package dao;

import entity.dbEntity.LeaguesEntity;
import util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LeagueDao {

    public LeaguesEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(LeaguesEntity.class, id);
    }

    public void save(LeaguesEntity league) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(league);
        tx1.commit();
        session.close();
    }

    public void update(LeaguesEntity league) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(league);
        tx1.commit();
        session.close();
    }

    public void delete(LeaguesEntity league) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(league);
        tx1.commit();
        session.close();
    }

    public List<LeaguesEntity> findAll() {
        List<LeaguesEntity> league = (List<LeaguesEntity>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From LeaguesEntity ").list();
        return league;
    }

    public List<LeaguesEntity> byName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session.createNamedQuery("League.byName")
                .setParameter("name", name)
                .getResultList();
    }

}
