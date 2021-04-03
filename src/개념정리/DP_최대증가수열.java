package 알고리즘개념정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
6
10 20 10 30 20 50
*/
public class DP_최대증가수열 {
	static int N,answer=Integer.MIN_VALUE;
	static int arr[],dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr=new int[N];
		dp=new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if(dp[i]==0) {
				dp[i]=1;
			}
			for (int j = 0; j < i; j++) {//자기자신과 맨앞부터 자기자신-1까지 하나씩 크기비교한다.
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[j]+1,dp[i]);
				}
			}
			answer=Math.max(answer,dp[i]);//dp배열중 제일 큰거(제일 길다는 뜻) 찾음
		}
		
		System.out.println(answer);
	}
}
