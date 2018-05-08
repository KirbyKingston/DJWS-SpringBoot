package distjavaws.service;

import distjavaws.data.dao.IProductDAO;
import distjavaws.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import static org.springframework.data.domain.Example.of;
import org.springframework.data.domain.ExampleMatcher;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import static org.springframework.data.domain.ExampleMatcher.matching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mitch
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    private IProductDAO pDAO;

    public Product getProduct(String id) {
        return pDAO.getOne(id);
    }

    public List<Product> getAllProducts() throws Exception {
        return pDAO.findAll();
    }

    public List<Product> findProducts(String search) {
        ExampleMatcher matcher = matching()
                .withMatcher("description", startsWith().ignoreCase());
        Product product = new Product();
        product.setDescription(search);
        return pDAO.findAll(of(product, matcher));
    }

    public void createProduct(Product product) {
        pDAO.save(product);
    }

    public void updateProduct(Product product) {
        pDAO.save(product);
    }

    public void deleteProduct(String id) {
        pDAO.deleteById(id);
    }

}
