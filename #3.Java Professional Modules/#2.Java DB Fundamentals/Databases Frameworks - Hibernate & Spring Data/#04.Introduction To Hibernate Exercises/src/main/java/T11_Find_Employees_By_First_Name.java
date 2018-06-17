import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class T11_Find_Employees_By_First_Name {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);


        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        String inputName=skener.nextLine();
        List<Employee> employees=em.createQuery("FROM Employee as e WHERE e.firstName like :input")
                .setParameter("input",inputName+"%")
                .getResultList();
        for (Employee item : employees) {
            System.out.println(item.getFirstName()+" "+item.getLastName()+" - "+item.getDepartment().getName()+" - ($"+item.getSalary()+")");
        }

        em.getTransaction().commit();
    }
}
