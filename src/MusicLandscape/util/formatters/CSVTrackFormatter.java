package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyFormatter;

public class CSVTrackFormatter  implements MyFormatter<Track> {

	//The csv representation of a track is:
	//"title","performer","writer","year","duration"
	
	public String format(Track t){
		return t.getTitle() + "," + t.getWriter() + "," + t.getPerformer() + "," + t.getDuration() + "," + t.getYear() + ";";
	}
	
	public String topSeparator() {
		return "";
	}
	
	public String toString() {
		return "CSV format [Title, Writer, Performer, duration, year]";
	}

	@Override
	public String header() {
		return "Title, Writer, Performer, duration, year;";
	}

}
