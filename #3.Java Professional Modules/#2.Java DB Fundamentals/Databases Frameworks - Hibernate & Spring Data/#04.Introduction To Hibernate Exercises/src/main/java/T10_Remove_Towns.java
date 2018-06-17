import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class T10_Remove_Towns {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        String inputTown="Sofia";
        List<Town> towns=em.createQuery("FROM Town as t WHERE t.name=:inpTown")
                .setParameter("inpTown",inputTown)
                .getResultList();

        for (Town town : towns) {
            List<Address> addresses=em.createQuery("FROM Address  as a WHERE a.town.id=:tID")
                    .setParameter("tID",town.getId())
                    .getResultList();


            //the task is bugged cuz we cannot delete a foreign key that also references to employees


//            for (Address address : addresses) {
//                em.remove(address);
//            }
            System.out.println(addresses.size()+" address in "+town.getName()+" deleted");
        }
        em.getTransaction().commit();
    }
}
