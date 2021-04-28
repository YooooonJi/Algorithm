package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class dfsbfs_여행경로 {
	static PriorityQueue<String> pq=new PriorityQueue<String>();
	static HashMap<String,Integer> hm=new HashMap<String,Integer>();
	static HashMap<Integer,String> hm2=new HashMap<Integer,String>();
	
	static int[][] arr;
	static boolean[][] visited;
	static int ticket_num=0,ticket_tmp=1;
	static String[] answer;
	static boolean flag=false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		String[][] tickets= {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}  };
		solution(tickets);
	}
	
	static public String[] solution(String[][] tickets) {
	        
	        for (int i = 0; i < tickets.length; i++) {
				for (int j = 0; j < 2; j++) {
					if(!pq.contains(tickets[i][j])) {
					pq.add(tickets[i][j]);
					}
				}
			}
	        int size=pq.size();
	        arr=new int[size][size];
	        visited=new boolean[size][size];
	        
	        int num=0;
	        while(!pq.isEmpty()) {
	        	String tmp=pq.poll();
	        	System.out.println(tmp);
	        	hm.put(tmp, num);
	        	hm2.put(num,tmp);
	        	num++;
	        }
	        
	        for (int i = 0; i < tickets.length; i++) {
	        	if(arr[hm.get(tickets[i][0])][hm.get(tickets[i][1])]!=1) {
	        		ticket_num++;
	        		arr[hm.get(tickets[i][0])][hm.get(tickets[i][1])]=1;
	        	}
			}	     
	        
	        ArrayList<String> list=new ArrayList<String>();
	        
	        dfs(hm.get("ICN"),0,list);
	        
	        return answer;
	    }
	
	static void dfs(int start,int ticket_tmp,ArrayList<String> list) {
		list.add(hm2.get(start));
		for(int i=0;i<arr.length;i++) {
			if(arr[start][i]==1&&visited[start][i]!=true) {
				visited[start][i]=true;
				dfs(i,ticket_tmp+1,list);
				list.remove(list.size()-1);
				visited[start][i]=false;
			}
		}
		
		if(flag==false&&ticket_tmp==ticket_num) {
			flag=true;
			answer = list.toArray(new String[list.size()]);
		}
		
	}
}
