package MusicLandscape.util.formatters;

import MusicLandscape.util.MyFormatter;
import MusicLandscape.entities.Track;

public class ShortTrackFormatter implements MyFormatter <Track>  {

	@Override
	public String header() {
		return "Title    (min:sec)" ;
	}

	@Override
	public String format(Track t) {
		int min = 0, sec = 0;
		
		if(t.getDuration() > 0) {
			min = t.getDuration() / 60;
			sec = t.getDuration() % 60;
		}
		
		StringBuilder builder = new StringBuilder();
		
		if(t.getTitle() != null){
			builder.append("unknown");
		}else
			builder.append(t.getTitle());			
		builder.append("(");
		builder.append(min);
		builder.append(":");
		builder.append(sec);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public String topSeparator() {
		return "----------------------";
	}
	
	public String toString(){
		return "short format [Title (min:sec)]";
	}

}
