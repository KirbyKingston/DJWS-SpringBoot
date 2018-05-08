package distjavaws.data.dao;

import distjavaws.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mitch
 */
public interface IProductDAO extends JpaRepository<Product, String>{

}