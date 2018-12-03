package itsgosho;

import itsgosho.services.imp.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLR implements CommandLineRunner {

    private final BranchServicesImp branchServicesImp;
    private final EmployeeCardServicesImp employeeCardServicesImp;
    private final EmployeeServicesImp employeeServicesImp;
    private final ProductServicesImp productServicesImp;
    private final TownServicesImp townServicesImp;

    public CLR(BranchServicesImp branchServicesImp, EmployeeCardServicesImp employeeCardServicesImp, EmployeeServicesImp employeeServicesImp, ProductServicesImp productServicesImp, TownServicesImp townServicesImp) {
        this.branchServicesImp = branchServicesImp;
        this.employeeCardServicesImp = employeeCardServicesImp;
        this.employeeServicesImp = employeeServicesImp;
        this.productServicesImp = productServicesImp;
        this.townServicesImp = townServicesImp;
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
