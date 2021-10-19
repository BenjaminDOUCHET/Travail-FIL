package util;

public interface Displayer {
	public void displayMsg(String s);
	
	public String prepareTrack(String name , String name2);
	
	public String endTrack(String name , String track);
	
	public String prepareRank(String key, int pts);
}
