package itsgosho;

import itsgosho.domain.dtos.exports.xml.BranchExportXMLDto;
import itsgosho.domain.dtos.exports.xml.TownExportXMLDto;
import itsgosho.domain.entities.Town;
import itsgosho.repositories.TownRepository;
import itsgosho.services.imp.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CLR implements CommandLineRunner {

    private final BranchServicesImp branchServicesImp;
    private final EmployeeCardServicesImp employeeCardServicesImp;
    private final EmployeeServicesImp employeeServicesImp;
    private final ProductServicesImp productServicesImp;
    private final TownServicesImp townServicesImp;
    private final TownRepository townRepository;

    public CLR(BranchServicesImp branchServicesImp, EmployeeCardServicesImp employeeCardServicesImp, EmployeeServicesImp employeeServicesImp, ProductServicesImp productServicesImp, TownServicesImp townServicesImp, TownRepository townRepository) {
        this.branchServicesImp = branchServicesImp;
        this.employeeCardServicesImp = employeeCardServicesImp;
        this.employeeServicesImp = employeeServicesImp;
        this.productServicesImp = productServicesImp;
        this.townServicesImp = townServicesImp;
        this.townRepository = townRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.townServicesImp.seedDatabase();
        this.branchServicesImp.seedDatabase();
        this.employeeCardServicesImp.seedDatabase();
        this.productServicesImp.seedDatabase();
        this.employeeServicesImp.seedDatabase();

        this.employeeCardServicesImp.exportFreeCards();
        this.employeeServicesImp.exportProductiveEmployee();

        this.townServicesImp.exportTowns();
        this.branchServicesImp.exportTopBranches();
    }
}
