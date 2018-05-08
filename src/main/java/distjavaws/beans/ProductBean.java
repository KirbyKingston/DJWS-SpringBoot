package distjavaws.beans;

import distjavaws.model.Product;
import distjavaws.service.ProductService;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
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
public class ProductBean implements Serializable {

    @Autowired
    private ProductService productService;

    private String search;
    private Product product;
    private List<Product> productList;

    public ProductBean() {
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public String searchProducts() {
        productList = productService.findProducts(search);
        return "productList";
    }

    public void ProductDetail(AjaxBehaviorEvent event) {
        try {
            getCurrentInstance().getExternalContext()
                    .redirect("ProductDetail.xhtml?id=" + product.getId());
        } catch (IOException ex) {
            FacesMessage msg = new FacesMessage("IOException", product.getId());
            getCurrentInstance().addMessage(null, msg);
        }
    }

    public String allProducts() throws Exception {
        productList = productService.getAllProducts();
        return "productList";
    }

}
