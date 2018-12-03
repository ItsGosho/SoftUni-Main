package itsgosho.services.imp;

import itsgosho.domain.dtos.exports.xml.BranchExportXMLDto;
import itsgosho.domain.dtos.exports.xml.BranchesExportWrapperXMLDto;
import itsgosho.domain.dtos.imports.json.BranchImportJSONDto;
import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.Product;
import itsgosho.domain.entities.Town;
import itsgosho.io.impl.FileIOImpl;
import itsgosho.parser.ValidationUtil;
import itsgosho.parser.implementations.JSONParser;
import itsgosho.parser.implementations.XMLParser;
import itsgosho.parser.interfaces.ModelParser;
import itsgosho.repositories.BranchRepository;
import itsgosho.repositories.ProductRepository;
import itsgosho.repositories.TownRepository;
import itsgosho.services.inter.BranchServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServicesImp implements BranchServices {

    private final BranchRepository branchRepository;
    private final ProductRepository productRepository;
    private final TownRepository townRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public BranchServicesImp(BranchRepository branchRepository, ProductRepository productRepository, TownRepository townRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.branchRepository = branchRepository;
        this.productRepository = productRepository;
        this.townRepository = townRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean save(Branch branch) {
        this.branchRepository.save(branch);
        return true;
    }

    @Override
    public void seedDatabase() {
       if(this.branchRepository.findAll().size()==0){
           BranchImportJSONDto[] branchImportJSONDtos = null;

           try {
               branchImportJSONDtos = this.jsonParser.read(BranchImportJSONDto[].class,this.fileIO.read("json\\input\\branches.json"));
           } catch (IOException | JAXBException e) {
               e.printStackTrace();
           }

           Arrays.stream(branchImportJSONDtos).forEach(x->{
               Town town = this.townRepository.findTownByName(x.getTown());
               if(this.validationUtil.isValid(x) && town!=null && this.branchRepository.findByName(x.getName())==null){
                   Branch branch = this.modelParser.convert(x,Branch.class);
                   branch.setTown(town);
                   this.save(branch);
                   System.out.println(String.format("Successfully imported Branch %s.",branch.getName()));
               }else{
                   System.out.println("Error: Invalid data.");
               }
           });
       }
    }

    @Override
    public void exportTopBranches() {
        BranchesExportWrapperXMLDto branchesExportWrapperXMLDto = new BranchesExportWrapperXMLDto();
        List<BranchExportXMLDto> branchExportXMLDtoList = new ArrayList<>();

        this.branchRepository.findAll().stream().forEach(x->{
            BranchExportXMLDto branch = new BranchExportXMLDto();
            long totalClients = this.productRepository.findAll().stream().filter(z -> z.getBranch().getId() == x.getId()).mapToLong(Product::getClients).sum();
            branch.setName(x.getName());
            branch.setTown(x.getTown().getName());
            branch.setTotalClients(totalClients);
            branchExportXMLDtoList.add(branch);
        });
        branchesExportWrapperXMLDto.setBranchExportXMLDtoList(branchExportXMLDtoList.stream().sorted((x1,x2)->Long.compare(x2.getTotalClients(),x1.getTotalClients())).collect(Collectors.toList()));
        String res = null;
        try {
            res = this.xmlParser.write(branchesExportWrapperXMLDto);
            this.fileIO.write(res,"xml\\output\\top-branches.xml");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
