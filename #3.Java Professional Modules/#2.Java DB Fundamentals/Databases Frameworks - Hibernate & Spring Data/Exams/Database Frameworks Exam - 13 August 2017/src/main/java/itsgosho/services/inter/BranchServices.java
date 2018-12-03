package itsgosho.services.inter;

import itsgosho.domain.entities.Branch;

public interface BranchServices {

    boolean save(Branch branch);
    void seedDatabase();

    void exportTopBranches();
}
