package MusicLandscape.entities;

import MusicLandscape.Date;
import MusicLandscape.Venue;

public class Event {
	private Artist artist = new Artist();
	private int attendees;
	private Date date = null;
	private String description = "";
	private Venue venue = null;
	
	//Constructors
	public Event(){		
	}
	
	public Event(Event e){
		this.artist = new Artist(e.artist);
		this.attendees = e.attendees;
		this.date = new Date(e.date);
		this.description = new String(e.description);
		this.venue = new Venue(e.venue);	
		
	}

	//Methods
	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		if (artist != null){
			this.artist = artist;
		}
	}


	public int getAttendees() {
		return attendees;
	}


	public void setAttendees(int attendees) {
		if(attendees >= 0){
			this.attendees = attendees;
		}
	}


	public Date getDate() {
		if (date != null){
			Date defenseCopy = new Date(date);
			return defenseCopy;
		}
		else{
			return null;
		}
	}


	public void setDate(Date date) {
		if (date != null){
			this.date = new Date(date);
		}
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		if(description!=null){
			this.description = description;
		}
	}


	public Venue getVenue() {
		return venue;
	}


	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	public int impact(){
		if (this.getAttendees()>0){
			return (this.getAttendees()*2);
		}
		else{
			return 0;
		}
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.artist);
		builder.append(" @ ");	
		if(this.venue == null){
			builder.append("unknown");
		} else{builder.append(this.venue.getName());}
		builder.append(" on ");
		builder.append(this.date);
		builder.append("\n");
		builder.append(this.description);
		builder.append("\n(");
		builder.append(this.attendees);
		builder.append(" attending (");
		builder.append(this.impact());
		builder.append("))");
		
		return builder.toString();
	}
}
