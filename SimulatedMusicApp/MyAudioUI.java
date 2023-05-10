//Name: Ryan Shafi
//Student Number: 501 167 088
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

// Simulation of a Simple Text-based Music App (like Apple Music)

public class MyAudioUI
{
	public static void main(String[] args)
	{
		// Simulation of audio content in an online store
		// The songs, podcasts, audiobooks in the store can be downloaded to your mylibrary
		AudioContentStore store = new AudioContentStore();
		
		// Create my music mylibrary
		Library mylibrary = new Library();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();

			if (action == null || action.equals(""))
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;

			else if (action.equalsIgnoreCase("STORE"))	// List all songs
			{
				store.listAll();
			}
			else if (action.equalsIgnoreCase("SONGS"))	// List all songs
			{
				mylibrary.listAllSongs();
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all songs
			{
				mylibrary.listAllAudioBooks();
			}
			else if (action.equalsIgnoreCase("PODCASTS"))	// List all songs
			{
				mylibrary.listAllPodcasts();
			}
			else if (action.equalsIgnoreCase("ARTISTS"))	// List all songs
			{
				mylibrary.listAllArtists();
			}
			else if (action.equalsIgnoreCase("PLAYLISTS"))	// List all play lists
			{
				mylibrary.listAllPlaylists();
			}
			// Download audiocontent (song/audiobook) from the store
			// Specify the index of the content
			else if (action.equalsIgnoreCase("DOWNLOAD"))
			{
				//download action was modified with user beginning and end index prompts
				//based on the store indices displayed from store action

				int fromIndex = 0;
				int toIndex = 0;

				System.out.print("From Store Content #: ");
				if (scanner.hasNextInt())
				{
					fromIndex = scanner.nextInt();
					scanner.nextLine(); // "consume" nl character (necessary when mixing nextLine() and nextInt())
				}
				System.out.print("To Store Content #: ");
				if (scanner.hasNextInt()){
					toIndex = scanner.nextInt();
					scanner.nextLine();
				}
				//for each loop was added to use .download() method multiple times depending on user inputs
				for(int i = fromIndex; i <= toIndex; i++){
					AudioContent content = store.getContent(i);

					//below check if content is in store, if not print message
					if (content == null) {
						System.out.println("Content Not Found in Store");
					}else {
						//try catch to check if content is already downloaded by user
						//print error message from exception if already download
						try{
							mylibrary.download(content);
						} catch (AlreadyDownloadedException e){
							System.out.println(e.getMessage());
						}
					}
				}

			}
			// Get the *library* index (index of a song based on the songs list)
			// of a song from the keyboard and play the song
			else if (action.equalsIgnoreCase("PLAYSONG"))
			{
				// basic user input
				int index = 0;
				System.out.print("Song Number: ");
				if (scanner.hasNextInt()){
					index = scanner.nextInt();
					scanner.nextLine();
				}
				//try catch for if user input index not found
				//print error message from exception if so
				try{
					mylibrary.playSong(index);
				} catch (AudioContentNotFoundException e){
					System.out.println(e.getMessage());
				}
			}
			// Print the table of contents (TOC) of an audiobook that
			// has been downloaded to the library. Get the desired book index
			// from the keyboard - the index is based on the list of books in the library
			else if (action.equalsIgnoreCase("BOOKTOC"))
			{
				// basic user input
				int index = 0;
				System.out.print("Audio Book Number: ");
				if (scanner.hasNextInt()){
					index = scanner.nextInt();
					scanner.nextLine();
				}
				//try catch for if user input index not found
				//print error message from exception if so
				try{
					mylibrary.printAudioBookTOC(index);
				} catch (AudioContentNotFoundException ex){
					System.out.println(ex.getMessage());
				}
			}
			// Similar to playsong above except for audio book
			// In addition to the book index, read the chapter
			// number from the keyboard - see class Library
			else if (action.equalsIgnoreCase("PLAYBOOK"))
			{
				// basic user inputs
				int index = 0;
				int ch = 0;
				System.out.print("Audio Book Number: ");
				if (scanner.hasNextInt()){
					index = scanner.nextInt();
					scanner.nextLine();
				}
				System.out.print("Chapter: ");
				if (scanner.hasNextInt()){
					ch = scanner.nextInt();
					scanner.nextLine();
				}
				//try catch for if user input index not found
				//print error message from exception if so
				//but if invalid user input ch and valid user input index
				//then first ch is played by default
				try{
					mylibrary.playAudioBook(index,ch);
				} catch(AudioContentNotFoundException e){
					System.out.println(e.getMessage());
				}

			}
			// Print the episode titles for the given season of the given podcast
			// In addition to the podcast index from the list of podcasts,
			// read the season number from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PODTOC"))
			{

			}
			// Similar to playsong above except for podcast
			// In addition to the podcast index from the list of podcasts,
			// read the season number and the episode number from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYPOD"))
			{

			}
			// Specify a playlist title (string)
			// Play all the audio content (songs, audiobooks, podcasts) of the playlist
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYALLPL"))
			{
				// basic user input
				String title = "";
				System.out.print("Playlist Title: ");
				if (scanner.hasNext()){
					title = scanner.nextLine();
				}

				//try catch for if user input playlist is not found
				//Print error message if the playlist doesn't exist in the library
				try{
					mylibrary.playPlaylist(title);
				} catch(PlaylistNotFoundException e){
					System.out.println(e.getMessage());
				}
			}
			// Specify a playlist title (string)
			// Read the index of a song/audiobook/podcast in the playist from the keyboard
			// Play all the audio content
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYPL"))
			{
				// basic user inputs
				String title = "";
				int index = 0;
				System.out.print("Playlist Title: ");
				if (scanner.hasNext()){
					title = scanner.nextLine();
				}
				System.out.print("Playlist Content #: ");
				if(scanner.hasNextInt()){
					index = scanner.nextInt();
					scanner.nextLine();
				}
				//try catch for if user given playlist or index in playlist not found
				//Print according error message from exception if the playlist doesn't exist in the library
				//Same for if index not found
				try{
					mylibrary.playPlaylist(title, index);
				} catch(PlaylistNotFoundException e){
					System.out.println(e.getMessage());
				} catch(AudioContentNotFoundException f){
					System.out.println(f.getMessage());
				}
			}
			// Delete a song from the list of songs in mylibrary and any play lists it belongs to
			// Read a song index from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("DELSONG"))
			{
				// basic user input
				int index = 0;
				System.out.print("Library Song #: ");
				if(scanner.hasNextInt()){
					index = scanner.nextInt();
					scanner.nextLine();
				}
				//try catch for if user input index is not found
				//Print error message from exception if so
				try {
					mylibrary.deleteSong(index);
				} catch(AudioContentNotFoundException e){
					System.out.println(e.getMessage());
				}

			}
			// Read a title string from the keyboard and make a playlist
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("MAKEPL"))
			{
				// basic user input
				String title = "";
				System.out.print("Playlist Title: ");
				if (scanner.hasNext()){
					title = scanner.nextLine();
				}
				//try catch for if playlist already exists
				//Print error message from exception if so
				try{
					mylibrary.makePlaylist(title);
				} catch (PlaylistExistsException e){
					System.out.println(e.getMessage());
				}
			}
			// Print the content information (songs, audiobooks, podcasts) in the playlist
			// Read a playlist title string from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PRINTPL"))	// print playlist content
			{
				// basic user input
				String title = "";
				System.out.print("Playlist Title: ");
				if (scanner.hasNext()){
					title = scanner.nextLine();
				}
				//try catch for if user given playlist not found
				//Print error message from exception if so
				try {
					mylibrary.printPlaylist(title);
				} catch (PlaylistNotFoundException e){
					System.out.println(e.getMessage());;
				}
			}
			// Add content (song, audiobook, podcast) from mylibrary (via index) to a playlist
			// Read the playlist title, the type of content ("song" "audiobook" "podcast")
			// and the index of the content (based on song list, audiobook list etc) from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("ADDTOPL"))
			{
				// basic user inputs
				String title = "";
				String type = "";
				int index = 0;
				System.out.print("Playlist Title: ");
				if (scanner.hasNext()){
					title = scanner.nextLine();
				}
				System.out.print("Content Type [SONG, AUDIOBOOK]: ");
				if (scanner.hasNext()){
					// user input is converted to uppercase to match type names
					type = scanner.nextLine().toUpperCase();
				}
				System.out.print("Library Content #: ");
				if(scanner.hasNextInt()){
					index = scanner.nextInt();
					scanner.nextLine();
				}
				//try catch for if title not found, invalid type, or user given index not found
				//Print according error messages from according exceptions if the above occurs
				try{
					mylibrary.addContentToPlaylist(type, index, title);
				} catch(PlaylistNotFoundException e){
					System.out.println(e.getMessage());
				} catch(AudioContentNotFoundException f){
					System.out.println(f.getMessage());
				} catch(InvalidTypeException t){
					System.out.println(t.getMessage());
				}
			}
			// Delete content from play list based on index from the playlist
			// Read the playlist title string and the playlist index
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("DELFROMPL"))
			{
				// basic user inputs
				String title = "";
				int index = 0;
				System.out.print("Playlist Title: ");
				if (scanner.hasNext()){
					title = scanner.nextLine();
				}
				System.out.print("Playlist Content #: ");
				if(scanner.hasNextInt()){
					index = scanner.nextInt();
					scanner.nextLine();
				}
				//try catch for if user given playlist and/or index not found
				//Print according error messages from according exceptions if the above occurs
				try{
					mylibrary.delContentFromPlaylist(index, title);
				} catch(PlaylistNotFoundException e){
					System.out.println(e.getMessage());
				} catch(AudioContentNotFoundException f){
					System.out.println(f.getMessage());
				}
			}
			// all commands above (download, playsong, etc) had method calls in the If statement
			// conditionals where all methods run first and then output a boolean value
			else if (action.equalsIgnoreCase("SORTBYYEAR")) // sort songs by year
			{
				mylibrary.sortSongsByYear();
			}
			else if (action.equalsIgnoreCase("SORTBYNAME")) // sort songs by name (alphabetic)
			{
				mylibrary.sortSongsByName();
			}
			else if (action.equalsIgnoreCase("SORTBYLENGTH")) // sort songs by length
			{
				mylibrary.sortSongsByLength();
			}
			// search through the store content for a user given audio content by title
			// makes use of the mapTitle in AudioContentStore.java by using getContentByTitle method
			// which returns an index to audio content
			else if (action.equalsIgnoreCase("SEARCH")){
				//basic user input
				String title = "";
				int index = 0;
				System.out.print("Title: ");
				if (scanner.hasNext()){
					title = scanner.nextLine();
				}

				// create audio content object to use in checking if title is in map
				index = store.getContentByTitle(title);
				AudioContent content = store.getContent(index+1);

				// if index returned by getContentByTitle method not in store print error,
				//else print audio content info
				if (content == null){
					System.out.println("No matches for "+title);
				} else {
					System.out.print(index+1+". ");
					content.printInfo();
				}
			}
			// search through the store content to find songs or books from a user given artist/author
			// makes use of the mapA from AudioContentStore.java by using getAContent method
			// which returns indices to audio contents
			else if (action.equalsIgnoreCase("SEARCHA")){
				//basic user input
				String a = "";
				System.out.print("Artist/Author: ");
				if (scanner.hasNext()){
					a = scanner.nextLine();
				}

				// if artist/author audio content not in store print error,
				//else print all their songs/books by use of for each loop
				//where i is the element in the arraylist of integers returned by
				//getAContent method
				if (store.getAContent(a) == null){
					System.out.println("No matches for "+a);
				} else {
					for(int i : store.getAContent(a)){
						AudioContent content = store.getContent(i+1);
						System.out.print(i+1+". ");
						content.printInfo();
						System.out.println("");
					}
				}
			}
			// search through the store content to find songs from a user given genre
			// makes use of the mapGenre from AudioContentStore.java by using getGenreSongs method
			// which returns indices to songs
			else if (action.equalsIgnoreCase("SEARCHG")){
				//basic user input
				String genre = "";
				System.out.print("Genre [POP, ROCK, JAZZ, HIPHOP, RAP, CLASSICAL]: ");
				if (scanner.hasNext()){
					genre = scanner.nextLine().toUpperCase(); //made not case sensitive
				}

				// if user given genre song not in store print error,
				//else print all the songs of that genre by using a for each loop
				//where i is the element in the arraylist of integers returned by
				//getGenreSongs method
				if (store.getGenreSongs(genre) == null){
					System.out.println("No matches for "+genre);
				} else {
					for(int i : store.getGenreSongs(genre)){
						AudioContent content = store.getContent(i+1);
						System.out.print(i+1+". ");
						content.printInfo();
						System.out.println("");
					}
				}
			}
			// Download all audiocontent (song/audiobook) from the store
			// Specify the artist/author of the audio content
			else if (action.equalsIgnoreCase("DOWNLOADA")){
				//basic user input
				String a = "";
				System.out.print("Artist/Author Name: ");
				if (scanner.hasNext()){
					a = scanner.nextLine();
				}

				// if artist/author audio content not in store print error,
				//else use for each loop to download all songs/books under that
				//artist/author similar to download and searchA action
				//try catch made for same purpose as default download action
				if (store.getAContent(a) == null){
					System.out.println("No matches for "+a);
				} else {
					for(int i : store.getAContent(a)){
						AudioContent content = store.getContent(i+1);
						try{
							mylibrary.download(content);
						} catch (AlreadyDownloadedException e){
							System.out.println(e.getMessage());
						}
					}
				}
			}
			// Download all songs from the store
			// Specify the genre of the song
			else if (action.equalsIgnoreCase("DOWNLOADG")){
				//basic user input
				String genre = "";
				System.out.print("Genre [POP, ROCK, JAZZ, HIPHOP, RAP, CLASSICAL]: ");
				if (scanner.hasNext()){
					genre = scanner.nextLine(); //made not case sensitive
				}

				// if user given genre song not in store print error,
				//else download all song under that genre using a for each loop
				//similar to searchG and download actions
				//try catch made for same purpose as default download action
				if (store.getGenreSongs(genre) == null){
					System.out.println("No matches for "+genre);
				} else {
					for(int i : store.getGenreSongs(genre)){
						AudioContent content = store.getContent(i+1);
						try{
							mylibrary.download(content);
						} catch (AlreadyDownloadedException e){
							System.out.println(e.getMessage());
						}
					}
				}
			}

			System.out.print("\n>");


		}
	}
}
