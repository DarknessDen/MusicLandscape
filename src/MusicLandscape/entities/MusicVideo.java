package MusicLandscape.entities;

public class MusicVideo extends Release {

	public MusicVideo() {
		
	}

	private Track track;
	
	//Methods
	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Override
	public int totalTime() {
		if (track != null && track.getDuration() != 0) {
			return (this.track.getDuration());
		}
		else
			return 0;
		
	}
	
	public String toString() {
		String str = super.toString() + "-(Video)";
		return str;
	}	
	

}
