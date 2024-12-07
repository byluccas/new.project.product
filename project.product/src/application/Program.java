package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.ImportedProduct;
import entites.Product;
import entites.UserProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner enter = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int quantity = enter.nextInt();

		for (int i = 1; i <= quantity; i++) {
			System.out.println("product #" + i + " Data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char enterOneCaracter = enter.next().charAt(0);
			// validation of character 'y' or 'n'

			System.out.print("Name: ");
			String enterName = enter.next();
			System.out.print("Price: ");
			double priceOfProducto = enter.nextDouble();

			if (enterOneCaracter == 'c') {
				list.add(new Product(enterName, priceOfProducto));

			} else if (enterOneCaracter == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(enter.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UserProduct(enterName, priceOfProducto, date));
			} else {
				System.out.print("Taxes imports: ");
				double customFee = enter.nextDouble();
				list.add(new ImportedProduct(enterName, priceOfProducto, customFee));
			}

		}

		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		enter.close();
	}

}