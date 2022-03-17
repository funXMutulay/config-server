package org.nioun.essentials.config.server.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Produit {
	
	
	private Long produitId ;

	private String image;

	private String name ;

	private String description;


	private BigDecimal price ;


	private String env ;
	/**
	 * 
	 */
	public Produit() {
	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param price
	 */
	public Produit( String name, String description, BigDecimal price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}


	public Produit( String image, String name, String description, BigDecimal price, String env) {
		
		this.image = image;
		this.name = name;
		this.description = description;
		this.price = price;
		this.env = env;
	}


	public Long getProduitId() {
		return produitId;
	}
	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}






}
