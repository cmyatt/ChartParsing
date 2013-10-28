package uk.ac.cam.cgm30.cfg;

import java.util.ArrayList;

public class NonTerminalRule extends Rule {
	public ArrayList<String> rhs;
	
	public NonTerminalRule(String lhs) {
		super(lhs);
		rhs = new ArrayList<String>();
	}
}
