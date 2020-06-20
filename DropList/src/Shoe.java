import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Shoe implements Serializable {
	Calendar c;
	private String brand;
	String model, imglink;
	Date releasedate;
	Double price;

	public String getBrand() {
		return brand;
	}

	private Shoe(String brand) {
		super();
		c = Calendar.getInstance();
		this.brand = brand;
		this.model = null;
		this.releasedate = null;
		this.price = null;
		this.imglink = null;
	}

	public String toString() {
		return "Brand: " + brand + "\nModel: " + model + "\nRelease date: " + releasedate + "\nPrice: " + price + "$";
	}

	public static Shoe factoryNike() {
		return new Shoe("Nike");
	}

	public static Shoe factoryAdidas() {
		return new Shoe("Adidas");
	}

	public static Shoe factoryGucci() {
		return new Shoe("Gucci");
	}

	public static Shoe factoryLV() {
		return new Shoe("Louis Vuitton");
	}

	public static Shoe factoryVans() {
		return new Shoe("Vans");
	}

	public static Shoe factoryBalenciaga() {
		return new Shoe("Balenciaga");
	}

	public static Shoe factoryUnderArmour() {
		return new Shoe("Under Armour");
	}

	public static Shoe factoryCrocs() {
		return new Shoe("Crocs");
	}

	public static Shoe factoryReebok() {
		return new Shoe("Reebok");
	}
}
