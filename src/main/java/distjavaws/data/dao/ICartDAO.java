package distjavaws.data.dao;

import distjavaws.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mitch
 */
public interface ICartDAO extends JpaRepository<Cart, Integer> {

}
