package uk.ac.cam.cgm30.parsing;

import uk.ac.cam.cgm30.cfg.ContextFreeGrammar;
import uk.ac.cam.cgm30.cfg.NonTerminalRule;
import uk.ac.cam.cgm30.cfg.TerminalRule;


public class TestParser {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("[Usage] java TestParser words of sentence etc");
			return;
		}
		ContextFreeGrammar g = new ContextFreeGrammar();
		
		NonTerminalRule S1 = new NonTerminalRule("S");
		NonTerminalRule S2 = new NonTerminalRule("S");
		NonTerminalRule VP1 = new NonTerminalRule("VP");
		NonTerminalRule VP2 = new NonTerminalRule("VP");
		NonTerminalRule VP3 = new NonTerminalRule("VP");
		NonTerminalRule VP4 = new NonTerminalRule("VP");
		NonTerminalRule NP1 = new NonTerminalRule("NP");
		NonTerminalRule NP2 = new NonTerminalRule("NP");
		NonTerminalRule PP = new NonTerminalRule("PP");
		
		S1.rhs.add("NP");
		S1.rhs.add("VP");
		S2.rhs.add("PR");
		S2.rhs.add("VP");
		VP1.rhs.add("VP");
		VP1.rhs.add("PP");
		VP2.rhs.add("V");
		VP3.rhs.add("V");
		VP3.rhs.add("NP");
		VP4.rhs.add("V");
		VP4.rhs.add("VP");
		NP1.rhs.add("NP");
		NP1.rhs.add("PP");
		NP2.rhs.add("DT");
		NP2.rhs.add("NP");
		PP.rhs.add("P");
		PP.rhs.add("NP");
		
		g.addRule(S1);
		g.addRule(S2);
		g.addRule(VP1);
		g.addRule(VP2);
		g.addRule(VP3);
		g.addRule(VP4);
		g.addRule(NP1);
		g.addRule(NP2);
		g.addRule(PP);
		
		g.addRule(new TerminalRule("PR", "he"));
		g.addRule(new TerminalRule("V", "ate"));
		g.addRule(new TerminalRule("V", "hit"));
		g.addRule(new TerminalRule("DT", "the"));
		g.addRule(new TerminalRule("DT", "a"));
		g.addRule(new TerminalRule("NP", "pizza"));
		g.addRule(new TerminalRule("NP", "truck"));
		g.addRule(new TerminalRule("NP", "tree"));
		g.addRule(new TerminalRule("NP", "garden"));
		g.addRule(new TerminalRule("P", "with"));
		g.addRule(new TerminalRule("P", "in"));
		g.addRule(new TerminalRule("NP", "fork"));
		
		Chart c = new Chart(g);
		c.parse(args, true);
		System.out.println(c);
	}
}
