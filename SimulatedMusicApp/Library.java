//Name: Ryan Shafi
//Student Number: 501 167 088
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * This class manages, stores, and plays audio content such as songs, podcasts and audiobooks. 
 */
public class Library
{
	private ArrayList<Song> 			songs; 
	private ArrayList<AudioBook> 	audiobooks;
	private ArrayList<Playlist> 	playlists; 
	
  //private ArrayList<Podcast> 	podcasts;

	// Public methods in this class set errorMesg string
	// Error Messages can be retrieved from main in class MyAudioUI by calling  getErrorMessage()
	// In assignment 2 we will replace this with Java Exceptions (replaced now)
	String errorMsg = "";

	public String getErrorMessage()
	{
		return errorMsg;
	}
	//NOTE: for all methods below, user given index should be subtracted by 1 to get real index
	public Library()
	{
		songs = new ArrayList<Song>();
		audiobooks = new ArrayList<AudioBook>();
		playlists = new ArrayList<Playlist>();
	  //podcasts		= new ArrayList<Podcast>(); ;
	}
	/*
	 * Download audio content from the store. Since we have decided (design decision) to keep 3 separate lists in our library
	 * to store our songs, podcasts and audiobooks (we could have used one list) then we need to look at the type of
	 * audio content (hint: use the getType() method and compare to Song.TYPENAME or AudioBook.TYPENAME etc)
	 * to determine which list it belongs to above
	 * 
	 * Make sure you do not add song/podcast/audiobook to a list if it is already there. Hint: use the equals() method
	 * If it is already in a list, set the errorMsg string and return false. Otherwise add it to the list and return true
	 * See the video
	 */
	public void download(AudioContent content)
	{
		// 2 if statements for corresponding song and audiobook types
		// since content is an AudioContent type, it is casted to song or audiobook
		// then songs or audiobook arraylist is looped through to find an element equal to content (s)
		// if equal AlreadyDownloadedException is thrown with an error message set accordingly
		// otherwise content is downloaded to corresponding arraylist through add method
		if(content.getType().equals(Song.TYPENAME)){
			Song s = (Song)content;
			for(Song elem : songs){
				if (elem.equals(s)){
					throw new AlreadyDownloadedException("Song "+elem.getTitle()+" already downloaded");
				}
			}
			songs.add(s);
			System.out.println("SONG "+s.getTitle()+" Added To Library");

		} else if (content.getType().equals(AudioBook.TYPENAME)) {
			AudioBook a = (AudioBook)content;
			for(AudioBook elem : audiobooks){
				if(elem.equals(a)){
					throw new AlreadyDownloadedException("AudioBook "+elem.getTitle()+" already downloaded");
				}
			}
			audiobooks.add(a);
			System.out.println("AUDIOBOOK "+a.getTitle()+" Added To Library");

		}
	}
	
	// Print Information (printInfo()) about all songs in the array list
	public void listAllSongs()
	{
		// loops through all songs in arraylist songs, numbers are acheived
		// through adding 1 to loop index
		// then in print statement empty quotations are started with for printing purposes
		// followed by index followed by a dot
		// finally the song element's basic info is printed using printInfo
		for (int i = 0; i < songs.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			songs.get(i).printInfo();
			System.out.println();	
		}
	}
	
	// Print Information (printInfo()) about all audiobooks in the array list
	public void listAllAudioBooks()
	{
		// similar to previous method all audiobooks are looped through
		// then audiobook number is acheived through adding 1 to loop index
		// blank quotation marks for printing purpose followed by index, followed by a dot
		// are printed
		// finally basic info of audiobook element is printed using printInfo
		for (int i = 0; i < audiobooks.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			audiobooks.get(i).printInfo();
			System.out.println();
		}
	}
	
  // Print Information (printInfo()) about all podcasts in the array list
	public void listAllPodcasts()
	{
		
	}
	
  // Print the name of all playlists in the playlists array list
	// First print the index number as in listAllSongs() above
	public void listAllPlaylists()
	{
		// loops through all playlist elements in playlist arraylist
		// playlist number is acheived through adding 1 to loop index
		// once again empty quotation marks for printing purposes followed by index,
		// followed by a dot then followed by title of playlist element by using getTitle
		for(int i = 0; i < playlists.size(); i++){
			int index = i + 1;
			System.out.print("" + index + ". " + playlists.get(i).getTitle());
			System.out.println();
		}
	}
	
