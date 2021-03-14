package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 백준_5577_RBY팡 {
	static int N,answer,min=Integer.MAX_VALUE;
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static ArrayList<Integer> tmp_list=new ArrayList<Integer>();
	static boolean visited[],flag1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
			tmp_list.add(list.get(i));
		}
		
		int tmp=0;
		for (int i= 0; i < N; i++) {
			flag1=false;
			list.clear();
			list.addAll(tmp_list);
			visited=new boolean[list.size()];
			//System.out.println(i+"번째#####################");
//			for (int j = 0; j <list.size(); j++) {
//				System.out.print(list.get(j));
//			}
			//System.out.println();
			//System.out.println("-----------------------------------");
			if(N<=3) {
				min=N;
				break;
			}
			if(i==0) {
				list.set(i, list.get(i+1));
				while(flag1!=true) {
//					for (int j = 0; j <list.size(); j++) {
//						System.out.print(list.get(j));
//					}
//					System.out.println();
					Arrays.fill(visited, false);
					check(0,1);
					
					}
			}
			else if(i==N-1) {
				list.set(i, list.get(N-2));
				while(flag1!=true) {
//					for (int j = 0; j <list.size(); j++) {
//						System.out.print(list.get(j));
//					}
//					System.out.println();
					Arrays.fill(visited, false);
					check(0,1);
					}
			}
			else {
				list.set(i, list.get(i-1));
				while(flag1!=true) {
//					for (int j = 0; j <list.size(); j++) {
//						System.out.print(list.get(j));
//					}
//					System.out.println();
					Arrays.fill(visited, false);
					check(0,1);
					}
				if(answer!=0) {
					min=Math.min(answer,min);
					//System.out.println("answer:"+answer);
					}				
				flag1=false;
				list.clear();
				list.addAll(tmp_list);
				Arrays.fill(visited, false);
				
				if(list.get(i-1)!=list.get(i+1)) {
				list.set(i, list.get(i+1));
				while(flag1!=true) {
//					for (int j = 0; j <list.size(); j++) {
//						System.out.print(list.get(j));
//					}
//					System.out.println();
					Arrays.fill(visited, false);
					check(0,1);
					}
				}
			}
			
			if(answer!=0) {
			min=Math.min(answer,min);
//			System.out.println("answer:"+answer);
			}
		}
		
		System.out.println(min);
		
		
	}
	
	static void check(int idx,int cnt) {
		//System.out.println(idx+" "+(list.size()-1));
		//System.out.println("리스트사이즈"+list.size());
		if(list.size()<=3) {
			flag1=true;
			answer=list.size();
			return;
		}
		if(idx>(list.size()-1)) {
			flag1=true;
			answer=list.size();
			return;
		}
		if(idx==list.size()-1) {
			if(cnt>=4) {
//				for (int i = 0; i < visited.length; i++) {
//					System.out.print(visited[i]+" ");
//				}
//				System.out.println();
				del(0,0,1);
				return;				
			}
			else {
				flag1=true;
				answer=list.size();
				return;
			}
		}
		if(list.get(idx)==list.get(idx+1)) {
			visited[idx]=true;
			visited[idx+1]=true;
			check(idx+1,++cnt);
		}
		else {
			if(cnt>=4) {
//				for (int i = 0; i < visited.length; i++) {
//					System.out.print(visited[i]+" ");
//				}
				//System.out.println();
				del(0,0,1);
				return;
			}
			else {
				visited[idx]=false;
				check(idx+1,1);
			}
		}
	}
	
	
//	static void check() {
//		
//		boolean flag=true;
//		boolean avail=false;
//		int cnt=0;
//		int number=0;
//		visited=new boolean[N];
//		
//		while(flag) {
//			for (int i = number; i <N-1; i++) {
//				if(arr[i]==arr[i+1]) {
//					avail=true;
//					visited[i]=visited[i+1]=true;
//					cnt++;
//					flag=true;
//				}
//				else {
//					if(cnt>=3) {
//						del();
//						cnt=0;
//						number=0;
//					}
//					else {
//						if(i==N-1) {
//							answer=N;
//							flag=false;
//						}
//						number=i;
//					}
//					break;
//				}
//			}
//		}
//		
//	}
	
	static void del(int start,int idx,int cnt) {
		//끝까지 확인했을 때
	//	System.out.println(start+" "+idx+" "+cnt+" "+(list.size()-1));
		if(idx>list.size()-1) {
			return;
		}
		if(idx==(list.size()-1)) {
			if(visited[idx]==true&&cnt>=4) {
				//System.out.println("cnt"+cnt+"start "+start);
				for (int i =start; i <(start+cnt-1); i++) {
					list.remove(start);
				}
				//지운만큼 N 바꿈
				return;
			}
		}
		if(visited[idx]==false) {
			//같은거 4개이상 찾았을때
			if(cnt>=5) {
//				System.out.println("cnt"+cnt+"start "+start);
				for (int i =start; i <(start+cnt-1); i++) {
					list.remove(start);
				}
//				System.out.println("size:"+list.size());
				//지운만큼 N 바꿈
				return;
			}
			//찾지 못했을 때
			else {
				del(idx+1,idx+1,1);
			}
		}
		
		//또 true일때
		if(visited[idx]==true) {
			del(start,idx+1,++cnt);
		}
	}
		
}
