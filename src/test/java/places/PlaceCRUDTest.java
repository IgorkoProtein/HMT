package places;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import places.dao.SessionManager;
import places.domain.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.01.2019.
 */

public class PlaceCRUDTest {


    @Test
    public void createPlaceTest(){
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();
        Place place = new Place();
        place.setTitle("nafta");
        place.setX(90.3);
        place.setY(76.3);
        place.setZoom(20);

        session.persist(place);
        transaction.commit();
        session.close();
    }

    @Test
    public void getAllPlacesTest(){
        List<Place> places = new ArrayList<>();
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();
        places = session.createQuery("FROM Place").list();
        transaction.commit();
        session.close();
        for (Place p:places) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void getPlacebyId(){
        Place place = new Place();
        place.setId(1);

        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();

        String queryString = "from Place where id = :id";
        Query query = (Query) session.createQuery(queryString);
        query.setInteger("id", place.getId());

        Place place1 = (Place) query.uniqueResult();
        System.out.println(place1.toString());

        transaction.commit();
        session.close();
    }

    @Test
    public void deletePlace() {
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();

//        String queryString = "from Place where id = :id";
//        Query query = session.createQuery(queryString);
//        query.setInteger("id", 1);
       // Place place = (Place) query.uniqueResult();
        Place place = (Place) session.get(Place.class, 2 );
        session.delete(place);
        System.out.println("One employee is deleted!");

        transaction.commit();
        session.close();

    }
    @Test
    public void updatePlace(){
        int id = 1;
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();

        Place place = new Place();
        place.setId(id);
        session.saveOrUpdate(place);
        Place place1 = (Place) session.get(Place.class, id );

        place1.toString();
    }

}
