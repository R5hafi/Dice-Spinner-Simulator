//Name: Ryan Shafi
//Student Number: 501 167 088
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Simulation of audio content in an online store
// The songs, podcasts, audiobooks listed here can be "downloaded" to your library

public class AudioContentStore
{
		private ArrayList<AudioContent> contents;
		private Map<String, Integer> mapTitle; //audiocontent title map
		private Map<String, ArrayList<Integer>> mapA; //artist or author map
		private Map<String, ArrayList<Integer>> mapGenre;//song genre map
		public AudioContentStore()
		{
			//intializing
			contents = new ArrayList<AudioContent>();
			mapTitle = new HashMap<String, Integer>();
			mapA = new HashMap<String, ArrayList<Integer>>();
			mapGenre = new HashMap<String, ArrayList<Integer>>();
		  // Create some songs & audiobooks to store
			//read store.txt file and put into contents arraylist
			//catch according file exceptions if need be
			try {
				for(AudioContent elem : readFile("store.txt")){
					contents.add(elem);
				}
			} catch(IOException e){
				System.out.println(e.getMessage());
				System.exit(1);
			}

			//one for loop that does 3 different mappings
			for(int i = 0; i < contents.size(); i++){
				//simple mapping to mapTitle from contents arraylist by map key (audio content title)
				//and value being index to that title in contents arraylist
				AudioContent elem = contents.get(i);
				mapTitle.put(elem.getTitle(), i);

				String a = ""; //for author or artist depending on song or audiobook if conditional

				if(elem.getType().equals("SONG")){
					a = ((Song)elem).getArtist();

					Song el = (Song)elem;
					//Note genre enum was accessed through if conditionals
					String genre = "";
					if(el.getGenre().equals(Song.Genre.POP)){
						genre = "POP";
					} else if (el.getGenre().equals(Song.Genre.ROCK)) {
						genre = "ROCK";
					} else if (el.getGenre().equals(Song.Genre.JAZZ)) {
						genre = "JAZZ";
					} else if (el.getGenre().equals(Song.Genre.HIPHOP)) {
						genre = "HIPHOP";
					} else if (el.getGenre().equals(Song.Genre.RAP)) {
						genre = "RAP";
					} else if (el.getGenre().equals(Song.Genre.CLASSICAL)) {
						genre = "CLASSICAL";
					}

					//based on above genre code, maps to mapGenre from contents arraylist
					//by map key (genre) and value being arraylist of integers which is indices to contents arraylist
					//where songs from that genre occur
					if(mapGenre.keySet().contains(genre)){
						mapGenre.get(genre).add(i);
					} else {
						ArrayList<Integer> genreSongs = new ArrayList<Integer>();
						genreSongs.add(i);
						mapGenre.put(genre, genreSongs);
					}
				} else if (elem.getType().equals("AUDIOBOOK")) {
					a = ((AudioBook)elem).getAuthor();
				}

				//maps to mapA from contents arraylist by map key (artist or author)
				//and value being arraylist of integers which is indices to contents arraylist
				//where audio content from that artist/author occurs
				if(!mapA.keySet().contains(a)){
					ArrayList<Integer> acInds = new ArrayList<Integer>();
					mapA.put(a, acInds);
				}
				mapA.get(a).add(i);
			}



			// Create a podcast object if you are doing the bonus see the makeSeasons() method below
			// It is currently commented out. It makes use of a class Season you may want to also create
			// or change it to something else
					
		}


		//below returns a map int value containing an index to contents arraylist,
		//from a map key that is equal to the user given title, the map in question being mapTitle
		//if not found -1 is returned to ensure no other errors or exceptions are thrown
		public int getContentByTitle(String title){
			if(mapTitle.get(title) == null){
				return -1;
			}
			return mapTitle.get(title);
		}

		//using author or artist string name (a) as map key the method
		//returns an arraylist of indexes to contents arraylist containing that artist/author
		//songs or books, the arraylist is the value connected to that map key (a) in map mapA
		//if not found then returns a null value
		public ArrayList<Integer> getAContent(String a){
			return mapA.get(a);
		}

		//using genre string name the method
		//returns an arraylist of indexes to contents arraylist containing that genre of songs
		//the arraylist is the value connected to that map key (genre) in map mapGenre
		//if not found then returns a null value
		public ArrayList<Integer> getGenreSongs(String genre){
			return mapGenre.get(genre);
		}
		public AudioContent getContent(int index)
		{
			if (index < 1 || index > contents.size())
			{
				return null;
			}
			return contents.get(index-1);
		}
		
