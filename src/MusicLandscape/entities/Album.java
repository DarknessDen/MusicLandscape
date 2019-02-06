package MusicLandscape.entities;

public class Album extends Release {
	
	private Album.TrackListItem trackListHead = null;

	//Constructors
	public Album(){
		super();
	}
	
	public Album(Album orig){
		super(orig);
	}
	
	public Album(String title, Artist artist, int year) {
		super(title,artist,year);
	}
	
	
	//Methods
	public boolean addTrack(Track t){
		if(t == null)
			return false;
		if(trackListHead == null) {
			trackListHead = new TrackListItem(t);
		}
		else {
			while(trackListHead.next != null) {
				trackListHead = trackListHead.next;
			}
			trackListHead.next = new TrackListItem(t);
		}		
		return true;
	}		
	
	public Track removeTrack(int nr){
				
		if(trackListHead == null || (this.nrTracks() -1) < nr){  
			return null;  // exception check
		}
		
		TrackListItem nextItem = trackListHead.next; //nextItem - one which will be deleted
		TrackListItem item = trackListHead;
		
		if (nr == 0) {					// If deleting first elemtent 
			trackListHead = nextItem; 
			return item.track;
		}
		
		for(int i = 1; i < nr; i++)	//goint to nr element
		{
			item = nextItem; 
			nextItem = nextItem.next;
		}
		
		item.next = nextItem.next;	
		return nextItem.track;
	}

	public int nrTracks(){
		
		int counter = 0;		
		TrackListItem copy = trackListHead;	// using a copy
		
		if(copy != null){
			// first Item
			counter = 1;
			while ((copy.next != null)) {
				copy = copy.next;
				counter++;
			}
		}		
		return counter;
	}
	
	public Track[] getTracks(){
		
		int counter=0;
		TrackListItem temp = trackListHead;
		Track[] t = new Track[nrTracks()];
		
		if(temp == null){
			// skip
		}
		else if(temp.track == null){
			// skip
		}
		else{
			counter++; 
			t[0] = trackListHead.track; //assigning first element
		while ((temp.next != null)) {
			temp = temp.next;
			t[counter] = temp.track;
			counter++;
			}
		}
		return t;	
	}	
		

	
	@Override
	public String toString(){	
	TrackListItem temp = trackListHead;	
	String str= String.format("%s\n[",super.toString());
	
	if(temp!=null)
	{
		do
		{
			str = str + "["  + temp.track.getTitle() + "]";
			temp = temp.next;
		}while(temp.next != null);
			str= str + "["  + temp.track.getTitle() + "]";
	}
	
		str = str + "]";
		return str;
	}
	
	@Override
	public int totalTime() {
		int time=0;
		TrackListItem temp = trackListHead;
				
		if(temp == null){
			return 0;
		}
		else if(temp.track == null){
			return 0;
		}
		else{
			time = temp.track.getDuration();
		while ((temp.next != null)) {
			temp = temp.next;
			time = time +temp.track.getDuration();
			}
		}		
		return time;
	}

	
	
	// Nested Class "TrackListItem"
	
	
	private class TrackListItem {
		
		//Attributes
		TrackListItem next = null;		// next item in the list
		Track track = null;				// data of the list

		//Constructor
		public TrackListItem(Track track) {	
			this.track = track;
		}
	}
}
