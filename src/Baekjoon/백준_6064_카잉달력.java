package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_6064_카잉달력 {
	static int T,M,N,x,y,num;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T=Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			num=0;
			
			for (int j = 0; j < N; j++) {
				num=x+M*j;
				if(y==num%N) {
					break;
				}
			}
			
			if(num>lcm(M,N)) {
				System.out.println("-1");
			}
			else System.out.println(num);
			
		}
	}
	
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
