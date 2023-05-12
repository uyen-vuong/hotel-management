package com.devpro.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "food_item")
@JsonIgnoreProperties("category")
public class FoodItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_item_id")
	private Long id;

	public FoodItem(Long id, String name, String description, String price, String image, Category category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	public FoodItem(String name, String description, String price, String image, Category category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	@Column(name = "food_item_name",unique = true)
	private String name;
	
	@Column(name = "food_item_description")
	private String description;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "image")
	private String image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

}
