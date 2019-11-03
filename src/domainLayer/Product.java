package domainLayer;

public class Product {
	private String name;
	private String description;
	private boolean deleted;
	private double price;
	private int amount;
	private String category;
	
	public Product(String name, String description, boolean deleted, double price, int amount,
			String category) {
		super();
		this.name = name;
		this.description = description;
		this.deleted = deleted;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String caregory) {
		this.category = caregory;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nDescription: " + description  + "\nIs deleted: " + 
	            deleted + "\nPrice: " + price + "\nAmount: " + amount + "\nCategory: " + category + "\n\n";
	}
}
