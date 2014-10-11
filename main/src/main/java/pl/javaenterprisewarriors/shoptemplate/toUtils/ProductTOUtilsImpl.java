package pl.javaenterprisewarriors.shoptemplate.toUtils;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.tos.ProductTO;

@Repository
public class ProductTOUtilsImpl implements ProductTOUtils {
	private ProductTO productTO;

	public ProductTO createProductTO(Product product) {
		ProductTO tempTO = new ProductTO();
		tempTO.setName(product.getName());
		tempTO.setPrice(product.getPrice());

		ProductTO lockedTO = new ProductTO(tempTO);
		return lockedTO;
	}

	public ProductTO createProductTO() {
		if (productTO == null) {
			throw new NullPointerException("No productTO created");
		}
		ProductTO lockedTO = new ProductTO(productTO);
		productTO = null;
		return lockedTO;
	}

	public boolean areEquals(ProductTO productTO1, ProductTO productTO2) {
		if (!productTO1.getName().equals(productTO2.getName())) {
			return false;
		}
		if (!BigDecimal.valueOf(productTO1.getPrice()).equals(
				BigDecimal.valueOf(productTO2.getPrice()))) {
			return false;
		}
		return true;
	}

	public void prepareProductTO() {
		productTO = new ProductTO();
	}

	public ProductTO marge(ProductTO productTO1, ProductTO productTO2) {
		ProductTO tempTO = new ProductTO();

		if (productTO2.getName() != null) {
			tempTO.setName(productTO2.getName());
		}
		else
		{
			tempTO.setName(productTO1.getName());
		}
		if (productTO2.getPrice() != null) {
			tempTO.setPrice(productTO2.getPrice());
		}
		else
		{
			tempTO.setPrice(productTO1.getPrice());
		}

		ProductTO lockedTO = new ProductTO(tempTO);
		return lockedTO;
	}

	public void setProductName(String name) {
		if (name != null) {
			productTO.setName(name);
		}
	}

	public void setProductPrice(Double price) {
		if (price != null) {
			productTO.setPrice(price);
		}
	}

}
