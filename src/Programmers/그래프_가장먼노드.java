package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 그래프_가장먼노드 {
	
	static int n,max=Integer.MIN_VALUE,result;
	static int[][] vertex= {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
	static public class Point{
		int idx,cnt;
		public Point(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		n=6;
		visited=new boolean[n+1];
		
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
	
		for (int i = 0; i < vertex.length; i++) {
			int x=vertex[i][0];
			int y=vertex[i][1];
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		bfs(1);
		System.out.println("result:"+result);

	}

	static void bfs(int start) {
		Queue<Point> q=new LinkedList<Point>();
		q.add(new Point(start,0));
		visited[start]=true;
		
		while(!q.isEmpty()) {
			Point now=q.poll();
			visited[now.idx]=true;
			System.out.println(now.idx +" "+now.cnt);
			if(max<now.cnt) {
				max=now.cnt;
				result=1;
			}
			else if(max==now.cnt) {
				result++;
			}
			
			for (int i = 0; i < list.get(now.idx).size(); i++) {
				int connect=list.get(now.idx).get(i);
				if(visited[connect]!=true) {
					visited[connect]=true;
					q.add(new Point(connect,now.cnt+1));
				}
			}
		}
		
	}
}
