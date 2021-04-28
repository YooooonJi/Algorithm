package Programmers;

public class 완전탐색_카펫{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(24,24);
	}
	
	static public int[] solution(int brown, int yellow) {
        int[] answer =new int[2];
        int width=0;
        int height=0;

        //2*x+2*y-4=brown
        //x+y=(brown+4)/2
        //(x-2)*(y-2)=yellow
        
        for (int i =3; i<(brown+4)/2; i++) {
			height=i;
        	width=(brown+4)/2-height;
			
			if(height>width) {
				continue;
			}
			
			if((height-2)*(width-2)==yellow) {
				break;
			}
		}
        
        answer[0]=width;
        answer[1]=height;
        return answer;
    }
	

}
