import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class T06_Addresses_with_Employee_Count {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        List<Address> address = em.createQuery("FROM Address").getResultList();
        address.stream().sorted(Comparator.comparingInt(x -> ((Address) x).getEmployees().size()).reversed())
                //.sorted(Comparator.comparing(x2 -> x2.getTown().getId()))
                .limit(10)
                .forEach(x->{
                    System.out.println(x.getText()+", "+x.getTown()+" - "+
                            x.getEmployees().size()+" employees");
                });

        em.getTransaction().commit();
    }
}
