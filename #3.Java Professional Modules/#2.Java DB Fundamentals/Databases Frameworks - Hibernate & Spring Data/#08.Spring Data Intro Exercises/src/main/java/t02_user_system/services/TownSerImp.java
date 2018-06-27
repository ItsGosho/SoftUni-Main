package t02_user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import t02_user_system.models.Town;
import t02_user_system.repositories.TownRepository;
import t02_user_system.services.interfaces.TownSer;

@Service
@Primary
public class TownSerImp implements TownSer {
    private TownRepository townRepository;

    @Autowired
    public TownSerImp(TownRepository townRepository){
        this.townRepository=townRepository;
    }

    @Override
    public void saveTown(Town town) {
        this.townRepository.save(town);
    }
}
