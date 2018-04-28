package beans;

import model.Cart;
import model.Product;
import service.CartService;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mitch
 */
@Component("cartBean")
@Scope("session")
public final class CartBean implements Serializable {

    @Autowired
    private CartService cartService;

    private Product product;
    private double total;
    private Integer amount;
    private String currentProductId;

    public CartBean() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
        System.out.println("CartBean amount at line 39 = " + this.amount);
    }

    public Cart getCart() {
        return cartService.getCart();
    }

    public String getCurrentProductId() {
        return currentProductId;
    }

    public void setTotal() {
        this.total = 0;
        getCart().getProducts().forEach((p) -> {
            this.total += p.getUnitCost() * getCart().getQuantityFor(p);
        });
    }

    public double getTotal() {
        return total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product p) {
        this.product = p;
    }

//    public int getItemsInCart() {
//        return cart.getItemsInCart();
//    }
//
//    public void addToCart(product p, amount a) {
//        this.cartService.addItem(p, a);
//    }
//
//    public void deleteItem(Product p) {
//        cart.remove(p);
//    }
    public void addToCart(AjaxBehaviorEvent event) {
        if (this.amount == null) {
            throw new IllegalArgumentException("");
        }
        if (this.product == null) {
            throw new IllegalArgumentException("");
        }
        this.cartService.addItem(product, this.amount);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/DistJavaWS/ProductDetail.xhtml");
        } catch (IOException e) {
            FacesMessage message = new FacesMessage("IOException", product.getId());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void qtyChange(ValueChangeEvent e) {
        this.setAmount(Integer.valueOf(e.getNewValue().toString()));
        throw new IllegalArgumentException();
    }
}
