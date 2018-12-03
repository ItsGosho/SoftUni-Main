package itsgosho.services.imp;

import itsgosho.domain.dtos.imports.xml.ProductsWrapperImportXMLDto;
import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.Product;
import itsgosho.io.impl.FileIOImpl;
import itsgosho.parser.ValidationUtil;
import itsgosho.parser.implementations.JSONParser;
import itsgosho.parser.implementations.XMLParser;
import itsgosho.parser.interfaces.ModelParser;
import itsgosho.repositories.BranchRepository;
import itsgosho.repositories.ProductRepository;
import itsgosho.services.inter.ProductServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class ProductServicesImp implements ProductServices {

    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public ProductServicesImp(ProductRepository productRepository, BranchRepository branchRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean save(Product product) {
        this.productRepository.save(product);
        return true;
    }

    @Override
    public void seedDatabase() {
        if (this.productRepository.findAll().size() == 0) {
            ProductsWrapperImportXMLDto productsWrapperImportXMLDto = null;
            try {
                productsWrapperImportXMLDto = this.xmlParser.read(ProductsWrapperImportXMLDto.class, this.fileIO.read("xml\\input\\products.xml"));
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }

            productsWrapperImportXMLDto.getProductImportXMLDtoList().stream().forEach(x -> {
                Branch branch = this.branchRepository.findByName(x.getBranch());
                if (this.validationUtil.isValid(x) && branch != null) {
                    Product product = this.modelParser.convert(x, Product.class);
                    product.setBranch(branch);
                    this.save(product);
                    System.out.println(String.format("Successfully imported Product %s.", product.getName()));
                } else {
                    System.out.println("Error: Invalid data.");
                }
            });

        }
    }
}
