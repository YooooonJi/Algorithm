package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1003_피보나치함수 {
	static int T,N;
	static int arr[],cnt[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <=T; test_case++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[100];
			cnt=new int[2];
			//fibonacci(N);
			
			arr[0]=0;
			arr[1]=1;
			for (int i = 0; i <=N; i++) {
				if(i==0||i==1) {
					arr[i]=i;
					cnt[i]++;
				}
				else {
					arr[i]=arr[i-1]+arr[i-2];
				}
			}
			System.out.println(cnt[0]+" "+cnt[1]);
		}
	}
		static void fibonacci(int n) {
			if(n==0||n==1) {
				arr[n]=N;
				return;
			}
			else {
				arr[n]=arr[n-1]+arr[n-2];
			}
		}
	}


