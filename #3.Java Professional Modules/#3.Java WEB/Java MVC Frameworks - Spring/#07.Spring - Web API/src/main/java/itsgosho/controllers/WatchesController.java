package itsgosho.controllers;

import com.google.gson.Gson;
import itsgosho.domain.dtos.watch.WatchCreateDto;
import itsgosho.services.WatchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/watches",method = {RequestMethod.GET,RequestMethod.POST})
@CrossOrigin(origins = "http://localhost:63342")
public class WatchesController extends BaseController {

    private final WatchServices watchServices;

    @Autowired
    public WatchesController(WatchServices watchServices) {
        this.watchServices = watchServices;
    }

    @GetMapping(value = "/top",produces = "application/json")
    @ResponseBody
    public String topWatches(){
        return new Gson().toJson(this.watchServices.exportTopWatches());
    }

    @GetMapping(value = "/all",produces = "application/json")
    @ResponseBody
    public String allWatches(){
        return new Gson().toJson(this.watchServices.exportAll());
    }

    @GetMapping(value = "/details",produces = "application/json")
    @ResponseBody
    public String detailsWatch(@RequestParam(required = true) String id) {
        this.watchServices.incrementViews(id);
        return new Gson().toJson(this.watchServices.exportDetails(id));
    }

    @PostMapping(value = "/add",produces = "application/json")
    @ResponseBody
    public String detailsWatch(@Valid WatchCreateDto watchCreateDto, BindingResult bindingResult) {
        if(!bindingResult.hasErrors()){
            return new Gson().toJson(this.watchServices.create(watchCreateDto));
        }
        return null;
    }

}
