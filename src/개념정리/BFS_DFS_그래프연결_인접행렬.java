package 개념정리;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6 5 0 
0 4
0 3
1 3
1 2
3 5
 */
public class BFS_DFS_그래프연결_인접행렬 {

	static int N,M,start;
	static boolean visited[][];
	static boolean flag[];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		start=Integer.parseInt(st.nextToken());
		
		visited=new boolean[N+1][N+1];
		flag=new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			visited[from][to]=true;
			visited[to][from]=true;
		}
		
		System.out.println("bfs");
		bfs2();
		Arrays.fill(flag,false);
		System.out.println("dfs");
		dfs2(start);

	}
	static void bfs2() {//그래프를 인접행렬로 표현했을 시, 그래프의 연결성 확인
		Queue<Integer> q=new LinkedList<Integer>();
		
		q.add(start);//처음 시작하는 값을 넣고
		flag[start]=true;

		while(!q.isEmpty()) {
			//한개를 뺀 후 그거에 인접한 애들 체크
			int now=q.poll();
			System.out.print(now+" ");
			for (int i = 1; i <=N; i++) {
				if(visited[now][i]==true||flag[i]==false) {
					//인접한데 방문안했으면
					flag[i]=true;
					q.add(i);
				}
			}
		}
	}
	
	static void dfs2(int num) {

		flag[num]=true;
		System.out.print(num+" ");
		for (int i = 1; i <=N; i++) {
			if(visited[num][i]==true&&flag[i]==false) {
				dfs2(i);
			}
		}
	}
}
