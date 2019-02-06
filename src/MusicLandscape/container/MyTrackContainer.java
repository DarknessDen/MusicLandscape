package MusicLandscape.container;
import java.util.*;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class MyTrackContainer {
	private List<Track> selection = new LinkedList<Track>();
	private Set<Track> tracks = new HashSet<Track>();
	
	public MyTrackContainer(){
	}
	
	public MyTrackContainer(Iterable<Track> t){
		if(t != null){
			for(Track tt : t)
				add(tt);
			reset();
		}
	}
	
	public MyTrackContainer(Track[] t){	
		if(t != null){
			addAll(t);
			reset();
		}
	}
	//Methods:
	public boolean add(Track t){
		if(t != null && !tracks.contains(t)){
			tracks.add(t);
			return true;
		}
		else
			return false;
	}
	
	public int addAll(Track[] t){
		int n = 0;
		for(Track tt : t){
			if(add(tt))
				n++;
		}
		return n;
	}
	
	public int filter (MyMatcher<Track> matcher){
		int count = 0;
		for(Iterator<Track> it = selection.iterator(); it.hasNext();){
			Track t = it.next();
			if (!matcher.matches(t)){
				it.remove();
				count++;
			}
		}	
		return count;
	}
	
	public int remove(){
		int n = tracks.size();
		tracks.removeAll(selection);
		selection.clear();
		reset();
		
		return n - tracks.size();
	}
	
	public void reset(){
		selection.removeAll(selection);
		selection.addAll(tracks);
	}
	
	public Track[] selection(){
		Track[] tracks = new Track[0];
		
		return selection.toArray(tracks);
	}
	
	public int size(){
		return tracks.size();
	}

	
	public void sort(Comparator<Track> theComp, boolean asc){
		if(asc == true)
			Collections.sort(selection, theComp);
		else
			Collections.sort(selection, Collections.reverseOrder(theComp));		
	}
	

}
