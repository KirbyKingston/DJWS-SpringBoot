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

	public final Product getProduct() {
		return product;
	}

	private final void setProduct(Product product) {
		if(product == null)
			throw new IllegalArgumentException(MSG + " 25 in LineItem class for null product");
		this.product = product;
	}

	public final int getAmount() {
		return amount;
	}

	public final void setAmount(int amount) {
		this.amount = amount;
	}

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.product);
        hash = 17 * hash + this.amount;
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
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
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    @Override
    public final String toString() {
        return "LineItem{" + "product=" + product + ", amount=" + amount + '}';
    }
        
   }
