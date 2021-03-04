package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int T,N,person_cnt,answer;
	static int tgt[];
	static PriorityQueue<Integer> pq1=new PriorityQueue<Integer>();
	static PriorityQueue<Integer> pq2=new PriorityQueue<Integer>();
	static ArrayList<Point> person_list=new ArrayList<Point>();
	static ArrayList<Point> exit_list=new ArrayList<Point>();
	
	static public class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T=Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N=Integer.parseInt(br.readLine());
			
			person_cnt=0;
			answer=Integer.MAX_VALUE;
			person_list=new ArrayList<Point>();
			exit_list=new ArrayList<Point>();
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					
					int num=Integer.parseInt(st.nextToken());
					
					if(num==1) {
						person_list.add(new Point(i,j));
						person_cnt++;
					}
					if(num==2) {
						exit_list.add(new Point(i,j));
					}
				}
			}
			
			tgt=new int[person_cnt];

			permutation(0);		
			System.out.println("#"+test_case+" "+answer);		
		}
	}
	
	static void permutation(int tgt_idx) {
		if(tgt_idx==person_cnt) {
			check_dir(tgt);
			return;
		}	
		tgt[tgt_idx]=2;
		permutation(tgt_idx+1);
		tgt[tgt_idx]=1;
		permutation(tgt_idx+1);
	}
	
	static void check_dir(int tgt[]) {
		for (int i = 0; i < tgt.length; i++) {
			Point now_person=person_list.get(i);
			Point exit1=exit_list.get(0);
			Point exit2=exit_list.get(1);
			if(tgt[i]==1) {
				int dir=Math.abs(now_person.x-exit1.x)+Math.abs(now_person.y-exit1.y);
				pq1.add(dir);
			}
			else if(tgt[i]==2) {
				int dir=Math.abs(now_person.x-exit2.x)+Math.abs(now_person.y-exit2.y);
				pq2.add(dir);
			}
		}
		check_time();
	}
	
	static void check_time() {
		int time=1;
		int exit1_time=0;
		int exit2_time=0;
		
		while(!pq1.isEmpty()||!pq2.isEmpty()) {
			
			if(!pq1.isEmpty()) exit1_time=pq1.peek();
			if(!pq2.isEmpty()) exit2_time=pq2.peek();
			
			
			if(exit1_time!=0&&exit1_time<=time) {
				pq1.poll();
			}
			
			if(exit2_time!=0&&exit2_time<=time) {
				pq2.poll();
			}
			time++;
		}
		answer=Math.min(answer,time);
	}

}
