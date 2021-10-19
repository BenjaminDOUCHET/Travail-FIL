package util;

public class StdDisplayer implements Displayer {
	public void displayMsg(String msg) {
		System.out.println(msg);
	}
	
	public String prepareTrack(String name, String name2) {
		String track = "";
		//on prépare la trace pour affichage
		track+=name;
		track+=" vs ";
		track+=name2;
		track+=" --> ";
		return track;
	}
	
	public String endTrack(String name, String track) {
		String newTrack = track +name +" wins !";
		return newTrack;
		
	}

	public String prepareRank(String key, int pts) {
		String res = key +" : "+Integer.toString(pts);
		return res;
	}
}
