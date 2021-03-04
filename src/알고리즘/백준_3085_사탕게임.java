package 알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_3085_사탕게임 {
	static int N,answer=Integer.MIN_VALUE;
	static int arr[][];
	static boolean visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	public static void main(String[] args)throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp=br.readLine();
			for (int j = 0; j <N; j++) {
				Character tmp2=tmp.charAt(j);
				if(tmp2=='C') {
					arr[i][j]=1;
				}
				else if(tmp2=='P') {
					arr[i][j]=2;
				}
				else if(tmp2=='Z') {
					arr[i][j]=3;
				}
				else if(tmp2=='Y') {
					arr[i][j]=4;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check(i,j);
			}
		}
		
		System.out.println(answer);
	}
	
	static void check(int x,int y) {
		dfs(0,0,1);
		
		for (int i = 0; i < 4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0||ny<0|nx>=N||ny>=N) continue;
			
			if(arr[nx][ny]!=arr[x][y]) {//서로 다른 숫자면
				int tmp=arr[x][y];//바꿈
				arr[x][y]=arr[nx][ny];
				arr[nx][ny]=tmp;
				
				for (int j = 0; j <N; j++) {
					for (int k = 0; k < N; k++) {
						dfs(j,k,1);
					}
				}
				
				arr[nx][ny]=arr[x][y];
				arr[x][y]=tmp;
			}		
		}
	}
	
	static void dfs(int x,int y,int depth) {
		
		if(x>=N&&y>=N) {
			return;
		}
		
		for (int i = 0; i <4; i++) {
			depth=1;
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<0||ny<0|nx>=N||ny>=N) continue;
			
				while(arr[x][y]==arr[nx][ny]) {
					x=nx;
					y=ny;
					nx+=dx[i];
					ny+=dy[i];
					answer=Math.max(answer,++depth);
					if(nx<0||ny<0|nx>=N||ny>=N) break;
				}
				
		}
	}

}
