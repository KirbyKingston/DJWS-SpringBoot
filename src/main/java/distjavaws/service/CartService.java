package distjavaws.service;

import distjavaws.model.Cart;
import distjavaws.model.Product;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mitch
 */
@Service
@Transactional
public class CartService {

    private static final Map<String, Cart> contents = new HashMap<>();

    public Cart getContents(String sessionId) {
        Cart cart = contents.computeIfAbsent(sessionId,
                (String t) -> new Cart());

//		ShoppingCart cart = contents.computeIfAbsent(sessionId,
//			new Function<String, ShoppingCart>() {
//			@Override
//			public ShoppingCart apply(String t) {
//				return new ShoppingCart();
//			}
//		});
        return cart;
    }

    public void update(String sessionId, Cart cart) {
        contents.put(sessionId, cart);
    }

    public void delete(String sessionId) {
        contents.remove(sessionId);
    }

}
