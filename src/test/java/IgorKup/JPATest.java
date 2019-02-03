package IgorKup;

import IgorKup.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by User on 09.12.2018.
 */
public class JPATest {
    private SessionFactory  factory;

    @Before
    public void setUp(){
        factory = new Configuration().configure().buildSessionFactory();
    }
    @Test
    public void createPlayerTest(){
        Session session = factory.openSession();
        session.beginTransaction();

        //Player player = new Player("Igor", 500);
        //session.save(player);
        session.getTransaction().commit();
        session.close();
    }
}
