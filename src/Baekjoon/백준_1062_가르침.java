package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1062_가르침 {
	static int N,K,max=Integer.MIN_VALUE;
	static boolean alpha[]=new boolean[26];
	static String word[];
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		word=new String[N];
		
		if(K<5) {
			System.out.println("0");
			return;
		}
		
		alpha['a'-97]=true;
		alpha['n'-97]=true;
		alpha['t'-97]=true;
		alpha['i'-97]=true;
		alpha['c'-97]=true;
		
		for (int i = 0; i <N; i++) {
			String s=br.readLine();
			s.substring(4, s.length()-4);
			word[i]=s;
		}
			
		K=K-5;
		dfs(0,K);
		
		System.out.println(max);
		
	}
	static void dfs(int num, int cnt) {
		if(cnt==0) {//�ܾ� �� �˷�������
			int tmp_answer=0;
			for (int i = 0; i <N; i++) {
				boolean flag=true;
				for (int j = 0; j < word[i].length(); j++) {
					int tmp=word[i].charAt(j)-'a';
					if(alpha[tmp]!=true) {
						flag=false;
						break;
					}
				}
				
				if(flag==true) {
					tmp_answer++;
				}
			}
			
			max=Math.max(tmp_answer,max);
			
			return;
		}
	
		for (int i = num; i < 26; i++) {
			if(alpha[i]!=true) {
				alpha[i]=true;
				dfs(i,cnt-1);
				alpha[i]=false;
			}
		}
	}
}
