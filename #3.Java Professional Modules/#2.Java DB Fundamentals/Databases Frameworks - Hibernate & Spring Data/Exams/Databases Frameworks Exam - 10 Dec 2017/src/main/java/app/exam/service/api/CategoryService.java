package app.exam.service.api;

import app.exam.domain.dto.xml.CategoriesFrequentItemsXMLExportDTO;
import app.exam.domain.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryService{
    CategoriesFrequentItemsXMLExportDTO getCategoriesWithMostPopularItems(List<String> categoryNames);
}
