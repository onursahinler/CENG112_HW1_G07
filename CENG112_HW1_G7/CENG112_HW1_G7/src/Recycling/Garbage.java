package Recycling;

public class Garbage {
    private String name;
    private String type;
    private int amount;
    private String quantity;
    
    public Garbage(String name, String type, int amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Garbage [name=" + name + ", type=" + type + ", amount=" + amount + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Garbage)) {
            return false;
        }

        Garbage other = (Garbage) obj;

        return name.equals(other.name) && type.equals(other.type) && amount == other.amount;
    }


	public String getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}



}

		