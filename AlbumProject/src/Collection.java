import java.util.Arrays;

/**
 * 
 * @author Varun Shah
 *
 */
public class Collection {
	private int initialCapacity = 4;
	private int increaseCapacity = 4;
	private String[] title = new String[initialCapacity];
	private String[] artist = new String[initialCapacity];
	private Genre[] genre = new Genre[initialCapacity];
	private Date[] date = new Date[initialCapacity];
	private boolean[] isAvailable = new boolean[initialCapacity];
	private int numAlbums = 0; // number of albums currently in the collection
	int[] albumArray = new int[initialCapacity];// position array
	// add album to array

	public boolean add(Album album) {
		boolean isFull = true;
		// checks for if album is already in collection
		for (int j = 0; j < albumArray.length; j++) {
			if (title[j].equals(album.getTitle()) && artist[j].equals(album.getArtist())) {
				return false;
			}
		}
		// instance album array is not full
		for (int i = 0; i < albumArray.length; i++) {
			if (albumArray[i] == 0) {
				isFull = false;
				albumArray[i] = numAlbums;
				title[i] = album.getTitle();
				artist[i] = album.getArtist();

				if (!(album.getGenre()).equals("classical") || !(album.getGenre()).equals("country")
						|| !(album.getGenre()).equals("jazz") || !(album.getGenre()).equals("pop")) {
					genre[i] = Genre.valueOf("unknown");
				} else {
					genre[i] = album.getGenre();
				}
				date[i] = album.getReleaseDate();
				isAvailable[i] = true;
				break;
			}
		}
		// instance album array is full
		if (isFull == true) {
			grow();
			albumArray[albumArray.length - increaseCapacity + 1] = numAlbums;
			title[albumArray.length - increaseCapacity + 1] = album.getTitle();
			artist[albumArray.length - increaseCapacity + 1] = album.getArtist();
			if (!(album.getGenre()).equals("classical") || !(album.getGenre()).equals("country")
					|| !(album.getGenre()).equals("jazz") || !(album.getGenre()).equals("pop")) {
				genre[albumArray.length - increaseCapacity + 1] = Genre.valueOf("unknown");
			} else {
				genre[albumArray.length - increaseCapacity + 1] = album.getGenre();
			}
			date[albumArray.length - increaseCapacity + 1] = album.getReleaseDate();
			isAvailable[albumArray.length - increaseCapacity + 1] = true;
		}
		numAlbums++;
		print();
		return true;
	}

	// find the album index, or return NOT_FOUND
	private int find(Album album) {
		String album2find = album.getTitle();
		for (int i = 0; i < albumArray.length; i++) {
			if (title[i].equals(album2find)) {
				return albumArray[i];
			}
		}
		return -1; // make return NOT_FOUND
	} // find the album index, or return NOT_FOUND
		// increase the capacity of the array list by 4

	private void grow() {
		int currentLength = albumArray.length;
		albumArray = Arrays.copyOf(albumArray, currentLength + increaseCapacity);
		title = Arrays.copyOf(title, currentLength + increaseCapacity);
		artist = Arrays.copyOf(artist, currentLength + increaseCapacity);
		genre = Arrays.copyOf(genre, currentLength + increaseCapacity);
		date = Arrays.copyOf(date, currentLength + increaseCapacity);
		isAvailable = Arrays.copyOf(isAvailable, currentLength + increaseCapacity);
	}

	public void reorganize(int[] arr) {
	}

	public boolean remove(Album album) {
		int invalid = -1;
		if (find(album) == -1) {
			return false; // album not found
		} else {
			albumArray[find(album)] = invalid;
			return true;
		}
	}

	public boolean lendingOut(Album album) {
		if (find(album) == -1) {
			return false; // album not found
		}
		if (isAvailable[find(album)] == false)
			return false; // album is already out and not Available
		isAvailable[find(album)] = false;
		return true;

	}

	// set to available
	public boolean returnAlbum(Album album) {
		if (find(album) == -1)
			return false; // album not found
		if (isAvailable[find(album)] == true)
			return false; // album is already Available
		isAvailable[find(album)] = true;
		return true;
	}

	// display the list without specifying the order
	public void print() {
		// if collection is empty, System.out.println("The collection is empty!");
		boolean empty = true;
		for (int i = 0; i < albumArray.length; i++) {
			if (albumArray[i] != 0) {
				empty = false;
				break;
			}
		}
		if (empty == true) {
			System.out.println("The collection is empty!");
		}
	}

	// display the list by release date
	public void printByReleaseDate() {
		// if collection is empty, System.out.println("The collection is empty!");
		boolean empty = true;
		for (int i = 0; i < albumArray.length; i++) {
			if (albumArray[i] != 0) {
				empty = false;
				break;
			}
		}
		if (empty == true) {
			System.out.println("The collection is empty!");
		}
	}

	// display the list by genre
	public void printByGenre() {
		// if collection is empty, System.out.println("The collection is empty!");
		boolean empty = true;
		for (int i = 0; i < albumArray.length; i++) {
			if (albumArray[i] != 0) {
				empty = false;
				break;
			}
		}
		if (empty == true) {
			System.out.println("The collection is empty!");
		}
	}
}