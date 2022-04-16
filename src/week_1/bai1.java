package week_1;

import java.util.ArrayList;

public class bai1 {
	public static void themDinh(ArrayList<ArrayList<Integer>> mtk) {
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
	public static void in(ArrayList<ArrayList<Integer>> mtk) {
		for (int i = 0; i < mtk.size(); i++) {
			for (int j = 0; j < mtk.size(); j++)

			{
				System.out.print(mtk.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	// Thêm một cạnh vào ma trận dưới dạng ma trận kề
	public static void themCanh(ArrayList<ArrayList<Integer>> mtk, int diemdau1, int diemdau2) {
		if (diemdau1 < 0 || diemdau2 < 0 || diemdau2 > mtk.size())
			return;
		mtk.get(diemdau1).set(diemdau2, 1);
		mtk.get(diemdau2).set(diemdau1, 1);
	}

	// tính bậc của đỉnh i và trả về kết quả
	public static int bac(ArrayList<ArrayList<Integer>> mtk, int i) {
		int sum = 0;
		for (int j = 0; j < mtk.size(); j++) {
			if (mtk.get(i).get(j) != 0)
				sum += mtk.get(i).get(j);
		}
		return sum;
	}

	// tính số cạnh của đồ thị và trả về kết quả
	public static int soCanh(ArrayList<ArrayList<Integer>> mtk) {
		int count = 0;
		for (int i = 0; i < mtk.size(); i++) {
			for (int j = 0; j < mtk.size(); j++) {
				if (mtk.get(i).get(j) != 0)
					count++;
			}
		}
		return count / 2;
	}

	// kiểm tra đỉnh x có kề đỉnh y không và trả về kết quả
	public static boolean ke(ArrayList<ArrayList<Integer>> mtk, int x, int y) {
		boolean res = false;
		if (x > mtk.size() || y > mtk.size())
			res = false;
		else if (mtk.get(x).get(y) != 0)
			res = true;
		return res;
	}
	// tìm các đỉnh kề với đỉnh i và trả về kết quả

	public static ArrayList<Integer> danhSachKe(ArrayList<ArrayList<Integer>> mtk, int i) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (i > mtk.size())
			return new ArrayList<>();
		else {
			for (int j = 0; j < mtk.size(); j++) {
				if (mtk.get(i).get(j) != 0)
					res.add(j);
			}
		}
		return res;
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> mtk = new ArrayList<ArrayList<Integer>>();
		themDinh(mtk);
		themDinh(mtk);
		themDinh(mtk);
		in(mtk);
	}
}
