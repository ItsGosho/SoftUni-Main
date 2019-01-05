package itsgosho.services;

import itsgosho.domain.dtos.watch.WatchCreateDto;
import itsgosho.domain.entities.Watch;
import itsgosho.domain.views.watch.WatchDetailsView;
import itsgosho.domain.views.watch.WatchesAllView;
import itsgosho.domain.views.watch.WatchesTopView;
import itsgosho.repositories.WatchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatchServicesImp implements WatchServices {

    private final WatchRepository watchRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WatchServicesImp(WatchRepository watchRepository, ModelMapper modelMapper) {
        this.watchRepository = watchRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<WatchesTopView> exportTopWatches() {
        List<WatchesTopView> result = new ArrayList<>();
        this.watchRepository.findAllOrderedByViews().stream().limit(4).forEach(x->result.add(this.modelMapper.map(x,WatchesTopView.class)));
        return result;
    }

    @Override
    public List<WatchesAllView> exportAll() {
        List<WatchesAllView> result = new ArrayList<>();
        this.watchRepository.findAll().forEach(x->result.add(this.modelMapper.map(x,WatchesAllView.class)));
        return result;
    }

    @Override
    public void incrementViews(String id) {
        Watch watch = this.watchRepository.findById(id).orElse(null);
        watch.setViews(watch.getViews()+1);
        this.watchRepository.save(watch);
    }

    @Override
    public WatchDetailsView exportDetails(String id) {
        WatchDetailsView result =this.modelMapper.map(this.watchRepository.findById(id).orElse(null),WatchDetailsView.class);
        return result;
    }

    @Override
    public WatchDetailsView create(WatchCreateDto watchCreateDto) {
        Watch watch = this.modelMapper.map(watchCreateDto,Watch.class);
        this.watchRepository.save(watch);
        return this.modelMapper.map(watch,WatchDetailsView.class);
    }
}
