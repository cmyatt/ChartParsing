package uk.ac.cam.cgm30.cfg;

public class TerminalRule extends Rule {
	public String rhs;
	
	public TerminalRule(String lhs, String r) {
		super(lhs);
		rhs = r;
	}
}
