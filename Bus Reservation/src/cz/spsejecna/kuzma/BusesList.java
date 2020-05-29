package cz.spsejecna.kuzma;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BusesList extends Bus {
	static ArrayList<Bus> buses = new ArrayList<Bus>();
	static Path path = Paths.get("busList.dat");

	public static void saveToList(Bus b) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			buses = deserialize(path);
			buses.add(b);
			serialize(buses);
		} catch (FileNotFoundException e) {
			serialize(new ArrayList<Bus>());
			saveToList(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static ArrayList<Bus> deserialize(Path path2)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toString()));
		ArrayList<Bus> list = (ArrayList<Bus>) ois.readObject();
		ois.close();
		return list;
	}

	private static void serialize(ArrayList<Bus> busList) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toString()));
		oos.writeObject(busList);
		oos.close();
	}

	public static String returnBusList() throws FileNotFoundException, ClassNotFoundException, IOException {
		String s = "";
		try {
			buses = deserialize(path);
			for (Bus b : buses) {
				if (b.emptySeatsCount > 0) {
					s += b.toString() + "\n";
				}
			}
		} catch (FileNotFoundException e) {
			return "There is no available buses.";
		}
		return s;
	}

	public static ArrayList<Bus> returnList() throws FileNotFoundException, ClassNotFoundException, IOException {
		buses = deserialize(path);
		return buses;
	}
}
