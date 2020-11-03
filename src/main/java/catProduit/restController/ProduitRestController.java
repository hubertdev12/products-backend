package catProduit.restController;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import catProduit.entities.Produit;
import catProduit.repository.ProduitRepository;

// Cette class permet d'implémenter les cas complexes que spring data ne peut pas faire
// A savoir que toutes les methodes ici dans cette classe sont deja pris en compte par spring data
// Donc l'utilisation du RestController permet de créer de méthodes complexes.

//@CrossOrigin("*")
//@RestController
public class ProduitRestController {

	@Autowired
	private ProduitRepository produitRepository;
	
	// retourner la liste de tous les produits
	@GetMapping("/listProduits")
	public List<Produit> listProduits(){
		return produitRepository.findAll();
	}
	
	// retourner un produit par son id
	@GetMapping("/listProduits/{id}")
	public Produit listProduits(@PathVariable(name="id") Long id){
		return produitRepository.findById(id).get();
	}
	
	// mettre à jour un produit par son id
	@PutMapping("/listProduits/{id}")
	public Produit update(@PathVariable(name="id") Long id, @RequestBody Produit p){
		p.setId(id);
		return produitRepository.save(p);
	}
	
	// enregistrer un produit par son id
	@PostMapping("/listProduits")
	public Produit save(@RequestBody Produit p){
		return produitRepository.save(p);
	}
	
	// supprimer un produit par son id
	@DeleteMapping("/listProduits/{id}")
	public void delete(@PathVariable(name="id") Long id){
		produitRepository.deleteById(id);
	}
//	// rechercher les produits par designation
//	@GetMapping("/listProduits/designation")
//	public List<Produit> findByKeyword(@PathParam(value = "mc") String designation){
//		return produitRepository.findByDesignation(designation);
//	}
//	// rechercher les produits par mot clé et de chaque page
//	@GetMapping("/listProduits/pagedesignation")
//	public Page<Produit> findByKeyword(@PathParam(value = "mc") String designation, Pageable page){
//		return produitRepository.findByDesignation(designation, page);
//	}
}
