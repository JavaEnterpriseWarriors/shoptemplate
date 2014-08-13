package pl.javaenterprisewarriors.shoptemplate.shoppingcomponent;

import java.util.ArrayList;
import java.util.List;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;

public class Basket {

	private List<Product> productList = new ArrayList<Product>();
	
	public void addProductToBasket(Product product) {
		productList.add(product);
	}
	
	public void removeProductFromBasket(Product product) {
		productList.remove(product);
	}
	
	public List<Product> getProductList() {
		return productList;
	}
}
