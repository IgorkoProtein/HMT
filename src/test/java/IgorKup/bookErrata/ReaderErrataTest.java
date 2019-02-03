package IgorKup.bookErrata;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import places.dao.SessionManager;

import javax.persistence.Table;

import static org.junit.Assert.*;

/**
 * Created by User on 30.01.2019.
 */
public class ReaderErrataTest {
    @Before
    public void clearTables() throws Exception {
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from ReaderErrata").executeUpdate();
        session.createQuery("delete from Book ").executeUpdate();

        transaction.commit();
        session.close();
    }

    @Test
    public void persistErrata(){
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();

        Book book = new Book();
        book.setTitle("Potter");
        session.persist(book);

        ReaderErrata errata = new ReaderErrata();
        errata.setBook(book);
        errata.setContent("first chapter cngbgvdbf");
        session.persist(errata);

        transaction.commit();
        session.close();

        session = SessionManager.openSession();
        transaction = session.beginTransaction();
        ReaderErrata readerErrata = (ReaderErrata) session.byId(ReaderErrata.class).load(errata.getId());
        assertNotNull(readerErrata);
        assertNotNull(readerErrata.getBook());
        assertEquals(readerErrata.getBook().getTitle(), book.getTitle());

        transaction.commit();
        session.close();

    }

}