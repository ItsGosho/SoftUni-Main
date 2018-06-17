import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class T05_Adding_A_New_Address_And_Updating_Employee {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Address address=new Address();
        address.setText("Vitoshka 15");
        em.persist(address);
        List<Employee> employees = em.createQuery("FROM Employee").getResultList();
        employees.get(employees.size()-1).setAddress(address);
        em.persist(employees.get(employees.size()-1));
        em.getTransaction().commit();
    }
}
