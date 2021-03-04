package 알고리즘;

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

		// 처음에는 row,col은 3
		row = col = 3;

		while (time <= 100) {

			int maxCol = Integer.MIN_VALUE;
			int maxRow = Integer.MIN_VALUE;

			if (row >= r && col >= c) {
				// k와 같을경우
				if (arr[r][c] == k) {
					System.out.println(time);
					return;
				}
			}

			// 1.행>=열
			if (row >= col) {
				for (int i = 1; i <= row; i++) {
					HashSet<Integer> used=new HashSet<Integer>();
					cnt = new int[101];
					for (int j = 1; j <= col; j++) {
						if (arr[i][j] != 0) {
							// 해당하는 num의 cnt 1 증가
							cnt[arr[i][j]]++;
							// num저장
							used.add(arr[i][j]);
						}
					}

					// 컬럼에 있던 num들 우선순위큐에 저장
					for (Integer integer : used) {
						pq.add(new Point(integer, cnt[integer]));
					}

					int nowLength = 1;
					while (!pq.isEmpty()) {
						if(nowLength>100) break;
						Point nowPoint = pq.poll();
						// 배열에 추가
						arr[i][nowLength++] = nowPoint.num;
						arr[i][nowLength++] = nowPoint.cnt;
					}
					
					// 새로 들어간 수 길이가 이전보다 작을경우 0으로 바꿔줌
					if (nowLength <= col) {
						for (int j = nowLength; j <= col; j++) {
							arr[i][j] = 0;
						}
					}

					// 최대 col
					maxCol = Math.max(nowLength-1, maxCol);
				}
				col = maxCol;
			}

			// 2.행<열
			else if (row < col) {
				for (int i = 1; i <= col; i++) {
					HashSet<Integer> used=new HashSet<Integer>();
					cnt = new int[101];
					for (int j = 1; j <= row; j++) {
						if (arr[j][i] != 0) {
							// 해당하는 num의 cnt 1 증가
							cnt[arr[j][i]]++;
							// num저장
							used.add(arr[j][i]);
						}
					}

					// 컬럼에 있던 num들 우선순위큐에 저장
					for (Integer integer : used) {
						pq.add(new Point(integer, cnt[integer]));
					}

					int nowLength = 1;
					while (!pq.isEmpty()) {
						if(nowLength>100) break;
						Point nowPoint = pq.poll();
						// 배열에 추가
						arr[nowLength++][i] = nowPoint.num;
						arr[nowLength++][i] = nowPoint.cnt;
					}

					// 새로 들어간 수 길이가 이전보다 작을경우 0으로 바꿔줌
					if (nowLength <= row) {
						for (int j = nowLength; j <= row; j++) {
							arr[j][i] = 0;
						}
					}

					// 최대 col
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
