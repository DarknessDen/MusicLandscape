package MusicLandscape.util.matcher;
import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class TitleMatcher extends MyMatcher<Track> {
	private String pattern;

	public TitleMatcher(String pat) {
		super(pat);
		// TODO Auto-generated constructor stub
	}
	
	//Methods
	@Override
	public boolean matches(Track t) {
		// TODO Auto-generated method stub
		if(t.getTitle().startsWith(pattern))
			return true;
		else
			return false;
	}

	@Override
	public void setPattern(String pat) {
		if(pat != null)
			this.pattern = pat;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPattern() {
		// TODO Auto-generated method stub
		return this.pattern;
	}
		
	public String toString(){
		return "title starts with (" + getPattern() + ")";
	}
	
}
