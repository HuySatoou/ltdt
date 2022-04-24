package week_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class bai2 {
	static ArrayList<ArrayList<Integer>> mtk = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> ke = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Boolean> visited = new ArrayList<Boolean>();

	public static void resetVisited() {
		// tất cả các đỉnh đều có visited=true;
		for (int i = 0; i < mtk.size(); i++) {
			visited.add(false);
		}
	}

	public static void themDinh() {
		if (mtk.size() == 0) {
			mtk.add(new ArrayList<Integer>());
			mtk.get(0).add(0);
			return;
		}
		for (int i = 0; i < mtk.size(); i++)
			mtk.get(i).add(0);
		ArrayList<Integer> dongmoi = new ArrayList<Integer>();
		for (int i = 0; i < mtk.size() + 1; i++)
			dongmoi.add(0);
		mtk.add(dongmoi);
	}

	// in dưới dạng ma trận kề
	public static void in() {
		for (int i = 0; i < mtk.size(); i++) {
			for (int j = 0; j < mtk.size(); j++)

			{
				System.out.print(mtk.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	// Thêm một cạnh vào ma trận dưới dạng ma trận kề
	public static void themCanh(int diemdau1, int diemdau2) {
		if (diemdau1 < 0 || diemdau2 < 0 || diemdau2 > mtk.size())
			return;
		mtk.get(diemdau1).set(diemdau2, 1);
		mtk.get(diemdau2).set(diemdau1, 1);
	}

	// kiểm tra đỉnh x có kề đỉnh y không và trả về kết quả
	public static boolean ke(int x, int y) {
		boolean res = false;
		if (x > mtk.size() || y > mtk.size())
			res = false;
		else if (mtk.get(x).get(y) != 0)
			res = true;
		return res;
	}

	public static void DFS(int i) {
		Stack<Integer> stack = new Stack<>();
		stack.push(i);
		visited.set(i, true);
		while (stack.isEmpty() == false) {
			int u = stack.pop();
			System.out.print(u + "\t");

			for (int v : ke.get(u)) {
				if (visited.get(v) == false) {
					stack.push(v);
					visited.set(v, true);
				}
			}
		}
	}

	public static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		resetVisited();
		queue.offer(i);
		visited.set(i, true);
		while (queue.isEmpty() == false) {
			int u = queue.poll();
			System.out.print(u + "\t");
			for (int v : ke.get(u)) {
				if (visited.get(v) == false) {
					queue.offer(v);
					visited.set(v, true);
				}
			}
		}
	}

	// in danh sách kề
	public static void inDSke() {
		for (int i = 0; i < ke.size(); i++) {
			System.out.print(i + ":[");
			for (int j : ke.get(i)) {
				System.out.print(j + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// tạo đồ thị 6 đỉnh
		themDinh();
		themDinh();
		themDinh();
		themDinh();
		themDinh();
		themDinh();
		// Thêm 8 cạnh
		themCanh(0, 1);
		themCanh(0, 2);
		themCanh(0, 5);
		themCanh(1, 4);
		themCanh(2, 3);
		themCanh(3, 4);
		themCanh(4, 2);
		themCanh(5, 3);
		// tạo danh sách kề rỗng gồm 6 phần tử
		for (int i = 0; i < mtk.size(); i++) {
			ke.add(new ArrayList<Integer>());
		}
		// thêm nội dung cho danh sách kề
		for (int i = 0; i < ke.size(); i++) {
			for (int j = 0; j < mtk.size(); j++) {
				if (ke(i, j) == true)
					ke.get(i).add(j);
			}
		}

		// gọi hàm DFS duyệt và in các đỉnh đã duyệt ra màn hình
		resetVisited();
		DFS(0);
	
		// BFS(0);
		// reset lại mảng visited

		// gọi hàm BFS duyệt và in các đỉnh đã duyệt ra màn hình

	}
}
