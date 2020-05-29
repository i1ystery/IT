package cz.spsejecna.kuzma;

public class Main {

	public static void main(String[] args) {
		/*Ted iterator je nastaveny tak, ze vypise 1 prvek v poli a pak preskoci jeden a vypise dalsi*/
		myArrayList<String> songs = new myArrayList<>();
		songs.add("Travis Scott - The Scotts");
		songs.add("Willow - Wait a Minute!");
		songs.add("Juice WRLD - Robbery");
		songs.add("Travis Scott - The Scotts");
		songs.add("Willow - Wait a Minute!");
		songs.add("Juice WRLD - Robbery");
		for (String s : songs) {
			System.out.println(s);
		}
	}

}
