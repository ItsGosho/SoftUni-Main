package itsgosho.repositories;

import itsgosho.domain.dtos.exports.xml.BranchExportXMLDto;
import itsgosho.domain.dtos.exports.xml.TownExportXMLDto;
import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town,Long> {

    Town findTownByName(String name);

    @Query(value = "select t,\n" +
            "coalesce((select sum(p.clients)\n" +
            "from Product as p\n" +
            "join Branch as b on b=p.branch\n" +
            "where b.town=t),0) as totalClients\n" +
            "from Town as t\n" +
            "order by totalClients desc")
    List<Object> exportTowns();
}
