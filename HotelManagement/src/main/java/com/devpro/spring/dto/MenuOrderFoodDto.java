package com.devpro.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.devpro.spring.model.FoodItem;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public class MenuOrderFoodDto {
	@Id
	private Long id;
	private String name;
	private Integer quantity;
	private String price;
	private String total;
	public MenuOrderFoodDto(FoodItem item,Integer quantity) {
		super();
		this.id = item.getId();
		this.name = item.getName();
		this.quantity = quantity;
		this.price = item.getPrice();
		this.total = String.valueOf(this.quantity*Integer.parseInt(this.price));
	}
	@Override
	public String toString() {
		return "MenuOrderFoodDto [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", total=" + total + "]";
	}
}
