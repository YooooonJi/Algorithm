package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ¹éÁØ_11286_Àý´ñ°ªÈü {
	static int N,x;
	static PriorityQueue<Number> pq=new PriorityQueue<Number>();
	static public class Number implements Comparable<Number>{
		int x;

		public Number(int x) {
			this.x = x;
		}
		
		public int compareTo(Number o) {
			if(Math.abs(this.x)==Math.abs(o.x)) {
				return this.x-o.x;
			}
			else return Math.abs(this.x)-Math.abs(o.x);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			x=Integer.parseInt(br.readLine());
			if(x!=0) {
				pq.add(new Number(x));
			}
			else {
				if(pq.isEmpty()) {
					System.out.println("0");
				}
				else {
				Number tmp=pq.poll();
				System.out.println(tmp.x);
				}
			}
		}
	}

}
