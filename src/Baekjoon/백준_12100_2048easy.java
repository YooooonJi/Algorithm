package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12100_2048easy {
	
	static int N,max=Integer.MIN_VALUE;
	static int arr[][];
	static int tmpArr[][];
	static int tgt[]=new int[5];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static boolean flag=false;
	//��0(��),��1(��),��2(��),��3(��)
	//��->��, ��->��, ��->��, ��->��
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		tmpArr=new int[N][N];
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				tmpArr[i][j]=arr[i][j];
			}
		}
		
		
		
		//�����¿� permutation
		permutation(0);
		
//		for (int i = 0; i <5; i++) {
//			move(tgt[i]);
//			System.out.println("move");
//			for (int a= 0; a <N; a++) {
//				for (int b = 0; b < N; b++) {
//					System.out.print(arr[a][b]+" ");
//				}
//				System.out.println();
//			}
//			merge(tgt[i]);
//			System.out.println("merge");
//			for (int a= 0; a <N; a++) {
//				for (int b = 0; b < N; b++) {
//					System.out.print(arr[a][b]+" ");
//				}
//				System.out.println();
//			}
//			
//			move(tgt[i]);
//			System.out.println("2move");
//			for (int a= 0; a <N; a++) {
//				for (int b = 0; b < N; b++) {
//					System.out.print(arr[a][b]+" ");
//				}
//				System.out.println();
//			}
//			
//		}
		
		System.out.println(max);
	}
	
	static void permutation(int tgt_idx) {
		if(tgt_idx==5) {
			for (int i = 0; i <5 ; i++) {
				//System.out.println(tgt[i]);
				move(tgt[i]);
				merge(tgt[i]);
				move(tgt[i]);
				
//				for (int j = 0; j <N; j++) {
//					for (int j2 = 0; j2 < N; j2++) {
//						max=Math.max(max,arr[j][j2]);
//						System.out.print(arr[j][j2]+" ");
//					}
//					System.out.println();
//				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j<N; j++) {
					arr[i][j]=tmpArr[i][j];
				}
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			tgt[tgt_idx]=i;
			permutation(tgt_idx+1);
		}
	}
	
	static void move(int moveNum) {
		switch (moveNum) {
		case 0://��
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if(arr[i][j]!=0) {
						moveCheck(i,j,i,j,moveNum);
						max=Math.max(max,arr[i][j]);
					}
				}
			}
			break;
		case 1://��
			for (int j = 0; j < N; j++) {
				for (int i =N-1; i >=0; i--) {
					if(arr[i][j]!=0) {
						moveCheck(i,j,i,j,moveNum);
						max=Math.max(max,arr[i][j]);
					}
				}
			}
			break;
		case 2://��
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]!=0) {
						moveCheck(i,j,i,j,moveNum);
						max=Math.max(max,arr[i][j]);
					}
				}
			}
			break;
		case 3://��
			for (int i = 0; i <N; i++) {
				for (int j = N-1; j >=0 ; j--) {
					if(arr[i][j]!=0) {
						moveCheck(i,j,i,j,moveNum);
						max=Math.max(max,arr[i][j]);
					}
				}
			}
			break;
		}
//		if(max==128&&flag==false) {
//			for (int i = 0; i < 5; i++) {
//				System.out.print(tgt[i]);
//			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j <N; j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
//			flag=true;
//			System.out.println();
//		}
	}
	
	static void merge(int moveNum) {
		switch (moveNum) {
		case 0:
			for (int j = 0; j < N; j++) {
				mergeCheck(0,j,1);
			}
			break;
		case 1:
			for (int j = 0; j < N; j++) {
				mergeCheck(N-1,j,0);
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				mergeCheck(i,0,3);
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				mergeCheck(i,N-1,2);
			}
			break;
		default:
			break;
		}
	}
	static void mergeCheck(int i,int j,int moveNum) {
		int nx=i+dx[moveNum];
		int ny=j+dy[moveNum];
		if(i<0||j<0||i>=N||j>=N) return;
		if(nx<0||ny<0||nx>=N||ny>=N) return;
		
		if(arr[i][j]!=0) {
			if(arr[i][j]==arr[nx][ny]) {
				arr[i][j]*=2;
				arr[nx][ny]=0;
				mergeCheck(nx+dx[moveNum],ny+dy[moveNum],moveNum);
			}
			else {
				mergeCheck(nx,ny,moveNum);
			}
		}
	}

	
	static void moveCheck(int iOrigin,int jOrigin,int i,int j,int moveNum) {
		int nx=i+dx[moveNum];
		int ny=j+dy[moveNum];
	
		if(nx<0||ny<0||nx>=N||ny>=N) {
			nx-=dx[moveNum];
			ny-=dy[moveNum];
			if(arr[nx][ny]==0) {
				arr[nx][ny]=arr[iOrigin][jOrigin];
				arr[iOrigin][jOrigin]=0;	
			}
			return;
		}
		
		if(arr[nx][ny]==0) {
			moveCheck(iOrigin,jOrigin,nx,ny,moveNum);
		}
		else {
			nx-=dx[moveNum];
			ny-=dy[moveNum];
			if(!(nx==iOrigin&&ny==jOrigin)) {
				arr[nx][ny]=arr[iOrigin][jOrigin];
				arr[iOrigin][jOrigin]=0;
				}
		}
	}
//	static void moveCheck(int i,int j,int moveNum) {
//		if(arr[i][j]!=0) {
//			int nx=i+dx[moveNum];
//			int ny=j+dy[moveNum];
//			
//			while (true) {
//				if(nx<0||ny<0||nx>=N||ny>=N)  {
//					nx-=dx[moveNum];
//					ny-=dy[moveNum];
//					if(arr[nx][ny]==0) {
//						arr[nx][ny]=arr[i][j];
//						arr[i][j]=0;
//					}
//					break;
//				}
//				
//				if(arr[nx][ny]!=0) {
//					nx-=dx[moveNum];
//					ny-=dy[moveNum];
//					//System.out.println("movecheck"+nx+" "+ny+" "+i+" "+j);
//					if(!(nx==i&&ny==j)) {
//					arr[nx][ny]=arr[i][j];
//					arr[i][j]=0;
//					}
//					break;
//				}
//				nx+=dx[moveNum];
//				ny+=dy[moveNum];
//			}
//		}
//	}

}
