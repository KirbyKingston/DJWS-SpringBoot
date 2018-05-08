package distjavaws.beans;

import distjavaws.model.Cart;
import distjavaws.model.Product;
import distjavaws.service.CartService;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cartBean")
@Scope("session")
public class CartBean implements Serializable {

    private final String sessionId;
    private final Cart cart;
    private final CartService cartService = new CartService();

    public CartBean() {
        FacesContext facesContext = getCurrentInstance();
        sessionId = facesContext.getExternalContext().getSessionId(true);
        cart = cartService.getContents(sessionId);
    }

    public int getItemsInCart() {
        return cart.getItemsInCart();
    }

    public void addToCart(Product product) {
        cart.add(product);
        cartService.update(sessionId, cart);
    }

}
