package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 완전탐색_모의고사{

	static int answers[]= {1,3,2,4,2};
	static PriorityQueue<Point> pq=new PriorityQueue<Point>();
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static int[] answer;
	static public class Point implements Comparable<Point>{
		int number,cnt;
		
		public Point(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}
		public int compareTo(Point o) {
			return o.cnt-this.cnt;
		}	
	}
	
	public static void main(String[] args) {
		solution(answers);
	}
	
	static public int[] solution(int[] answers) {
        
        int[] result= new int[3];
        int[] supo1=new int[10000];
        int[] supo2=new int[10000];
        int[] supo3=new int[10000];
        int supo1_Num=1;
        int[] supo2_tmp= {1,3,4,5};
        int supo2_Num=0;
        int[] supo3_tmp= {3,1,2,4,5};
        int supo3_Num=0;
        
        for (int i = 0; i < 10000; i++) {
        	//1�� ������
        	supo1[i]=supo1_Num++;
        	if(supo1_Num==6) supo1_Num=1;
        	
			//2�� ������
        	if(i%2==0) {
        		supo2[i]=2;
        	}
        	else {
        		supo2[i]=supo2_tmp[supo2_Num%4];
        		supo2_Num++;
        	}
        	//3�� ������
        	supo3[i]=supo3_tmp[supo3_Num%5];
			if(i%2==1) supo3_Num++;
		}
   
        for (int i = 0; i < answers.length; i++) {
			if(supo1[i]==answers[i]) result[0]++;
			if(supo2[i]==answers[i]) result[1]++;
			if(supo3[i]==answers[i]) result[2]++;
		}
        
        for (int i = 0; i < 3; i++) {
			pq.add(new Point(i+1,result[i]));
		}
        
        int max=pq.peek().cnt;
        while(!pq.isEmpty()) {
        	Point now=pq.poll();
        	if(max==now.cnt) {
        	list.add(now.number);
        	}
        }
        
        answer=new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
			answer[i]=list.get(i);
			System.out.println(answer[i]);
		}
        
        Arrays.sort(answer);
        return answer;
    }
	

}
