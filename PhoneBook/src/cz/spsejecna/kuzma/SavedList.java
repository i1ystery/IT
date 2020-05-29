package cz.spsejecna.kuzma;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

public class SavedList {
	static HashSet<Record> list;
	static Path path = Paths.get("savedList.dat");

	public static void saveToList(Record r) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			list = deserialize(path);
			list.add(r);
			serialize(list);
		} catch (FileNotFoundException e) {
			serialize(new HashSet<Record>());
			saveToList(r);
		}
	}

	public static String returnList() throws FileNotFoundException, ClassNotFoundException, IOException {
		String a = "";
		try {
			list = deserialize(path);
			for (Record r : list) {
				a += r + "\n";
			}
		} catch (FileNotFoundException e) {
			return "List is empty";
		}
		return a;
	}

	private static void serialize(HashSet<Record> list) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toString()));
		oos.writeObject(list);
		oos.close();
	}

	private static HashSet<Record> deserialize(Path path)
			throws FileNotFoundException, ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toString()));
		HashSet<Record> list = (HashSet<Record>) ois.readObject();
		ois.close();
		return list;
	}

	public static Record findRecord(String nextLine) {
		// TODO Auto-generated method stub
		try {
			list = deserialize(path);
			for (Record r : list) {
				if (nextLine.equalsIgnoreCase(r.recordName)) {
					return r;
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
		return new Record();

	}

	public static void delete(String next) {
		// TODO Auto-generated method stub
		try {
			list = deserialize(path);
			for (Record r : list) {
				if (next.equalsIgnoreCase(r.recordName)) {
					list.remove(r);
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
			for (Record r : list) {
				if (next.equalsIgnoreCase(r.recordName)) {
					r.setRecordName();
					r.setAddress();
					r.setFatherName();
					r.setMotherName();
					r.setPhoneNo();
					r.setSex();
					r.setEmail();
					r.setCitizenNo();
					serialize(list);
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
