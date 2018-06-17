import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class T07_Get_Employee_with_Project {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        int inputId=Integer.parseInt(skener.nextLine());
        Employee employee=em.find(Employee.class,inputId);

        System.out.println(employee.getFirstName()+" "+employee.getLastName()
        +" - "+employee.getJobTitle());

        Set<Project> projects=employee.getProjects();

        projects.stream()
                .sorted((x1,x2)->x1.getName().compareTo(x2.getName()))
                .forEach(x->{
            Project project=x;
            System.out.println(project.getName());
        });

        em.getTransaction().commit();
    }
}
