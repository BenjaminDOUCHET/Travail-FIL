package competitor;

/**
 * 
 * @author douchet
 * class to modelize a competitor
 */
public class Competitor {
	
private String name;
private int points;

public Competitor(String name) {
	this.name = name;
	this.points= 0;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getPoints() {
	return points;
}
public void setPoints(Integer points) {
	
	this.points = points;
}

public boolean equals(Object o) {
	if(o instanceof Competitor) {
		Competitor other = (Competitor) o;
		return this.getName().equals(other.getName());
	}
	else {
		return false;
	}
}

}