		public void listAll()
		{
			for (int i = 0; i < contents.size(); i++)
			{
				int index = i + 1;
				System.out.print("" + index + ". ");
				contents.get(i).printInfo();
				System.out.println();
			}
		}
		
		private ArrayList<String> makeHPChapterTitles()
		{
			ArrayList<String> titles = new ArrayList<String>();
			titles.add("The Riddle House");
			titles.add("The Scar");
			titles.add("The Invitation");
			titles.add("Back to The Burrow");
			return titles;
		}
		
		private ArrayList<String> makeHPChapters()
		{
			ArrayList<String> chapters = new ArrayList<String>();
			chapters.add("In which we learn of the mysterious murders\r\n"
					+ " in the Riddle House fifty years ago, \r\n"
					+ "how Frank Bryce was accused but released for lack of evidence, \r\n"
					+ "and how the Riddle House fell into disrepair. ");
			chapters.add("In which Harry awakens from a bad dream, \r\n"
					+ "his scar burning, we recap Harry's previous adventures, \r\n"
					+ "and he writes a letter to his godfather.");
			chapters.add("In which Dudley and the rest of the Dursleys are on a diet,\r\n"
					+ " and the Dursleys get letter from Mrs. Weasley inviting Harry to stay\r\n"
					+ " with her family and attend the World Quidditch Cup finals.");
			chapters.add("In which Harry awaits the arrival of the Weasleys, \r\n"
					+ "who come by Floo Powder and get trapped in the blocked-off fireplace\r\n"
					+ ", blast it open, send Fred and George after Harry's trunk,\r\n"
					+ " then Floo back to the Burrow. Just as Harry is about to leave, \r\n"
					+ "Dudley eats a magical toffee dropped by Fred and grows a huge purple tongue. ");
			return chapters;
		}
		
		private ArrayList<String> makeMDChapterTitles()
		{
			ArrayList<String> titles = new ArrayList<String>();
			titles.add("Loomings.");
			titles.add("The Carpet-Bag.");
			titles.add("The Spouter-Inn.");
			return titles;
		}
		private ArrayList<String> makeMDChapters()
		{
			ArrayList<String> chapters = new ArrayList<String>();
			chapters.add("Call me Ishmael. Some years ago never mind how long precisely having little\r\n"
					+ " or no money in my purse, and nothing particular to interest me on shore,\r\n"
					+ " I thought I would sail about a little and see the watery part of the world.");
			chapters.add("stuffed a shirt or two into my old carpet-bag, tucked it under my arm, \r\n"
					+ "and started for Cape Horn and the Pacific. Quitting the good city of old Manhatto, \r\n"
					+ "I duly arrived in New Bedford. It was a Saturday night in December.");
			chapters.add("Entering that gable-ended Spouter-Inn, you found yourself in a wide, \r\n"
					+ "low, straggling entry with old-fashioned wainscots, \r\n"
					+ "reminding one of the bulwarks of some condemned old craft.");
			return chapters;
		}
		
		private ArrayList<String> makeSHChapterTitles()
		{
			ArrayList<String> titles = new ArrayList<String>();
			titles.add("Prologue");
			titles.add("Chapter 1");
			titles.add("Chapter 2");
			titles.add("Chapter 3");
			return titles;
		}
		
		private ArrayList<String> makeSHChapters()
		{
			ArrayList<String> chapters = new ArrayList<String>();
			chapters.add("The gale tore at him and he felt its bite deep within\r\n"
					+ "and he knew that if they did not make landfall in three days they would all be dead");
			chapters.add("Blackthorne was suddenly awake. For a moment he thought he was dreaming\r\n"
					+ "because he was ashore and the room unbelieveable");
			chapters.add("The daimyo, Kasigi Yabu, Lord of Izu, wants to know who you are,\r\n"
					+ "where you come from, how ou got here, and what acts of piracy you have committed.");
			chapters.add("Yabu lay in the hot bath, more content, more confident than he had ever been in his life.");
			return chapters;
		}

