//Name: Ryan Shafi
//Student Number: 501 167 088
import java.util.ArrayList;

/*
 * A Playlist contains an array list of AudioContent (i.e. Song, AudioBooks, Podcasts) from the library
 */
public class Playlist
{
	private String title;
	private ArrayList<AudioContent> contents; // songs, books, or podcasts or even mixture
	
	public Playlist(String title)
	{
		this.title = title;
		contents = new ArrayList<AudioContent>();
	}
	
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void addContent(AudioContent content)
	{
		contents.add(content);
	}
	
	public ArrayList<AudioContent> getContent()
	{
		return contents;
	}

	public void setContent(ArrayList<AudioContent> contents)
	{
		this.contents = contents;
	}
	
	/*
	 * Print the information of each audio content object (song, audiobook, podcast)
	 * in the contents array list. Print the index of the audio content object first
	 * followed by ". " then make use of the printInfo() method of each audio content object
	 * Make sure the index starts at 1
	 */
	public void printContents()
	{
		// method for printing contents of a playlist
		// which is looped through, content number is acheived by adding 1 to loop index
		// print statement has empty quotations for printing purposes, then followed by
		// content number and a dot
		// finally a content's info is printed (title, author/artist, etc)
		for(int i = 0; i<contents.size(); i++){
			int index = i + 1;
			System.out.print("" + index + ". ");
			contents.get(i).printInfo();
			System.out.println();
		}
	}

	// Play all the AudioContent in the contents list
	public void playAll()
	{
		// all content in a playlist is played, the contents are looped through
		// and then for each element their corresponding play method is called
		for(int i = 0; i < contents.size(); i++){
			contents.get(i).play();
		}

	}
	
	// Play the specific AudioContent from the contents array list.
	// First make sure the index is in the correct range. 
	public void play(int index)
	{
		// a user given playlist content is played, only if index is valid
		if (index>=1 && index<=contents.size()){
			contents.get(index-1).play();
		}
	}
	
	public boolean contains(int index)
	{
		return index >= 1 && index <= contents.size();
	}
	
	// Two Playlists are equal if their titles are equal
	public boolean equals(Object other)
	{
		// similar to Song and AudioBook class, other object is casted to Playlist type
		// then using getTitle for both objects, string equals method is used to compare both
		// and return either true or false
		Playlist p = (Playlist)other;
		return this.getTitle().equals(p.getTitle());
	}
	
	// Given an index of an audio content object in contents array list,
	// remove the audio content object from the array list
	// Hint: use the contains() method above to check if the index is valid
	// The given index is 1-indexed so convert to 0-indexing before removing
	public void deleteContent(int index)
	{
		// for a playlist object this keyword must be used for the contains method
		// index does not need to be subtracted in contains method since the contains method itself
		// has functionality for it
		// arraylist remove method is then called with index variable - 1 for real index
		if (this.contains(index)){
			contents.remove(index-1);
		}
	}
	
	
}
