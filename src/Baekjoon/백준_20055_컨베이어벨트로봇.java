package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_20055_컨베이어벨트로봇 {
	static int N,K,zeronum,answer;
	static ArrayList<Point> list1=new ArrayList<Point>();
	static ArrayList<Integer> list2=new ArrayList<Integer>();
	
	static public class Point{
		int weight;
		boolean flag;
		
		public Point(int weight, boolean flag) {
			this.weight = weight;
			this.flag = flag;
		}
		
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 2*N; i++) {
			int number=Integer.parseInt(st.nextToken());
			Point now=new Point(number,false);
			list1.add(now);
		}
		
		while(true) {
			
			answer++;
			
			//1.ȸ��
			Point end=list1.remove(list1.size()-1);
			list1.add(0, end);
			
			for (int i = 0; i < list2.size(); i++) {
				int idx=(list2.get(i)+1)%(2*N);
				list2.set(i, idx);
				if(idx==N-1) {
					list2.remove(i);
					i--;
				}
			}
			
			if(list1.get(N-1).flag==true) {
				list1.set(N-1, new Point(list1.get(N-1).weight,false));
			}
			
			//2.�κ� �̵�
			for (int i = 0; i < list2.size(); i++) {
				int idx=(list2.get(i)+1)%(2*N);
				if(list1.get(idx).weight>0&&list1.get(idx).flag==false) {
					//System.out.println(list2.get(i)+"->"+idx);
					list2.set(i,idx);
					list1.set(i,new Point(list1.get(i).weight,false));
					list1.set(idx,new Point(list1.get(idx).weight-1,true));
					if(idx==N-1) {
						list1.set(N-1, new Point(list1.get(N-1).weight,false));
						list2.remove(i);
						i--;
					}
				}
			}
			
			
			//if(list1.get(N-1).flag==true) {
			//	list1.set(N-1, new Point(list1.get(N-1).weight,false));
			//}
			
			
			//3.�ö󰡴� ��ġ
			if(list1.get(0).weight>0&&list1.get(0).flag==false) {
				int tmp=list1.get(0).weight-1;
				list1.set(0,new Point(tmp,true));
				list2.add(0);
			}
			
			int zeronum=0;
			for (int i = 0; i < list1.size(); i++) {
				if(list1.get(i).weight==0) {
					zeronum++;
				}
			}
			
			for (int j = 0; j < list1.size(); j++) {
				System.out.print(list1.get(j).weight+" ");
			}
			System.out.println();
			
			if(K<=zeronum) break;
		}
		
		System.out.println(answer);
		
	}

}
