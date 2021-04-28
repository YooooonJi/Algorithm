package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9095_123더하기 {
	static int T,n,answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n=Integer.parseInt(br.readLine());
			answer=0;
			
			for (int i = 1; i < 4; i++) {
				dfs(n,i,0);
			}
			
			System.out.println(answer);
		}
		
	}
	
	static void dfs(int n,int idx,int sum) {
		//n���� Ŀ���� ��� ����
		sum+=idx;
		if(sum>n) {
			return;
		}
		
		//n�̶� ������ answer 1 ����
		if(sum==n) {
			answer++;
			return;
		}
		
		dfs(n,1,sum);
		dfs(n,2,sum);
		dfs(n,3,sum);
	}

}
