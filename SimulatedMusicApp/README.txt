This is a terminal-based music app that simulates audio files playing through text 
and does not actually output sound. There are a multitude of user actions that can be found in the MyAudioUI.java file.

From Assignment 1 code:

All methods work as intended, minor difference in output that occurs is that for playbook
(playAudioBook method) in the UI it outputs the chapter title without the "." character
since in the chaptertitles arraylist it is stored without a "." character. 

Also for the playAudioBook method, if an invalid chapter number is inputted but a valid
audiobook number is inputted, no error is set for invalid chapter number and instead the
last selected chapter for a valid audiobook number is outputted. This 'error' was left alone
to match the output.txt file as closely as possible and I assumed the functionality for that
was not necessary for the assignment.

Comments were only done on methods written by me and not on the already filled out methods,
as a TA advised that only methods written by the student should be commented. Additionally,
some comments may be redundant but this was kept to avoid potential loss in marks.
 
Bonus was not done thus corresponding podcast methods were left empty and some UI output 
strings were changed like "Content Type [SONG, PODCAST, AUDIOBOOK]:" to 
"Content Type [SONG, AUDIOBOOK]:".

_________________________
|For Assignment 2 code: |
-------------------------

The scanner replaced the ’ character with ? for the Harry Potter chapters in store.txt when using playbook action. 
This error happened most likely because of the encoding type of the txt file.
To fix this, in store.txt ’ was replaced with '.

Additionally a similar error happened with character hyphen — which got replaced with - (a shorter version, so different symbols)
in store.txt. The error was in the Moby Dick audiobook.

Also, to reduce redundancy from making a SongNotFoundException or an AudioBookNotFoundException,
AudioContentNotFoundException was thrown when a song, audiobook, or audiocontent was not found
in a method, and their error messages were set accordingly. 
For example, for a when a song is not found, error message for AudioContentNotFoundException was set to "Song not found" 
and for AudioBook not found error message was set to "AudioBook not found". 
Furthermore, for methods that work with AudioContent objects specifically, for example playlist methods, the error message when 
specified element was not found was set to "AudioContent not found". 
The justification for this is that since song and audiobooks inherit/extends AudioContent class, 
they have very similar or the same exception cases and both songs & audiobooks can be classified as AudioContent. 
I am unsure if using one exception with 3 different but related error messages 
classifies as "bad use of exceptions" from the rubric.

Similarily my AlreadyDownloadedException has 2 different messages for a song or audiobook. For a song
it is "Song "+elem.getTitle()+"already downloaded" and for an audiobook it is 
"Audiobook "+elem.getTitle()+" already downloaded". elem.getTitle() is the name of a song or audiobook 
which was separated by an if conditional (Library.java line 52).

The prompt for searchA is not the same as the video since the word doc specifies that searchA should work for both artists and
authors. So instead of "Artist: " the prompt "Artist/Author: " was used. Similarly for downloada, "Artist/Author Name:" instead
of "Artist Name: ".

For the downloada action in the video it says which songs are already downloaded but it doesn't say which song is downloaded, 
my downloada action outputs "SONG Wild Things added to library" which should be acceptable. The video does the same thing but 
it just doesn't output that its being added to library.

Finally the doc recommended to do one big try block for MyAudioUI.java actions if statements, but instead
the design choice made was to do a small try catch for each action that needed it.