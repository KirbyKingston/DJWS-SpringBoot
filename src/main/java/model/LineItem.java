package model;

import java.util.Objects;

/**
 *
 * @author Mitch
 */
public class LineItem {
        private final static String MSG = "IAE at line";
	private Product product;
	private int amount;
	
	public LineItem(Product p, int amount){
		setProduct(p);
		setAmount(amount);
	}

	public Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		if(product == null)
			throw new IllegalArgumentException(MSG + " 25 in LineItem class for null product");
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.product);
        hash = 17 * hash + this.amount;
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
        final LineItem other = (LineItem) obj;
        if (this.amount != other.amount) {
            return false;
        }
        return Objects.equals(this.product, other.product);
    }

    @Override
    public String toString() {
        return "LineItem{" + "product=" + product + ", amount=" + amount + '}';
    }
        
   }
