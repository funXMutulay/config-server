package org.nioun.essentials.config.server.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Lob;

import org.nioun.essentials.config.server.model.Commande;
import org.nioun.essentials.config.server.model.Produit;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

public class ServerXController {

	@GetMapping("/commande/name/{name}/description/{description}/quantite/{quantite}")
	public Commande returnCommandeValue(@PathVariable ("name") String name ,
			@PathVariable ("description") String description ,
			@PathVariable ("quantite") BigDecimal quantite ,ModelMap map) {
		
		HashMap<String , String> uriVariables = new HashMap<>();
		uriVariables.put("name", name);
		uriVariables.put("description", description);
		ResponseEntity<Commande> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/produit/name/{name}/description/{description}",
						Commande.class,
						uriVariables);
		
		Commande commande = responseEntity.getBody() ;
		
		
		return new Commande(commande.getProduitId(),
				name,description,quantite,
				commande.getPrice(),
				quantite.multiply(commande.getPrice()),
				commande.getEnv());
	
	
	} 
	
	@GetMapping("/produit/name/{name}/description/{description}")
	 public Produit	recupererProduit(@PathVariable ("name") String name , @PathVariable ("description") String description){
//		 Produit produit = new Produit(1000L,name,description,BigDecimal.valueOf(1000));
		
		HashMap<String , String> uriVariables = new HashMap<>();
		uriVariables.put("name", name);
		uriVariables.put("description", description);
		ResponseEntity<Produit> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/produit/name/{name}/description/{description}",
						Produit.class,
						uriVariables);
		
		Produit produit = responseEntity.getBody() ;
		
		
		Produit produit1=new Produit(); 
		produit1.setProduitId(produit.getProduitId());
		produit1.setImage(produit.getImage());
		produit1.setName(produit.getName());
		produit.setDescription(produit.getDescription());
		produit1.setPrice(produit.getPrice());
		produit1.setEnv(produit.getEnv());


		return produit1;
		

	}

}
