package entites;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	/**
	 * @return the customsFee
	 */
	public Double getCustomsFee() {
		return customsFee;
	}

	/**
	 * @param customsFee the customsFee to set
	 */
	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public double totalPrice() {
		return getPrice() + customsFee;
	}
	
	@Override
	public String priceTag() {
		return getName()
				+ "$"
				+ String.format("%.2f", totalPrice())
		+ ("Customs fee $") + String.format("%.2f", customsFee);
	}
	

}
