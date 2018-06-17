import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        EntityManagerFactory emf=
                Persistence.createEntityManagerFactory("university");

        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        Student gosho=new Student("Gosho",17,"Vraca");
        Student rojko=new Student("Rojko",6,"Ruse");
        Student bochko=new Student("Bochko",11,"Burgas");
        Student zimba=new Student("Zimba",25,"Rim");
        Student taratorcho=new Student("Taratorcho",61,"Dubai");
        em.persist(gosho);
        em.persist(rojko);
        em.persist(bochko);
        em.persist(zimba);
        em.persist(taratorcho);

        Student student=em.find(Student.class,4);
        //System.out.println(student.getName());

        //em.remove(taratorcho);

        List<Student> students=
                em.createQuery("FROM Student").getResultList();
        for (Student item : students) {
            System.out.println(item.getId()+". "+item.getName()+" "+item.getAge()+" "+item.getTown());
        }

        em.getTransaction().commit();
    }
}
