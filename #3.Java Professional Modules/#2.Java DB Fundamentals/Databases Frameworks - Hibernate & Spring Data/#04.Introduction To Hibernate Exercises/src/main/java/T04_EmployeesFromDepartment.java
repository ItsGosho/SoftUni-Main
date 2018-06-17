import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T04_EmployeesFromDepartment {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("FROM Employee").getResultList();
        List<Department> departments = em.createQuery("FROM Department").getResultList();
        employees.stream()
                .filter(x->x.getDepartment().getName().equals("Research and Development"))
                .sorted((x1,x2)->x2.getSalary().compareTo(x1.getSalary()))
                .sorted((x1,x2)->x1.getId().compareTo(x2.getId()))
        .forEach(x->{
            Department department=x.getDepartment();
            System.out.println(x.getFirstName()+" "+x.getLastName()+" from "+
           department.getName()+" - $"+x.getSalary());
        });

        em.getTransaction().commit();
    }
}
