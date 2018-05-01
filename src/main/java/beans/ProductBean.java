package beans;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.ProductService;

/**
 *
 * @author Mitch
 */
@Component("productBean")
@Scope("session")
public class ProductBean implements Serializable {

    @Autowired
    private ProductService productService;

    private String searchString;
    private Product product;
    private List<Product> products;

    public ProductBean() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product p) {
        product = p;
        System.out.println("product = " + product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void setProducts(List<Product> p) {
        if (p != null) {
            products = p;
        }
        System.out.println("ProductBean products at line 51 = " + products);
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String search) {
        searchString = search;
        System.out.println("ProductBean searchString at line 60 = " + searchString);
    }

    public String searchProducts() throws Exception {
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
