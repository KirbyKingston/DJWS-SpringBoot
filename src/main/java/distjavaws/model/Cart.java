package distjavaws.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Mitch
 */

//public final class Cart implements Serializable {
//
//    private final static String MSG = "IAE at line";
//
////    private String cartId;
//
//    private Map<Product, Integer> products;
//
//    public Cart(Map<Product, Integer> products) {
//        setProducts(products);
//    }
//
//    public List<Product> getProducts() {
//        return new ArrayList(products.keySet());
//    }
//
//    public int getQuantityFor(Product p) {
//        int i = products.get(p) == null ? 0 : products.get(p);
//        return i;
//    }
//
//    public void setProducts(Map<Product, Integer> products) {
//        if (products == null) {
//            throw new IllegalArgumentException(MSG + " 30 in CART Class");
//        }
//        this.products = products;
//    }
//
//    public void setProduct(Product p, int q) {
//        products.put(p, q);
//    }
//
//    public void addProduct(Product p, int q) {
//        if (products.containsKey(p)) {
//            products.put(p, products.get(p) + q);
//        } else {
//            products.put(p, q);
//        }
//    }
//
//}
public class Cart implements Serializable {
	private final List<Product> contents = new ArrayList<>();

	public List<Product> getContents() {
		return Collections.unmodifiableList(contents);
	}

	public int getItemsInCart() {
		return contents.size();
	}

	public void add(Product product) {
		contents.add(product);
	}

	public void remove(Product product) {
		contents.remove(product);
	}

	public void removeAll() {
		contents.clear();
	}

}
