package beans;
import model.Product;
import service.ProductService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mitch
 */
@Component("productBean")
@Scope("session")
public final class ProductBean implements Serializable {

    @Autowired
    private ProductService productService;

    private String searchString;
    private Product product;
    private List<Product> products;

    public ProductBean() {
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product p) {
        product = p;
        System.out.println("product = " + product);
    }

    public final List<Product> getProducts() {
        return products;
    }

    public final void setProducts(List<Product> p) {
        if (p != null) {
            products = p;
        }
        System.out.println("ProductBean products at line 51 = " + products);
    }

    public final String getSearchString() {
        return searchString;
    }

    public final void setSearchString(String search) {
        searchString = search;
        System.out.println("ProductBean searchString at line 60 = " + searchString);
    }

    public final String searchProducts() throws Exception {
        List<Product> productSearchList = productService.findProducts(searchString);
        System.out.println(productSearchList);
        if (productSearchList == null) {
            System.out.println("null productSearchList");
            return "ProductList";
        }
        System.out.println("good productSearchList");
        return "ProductList";
    }

    public void productDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/DistJavaWS/ProductDetail.xhtml");
        } catch (IOException ex) {
            FacesMessage message = new FacesMessage("IOException", product.getId());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
