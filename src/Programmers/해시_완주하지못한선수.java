package Programmers;

import java.util.HashMap;

public class 해시_완주하지못한선수 {
	static String[] participant= {"marina", "josipa", "nikola", "vinko", "filipa"};
	static String[] completion= {"josipa", "filipa", "marina", "nikola"};
	static HashMap<String,Integer> h=new HashMap();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		
		for (int i = 0; i < participant.length; i++) {
			if(h.containsKey(participant[i])) {
				h.replace(participant[i],h.get(participant[i])+1);
			}
			else h.put(participant[i],1);
			
		}
		
		for (int i = 0; i < completion.length; i++) {
			if(h.containsKey(completion[i])) {
				h.replace(completion[i],h.get(completion[i])-1);
			}
		}
		
		
		for (int i = 0; i < participant.length; i++) {
			if(h.get(participant[i])!=0) {
				System.out.println(participant[i]);
				sb.append(participant[i]);
			}
		}
		
		System.out.println(sb.toString());
	}

}
