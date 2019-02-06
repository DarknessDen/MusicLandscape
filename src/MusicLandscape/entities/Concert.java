package MusicLandscape.entities;

public class Concert extends Event {
	
	private int nextIdx;
	private Track[] setList;
	
	public Concert(){
		nextIdx = 0;
		setList = new Track[5]; //creating array with 5 containers 
	}
	
	
	public Track[] getSetList() {
		Track[] defensiveCopy = new Track[nextIdx];
		for(int i=0; i<nextIdx; i++){
			defensiveCopy[i] = new Track(setList[i]);
		}
		return defensiveCopy; 
		//Method returns a copy
	}

	public void setSetList(Track[] setList) {
		Track[] deepCopy = new Track[setList.length];
		for(int i=0; i<setList.length; i++){
			if(setList[i] != null){
				deepCopy[i] = new Track(setList[i]);
			}
		}
		nextIdx = setList.length;
		
		this.setList = deepCopy;
	}

	public boolean addTrack(Track t){
		if(t == null){
			return false;
		}
		
		ensureCapacity(nextIdx+1);
		setList[nextIdx]= t;
		nextIdx++;
		return true;
		
	}
	
	private void ensureCapacity(int length){
		if(length>=setList.length){
			Track[] biggerSetList = new Track[setList.length*2];
			for(int i=0;i<setList.length;i++){
				biggerSetList[i] = setList[i];
			}
			this.setList = biggerSetList;
		}
	}
	
	public int duration(){
		int totalDuration =0;
		for (int i = 0; i<nextIdx;i++){
			totalDuration = totalDuration + this.setList[i].getDuration();
		}
		return totalDuration;
	}

	
	public int impact(){
		int durationFactor = 1;
		if(duration()>0){
			durationFactor = durationFactor + duration()/1800;
		}
		return durationFactor*getAttendees();
	}
	
	public void resetSetList(){
		nextIdx = 0;
		setList = new Track[5];
	}
	
	public int nrTracks(){
		return nextIdx;
	}
	
	public String toString(){
		int m = 0;
		int h = 0;
		if (duration() != 0){
			m = duration()/60;
			if(m >= 60){
				h = m/60;
				m = m%60;
			}
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.getArtist());
		builder.append(" @ ");	
		if(this.getVenue() == null){
			builder.append("unknown");
		} else{builder.append(this.getVenue().getName());}
		builder.append(" on ");
		builder.append(this.getDate());
		builder.append("\n");
		builder.append(this.getDescription());
		builder.append("\n(");
		builder.append(this.getAttendees());
		builder.append(" attending (");
		builder.append(this.impact());
		builder.append("))");
		builder.append("\n");
		builder.append(this.nrTracks());
		builder.append(" tracks played, ");	
		builder.append(m);
		builder.append(":");
		builder.append(h);
		builder.append(" time");
							
		return builder.toString();
	}
}
