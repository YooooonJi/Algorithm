package Programmers;

public class 완전탐색_카펫{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(24,24);
	}
	
	static public int[] solution(int brown, int yellow) {
        int[] answer =new int[2];
        
        double x1=((brown/2+2)+Math.sqrt(Math.pow(brown/2+2,2)-4*(brown+yellow)))/2;
        double y1=brown/2+2-x1;

        answer[0]=(int)x1;
        answer[1]=(int)y1;
        return answer;
    }
	

}
