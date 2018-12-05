package itsgosho.repositories;

import itsgosho.domain.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {

    Branch findByName(String name);

    @Query("select b,(\n" +
            "select coalesce(sum(p.clients),0)\n" +
            "from Product as p\n" +
            "where p.branch = b\n" +
            ") as totalClients\n" +
            "from Branch as b\n" +
            "join Town as t on t=b.town\n" +
            "order by totalClients desc")
    List<Object> exportTopBranches();
}
