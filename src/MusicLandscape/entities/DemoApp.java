package MusicLandscape.entities;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import MusicLandscape.entities.*;
import MusicLandscape.util.comparators.*;

public class DemoApp {
	public static void main(String[] args) {
		
		WriterComparator wcomp = new WriterComparator();
		Track t1 = new Track();
		Track t2 = new Track();
		Artist w1 = new Artist();
		Artist w2 = new Artist();
		w1.setName("jimmy");
		w2.setName("Heini");
		t1.setWriter(w1);
		t2.setWriter(w2);
		t1.setTitle("1stTitle");
		t2.setTitle("2nsTitle");
		int ret = wcomp.compare(t1, t2);
		System.out.printf("Ret: %d", ret);
		String txt = wcomp.toString();
		System.out.printf(t1.getWriter().getName());

}
