package 개념정리;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 4 6
1 0 1 1 1 1
1 0 1 0 1 0
1 0 1 0 1 1
1 1 1 0 1 1
 */
public class BFS_DFS_미로탐색 {
	
	static public class Location{
		int x,y;
		int depth;
		public Location(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	static int N,M;
	static int arr[][];
	static int visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	public static void main(String[] args)throws Exception {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		arr=new int[N][M];
		visited=new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j <M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//무조건 0,0에서 출발하여 미로탐색!!
		//bfs();//큐에 넣을 거기 때문에 파라미터로 넘겨줄 필요 없음
		//System.out.println("bfs결과");
		//print();
		
		dfs(0,0,1);
		System.out.println("dfs결과");
		print();
		
		System.out.println("답"+(visited[N-1][M-1]));
		
	}
	
	static void bfs() {
		Queue<Location> queue=new LinkedList<Location>();//bfs에 쓸 큐를 만든다
		queue.offer(new Location(0,0,1));//시작할 위치를 넣어준다. depth는 처음이니까 1
		visited[0][0]=1;//visit방문했다고 처리 
		while(!queue.isEmpty()) {
			Location now=queue.poll(); //현재 처리할 좌표를 큐에서 뺀다
			for (int i = 0; i < 4; i++) {//현재좌표의 상하좌우를 탐색한다
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				//범위 벗어나거나, 0이어서 길이 아닐경우, visited 중 0이 아니면 이미 방문해서 depth 저장한 것
				if(nx<0||nx>=N||ny<0||ny>=M||arr[nx][ny]==0||visited[nx][ny]!=0) continue;
				queue.offer(new Location(nx,ny,now.depth+1));
				visited[nx][ny]=now.depth+1;
			}
		}
	}
	
	static void dfs(int x,int y,int depth) {
		visited[x][y]=depth;
		for (int i = 0; i < 4; i++) {//현재좌표의 상하좌우를 탐색한다
			int nx=x+dx[i];
			int ny=y+dy[i];
			//범위 벗어나거나, 0이어서 길이 아닐경우, visited 중 0이 아니면 이미 방문해서 depth 저장한 것
			if(nx<0||nx>=N||ny<0||ny>=M||arr[nx][ny]==0||visited[nx][ny]!=0) continue;
			visited[nx][ny]=depth+1;
			dfs(nx,ny,depth+1);
		}
	}
	
	static void print() {
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}
}
