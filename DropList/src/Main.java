import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner s = new Scanner(System.in);
		Path path = Paths.get("Droplist.dat");
		Boolean end = true;
		try {
			do {
				ArrayList<Shoe> list = (ArrayList<Shoe>) deserialize(path);
				System.out.println("Choose the mode:\nCheck List-->C\nDeveloper Mode-->D\nExit-->E");
				String a = s.nextLine();
				if (a.equalsIgnoreCase("C")) {
					for (Shoe listing : list) {
						System.out.println(listing + "\n");
					}
					end = false;
				}
				if (a.equalsIgnoreCase("D")) {
					System.out.println("Add shoe-->A\nDelete shoe by model-->D\nExit-->E");
					a = s.nextLine();
					if (a.equalsIgnoreCase("A")) {
						Shoe shoe = null;
						System.out.println("Choose brand:");
						System.out.println(
								"Available brands:\n*Nike\n*Adidas\n*Gucci\n*Louis Vuitton\n*Vans\n*Balenciaga\n*Under Armour\n*Crocs\n*Reebok\nTo cancel adding: Cancel");
						String brand = s.nextLine();
						switch (brand.toUpperCase()) {
						case "NIKE":
							shoe = Shoe.factoryNike();
							enter(shoe);
							break;
						case "ADIDAS":
							shoe = Shoe.factoryAdidas();
							enter(shoe);
							break;
						case "GUCCI":
							shoe = Shoe.factoryGucci();
							enter(shoe);
							break;
						case "LOUIS VUITTON":
							shoe = Shoe.factoryLV();
							enter(shoe);
							break;
						case "VANS":
							shoe = Shoe.factoryVans();
							enter(shoe);
							break;
						case "BALENCIAGA":
							shoe = Shoe.factoryBalenciaga();
							enter(shoe);
							break;
						case "UNDER ARMOUR":
							shoe = Shoe.factoryUnderArmour();
							enter(shoe);
							break;
						case "CROCS":
							shoe = Shoe.factoryCrocs();
							enter(shoe);
							break;
						case "REEBOK":
							shoe = Shoe.factoryReebok();
							enter(shoe);
							break;
						case "CANCEL":
							break;
						}
						if (shoe != null) {
							list.add(shoe);
							serialize(list, path);
						}
					}
					if (a.equalsIgnoreCase("D")) {
						System.out.println("All models from droplist:");
						for (Shoe e : list) {
							System.out.println("Brand: "+e.getBrand());
							System.out.println("Model: "+e.model);
						}
						System.out.println("Enter model you want to delete: ");
						String delete = s.nextLine();
						for (Shoe removable : list) {
							if (delete.equalsIgnoreCase(removable.model)) {
								list.remove(removable);
								serialize(list,path);
								break;
							}
						}
					}
				}
				if (a.equalsIgnoreCase("E")) {
					System.out.println("Exiting...");
					end = false;
				}

			} while (end);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Droplist was created.");
			ArrayList<Shoe> a = new ArrayList<Shoe>();
			serialize(a, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enter(Shoe shoe) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter model: ");
		shoe.model = s.nextLine();
		System.out.println("Enter price: ");
		shoe.price = s.nextDouble();
		System.out.println("Enter release date and time(yyyy/mm/dd/hour):");
		String releasedate = s.next();
		String[] date = releasedate.split("/");
		shoe.c.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]),
				Integer.parseInt(date[3]), 0, 0);
		shoe.releasedate = shoe.c.getTime();
	}

	public static void serialize(ArrayList<Shoe> a, Path path) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toString()));
		oos.writeObject(a);
		oos.close();
	}

	public static Object deserialize(Path path) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toString()));
		Object a = ois.readObject();
		ois.close();
		return a;
	}
}
