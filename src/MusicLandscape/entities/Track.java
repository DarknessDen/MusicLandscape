package MusicLandscape.entities;
import java.util.Scanner;

import MusicLandscape.util.ConsoleScanable;

public class Track implements ConsoleScanable{
	
	private String title;
	private int duration;
	private Artist performer;
	private int year;
	private Artist writer;
	
	//Constructors
	public Track(){
		this.title = new String("unknown title");
		this.duration = 0; 
		this.year = 1900;
		this.writer = new Artist();
		this.performer = new Artist();
	}	
	public Track(String title){
		this();
		this.title = new String(title);
	}
	
	public Track(Track t){
		this.title = new String(t.title);
		this.duration = t.duration;
		this.year = t.year;
		this.writer = new Artist(t.writer);
		this.performer = new Artist(t.performer);
	}
	
	//Methods
	public int getDuration(){
		return duration;
	}
	
	public void setDuration(int duration){
		if(duration>0)
			this.duration = duration;
	}
	
	public String getTitle(){
		if(this.title == null)
			return "unknown title";
		return title;
	}
	
	public void setTitle(String title){
		if(title != null && title.trim().length() !=0){
			this.title = title;
		}
	}
	
	public Artist getPerformer(){
		return performer;
	}
	
	public void setPerformer(Artist performer) {
		if(performer!=null)
			this.performer = performer;
	}
	
	public Artist getWriter() {
		return writer;
	}
	
	public void setWriter(Artist writer) {
		if(writer!=null)
			this.writer = writer;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		if(year>=1900 && year<=2999)
			this.year = year;
	}
	
	public boolean writerIsKnown(){
		if(this.getWriter()!=null && this.getWriter().getName() != null){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return getString();
	}
	
	public String getString(){
		String mins,secs;
		int min,sec;
		min = this.getDuration()/60;
		sec = this.getDuration()%60;
		/*if(sec < 10)
			secs = "0"+String.valueOf(sec);
		else
			secs = String.valueOf(sec);*/
		secs = (sec<10) ? "0"+String.valueOf(sec) : String.valueOf(sec);
		mins = (min<10) ? "0"+String.valueOf(min) : String.valueOf(min);
		
		String title_print,writer_print,performer_print;
		if(this.getTitle() == "unknown title")
			title_print = String.format("%10s", "unknown");
		else if(this.getTitle()!=null)
			title_print = String.format("%10s", this.getTitle()).substring(0, 10);
		else 
			title_print = String.format("%10s", "unknown");;
		if(this.getWriter()!= null && this.getWriter().getName()!=null)
			writer_print = String.format("%10s", this.getWriter().getName()).substring(0, 10);
		else 
			writer_print = String.format("%10s", "unknown");
		if(this.getPerformer()!=null && this.getPerformer().getName()!=null)
			performer_print = String.format("%10s", this.getPerformer().getName()).substring(0, 10);
		else
			performer_print = String.format("%10s", "unknown");;
		
		return title_print+" by "+writer_print+" performed by "+performer_print
				+ " ("+mins+":"+secs+")";
	}
	
	@Override
	public boolean scan(){
		boolean fieldChanged = false;
		boolean objectChanged = false;
		
		String input = "";
		int inputDuration = 0;
		
		Scanner scan = new Scanner(System.in);
		
		//scanning title
		do{
			System.out.printf("current title: %s\n", this.title);
			System.out.print("enter new title (leave empty to keep):");
			
			if(scan.hasNextLine())
				input = scan.nextLine().split("\n")[0];
			
			if(input.length() == 0){
				fieldChanged = false;
				break;
			}
			
			 
			  if(!validateTitle(input)){
				 System.out.printf("not a valid title (%s).\n", input);
				 continue;
			 }
			 
			 
			 fieldChanged = true;
			 break;			 
		} while(true);
		
		if(fieldChanged){
			setTitle(input);			
		}
		
		objectChanged = objectChanged || fieldChanged;
		fieldChanged = false; //set up for next field
		
		//scanning duration
		
		do{
			System.out.printf("current duration: %s\n", this.duration);
			System.out.print("enter new duration (leave empty to keep):");
			
			while(scan.hasNext()){
			if(scan.hasNextInt())
				inputDuration = scan.nextInt();
			else
				scan.next();
			}
			
			if(inputDuration < 0){
				fieldChanged = false;
				break;
			}
			 
			 fieldChanged = true;
			 break;
			 
		} while(true);
		
		if(fieldChanged)
			setDuration(inputDuration);
		
		objectChanged = objectChanged || fieldChanged;
		fieldChanged = false; //set up for next field
		inputDuration = 0;
		
		scan.close();
		return objectChanged;		
	}
	
	public boolean validateTitle(String title){
		if(title != null)
			return true;
		else
			return false;
	}
	
}
