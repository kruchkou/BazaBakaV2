package util;

import entity.dbEntity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(MatchesLEntity.class);
                configuration.addAnnotatedClass(PlayersEntity.class);
                configuration.addAnnotatedClass(LeaguesEntity.class);
                configuration.addAnnotatedClass(ResultEntity.class);
                configuration.addAnnotatedClass(WinLsEntity.class);
                configuration.addAnnotatedClass(MatchesUpdatesEntity.class);
                configuration.addAnnotatedClass(AppusersEntity.class);
                configuration.addAnnotatedClass(UnregUsersEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}