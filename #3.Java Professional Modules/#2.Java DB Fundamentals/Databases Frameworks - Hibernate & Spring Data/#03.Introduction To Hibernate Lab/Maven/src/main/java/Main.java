import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Student gosho=new Student("Gosho",17,"Vraca");
        Student rojko=new Student("Rojko",6,"Ruse");
        Student bochko=new Student("Bochko",11,"Burgas");
        Student zimba=new Student("Zimba",25,"Rim");
        Student taratorcho=new Student("Taratorcho",61,"Dubai");
        session.save(gosho);
        session.save(rojko);
        session.save(bochko);
        session.save(zimba);
        session.save(taratorcho);

        Student student=session.get(Student.class,4);
        //System.out.println(student.getName());

        List<Student> students=session
                .createQuery("FROM Student ")
                .list();
        List<Student> studentsWithCriteria=session
                .createCriteria(Student.class)
                .add(Restrictions.like("name","G%"))
                .list();
        for (Student item : students) {
            System.out.println(item.getId()+". "+item.getName()+" "+item.getAge()+" "+item.getTown());
        }

        session.getTransaction().commit();
        session.close();
    }
}
