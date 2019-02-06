package MusicLandscape.entities;

/**
 * 
 * @author Denis Varaksin
 *
 */

public class Artist {
	private String name; //attributes
	
	//Constructors
	public Artist(){
		this.name = "unknown";
	}
	
	
	public Artist(Artist a){
		if(a!=null){
			this.name = new String(a.getName());
		}else{
			this.name = "unknown";
		}
	}
	
	public Artist(String name){
		this.name = new String(name);
	}
	
	//Methods
	
	public String toString() {
		return "Artist [name=" + name + "]";
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		if(name!=null && name.trim().length()>0)
			this.name = name;
	}


	public int compareTo(Artist arg0) {
		return name.compareTo(arg0.name);
	}
}