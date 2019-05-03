package br.com.ecommerceapi.entity;

public class Product {

	private Integer id;

	private String name;

	private Double costPurchase;

	private Double costSale;

	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCostPurchase() {
		return costPurchase;
	}

	public void setCostPurchase(Double costPurchase) {
		this.costPurchase = costPurchase;
	}

	public Double getCostSale() {
		return costSale;
	}

	public void setCostSale(Double costSale) {
		this.costSale = costSale;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
