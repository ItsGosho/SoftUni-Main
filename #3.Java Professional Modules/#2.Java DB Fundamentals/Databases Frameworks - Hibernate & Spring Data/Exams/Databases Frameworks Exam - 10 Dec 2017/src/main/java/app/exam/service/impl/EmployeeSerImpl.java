package app.exam.service.impl;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.domain.entities.Employee;
import app.exam.domain.entities.Position;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.EmployeeRepository;
import app.exam.repository.PositionRepository;
import app.exam.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;

@Service
public class EmployeeSerImpl implements EmployeeService {

    @Autowired
    private ModelParser modelParser;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public void create(EmployeeJSONImportDTO importDTO) {
        Employee employee=this.modelParser.convert(importDTO,Employee.class);
        if(this.positionRepository.getPositionByName(importDTO.getPosition())==null){
            Position position=new Position();
            position.setName(importDTO.getPosition());
            position.setEmployees(new LinkedList<>());
            position.getEmployees().add(employee);
            this.positionRepository.save(position);
            employee.setPosition(this.positionRepository.getPositionByName(importDTO.getPosition()));
            this.employeeRepository.save(employee);
        }else{
            Position position=this.positionRepository.getPositionByName(importDTO.getPosition());
            position.getEmployees().add(employee);
            this.employeeRepository.save(employee);
            employee.setPosition(this.positionRepository.getPositionByName(importDTO.getPosition()));
            this.positionRepository.save(position);
        }
    }

    @Override
    public void createMany(EmployeeJSONImportDTO[] importDTO) {
        Employee[] employee=this.modelParser.convert(importDTO,Employee[].class);
        this.employeeRepository.save(Arrays.asList(employee));
    }
}
