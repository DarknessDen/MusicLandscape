package MusicLandscape.util.comparators;

import MusicLandscape.entities.Track;

public class WriterComparator implements java.util.Comparator<Track> {

	@Override
	public int compare(Track o1, Track o2) {
		return o1.getWriter().getName().compareTo(o2.getWriter().getName());
	}
	
	public String toString(){
		return "by writer";		
	}
}
