package org.nioun.essentials.config.server.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Commande {

@Id
@GeneratedValue
private Long commandeId ;

private Long produitId;

private String name ;


private String description;

private BigDecimal quantite ;

private BigDecimal price ;

private BigDecimal prixTotal;

private String env ;


public Commande() {
	
}






public Commande(Long produitId, String name, String description,BigDecimal quantite, BigDecimal price,  BigDecimal prixTotal,
		String env) {
	super();
	this.produitId = produitId;
	this.name = name;
	this.description = description;
	this.price = price;
	this.quantite = quantite;
	this.prixTotal = prixTotal;
	this.env = env;
}



public Long getProduitId() {
	return produitId;
}


public void setProduitId(Long produitId) {
	this.produitId = produitId;
}


public Long getCommandeId() {
	return commandeId;
}


public void setCommandeId(Long commandeId) {
	this.commandeId= commandeId;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public BigDecimal getPrice() {
	return price;
}


public void setPrice(BigDecimal price) {
	this.price = price;
}


public BigDecimal getQuantite() {
	return quantite;
}


public void setQuantite(BigDecimal quantite) {
	this.quantite = quantite;
}


public BigDecimal getPrixTotal() {
	return prixTotal;
}


public void setPrixTotal(BigDecimal prixTotal) {
	this.prixTotal = prixTotal;
}


public String getEnv() {
	return env;
}


public void setEnv(String env) {
	this.env = env;
}



}
