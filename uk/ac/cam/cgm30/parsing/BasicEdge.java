package uk.ac.cam.cgm30.parsing;

public class BasicEdge extends Edge {
	public String daughter;
	
	public BasicEdge(int left, int right, String mother, String d) {
		super(left, right, mother);
		daughter = d;
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s += "(" + daughter + ")\n";
		return s;
	}
}
