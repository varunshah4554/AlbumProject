/**
 * 
 * @author Varun Shah
 *
 */
public class Album {
	private String title;
	private String artist;
	private Genre genre; // enum class; Classical, Country, Jazz, Pop, Unknown
	private Date releaseDate;
	private boolean isAvailable;

	@Override
	public boolean equals(Object obj) {
		Album a = (Album) obj;
		if ((this.getTitle().equals(a.getTitle())) && (this.getArtist().equals(a.getArtist())))
			return true;
		return false;
	}

	// to string
	@Override
	public String toString() {
		if (isAvailable() == true)
			return getTitle() + "::" + getArtist() + "::" + getGenre() + "::" + getReleaseDate() + "::is available";
		return getTitle() + "::" + getArtist() + "::" + getGenre() + "::" + getReleaseDate() + "::is not available";
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}