package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10451_순열사이클 {
	static int T,N,answer;
	static int arr[][];
	static boolean visited[];
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T=Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <=T; test_case++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N+1][N+1];
			visited=new boolean[N+1];
			
			st=new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= N; i++) {
				int num=Integer.parseInt(st.nextToken());
				arr[i][num]=1;
				arr[i][i]=1;
			}
			
			
			for (int i = 1; i <N+1; i++) {
				if(visited[i]==false) {
					dfs(i);
				}
			}
			
			
		}
		
	}
	static void dfs(int num) {
		visited[num]=true;
		for (int i = 1; i <= N; i++) {
			if(arr[num][i]==1&&visited[i]==false) {
				dfs(i);
			}
		}
	}
	
	

}
