package uk.ac.cam.cgm30.parsing;

import java.util.ArrayList;

public class ComplexEdge extends Edge {
	public ArrayList<Integer> daughters;
	
	public ComplexEdge(int left, int right, String mother) {
		super(left, right, mother);
		daughters = new ArrayList<Integer>();
	}
	
	@Override
	public String toString() {
		String s = super.toString() + "(" + daughters.get(0);
		if (daughters.get(0) != daughters.get(1)) {
			s += ", " + daughters.get(1);
		}
		s += ")\n";
		return s;
	}
}
