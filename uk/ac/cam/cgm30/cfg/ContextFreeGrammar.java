package uk.ac.cam.cgm30.cfg;

import java.util.ArrayList;

import uk.ac.cam.cgm30.parsing.Edge;

public class ContextFreeGrammar {
	private ArrayList<Rule> rules;
	
	public ContextFreeGrammar() {
		rules = new ArrayList<Rule>();
	}
	
	public void addRule(Rule r) {
		rules.add(r);
	}
	
	public String getRule(String word) {
		for (Rule r : rules) {
			if (r instanceof TerminalRule && ((TerminalRule)r).rhs.equals(word))
				return r.lhs;
		}
		System.out.println("!!! Word '"+word+"' not recognised");
		return null;
	}
	
	public ArrayList<String> getNonTerminalRule(String rightmost, Edge e) {
		ArrayList<String> matches = new ArrayList<String>();
		for (Rule r : rules) {
			if (r instanceof NonTerminalRule) {
				NonTerminalRule ntr = (NonTerminalRule)r;
				if (ntr.rhs.get(ntr.rhs.size()-1).equals(rightmost) && ntr.rhs.get(0).equals(e.mother) && !matches.contains(ntr.lhs)) {
					matches.add(ntr.lhs);
				}
			}
		}
		return matches;
	}
}
