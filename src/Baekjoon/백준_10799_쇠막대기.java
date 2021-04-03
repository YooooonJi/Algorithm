package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_10799_쇠막대기 {
	static String s;
	static char galho[];
	static int arr[];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		s=br.readLine();
		
		galho=new char[s.length()];
		arr=new int[s.length()];
		visited=new boolean[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			galho[i]=s.charAt(i);
		}
		
		int idx=1;
		int cnt=0;
		for (int i = 0; i < s.length(); i++) {
			if(galho[i]=='(') {
				idx++;
				arr[i]=idx;
			}
			else {				
				if(galho[i-1]=='(') {
					arr[i-1]=1;
					arr[i]=1;
					cnt-=idx;
					idx--;
				}
				else {
					cnt++;
					arr[i]=idx;
					idx--;
				}
			}
		}
		
		for (int i = 0; i < s.length(); i++) {
			System.out.print(arr[i]);
		}
	}
	
	static void dfs(int idx,int num,int cnt) {
		System.out.println(idx+" "+num+" "+cnt);
		for (int i = 0; i < s.length(); i++) {
			System.out.print(arr[i]);
		}
		System.out.println("++++++++++++");
		if(idx>=s.length()) {
			return;
		}
		
		if(galho[idx]==')') {
			if(galho[idx-1]=='(') {
				arr[idx-1]=1;
				arr[idx]=1;
				visited[idx-1]=visited[idx]=true;
				cnt+=num;
			}
			else {
				arr[idx]=cnt;
				visited[idx]=true;
			}
		}
		
		if(galho[idx]=='('&&visited[idx]!=true) {
			arr[idx]=cnt;
			visited[idx]=true;
			dfs(idx+1,2,cnt+1);
		}
	}

}
