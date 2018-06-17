import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class T12_Employees_Maximum_Salaries {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);


        EntityManagerFactory emf=Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        List<Department> departments=em.createQuery("FROM Department ").getResultList();
        for (Department department : departments) {
            double salaryTotal=0D;
            Set<Employee> employeeSet=department.getEmployees();
            for (Employee employee : employeeSet) {
                salaryTotal+=employee.getSalary().doubleValue();
            }
            if(salaryTotal<30000.00 || salaryTotal>70000.00){
                System.out.println(department.getName()+" - "+salaryTotal);
            }
        }

        em.getTransaction().commit();
    }
}
