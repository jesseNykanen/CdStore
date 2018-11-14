package hh.palvelinohjelmointi.cdstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.cdstore.model.Category;
import hh.palvelinohjelmointi.cdstore.model.CategoryRepository;
import hh.palvelinohjelmointi.cdstore.model.Cd;
import hh.palvelinohjelmointi.cdstore.model.CdRepo;


@SpringBootApplication
public class CdstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(CdstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CdstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(CdRepo cdRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			//saving products 
			categoryRepository.save(new Category("Metal"));
			categoryRepository.save(new Category("Rock"));
			categoryRepository.save(new Category("Rap"));
			
			cdRepository.save(new Cd("Helix", "Amaranthe", 2018, 1L, 19.99, categoryRepository.findByName("Metal").get(0)));
			cdRepository.save(new Cd("Last Resort", "Papa Roach", 2010, 2L, 15, categoryRepository.findByName("Rock").get(0)));
			cdRepository.save(new Cd("Korson rambo", "en tiedä", 2008, 3L, 22, categoryRepository.findByName("Rap").get(0)));
			
			for (Cd cd : cdRepository.findAll()) {
				log.info(cd.toString());
			}
		};
	}
}