		//readfile method to read store.txt in a specific format line by line depending on
		//if lines use song or audiobook format
		//a song or audiobook object is created with placeholder values before using set methods on each line
		//when finished arraylist of the audiocontent is returned
		//Note as genre is an enum, if conditionals for each genre had to be used
		private ArrayList<AudioContent> readFile(String filename) throws FileNotFoundException{
			Scanner in = new Scanner(new File(filename));
			ArrayList<AudioContent> res = new ArrayList<AudioContent>();
			while(in.hasNextLine()){
				String line = in.nextLine();
				if(line.equals("SONG")){
					Song elem = new Song("x",0,"x",Song.TYPENAME,"x",0,"x","x",Song.Genre.POP,"x");
					elem.setId(in.nextLine());
					elem.setTitle(in.nextLine());
					elem.setYear(Integer.parseInt(in.nextLine()));
					elem.setLength(Integer.parseInt(in.nextLine()));
					elem.setArtist(in.nextLine());
					elem.setComposer(in.nextLine());
					String genre = in.nextLine();
					if(genre.equals("POP")){
						elem.setGenre(Song.Genre.POP);
					} else if (genre.equals("ROCK")) {
						elem.setGenre(Song.Genre.ROCK);
					} else if (genre.equals("JAZZ")) {
						elem.setGenre(Song.Genre.JAZZ);
					} else if (genre.equals("HIPHOP")) {
						elem.setGenre(Song.Genre.HIPHOP);
					} else if (genre.equals("RAP")) {
						elem.setGenre(Song.Genre.RAP);
					} else if (genre.equals("CLASSICAL")) {
						elem.setGenre(Song.Genre.CLASSICAL);
					}
					String lyrics = "";
					int lyrLen = Integer.parseInt(in.nextLine());
					for(int i = 0; i < lyrLen; i++){
						lyrics+=in.nextLine()+"\n";
					}
					elem.setLyrics(lyrics);
					res.add(elem);
				} else if (line.equals("AUDIOBOOK")) {
					ArrayList<String> titles = new ArrayList<String>();
					ArrayList<String> chs = new ArrayList<String>();
					AudioBook elem = new AudioBook("x",0,"x",AudioBook.TYPENAME,"x",0,"x","x",titles,chs);
					elem.setId(in.nextLine());
					elem.setTitle(in.nextLine());
					elem.setYear(Integer.parseInt(in.nextLine()));
					elem.setLength(Integer.parseInt(in.nextLine()));
					elem.setAuthor(in.nextLine());
					elem.setNarrator(in.nextLine());
					int numChs = Integer.parseInt(in.nextLine());
					for(int i = 0; i < numChs; i++){
						titles.add(in.nextLine());
					}

					for(int j = 0; j < numChs; j++){
						int numLines = Integer.parseInt(in.nextLine());
						String chapter = "";
						for(int i = 0; i < numLines; i++){
							chapter+=in.nextLine()+"\n";
						}
						chs.add(chapter);
					}

					elem.setChapterTitles(titles);
					elem.setChapters(chs);
					res.add(elem);
				}
			}
			return res;
		}
		// Podcast Seasons
		/*
		private ArrayList<Season> makeSeasons()
		{
			ArrayList<Season> seasons = new ArrayList<Season>();
		  Season s1 = new Season();
		  s1.episodeTitles.add("Bay Blanket");
		  s1.episodeTitles.add("You Don't Want to Sleep Here");
		  s1.episodeTitles.add("The Gold Rush");
		  s1.episodeFiles.add("The Bay Blanket. These warm blankets are as iconic as Mariah Carey's \r\n"
		  		+ "lip-syncing, but some people believe they were used to spread\r\n"
		  		+ " smallpox and decimate entire Indigenous communities. \r\n"
		  		+ "We dive into the history of The Hudson's Bay Company and unpack the\r\n"
		  		+ " very complicated story of the iconic striped blanket.");
		  s1.episodeFiles.add("There is no doubt that the Klondike Gold Rush was an iconic event. \r\n"
		  		+ "But what did the mining industry cost the original people of the territory? \r\n"
		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
		  s1.episodeFiles.add("here is no doubt that the Klondike Gold Rush was an iconic event. \r\n"
		  		+ "But what did the mining industry cost the original people of the territory? \r\n"
		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
		  s1.episodeLengths.add(31);
		  s1.episodeLengths.add(32);
		  s1.episodeLengths.add(45);
		  seasons.add(s1);
		  Season s2 = new Season();
		  s2.episodeTitles.add("Toronto vs Everyone");
		  s2.episodeTitles.add("Water");
		  s2.episodeFiles.add("There is no doubt that the Klondike Gold Rush was an iconic event. \r\n"
		  		+ "But what did the mining industry cost the original people of the territory? \r\n"
		  		+ "And what was left when all the gold was gone? And what is a sour toe cocktail?");
		  s2.episodeFiles.add("Can the foundation of Canada be traced back to Indigenous trade routes?\r\n"
		  		+ " In this episode Falen and Leah take a trip across the Great Lakes, they talk corn\r\n"
		  		+ " and vampires, and discuss some big concerns currently facing Canada's water."); 
		  s2.episodeLengths.add(45);
		  s2.episodeLengths.add(50);
		 
		  seasons.add(s2);
		  return seasons;
		}
		*/
}
