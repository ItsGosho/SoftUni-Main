package app.exam.service.impl;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.domain.entities.Category;
import app.exam.domain.entities.Item;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.CategoryRepository;
import app.exam.repository.ItemsRepository;
import app.exam.service.api.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class ItemSerImpl implements ItemsService {
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemsRepository itemsRepository;
    @Override
    public void create(ItemJSONImportDTO itemJSONImportDTO) {
        Item item=this.modelParser.convert(itemJSONImportDTO,Item.class);
        if(this.categoryRepository.getCategoryByName(itemJSONImportDTO.getCategory())==null){
            Category category=new Category();
            category.setName(itemJSONImportDTO.getCategory());
            category.setItems(new LinkedList<>());
            category.getItems().add(item);
            this.categoryRepository.save(category);
            item.setCategory(this.categoryRepository.getCategoryByName(itemJSONImportDTO.getCategory()));
            this.itemsRepository.save(item);
        }else{
            Category category=this.categoryRepository.getCategoryByName(itemJSONImportDTO.getCategory());
            category.getItems().add(item);
            this.categoryRepository.save(category);
            item.setCategory(this.categoryRepository.getCategoryByName(itemJSONImportDTO.getCategory()));
            this.itemsRepository.save(item);
        }
    }
}
