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

public class List {
	static ArrayList<Song> list;
	static Path path = Paths.get("savedList.dat");

	public static void addToList(Song a) throws ClassNotFoundException, IOException {
		try {
			list = deserialize(path);
			list.add(a);
			serialize(list);
		} catch (FileNotFoundException e) {
			serialize(new ArrayList<Song>());
			addToList(a);
		}
	}

	public static String returnList() throws FileNotFoundException, ClassNotFoundException, IOException {
		String a = "";
		try {
			list = deserialize(path);
			for (Song s : list) {
				a += s + "\n";
			}
		} catch (FileNotFoundException e) {
			return "List is empty";
		}
		return a;
	}

	public static Song findSong(String nextLine) {
		// TODO Auto-generated method stub
		try {
			list = deserialize(path);
			for (Song s : list) {
				if (nextLine.equalsIgnoreCase(s.name)) {
					return s;
				}
			}
			System.out.println("Not found");
		} catch (FileNotFoundException e) {
			System.out.println("List is empty");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Song();

	}

	public static void delete(String next) {
		// TODO Auto-generated method stub
		try {
			list = deserialize(path);
			for (Song s : list) {
				if (next.equalsIgnoreCase(s.name)) {
					list.remove(s);
					serialize(list);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("List is empty");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void modify(String next) {
		// TODO Auto-generated method stub
		try {
			list = deserialize(path);
			for (Song s : list) {
				if (next.equalsIgnoreCase(s.name)) {
					s.setCategory();
					s.setType();
					s.setName();
					s.setArtist();
					s.setPrice();
					s.setQuantity();
					serialize(list);
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void serialize(ArrayList<Song> list) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toString()));
		oos.writeObject(list);
		oos.close();
	}

	private static ArrayList<Song> deserialize(Path path)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toString()));
		ArrayList<Song> list = (ArrayList<Song>) ois.readObject();
		ois.close();
		return list;
	}

	public static int buySong(String nextLine) {
		// TODO Auto-generated method stub
		try {
			int temp;
			list = deserialize(path);
			for (Song s : list) {
				if (nextLine.equalsIgnoreCase(s.name)) {
					s.quantity = s.quantity - 1;
					serialize(list);
					return 1;
				}
			}
			return 0;
		} catch (FileNotFoundException e) {
			return 0;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String SoldItems() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String a = "";
		try {
			list = deserialize(path);
			for (Song s : list) {
				if (s.quantity < 1) {
					a += s + "\n";
				} else {
					a = "All songs are in stock";
				}
			}
		} catch (FileNotFoundException e) {
			return "List is empty";
		}
		return a;
	}

	public static String ItemsInStock() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String a = "";
		try {
			list = deserialize(path);
			for (Song s : list) {
				if (s.quantity > 0) {
					a += s + "\n";
				} else {
					a = "All songs are out stock";
				}
			}
		} catch (FileNotFoundException e) {
			return "List is empty";
		}
		return a;
	}

}
