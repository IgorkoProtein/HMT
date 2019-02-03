package places;

import IgorKup.bookErrata.ReaderErrata;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import places.dao.SessionManager;
import places.domain.MapArea;
import places.domain.Place;
import places.domain.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by User on 03.02.2019.
 */
public class UserTest {
    @Before
    public void clearTables() throws Exception {
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from User ").executeUpdate();
        session.createQuery("delete from MapArea ").executeUpdate();
        session.createQuery("delete from Place ").executeUpdate();

        transaction.commit();
        session.close();
    }

    @Test
    public void mapsTest(){
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();


        User user = new User();
        user.setLogin("igorKupchak");
        user.setEmail("igorkoprotein@gmail.com");
        user.setPassword("12345678");

        session.persist(user);

        MapArea mp1 = new MapArea();
        mp1.setTitle("IF");
        mp1.setUser(user);

        session.persist(mp1);

        Place mp1p1 = new Place();
        mp1p1.setTitle("nafta");
        mp1p1.setDescription("bursa");
        mp1p1.setX(90.3);
        mp1p1.setY(76.3);
        mp1p1.setZoom(20);
        mp1p1.setArea(mp1);

        session.persist(mp1p1);

        Place mp1p2 = new Place();
        mp1p2.setTitle("plaza");
        mp1p2.setDescription("bursa");
        mp1p2.setX(90.3);
        mp1p2.setY(76.3);
        mp1p2.setZoom(20);
        mp1p2.setArea(mp1);

        session.persist(mp1p2);

        transaction.commit();
        session.close();

//        session = SessionManager.openSession();
//        transaction = session.beginTransaction();
//
//        User user1 = (User) session.byId(User.class).load(user.getId());
//        assertNotNull(user1);
//        assertNotNull(user1.getMapAreaList());
//        assertEquals(user1.getMapAreaList().get(0).getTitle(), mp1.getTitle());
//
//        transaction.commit();
//        session.close();

    }
}