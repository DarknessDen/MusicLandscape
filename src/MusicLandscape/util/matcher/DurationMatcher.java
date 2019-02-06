package MusicLandscape.util.matcher;
import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class DurationMatcher extends MyMatcher<Track> {
	private int lower;
	private int upper;
	
	public DurationMatcher(String pat) {
		super(pat);
		// TODO Auto-generated constructor stub
	}
	
	public DurationMatcher(){
		this("0 " + Integer.MAX_VALUE);
	}
	
	//Methods
	@Override
	public boolean matches(Track t) {
		if(t.getDuration() >= lower && t.getDuration() <= upper)
			return true;
		else
			return false;
	}

	@Override
	public void setPattern(String pat) {
		if(pat != null){
			String[] parts = pat.trim().split(" ");
			
			if(parts.length <= 1 || parts.length > 2)
				return; //Invalid input: Two int-numbers are allowed
			try{
				this.lower = Integer.parseInt(parts[0]);
				if(this.lower <= Integer.parseInt(parts[1]))
					this.upper = Integer.parseInt(parts[1]);
			}
			catch (NumberFormatException e){
				System.out.println("Invalid input");
			}
		}
	}

	@Override
	public String getPattern() {
		String StringLower;
		String StringUpper;
		
		StringLower = String.format("%d", lower);
		StringUpper = String.format("%d", upper);
		
		return StringLower + " " + StringUpper;
	}

	public String toString(){
		return "duration in range (" + getPattern() + ")";
	}

}
