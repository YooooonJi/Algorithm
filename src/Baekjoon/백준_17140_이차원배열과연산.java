package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_17140_이차원배열과연산 {
	static int r, c, k, row, col, time;
	static int arr[][];
	static int cnt[];
	static PriorityQueue<Point> pq = new PriorityQueue<Point>();

	static public class Point implements Comparable<Point>{
		int num, cnt;

		public Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		public int compareTo(Point o) {
			if (this.cnt == o.cnt) {
				return this.num - o.num;
			} else
				return this.cnt - o.cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[101][101];
		cnt = new int[101];

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// ó������ row,col�� 3
		row = col = 3;

		while (time <= 100) {

			int maxCol = Integer.MIN_VALUE;
			int maxRow = Integer.MIN_VALUE;

			if (row >= r && col >= c) {
				// k�� �������
				if (arr[r][c] == k) {
					System.out.println(time);
					return;
				}
			}

			// 1.��>=��
			if (row >= col) {
				for (int i = 1; i <= row; i++) {
					HashSet<Integer> used=new HashSet<Integer>();
					cnt = new int[101];
					for (int j = 1; j <= col; j++) {
						if (arr[i][j] != 0) {
							// �ش��ϴ� num�� cnt 1 ����
							cnt[arr[i][j]]++;
							// num����
							used.add(arr[i][j]);
						}
					}

					// �÷��� �ִ� num�� �켱����ť�� ����
					for (Integer integer : used) {
						pq.add(new Point(integer, cnt[integer]));
					}

					int nowLength = 1;
					while (!pq.isEmpty()) {
						if(nowLength>100) break;
						Point nowPoint = pq.poll();
						// �迭�� �߰�
						arr[i][nowLength++] = nowPoint.num;
						arr[i][nowLength++] = nowPoint.cnt;
					}
					
					// ���� �� �� ���̰� �������� ������� 0���� �ٲ���
					if (nowLength <= col) {
						for (int j = nowLength; j <= col; j++) {
							arr[i][j] = 0;
						}
					}

					// �ִ� col
					maxCol = Math.max(nowLength-1, maxCol);
				}
				col = maxCol;
			}

			// 2.��<��
			else if (row < col) {
				for (int i = 1; i <= col; i++) {
					HashSet<Integer> used=new HashSet<Integer>();
					cnt = new int[101];
					for (int j = 1; j <= row; j++) {
						if (arr[j][i] != 0) {
							// �ش��ϴ� num�� cnt 1 ����
							cnt[arr[j][i]]++;
							// num����
							used.add(arr[j][i]);
						}
					}

					// �÷��� �ִ� num�� �켱����ť�� ����
					for (Integer integer : used) {
						pq.add(new Point(integer, cnt[integer]));
					}

					int nowLength = 1;
					while (!pq.isEmpty()) {
						if(nowLength>100) break;
						Point nowPoint = pq.poll();
						// �迭�� �߰�
						arr[nowLength++][i] = nowPoint.num;
						arr[nowLength++][i] = nowPoint.cnt;
					}

					// ���� �� �� ���̰� �������� ������� 0���� �ٲ���
					if (nowLength <= row) {
						for (int j = nowLength; j <= row; j++) {
							arr[j][i] = 0;
						}
					}

					// �ִ� col
					maxRow = Math.max(nowLength-1, maxRow);
				}
				row = maxRow;
			}
//
//			for (int i = 1; i <= row; i++) {
//				for (int j = 1; j <=col; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			time++;
		}
		System.out.println("-1");

	}

}
