package MusicLandscape.util.comparators;
import MusicLandscape.entities.Track;

public class DurationComparator implements java.util.Comparator<Track> {

	@Override
	public int compare(Track arg0, Track arg1) {
		int t1, t2;
		
		if(arg0 == null)
			t1 = 0;
		else
			t1 = arg0.getDuration();
		
		if(arg1 == null)
			t2 = 0;
		else
			t2 = arg1.getDuration();
		
		return t1 - t2;		
	}
	
	public String toString(){
		return "by duration";
	}

}
