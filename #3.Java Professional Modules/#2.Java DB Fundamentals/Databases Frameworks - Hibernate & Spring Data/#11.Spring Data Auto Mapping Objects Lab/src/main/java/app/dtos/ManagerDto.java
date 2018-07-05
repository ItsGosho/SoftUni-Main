package app.dtos;

import app.entities.Employee;

import java.util.Set;

public class ManagerDto {

    private String firstName;
    private String lastName;
    private Set<EmployeeDto> employees;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeDto> employees) {
        this.employees = employees;
    }
}
