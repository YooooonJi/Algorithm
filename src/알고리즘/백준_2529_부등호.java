package 알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class 백준_2529_부등호 {
	static int k;
	static long max=Long.MIN_VALUE,min=Long.MAX_VALUE;
	static int tgt[],src[],compare[];
	static boolean used[];
	


	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k=Integer.parseInt(br.readLine());
		
		compare=new int[k];
		tgt=new int[k+1];
		src=new int[10];
		used=new boolean[10];
		
		for (int i = 0; i <10; i++) {
			src[i]=i;
		}
		
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			//<이면 1 , >이면 0
			if(st.nextToken().equals("<")){
				compare[i]=1;
			}
			else {
				compare[i]=0;
			}
		}
		

		
		for (int i = 0; i <10; i++) {
			smallDfs(0,i);
		}
		
		tgt=new int[k+1];
		used=new boolean[10];

		for (int i = 9; i>=0; i--) {
			bigDfs(0,i);
		}
		
		if((int)(Math.log10(max)+1)==k) {
			System.out.print(0);
			System.out.println(max);
		}
		else {
			System.out.println(max);
		}
		
		if((int)(Math.log10(min)+1)==k) {
			System.out.print(0);
			System.out.println(min);
		}
		else {
			System.out.println(min);
		}
	
	}
	
	static void smallDfs(int tgt_idx,int src_idx) {
		//tgt배열에 다 채웠을경우
		if(tgt_idx==k+1) {
			long number=0;
			//실제 숫자를 구함
			for (int i = 0; i < k+1; i++) {
				number+=tgt[i]*Math.pow(10, k-i);
			}
			//최대찾기
			min=Math.min(min,number);
			return;
		}
		
		//처음일경우
		if(tgt_idx==0) {
			tgt[tgt_idx]=src[src_idx];
			used[src_idx]=true;
			smallDfs(tgt_idx+1,src_idx);
			used[src_idx]=false;
		}
		//두번째 이상부터
		else {
			boolean check=false;
			//<일경우
			if(compare[tgt_idx-1]==1) {
				check=false;
				for (int i = 0; i < 10; i++) {
					if(used[i]==false&&tgt[tgt_idx-1]<src[i]) {
						check=true;
						tgt[tgt_idx]=src[i];
						used[i]=true;
						smallDfs(tgt_idx+1,src_idx);
						used[i]=false;
					}
				}
				
				//조건에 맞는게 한개도 없으면
				if(check==false) {
					return;
				}
			}
			//>일경우
			else if(compare[tgt_idx-1]==0) {
				check=false;
				for (int i = 0; i < 10; i++) {
					if(used[i]==false&&tgt[tgt_idx-1]>src[i]) {
						check=true;
						tgt[tgt_idx]=src[i];
						used[i]=true;
						smallDfs(tgt_idx+1,src_idx);
						used[i]=false;
					}
				}
				
				//조건에 맞는게 한개도 없으면
				if(check==false) {
					return;
				}				
			}
		}
		
	}
	
	static void bigDfs(int tgt_idx,int src_idx) {
		//tgt배열에 다 채웠을경우
		if(tgt_idx==k+1) {
			long number=0;
			//실제 숫자를 구함
			for (int i = 0; i < k+1; i++) {
				number+=tgt[i]*Math.pow(10, k-i);	
			}
			//최대찾기
			max=Math.max(max,number);
			return;
		}
		
		//처음일경우
		if(tgt_idx==0) {
			tgt[tgt_idx]=src[src_idx];
			used[src_idx]=true;
			bigDfs(tgt_idx+1,src_idx);
			used[src_idx]=false;
		}
		//두번째 이상부터
		else {
			boolean check=false;
			//<일경우
			if(compare[tgt_idx-1]==1) {
				check=false;
				for (int i = 9; i>=0; i--) {
					if(used[i]==false&&tgt[tgt_idx-1]<src[i]) {
						check=true;
						tgt[tgt_idx]=src[i];
						used[i]=true;
						bigDfs(tgt_idx+1,src_idx);
						used[i]=false;
					}
				}
				
				//조건에 맞는게 한개도 없으면
				if(check==false) {
					return;
				}
			}
			//>일경우
			else if(compare[tgt_idx-1]==0) {
				check=false;
				for (int i = 9; i >=0; i--) {
					if(used[i]==false&&tgt[tgt_idx-1]>src[i]) {
						check=true;
						tgt[tgt_idx]=src[i];
						used[i]=true;
						bigDfs(tgt_idx+1,src_idx);
						used[i]=false;
					}
				}
				
				//조건에 맞는게 한개도 없으면
				if(check==false) {
					return;
				}				
			}
		}
		
	}
	
}
