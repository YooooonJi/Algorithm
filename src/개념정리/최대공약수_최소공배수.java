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
		
		System.out.println("�ִ�����:"+gcd(x,y));
		System.out.println("�ּҰ����:"+lcm(x,y));
	}
	
	//gcd-�ִ�����
	//x�� y�� ���� �������� 0���� Ŭ���� �ݺ�
	static int gcd(int x,int y){
		while(y!=0) {
			int tmp=x%y;
			x=y;
			y=tmp;
		}
		return x;
	}
	
	
	//lcm_�ּҰ����
	//x,y�� ���� �ִ������� ������.
	static int lcm(int x,int y) {
		int gcd=gcd(x,y);
		return x*y/gcd;
	}

}
