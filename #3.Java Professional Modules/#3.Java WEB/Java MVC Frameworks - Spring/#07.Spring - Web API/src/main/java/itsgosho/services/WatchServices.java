package itsgosho.services;

import itsgosho.domain.dtos.watch.WatchCreateDto;
import itsgosho.domain.views.watch.WatchDetailsView;
import itsgosho.domain.views.watch.WatchesAllView;
import itsgosho.domain.views.watch.WatchesTopView;

import java.util.List;

public interface WatchServices {
    List<WatchesTopView> exportTopWatches();

    List<WatchesAllView> exportAll();

    void incrementViews(String id);

    WatchDetailsView exportDetails(String id);

    WatchDetailsView create(WatchCreateDto watchCreateDto);
}
