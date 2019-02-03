package IgorKup;


import IgorKup.model.Player;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {
    private EntityManagerFactory factory;
    @Before
    public void getFactory(){
        factory = Persistence.createEntityManagerFactory("web-game");


    }

    @Test
    public void emTest(){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Player player = new Player();
        player.setNickName("Vova");
        player.setBet(200);
        em.persist(player);
        em.getTransaction().commit();
        em.close();

    }
}
