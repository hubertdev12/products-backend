package catProduit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import catProduit.entities.Produit;
import catProduit.repository.ProduitRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	private ProduitRepository produitRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Produit.class); // cette methode permet d'exposer l'id du produit
		
//		produitRepository.save(new Produit(null, "Packarbell 14", 1500, 15));
//		produitRepository.save(new Produit(null, "Acer", 100, 20));
//		produitRepository.save(new Produit(null, "HP 14", 530, 50));
//		produitRepository.save(new Produit(null, "Packarbell", 500, 158));
//		produitRepository.save(new Produit(null, "Packarbell", 800, 105));
		
//		produitRepository.findAll().forEach(p -> {
//			System.out.println(p.toString());
//		});
	}

}
