package gdsc.fundhub.kantongsosialcampaign.restcontroller;

import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdsc.fundhub.kantongsosialcampaign.dto.Request.CreateCampaignRequestDTO;
import gdsc.fundhub.kantongsosialcampaign.dto.response.CreateCampaignResponse;
import gdsc.fundhub.kantongsosialcampaign.model.Category;
import gdsc.fundhub.kantongsosialcampaign.service.CategoryService;
import java.util.*;

@RestController
@RequestMapping("/api")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("/all-category")
    private ResponseEntity<?> getAllCategory() {
        try {
            List<Category> categories = categoryService.findAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
