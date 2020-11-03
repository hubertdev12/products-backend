package catProduit.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import catProduit.entities.Produit;

@CrossOrigin({"*"})
@RepositoryRestResource
public interface ProduitRepository  extends JpaRepository<Produit, Long>{
	// la liste de tous les produits
	public List<Produit> findAll();
	
	// rechercher les produits par designation
	@RestResource(path = "/designation")
	public List<Produit> findByDesignation(@Param("mc") String designation);
	
	// rechercher les produits par mot clé et de chaque page
	@RestResource(path = "/pagedesignation")
	public Page<Produit> findByDesignation(@Param("mc") String designation, Pageable page);
}
