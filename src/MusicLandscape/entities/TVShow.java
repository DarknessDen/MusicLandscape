package MusicLandscape.entities;


public class TVShow extends Event {
	private String name;
	private int viewers;
	
	//Constructors
	public TVShow(){
		this.name = "unknown";
		this.viewers = 0;
	}
	
	public TVShow(Event e){
		super(e);				//Event copy constructor
	}
	
	public TVShow(TVShow tvs){	//copy constructor
		super(tvs);
		this.viewers = tvs.viewers;
		this.name = new String(tvs.name);
	}
	
	//Methods
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		if(name!=null && name.trim().length() !=0){
			this.name = name;
		}
	}
	
	public int getViewers() {
		return viewers;
	}
	
	public void setViewers(int v) {
		if(v > 0){
			this.viewers = v;
		}		
	}
	
	public int impact(){
		return ((getAttendees()+viewers)*2);
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		
		if(this.getArtist()!= null && this.getArtist().getName()!= null){
			builder.append(this.getArtist().getName());
		}
		builder.append(" @ ");	
		if(this.name!=null){
			builder.append(this.name);
		}
		builder.append(" on ");
		if(this.getDate()!=null){
			builder.append(this.getDate());
		}
		builder.append("\n");
		builder.append(this.getDescription());
		builder.append("\n(");
		builder.append(this.viewers);
		builder.append(" attending (");
		builder.append(this.impact());
		builder.append("))");
		
		return builder.toString();	
	}

}
