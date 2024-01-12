package gdsc.fundhub.kantongsosialcampaign;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gdsc.fundhub.kantongsosialcampaign.service.CategoryService;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class KantongsosialCampaignApplication {

	public static void main(String[] args) {
		SpringApplication.run(KantongsosialCampaignApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner run(CategoryService categoryService) {
		return args -> {
			categoryService.deleteAll();
			categoryService.createCategory(1, "Sosial");
			categoryService.createCategory(2, "Pendidikan");
			categoryService.createCategory(3, "Lingkungan");
			categoryService.createCategory(4, "Kesehatan");
			categoryService.createCategory(5, "Lainya");
		};
	}

}
