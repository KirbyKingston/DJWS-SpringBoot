package distjavaws.rest;

import distjavaws.model.Product;
import distjavaws.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mitch
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService ps;

    // Create (i.e., POST)
    @RequestMapping(method = POST, path = "/product")
    public void createProduct(@RequestBody Product product) {
        ps.createProduct(product);
    }

    // Read (i.e., GET)
    @RequestMapping(method = GET, path = "/product")
    public List<Product> getProducts() throws Exception {
        List<Product> productList = ps.getAllProducts();
        return productList;
    }

    @RequestMapping(method = GET, path = "/product/{id}")
    public Product getProduct(@PathVariable String id) {
        Product product = ps.getProduct(id);
        return product;
    }

    // Update (i.e., PUT)
    @RequestMapping(method = PUT, path = "/product")
    public void updateProduct(@RequestBody Product product) {
        ps.updateProduct(product);
    }

    // Delete
    @RequestMapping(method = DELETE, path = "/product/{id}")
    public void deleteProduct(@PathVariable String id) {
        ps.deleteProduct(id);
    }

}
