package uk.ac.cam.cgm30.parsing;

import java.util.ArrayList;

public class PackingEdge extends Edge {
	public ArrayList<ArrayList<Integer>> daughters;
	
	public PackingEdge(int left, int right, String mother) {
		super(left, right, mother);
		daughters = new ArrayList<ArrayList<Integer>>();
	}
	
	@Override
	public String toString() {
		String s = super.toString() + "{";
		for (ArrayList<Integer> lst : daughters) {
			s += "(" + lst.get(0);
			if (lst.get(0) != lst.get(1)) {
				s += ", " + lst.get(1);
			}
			s += "), ";
		}
		return s.substring(0, s.length()-2) + "}\n";
	}
}
