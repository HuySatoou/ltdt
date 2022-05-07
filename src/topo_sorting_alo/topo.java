package topo_sorting_alo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class topo {
	static ArrayList<ArrayList<Integer>> mtk = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> ke = new ArrayList<>();
	static ArrayList<Boolean> visited = new ArrayList<>();
	static Stack<Integer> topo = new Stack<>();

	static void resetVisited() {
		for (int i = 0; i < visited.size(); i++) {
			visited.add(i, false);
		}
	}

	static void DFS(int i) {
		visited.set(i, true);
		for (int u : ke.get(i)) {
			if (visited.get(u) == false) {
				DFS(u);
			}
		}
		topo.add(i);
	}

	static void topoSorting() {
		for (int i = 0; i < mtk.size(); i++) {
			if (!visited.get(i)) {
				DFS(i);
			}
		}
		Collections.reverse(topo);
		for (int i : topo) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		resetVisited();
		topoSorting();
	}
}
