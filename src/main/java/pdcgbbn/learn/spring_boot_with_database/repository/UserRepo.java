package pdcgbbn.learn.spring_boot_with_database.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import pdcgbbn.learn.spring_boot_with_database.domain.User;

@Repository
@RequiredArgsConstructor
public class UserRepo {

    private final SessionFactory sessionFactory;

    public User save(User user) {
        Session session = session();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();

        return user;
    }


    private Session session() {
        Session session = sessionFactory.getCurrentSession();
        if(session == null) {
            session = sessionFactory.openSession();
        }

        return session;
    }
}