  // Print the name of all artists. 
	public void listAllArtists()
	{
		// First create a new (empty) array list of string 
		// Go through the songs array list and add the artist name to the new arraylist only if it is
		// not already there. Once the artist arrayl ist is complete, print the artists names
		ArrayList<String> artists = new ArrayList<String>();
		for(Song elem : songs){
			String artist = elem.getArtist();
			if(!(artists.contains(artist))){
				artists.add(artist);
			}
		}
		for(int i = 0; i < artists.size(); i++){
			int index = i + 1;
			System.out.print("" + index + ". "+artists.get(i));
			System.out.println();
		}
		// for above code, songs are all looped through and artist is grabbed then put into
		// an arraylist of artists, contains method is used to avoid duplicates
		// then in another for loop, artists are looped through and printed
	}

	// Delete a song from the library (i.e. the songs list) - 
	// also go through all playlists and remove it from any playlist as well if it is part of the playlist
	public void deleteSong(int index)
	{
		// first check if valid index, then loop through all playlist type elements
		// there is a nested for loop to loop through each playlist type elements contents arraylist
		// each content is casted to a song because they are of type AudioContent
		// then content is checked to see if equal to the user indicated element in songs arraylist
		// if so, then that content is deleted from playlist element using deleteContent method
		// many .methods are chained together to acheive the location of where that song is in the playlist
		// then song is finally removed from songs arraylist
		if(index >= 1 && index<=songs.size()){
			for(int i = 0; i < playlists.size(); i++){
				for(int j = 0; j < playlists.get(i).getContent().size(); j++){
					Song s = (Song)(playlists.get(i).getContent().get(j));
					if (s.equals(songs.get(index-1))){
						playlists.get(i).deleteContent(playlists.get(i).getContent().indexOf(songs.get(index-1))+1);
					}
				}
			}
			songs.remove(index-1);
			// below, exception is thrown if index invalid, meaning audio content song was not found
		} else {
			throw new AudioContentNotFoundException("Song not found");
		}
	}
	
  //Sort songs in library by year
	public void sortSongsByYear()
	{
		// Use Collections.sort() 
		Collections.sort(songs, new SongYearComparator());
		//above sorts song by year using comparator interface
	}
  // Write a class SongYearComparator that implements
	// the Comparator interface and compare two songs based on year
	private class SongYearComparator implements Comparator<Song>
	{
		// for sortSongsByYear method, compare method from interface is filled out
		// return 1 if song year a later than song year b
		// return -1 if song year a earlier than song year b
		// return 0 if song years are equal
		public int compare(Song a, Song b){
			if(a.getYear()>b.getYear()){
				return 1;
			}else if(a.getYear()<b.getYear()){
				return -1;
			} else {
				return 0;
			}
		}
	}

	// Sort songs by length
	public void sortSongsByLength()
	{
	 // Use Collections.sort()
		Collections.sort(songs, new SongLengthComparator());
		//above sorts songs by song length, by use of comparator interface
	}
  // Write a class SongLengthComparator that implements
	// the Comparator interface and compare two songs based on length
	private class SongLengthComparator implements Comparator<Song>
	{
		// for sortSongsByLengthMethod, compare method from interface is filled out
		// if song a longer than song b return 1
		// if song a shorter than song b return -1
		// 0 is returned if song lengths equal
		public int compare(Song a, Song b){
			if(a.getLength()>b.getLength()){
				return 1;
			}else if(a.getLength()<b.getLength()){
				return -1;
			} else {
				return 0;
			}
		}
	}

	// Sort songs by title 
	public void sortSongsByName()
	{
	  // Use Collections.sort()
		// class Song should implement the Comparable interface
		// see class Song code
		Collections.sort(songs);
		//class song implement comparable interface,
		//method sorts songs alphabetically by title
	}

	
	
	/*
	 * Play Content
	 */
	
	// Play song from songs list
	public void playSong(int index)
	{
		// check if index is valid
		// if not throw exception with according error message
		// otherwise get song from songs arraylist and play using .play method
		if (index < 1 || index > songs.size())
		{
			throw new AudioContentNotFoundException("Song Not Found");
		}
		songs.get(index-1).play();
	}
	
