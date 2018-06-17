import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class T02_Contains_Employee {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        String fullName=skener.nextLine();
        List<Employee> employees = em.createQuery("FROM Employee").getResultList();
        boolean found=false;
        for (Employee employee : employees) {
            if((employee.getFirstName()+" "+employee.getLastName()).equals(fullName)){
                found=true;
                break;
            }
        }
        if(found){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        em.getTransaction().commit();
    }
}
