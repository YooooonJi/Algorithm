package 개념정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수_최소공배수 {
	static int x,y;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		
		System.out.println("최대공약수:"+gcd(x,y));
		System.out.println("최소공배수:"+lcm(x,y));
	}
	
	//gcd-최대공약수
	//x를 y로 나눈 나머지가 0보다 클동안 반복
	static int gcd(int x,int y){
		while(y!=0) {
			int tmp=x%y;
			x=y;
			y=tmp;
		}
		return x;
	}
	
	
	//lcm_최소공배수
	//x,y의 곱을 최대공약수로 나눈다.
	static int lcm(int x,int y) {
		int gcd=gcd(x,y);
		return x*y/gcd;
	}

}
