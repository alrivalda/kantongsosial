package gdsc.fundhub.kantongsosialcampaign.service;

import org.springframework.stereotype.Service;

import gdsc.fundhub.kantongsosialcampaign.model.Category;

import java.util.*;
@Service
public interface CategoryService {
    List<Category> findAll();
    void createCategory(long id, String category);
    void deleteAll();
}
