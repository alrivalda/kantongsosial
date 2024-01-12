package gdsc.fundhub.kantongsosialcampaign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdsc.fundhub.kantongsosialcampaign.model.Category;
import gdsc.fundhub.kantongsosialcampaign.repository.CategoryDb;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDb categoryDb;

    @Override
    public List<Category> findAll() {
        return categoryDb.findAll();
    }

    @Override
    public void createCategory(long id, String category) {
        Category category2 = new Category();
        category2.setCategory(category);
        category2.setId(id);
        categoryDb.save(category2);
    }

    @Override
    public void deleteAll() {
        List<Category> listCategories = findAll();
        for (Category category : listCategories) {
            categoryDb.delete(category);
        }
    }
    
}