	// Play podcast from list (specify season and episode)
	// Bonus
	public boolean playPodcast(int index, int season, int episode)
	{
		return false;
	}
	
	// Print the episode titles of a specified season
	// Bonus 
	public boolean printPodcastEpisodes(int index, int season)
	{
		return false;
	}
	
	// Play a chapter of an audio book from list of audiobooks
	public void playAudioBook(int index, int chapter)
	{
		// check if index is valid
		// if not then throw an exception with according error message,
		// meaning audio content audiobook was not found
		// otherwise get audiobook and select chapter using selectChapter method
		// with user given chapter
		// then play using play method
		if (index < 1 || index > audiobooks.size())
		{
			throw new AudioContentNotFoundException("AudioBook Not Found");
		}
		audiobooks.get(index-1).selectChapter(chapter);
		audiobooks.get(index-1).play();
	}
	
	// Print the chapter titles (Table Of Contents) of an audiobook
	// see class AudioBook
	public void printAudioBookTOC(int index)
	{
		// check if index is valid
		// if so, get audiobook and use printTOC method to print table of contents
		// if not then throw exception with according error message
		if (index < 1 || index > audiobooks.size())
		{
			throw new AudioContentNotFoundException("AudioBook Not Found");
		}
		audiobooks.get(index-1).printTOC();
	}
	
  /*
   * Playlist Related Methods
   */
	
	// Make a new playlist and add to playlists array list
	// Make sure a playlist with the same title doesn't already exist
	public void makePlaylist(String title)
	{
		// create new playlist
		// then loop through all playlists to check if the one just made already exists
		// if it exists then throw PlayListExists Exception with an according error message
		// if not then add the playlist to arraylist of playlists
		Playlist n = new Playlist(title);
		for(Playlist elem : playlists){
			if(elem.equals(n)){
				throw new PlaylistExistsException("Playlist "+title+" already exists");
			}
		}
		playlists.add(n);
	}
	
	// Print list of content information (songs, audiobooks etc) in playlist named title from list of playlists
	public void printPlaylist(String title)
	{
		// loop through all playlists and print content basic info if user given playlist is found
		// otherwise throw PlaylistNotFoundException with an error message
		String elemTitle = "";
		for(Playlist elem : playlists){
			elemTitle = elem.getTitle();
			if(elemTitle.equals(title)){
				elem.printContents();
				break;
			}
		}
		if(!elemTitle.equals(title)){
			throw new PlaylistNotFoundException("Playlist not found");
		}
	}
	
	// Play all content in a playlist
	public void playPlaylist(String playlistTitle)
	{
		// loop through all playlists to find user given playlist
		// if found, play all contents in playlist using playAll method
		// if not found then throw PlaylistNotFoundException with an error message
		String elemTitle = "";
		for(Playlist elem : playlists){
			elemTitle = elem.getTitle();
			if(elemTitle.equals(playlistTitle)){
				elem.playAll();
				break;
			}
		}
		if(!elemTitle.equals(playlistTitle)){
			throw new PlaylistNotFoundException("Playlist not found");
		}
	}
	
	// Play a specific song/audiobook in a playlist
	public void playPlaylist(String playlistTitle, int indexInPL)
	{
		// overrides previous method for a specific playlist to play
		// loop through all playlists to find the user given one
		// if found stop looping outside loop,
		// then loop playlist element's contents arraylist to find user given index
		// if playListTitle not found then throw PlaylistNotFoundException with an error message
		// if index in playlist found, play the content at that index, exit inside loop
		// if not found then throw AudioContentNotFoundException with error message
		String elemTitle = "";
		for(int i = 0; i < playlists.size(); i++){
			elemTitle = playlists.get(i).getTitle();
			if(elemTitle.equals(playlistTitle)){
				for(int j = 0; j < playlists.get(i).getContent().size(); j++){
					if(indexInPL < 1 || indexInPL > playlists.get(i).getContent().size()){
						throw new AudioContentNotFoundException("Audio content not found");
					}
					if(j == indexInPL-1){
						System.out.println(playlistTitle);
						playlists.get(i).getContent().get(j).play();
						break;
					}
				}
				break;
			}
		}
		if(!elemTitle.equals(playlistTitle)){
			throw new PlaylistNotFoundException("Playlist not found");
		}
	}
	
