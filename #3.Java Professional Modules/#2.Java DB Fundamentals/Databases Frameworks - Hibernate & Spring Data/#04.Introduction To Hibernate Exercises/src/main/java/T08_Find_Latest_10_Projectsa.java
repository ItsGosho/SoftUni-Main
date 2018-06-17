import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class T08_Find_Latest_10_Projectsa {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        List<Project> projects=em.createQuery("FROM Project order by endDate asc").getResultList();
        projects.stream()
                .sorted((x1,x2)->x1.getName().compareTo(x2.getName()))
                .limit(10).forEach(x->{
            System.out.println("Project name:"+x.getName());
            System.out.println("Project Description: "+x.getDescription());
            System.out.println("Project Start Date: "+x.getStartDate());
            System.out.println("Project End Date: "+x.getEndDate());
        });
        
        em.getTransaction().commit();
    }
}
