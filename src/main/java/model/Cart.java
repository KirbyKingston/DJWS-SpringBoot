package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Mitch
 */

public class Cart implements Serializable {

    private final static String MSG = "IAE at line";

//    private String cartId;

    private Map<Product, Integer> products;

    public Cart(Map<Product, Integer> products) {
        setProducts(products);
    }

    public final List<Product> getProducts() {
        return new ArrayList(products.keySet());
    }

    public final int getQuantityFor(Product p) {
        int i = products.get(p) == null ? 0 : products.get(p);
        return i;
    }

    public final void setProducts(Map<Product, Integer> products) {
        if (products == null) {
            throw new IllegalArgumentException(MSG + " 30 in CART Class");
        }
        this.products = products;
    }

    public final void setProduct(Product p, int q) {
        products.put(p, q);
    }

    public final void addProduct(Product p, int q) {
        if (products.containsKey(p)) {
            products.put(p, products.get(p) + q);
        } else {
            products.put(p, q);
        }
    }

}
