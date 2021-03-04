package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution2 {
	static int T, W, H,max,answer=Integer.MAX_VALUE;
	static int arr[][];
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static boolean street[][];
	static boolean visited[][];
	static boolean available;
	
	static public class Point{
		int x,y,depth;

		public Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());

			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			arr = new int[H][W];
			visited=new boolean[H][W];
			street = new boolean[H][W];
			answer=Integer.MAX_VALUE;
			available=false;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < W; i++) {
				check(0, i);
				check(H - 1, i);
			}
			
			for (int i = 0; i < W; i++) {
				check(i, 0);
				check(i, H - 1);
			}
			
			if(available==false) {
				System.out.println("#"+test_case+" "+"-1");
			}
			else System.out.println("#"+test_case+" "+answer);
		}
	}

	static void check(int x, int y) {
		
		for (int i = 0; i < 8; i++) {
			street=new boolean[H][W];
			
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx < 0 || ny < 0 || nx >= H || ny >= W || arr[nx][ny] == 1)
				continue;

			street[nx][ny] = true;

			// 가능하면 쭉 가본다
			boolean flag = true;
			int tmp_x = nx;
			int tmp_y = ny;

			while (true) {
				// 같은 방향 확인
				nx += dx[i];
				ny += dy[i];
				
				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					break;
				
				if (arr[nx][ny] == 1) {
					flag = false;
					break;
				}				
				street[nx][ny]=true;
			}

			if (flag == true) {
				// 끝까지 안막히고 갔다면 반대쪽도 확인
				while (true) {
					tmp_x -= dx[i];
					tmp_y -= dy[i];

					if (tmp_x < 0 || tmp_y < 0 || tmp_x >= H || tmp_y >= W)
						break;

					if (arr[tmp_x][tmp_y] == 1) {
						flag = false;
						break;
					}
					street[tmp_x][tmp_y]=true;
				}
			}
			
			if(flag==true) {
				available=true; //다리를 하나라도 만들 수 있음
				max=Integer.MIN_VALUE;
				for (int j = 0; j < H; j++) {
					for (int k = 0; k < W; k++) {
						if(arr[j][k]==1) {
							visited=new boolean[H][W];
							distance(j,k,0);
						}
					}
				}
				answer=Integer.min(answer,max);
			}

		}
	}
	
	static void distance(int x,int y,int depth) {
		Queue<Point> q=new LinkedList<Point>();
		
		q.add(new Point(x,y,depth));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			Point now=q.poll();
			for (int i = 0; i < 4; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				
				if (nx < 0 || ny < 0 || nx >= H || ny >= W||visited[nx][ny]==true) continue;
				
				visited[nx][ny]=true;
				if(street[nx][ny]==true) {
					max=Integer.max(max,now.depth+1);
					return;
				}
				q.add(new Point(nx,ny,now.depth+1));
			}
		}
		
	}

}
