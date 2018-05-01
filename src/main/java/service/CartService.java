package service;

import java.util.HashMap;
import java.util.Objects;
import model.Cart;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mitch
 */
@Service
@Transactional
public class CartService {

    @Autowired
    private final Cart cart;

    public CartService() {
        cart = new Cart(new HashMap<>());
    }

    public Cart getCart() {
        return cart;
    }

    public void addItem(Product p, int amount) {
        cart.addProduct(p, amount);
    }

    public void setItem(Product p, int amount) {
        cart.setProduct(p, amount);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cart);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CartService other = (CartService) obj;
        return Objects.equals(this.cart, other.cart);
    }

    @Override
    public String toString() {
        return "CartService{" + "cart=" + cart + '}';
    }

}
