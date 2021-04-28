package 개념정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 3 2
 1 2 3
 */
public class 순열_조합_부분집합 {
	
	static int N,M;
	static int src[],tgt[];
	static boolean used[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());//소스 전체 개수
		M=Integer.parseInt(st.nextToken());//뽑을 개수
		
		src=new int[N];
		tgt=new int[M];
		used=new boolean[N];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i]=Integer.parseInt(st.nextToken());
		}
		System.out.println("순열:");
		permutation(0);
		System.out.println("중복순열");
		de_permutation(0);
		System.out.println("조합:");
		combination(0,0);
		Arrays.fill(used, false);
		System.out.println("부분집합:");
		powerset(0);
		
	}
	
	//순열
	static void permutation(int tgt_idx) {
		if(tgt_idx==M) {
			print();
			return;
		}
		
		for (int i =0; i <N; i++) {
			if(used[i]==false) {
				tgt[tgt_idx]=src[i];
				used[i]=true;
				permutation(tgt_idx+1);
				used[i]=false;
			}
		}
	}
	
	//중복순열
	static void de_permutation(int tgt_idx) {
		if(tgt_idx==M) {
			print();
			return;
		}
		
		for (int i =0; i <N; i++) {
				tgt[tgt_idx]=src[i];
				permutation(tgt_idx+1);
		}
	}
	
	//조합
	static void combination(int src_idx,int tgt_idx) {
		if(tgt_idx==M) {
			print();
			return;
		}
		if(src_idx==N) return;
		
		tgt[tgt_idx]=src[src_idx];
		combination(src_idx+1,tgt_idx+1);
		combination(src_idx+1,tgt_idx);
	}
	
	static void powerset(int tgt_idx) {
		if(tgt_idx==N) {
			boolean flag=false;
			for (int i = 0; i<N; i++) {
				if(used[i]==true) {
					System.out.print(src[i]);
					flag=true;
				}
			}
			if(flag==false) {
				System.out.print("공집합");
			}
			System.out.println();
			return;
		}
		used[tgt_idx]=true;
		powerset(tgt_idx+1);
		used[tgt_idx]=false;
		powerset(tgt_idx+1);
	}
	
	static void print() {
		for (int i : tgt) {
			System.out.print(i);
		}
		System.out.println();
	}
	

}
