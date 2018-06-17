import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class T09_Increase_Salaries {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        List<Employee> employees=em.createQuery("FROM Employee as t WHERE t.department.name='Engineering' or t.department.name='Tool Design' or t.department.name='Marketing' or t.department.name='Information Services'").getResultList();
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            System.out.println(employee.getFirstName()+" "+employee.getLastName()+" ($"+employee.getSalary()+")");
        }

        em.getTransaction().commit();
    }
}
