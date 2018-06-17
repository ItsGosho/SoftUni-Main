import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class T01_Remove_Objects {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        List<Town> towns=em.createQuery("FROM Town as t WHERE LENGTH(t.name)>5").getResultList();

        for (Town town : towns) {
           town.setName(town.getName().toLowerCase());
        }
        em.getTransaction().commit();
    }
}
