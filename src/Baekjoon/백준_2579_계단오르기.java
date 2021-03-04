package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2579_계단오르기 {
	static int N;
	static int arr[],dp[];
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		dp=new int[N+1];
		
		for (int i = 1; i <N+1; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		dp[1]=arr[1];
		
		if(N>=2) {
			dp[2]=arr[1]+arr[2];
			for (int i = 3; i < N+1; i++) {
				dp[i]=Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i];
			}
		}
		
		System.out.println(dp[N]);
	}

}
