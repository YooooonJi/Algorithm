package SWExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1949_등산로조성 {
	
	static int T,N,K,maxNum=Integer.MIN_VALUE,maxDepth=Integer.MIN_VALUE;
	static int arr[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static boolean visited[][];
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T=Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			maxNum=Integer.MIN_VALUE;
			maxDepth=Integer.MIN_VALUE;
			arr=new int[N][N];
			visited=new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j <N; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					maxNum=Math.max(maxNum,arr[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					if(maxNum==arr[i][j]) {
						for (int i2 = 0; i2 <N; i2++) {
							for (int j2 = 0; j2 <N; j2++) {
								int tmpHeight=arr[i2][j2];
								for (int k = 0; k <= K; k++) {
									arr[i2][j2]-=k;
									visited[i][j]=true;
									dfs(i,j,1);
									visited=new boolean[N][N];
									//System.out.println();	
									arr[i2][j2]=tmpHeight;
								}
							}
						}
						
						
						for (int k = 0; k <= K; k++) {
						//bfs(i,j);
						visited[i][j]=true;
						dfs(i,j,1);
						visited=new boolean[N][N];
						//System.out.println();
						}
					}
				}
			}
			System.out.println(maxDepth);
			
			
		}
		
	}
	
	static void bfs(int x,int y) {
		Queue<Point> queue=new LinkedList<Point>();
		queue.add(new Point(x,y,0));
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			Point now=queue.poll();
			visited[now.x][now.y]=true;
			//System.out.print(arr[now.x][now.y]);
			for (int i = 0; i < 4; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]==true) continue;
				
				if(arr[nx][ny]<arr[now.x][now.y]) {
					queue.add(new Point(nx,ny,now.depth+1));
				}
				
			}
		}
	}
	
	static void dfs(int x,int y,int depth) {
		//System.out.print(depth);
		maxDepth=Math.max(maxDepth,depth);
		for (int i = 0; i < 4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]==true) continue;
			
			if(arr[nx][ny]<arr[x][y]) {
				visited[nx][ny]=true;
				dfs(nx,ny,depth+1);
			}
			
		}
		//System.out.println();
	}

	static public class Point{
		int x,y;
		int depth;
		public Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
		
	}
}
