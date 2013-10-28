package uk.ac.cam.cgm30.parsing;

import java.util.ArrayList;

import uk.ac.cam.cgm30.cfg.ContextFreeGrammar;

public class Chart {
	private ArrayList<Edge> edges;
	private ArrayList<Edge> spanning_edges;
	private ContextFreeGrammar cfg;
	private int max_vertex;
	
	public Chart(ContextFreeGrammar grammar) {
		edges = new ArrayList<Edge>();
		spanning_edges = new ArrayList<Edge>();
		cfg = grammar;
		max_vertex = -1;
	}
	
	@Override
	public String toString() {
		String s = "id\tleft\tright\tmother\tdaughters\n";
		for (Edge e : edges) {
			s += e;
			if (e.left == 0 && e.right == max_vertex) {
				spanning_edges.add(e);
			}
		}
		s += "\nSpanning edges: ";
		for (Edge e : spanning_edges) {
			s += e.id + ", ";
		}
		return s.substring(0, s.length()-2)+"\n";
	}
	
	public void parse(String[] words, boolean usePacking) {
		max_vertex = words.length;
		for (int i = 0; i < words.length; ++i) {
			addEdge(words[i], i, i+1, usePacking);
		}
	}
	
	private void addEdge(String word, int left, int right, boolean usePacking) {
		String mother = cfg.getRule(word);
		if (mother == null) {
			return;
		}
		BasicEdge e = new BasicEdge(left, right, mother, word);
		edges.add(e);
		updateEdges(e, usePacking);
	}
	
	private void addEdge(String mother, int left, int right, int id1, int id2, boolean usePacking) {
		if (usePacking) {
			// Check for existing edge with same span and mother
			for (Edge e : edges) {
				if (e.left == left && e.right == right && e.mother.equals(mother)) {
					PackingEdge pe = (PackingEdge)e;
					ArrayList<Integer> lst = new ArrayList<Integer>();
					lst.add(id1);
					lst.add(id2);
					pe.daughters.add(lst);
					return;
				}
			}
			PackingEdge e = new PackingEdge(left, right, mother);
			ArrayList<Integer> lst = new ArrayList<Integer>();
			lst.add(id1);
			lst.add(id2);
			e.daughters.add(lst);
			edges.add(e);
			updateEdges(e, usePacking);
		} else {
			ComplexEdge e = new ComplexEdge(left, right, mother);
			e.daughters.add(id1);
			e.daughters.add(id2);
			edges.add(e);
			updateEdges(e, usePacking);
		}
	}
	
	private void updateEdges(Edge added, boolean usePacking) {
		// !!! Not general here; expect non terminal rules to have <= 2 daughters
		for (int i = 0; i < edges.size(); ++i) {
			Edge e = edges.get(i);
			if (e.right == added.left || e == added) {
				ArrayList<String> matches = cfg.getNonTerminalRule(added.mother, e);
				for (String r : matches) {
					addEdge(r, e.left, added.right, e.id, added.id, usePacking);
				}
			}
		}
	}
}
