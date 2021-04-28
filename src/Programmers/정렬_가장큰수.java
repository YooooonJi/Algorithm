package Programmers;

import java.util.PriorityQueue;

public class 정렬_가장큰수 {
	static int number[]= {3,30,34,5,9};
	static String answer;
	static PriorityQueue<Num> pq=new PriorityQueue<Num>();
	static public class Num implements Comparable<Num>{
		 int num1;
		

		public Num(int num1) {
			this.num1 = num1;
		}

		
	
		
		@Override
		public int compareTo(Num o) {
			int num1=Integer.parseInt(Integer.toString(this.num1)+Integer.toString(o.num1));
			int num2=Integer.parseInt(Integer.toString(o.num1)+Integer.toString(this.num1));
			System.out.println(this.num1+" "+o.num1);
			System.out.println(num1+" "+num2);
			if(num1>=num2) {
				System.out.println("num1");
				return -1;//������ �ٲ� (this�� ù��°)
			}
			else
				return 1;//�ȹٲ�� �״�� 
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i <number.length; i++) {
			Num num=new Num(number[i]);
			pq.add(num);
		}
		
		StringBuilder result=new StringBuilder();
		
		while(!pq.isEmpty()) {
			Num n=pq.poll();
			result.append(n.num1);
		}
		
		System.out.println(result);
	}

}
