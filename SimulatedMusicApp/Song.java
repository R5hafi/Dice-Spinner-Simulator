//Name: Ryan Shafi
//Student Number: 501 167 088
/*
 * A Song is a type of AudioContent. A Song has extra fields such as Artist (person(s) singing the song) and composer
 */
public class Song extends AudioContent implements Comparable<Song> // implement the Comparable interface
{
	public static final String TYPENAME =	"SONG";

	public static enum Genre {POP, ROCK, JAZZ, HIPHOP, RAP, CLASSICAL};
	private String artist; 		// Can be multiple names separated by commas
	private String composer; 	// Can be multiple names separated by commas
	private Genre  genre;
	private String lyrics;


	// constructor for song class; title, year, id, type, audioFile, and length
	// are inherited from audio content class, artist, composer, genre, lyrics
	// are instance variables unique to the song class
	public Song(String title, int year, String id, String type, String audioFile, int length, String artist,
				String composer, Song.Genre genre, String lyrics)
	{
		// Make use of the constructor in the super class AudioContent.
		// Initialize additional Song instance variables.
		super(title, year, id, type, audioFile, length);
		this.artist = artist;
		this.composer = composer;
		this.genre = genre;
		this.lyrics = lyrics;
	}

	public String getType()
	{
		return TYPENAME;
	}

	// Print information about the song. First print the basic information of the AudioContent
	// by making use of the printInfo() method in superclass AudioContent and then print artist, composer, genre
	public void printInfo()
	{
		// AudioContent class printInfo method was used, then song instance variables are printed
		// (artist, composer, and genre)
		super.printInfo();
		System.out.println("Artist: "+this.artist+" Composer: "+this.composer+" Genre: "+this.genre);
	}

	// Play the song by setting the audioFile to the lyrics string and then calling the play() method of the superclass
	public void play()
	{
		// audioFile is set to lyrics using super class method
		// then info like lyrics, is displayed using play from super class
		super.setAudioFile(this.lyrics);
		super.play();
	}

	public String getComposer()
	{
		return composer;
	}
	public void setComposer(String composer)
	{
		this.composer = composer;
	}

	public String getArtist()
	{
		return artist;
	}
	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	public String getLyrics()
	{
		return lyrics;
	}
	public void setLyrics(String lyrics)
	{
		this.lyrics = lyrics;
	}

	public Genre getGenre()
	{
		return genre;
	}

	public void setGenre(Genre genre)
	{
		this.genre = genre;
	}

	// Two songs are equal if their AudioContent information is equal and both the composer and artists are the same
	// Make use of the superclass equals() method
	public boolean equals(Object other)
	{
		// cast other object to a song for comparison
		// then using super class equals compare inherited variables
		// and compare instance variables (composer and artist)
		Song a = (Song)other;
		return super.equals(other) && this.composer == a.composer && this.artist == a.artist;
	}

	// Implement the Comparable interface
	// Compare two songs based on their title
	// This method will allow songs to be sorted alphabetically
	public int compareTo(Song other)
	{
		// comparable interface implemented at top
		// use super class method getTitle then use compareTo and other.getTitle
		// no casting needed here since other is a Song object
		return super.getTitle().compareTo(other.getTitle());
	}
}
