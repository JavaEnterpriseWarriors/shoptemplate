package pl.javaenterprisewarriors.shoptemplate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DISCOUNTS")
public class Discount {

	@Id
	@GeneratedValue
	@Column(name = "discount_id")
	private int id;
	@Column(name = "amount_of_discount")
	private double amountOfDiscount;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Product product;

	public Discount() {
	}

	public Discount(double amountOfDiscount, Product product) {
		this.amountOfDiscount = amountOfDiscount;
		this.product = product;
	}
}
