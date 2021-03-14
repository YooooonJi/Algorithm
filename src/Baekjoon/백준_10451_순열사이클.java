package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_10451_��������Ŭ {
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
			answer=0;
			
			st=new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= N; i++) {
				int num=Integer.parseInt(st.nextToken());
				arr[i][num]=1;
				arr[num][i]=1;
			}
			
			
			for (int i = 1; i <N+1; i++) {
				if(visited[i]==false) {
					dfs(i);
					System.out.println();
					answer++;
				}
			}
			
			System.out.println(answer);
		}
		
	}
	static void dfs(int num) {
		visited[num]=true;
		System.out.print(num+" ");
		for (int i = 1; i <= N; i++) {
			if(arr[num][i]==1&&visited[i]==false) {
				dfs(i);
			}
		}
	}
	
	

}
