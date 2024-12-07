package entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserProduct extends Product {

	private LocalDate manuFactureDate;

	public UserProduct() {

	}

	public UserProduct(String name, Double price, LocalDate manuFactureDate) {
		super(name, price);
		this.manuFactureDate = manuFactureDate;
	}

	public LocalDate getManuDate() {
		return manuFactureDate;
	}

	public void setManuFactureDate(LocalDate manuFactureDate) {
		this.manuFactureDate = manuFactureDate;
	}

	@Override
	public String priceTag() {
		return getName() + ("used ") + "$" + String.format("%.2f", getName()) + ("manuFactureDate")
				+ manuFactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

}
