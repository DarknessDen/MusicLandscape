package MusicLandscape.entities;

public abstract class Release {
	private Artist artist;
	private String title;
	private int year;
	
	//Constructors
	public Release(){
		this.artist = new Artist();
		this.year = 1900;
	}
	
	public Release(Release orig){
		this.artist = new Artist(orig.artist);
		this.title = orig.title;
		this.year = orig.year;
	}
	
	public Release(String title, Artist artist, int year) {
		this.title = new String(title);
		this.artist = new Artist(artist);
		this.year = year;
	}
	
	//Methods
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year>=0){
			this.year = year;
		}
	}
	public abstract int totalTime();
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		
		if(this.title != null){
			builder.append(this.getTitle());
		}
		builder.append("-");
		if(this.artist != null && this.artist.getName() != null){
			builder.append(this.artist.getName());
		}
		builder.append("-");
		if(year < 1900){
			builder.append("unknown");
		} else{builder.append(this.getYear());}	
		builder.append("-");
		builder.append(totalTime());
		
		return builder.toString();
	}
			
}
