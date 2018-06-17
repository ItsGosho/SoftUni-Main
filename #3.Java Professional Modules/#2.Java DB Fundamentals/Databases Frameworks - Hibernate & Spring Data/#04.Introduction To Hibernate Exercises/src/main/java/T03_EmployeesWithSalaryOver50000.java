import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class T03_EmployeesWithSalaryOver50000 {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        List<Employee> employees=em.createQuery("FROM Employee as e WHERE e.salary>50000").getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
        em.getTransaction().commit();
    }
}
