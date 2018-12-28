package itsgosho.controllers;

import itsgosho.config.validators.preAuthenticate.PreAuthenticate;
import itsgosho.domain.dtos.virus.VirusCreateDto;
import itsgosho.domain.dtos.virus.VirusEditDto;
import itsgosho.domain.entities.Virus;
import itsgosho.domain.services.CapitalServices;
import itsgosho.domain.services.VirusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/viruses")
public class VirusController extends BaseController {

    private final VirusServices virusServices;
    private final CapitalServices capitalServices;

    @Autowired
    public VirusController(VirusServices virusServices, CapitalServices capitalServices) {
        this.virusServices = virusServices;
        this.capitalServices = capitalServices;
    }

    @GetMapping("/add")
    private ModelAndView addGET(ModelAndView modelAndView) {
        modelAndView.addObject("avaliableCapitals", this.capitalServices.getAllCapitals());
        return super.page("main-page","viruses/add-virus-form","Add Virus",modelAndView);
    }

    @PostMapping("/add")
    private ModelAndView addPOST(ModelAndView modelAndView, VirusCreateDto virusCreateDto) {
        if (this.virusServices.addVirus(virusCreateDto)) {
            return super.redirect("/viruses/show");
        }
        return super.page("main-page","viruses/add-virus-form","Add Virus",modelAndView);
    }

    @GetMapping("/show")
    private ModelAndView showGET(ModelAndView modelAndView) {
        modelAndView.addObject("viruses", this.virusServices.getAllViruses());
        return super.page("main-page","viruses/show-viruses-table","All Viruses",modelAndView);
    }

    @GetMapping("/delete/{id}")
    private ModelAndView deleteProceed(@PathVariable String id, ModelAndView modelAndView) {
        if (this.virusServices.deleteById(id)) {
            return super.redirect("/viruses/show");
        }
        return super.redirect("/viruses/show");
    }

    @GetMapping("/edit/{id}")
    private ModelAndView editGET(@PathVariable String id, ModelAndView modelAndView) {
        Virus virus = this.virusServices.getVirusById(id);
        if(virus!=null){

            modelAndView.addAllObjects(this.virusServices.getAllFieldsAndValues(virus));
            modelAndView.addObject("avaliableCapitals",this.capitalServices.getAllCapitals());

            return super.page("main-page","viruses/edit-virus-form","Edit Virus",modelAndView);
        }
        return super.redirect("viruses/show");
    }

    @PostMapping("/edit/{id}")
    private ModelAndView editPost(@PathVariable String id, ModelAndView modelAndView, VirusEditDto virusEditDto) {
        if(this.virusServices.editVirus(id,virusEditDto)){
            return super.redirect("/viruses/show");
        }
        return super.page("main-page","viruses/edit-virus-form","Edit Virus",modelAndView);
    }

}
