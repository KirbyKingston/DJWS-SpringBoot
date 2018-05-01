package service;

import data.dao.IProductDAO;
import java.util.List;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    public ProductService() {
    }

    public Product getProductById(String searchId) {
        return pDAO.getOne(searchId);
    }

    public List<Product> getAllProducts() {
        return pDAO.findAll();
    }

    public List<Product> findProducts(String search) {
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("description", ExampleMatcher.GenericPropertyMatchers.contains());
        Product p = new Product();
        p.setDescription(search);
        return pDAO.findAll(Example.of(p, matcher));
    }

}
