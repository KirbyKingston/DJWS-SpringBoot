package distjavaws.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Mitch
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product{

    public final static String REQUIRED_MSG = "This is a required field.";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "description")
    private String description;
    @Column(name = "unitCost")
    private double unitCost;

    public Product() {
    }

    public Product(String description, double unitCost) {
        this.description = description;
        this.unitCost = unitCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException(REQUIRED_MSG);
        }
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException(REQUIRED_MSG);
        }
        this.description = description;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        if (unitCost < 0) {
            throw new IllegalArgumentException(REQUIRED_MSG);
        }
        this.unitCost = unitCost;
    }

}
