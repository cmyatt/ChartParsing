package uk.ac.cam.cgm30.parsing;


public class Edge {
	private static int next_id = 0;
	
	public int id, left, right;
	public String mother;
	
	public Edge(int l, int r, String m) {
		id = next_id++;
		left = l;
		right = r;
		mother = m;
	}
	
	@Override
	public String toString() {
		return "" + id + "\t" + left + "\t" + right + "\t" + mother + "\t";
	}
}