	// Add a song/audiobook/podcast from library lists at top to a playlist
	// Use the type parameter and compare to Song.TYPENAME etc
	// to determine which array list it comes from then use the given index
	// for that list
	public void addContentToPlaylist(String type, int index, String playlistTitle)
	{
		// first check if type is song or audiobook
		// if type is valid, then check if index is valid, if type is not valid then throw InvalidTypeException
		// if index valid, loop through playlists to find user given playlist,
		// if index not valid, throw AudioContentNotFoundException with according message for type song or audiobook
		// if user given playlist found, then add content to playlist
		// if not found, then throw PlaylistNotFoundException
		String elemTitle = "";
		if (type.equals(Song.TYPENAME)){
			if(index < 1 || index > songs.size()){
				throw new AudioContentNotFoundException("Song not found");
			} else {
				for(Playlist elem : playlists){
					elemTitle = elem.getTitle();
					if(elemTitle.equals(playlistTitle)){
						elem.getContent().add(songs.get(index-1));
						break;
					}
				}
			}
			if(!elemTitle.equals(playlistTitle)){
				throw new PlaylistNotFoundException("Playlist not found");
			}
		} else if (type.equals(AudioBook.TYPENAME)) {
			if(index < 1 || index > audiobooks.size()){
				throw new AudioContentNotFoundException("AudioBook not found");
			} else {
				for(Playlist elem : playlists){
					elemTitle = elem.getTitle();
					if(elemTitle.equals(playlistTitle)){
						elem.getContent().add(audiobooks.get(index-1));
						break;
					}
				}
			}
			if(!elemTitle.equals(playlistTitle)){
				throw new PlaylistNotFoundException("Playlist not found");
			}
		} else {
			throw new InvalidTypeException("Invalid audio content type");
		}
	}

  // Delete a song/audiobook/podcast from a playlist with the given title
	// Make sure the given index of the song/audiobook/podcast in the playlist is valid 
	public void delContentFromPlaylist(int index, String title)
	{
		// loop through playlists to find user given playlist
		// if user given playlist found then loop through playlist contents
		// if user given playlist not found, throw PlayListNotFoundException
		// check if user given index is found
		// if found then delete playlist content at that index
		// if index not found, then throw AudioContentNotFound exception with according error message
		String elemTitle = "";
		for(int i = 0; i < playlists.size(); i++){
			elemTitle = playlists.get(i).getTitle();
			if(elemTitle.equals(title)){
				for(int j = 0; j < playlists.get(i).getContent().size(); j++){
					if(index < 1 || index > playlists.get(i).getContent().size()){
						throw new AudioContentNotFoundException("Audio content not found");
					} else {
						if (j == index - 1){
							playlists.get(i).deleteContent(index);
							break;
						}
					}
				}
				break;
			}
		}
		if(!elemTitle.equals(title)){
			throw new PlaylistNotFoundException("Playlist not found");
		}

	}

}

//customized exceptions
//AlreadyDownloadedException used for when an audiobook or song is already downloaded
class AlreadyDownloadedException extends RuntimeException{
	public AlreadyDownloadedException() {}
	public AlreadyDownloadedException(String message){
		super(message);
	}
}

//AudioContentNotFoundException used for when Song, Audiobook, or an AudioContent object not found,
//in their according arraylists (at the top of this file)
//for AudioContent its the contents arraylist in Playlist.java
class AudioContentNotFoundException extends RuntimeException{
	public AudioContentNotFoundException() {}
	public AudioContentNotFoundException(String message){
		super(message);
	}
}

//PlayListNotFoundException used for when a playlist in arraylist Playlists is not found
class PlaylistNotFoundException extends RuntimeException{
	public PlaylistNotFoundException() {}
	public PlaylistNotFoundException(String message){
		super(message);
	}
}

//PlaylistExistsException used for when creating a playlist, if the created playlist is already
//in playlists arraylist
class PlaylistExistsException extends RuntimeException{
	public PlaylistExistsException() {}
	public PlaylistExistsException(String message){
		super(message);
	}
}

//InvalidTypeException used for when a type in a method is not equal to "SONG" or "AUDIOBOOK"
//audiocontent types
class InvalidTypeException extends RuntimeException{
	public InvalidTypeException() {}
	public InvalidTypeException(String message){
		super(message);
	}
}