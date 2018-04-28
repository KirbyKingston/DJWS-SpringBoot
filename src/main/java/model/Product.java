package model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Mitch
 */
@Entity(name = "Product")
public class Product implements Serializable{

    public final static String REQUIRED_MSG = "This is a required field.";

    @Id
    @GeneratedValue
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "unitCost")
    private double unitCost;

    public Product(String id, String description, double unitCost) {
        setId(id);
        setDescription(description);
        setUnitCost(unitCost);
    }
    
    public Product(String id, Double unitCost){
		this(id,"",unitCost);
	}
    
    public Product(){ 
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", unitCost=" + unitCost + '}';
    }

}
