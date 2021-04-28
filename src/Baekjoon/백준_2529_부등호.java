package Baekjoon;

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
			//<�̸� 1 , >�̸� 0
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
		//tgt�迭�� �� ä�������
		if(tgt_idx==k+1) {
			long number=0;
			//���� ���ڸ� ����
			for (int i = 0; i < k+1; i++) {
				number+=tgt[i]*Math.pow(10, k-i);
			}
			//�ִ�ã��
			min=Math.min(min,number);
			return;
		}
		
		//ó���ϰ��
		if(tgt_idx==0) {
			tgt[tgt_idx]=src[src_idx];
			used[src_idx]=true;
			smallDfs(tgt_idx+1,src_idx);
			used[src_idx]=false;
		}
		//�ι�° �̻����
		else {
			boolean check=false;
			//<�ϰ��
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
				
				//���ǿ� �´°� �Ѱ��� ������
				if(check==false) {
					return;
				}
			}
			//>�ϰ��
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
				
				//���ǿ� �´°� �Ѱ��� ������
				if(check==false) {
					return;
				}				
			}
		}
		
	}
	
	static void bigDfs(int tgt_idx,int src_idx) {
		//tgt�迭�� �� ä�������
		if(tgt_idx==k+1) {
			long number=0;
			//���� ���ڸ� ����
			for (int i = 0; i < k+1; i++) {
				number+=tgt[i]*Math.pow(10, k-i);	
			}
			//�ִ�ã��
			max=Math.max(max,number);
			return;
		}
		
		//ó���ϰ��
		if(tgt_idx==0) {
			tgt[tgt_idx]=src[src_idx];
			used[src_idx]=true;
			bigDfs(tgt_idx+1,src_idx);
			used[src_idx]=false;
		}
		//�ι�° �̻����
		else {
			boolean check=false;
			//<�ϰ��
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
				
				//���ǿ� �´°� �Ѱ��� ������
				if(check==false) {
					return;
				}
			}
			//>�ϰ��
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
				
				//���ǿ� �´°� �Ѱ��� ������
				if(check==false) {
					return;
				}				
			}
		}
		
	}
	
}
