package kiemTraChuTrinh;

import java.util.ArrayList;

public class chuTrinhVoHuong {
	static ArrayList<ArrayList<Integer>> mtk = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> ke = new ArrayList<>();
	static ArrayList<Boolean> visited = new ArrayList<>();
	static ArrayList<Integer> parent = new ArrayList<>(mtk.size());

	public static void resetVisited() {
		// tất cả các đỉnh đều có visited=true;
		for (int i = 0; i < mtk.size(); i++) {
			visited.add(false);
		}
	}

	static void resetParent() {
		for (int i = 0; i < mtk.size(); i++) {
			parent.add(0);
		}
	}

	static Boolean DFS(int u) {
		visited.set(u, true);
		for (int v : ke.get(u)) {
			if (!visited.get(v)) {
				parent.set(v, u);
				if (DFS(v))
					return Boolean.TRUE;
			} else if (v != parent.get(u))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	static String KiemTraChuTrinh() {
		resetVisited();
		for (int i = 0; i < mtk.size(); i++) {
			if (!visited.get(i)) {
				if (DFS(i))
					return "YES";
			}
		}
		return "NO";
	}

	public static void main(String[] args) {

	}
}
