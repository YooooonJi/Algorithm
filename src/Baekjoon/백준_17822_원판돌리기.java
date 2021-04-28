package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_17822_원판돌리기 {
	static int N,M,T,answer;
	static int xi,di,ki;
	static int arr[][];
	static boolean visited[][];
	static boolean flag;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args)throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][M+1];
		visited=new boolean[N+1][M+1];
		
		for (int i = 1; i <=N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j <=M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for (int test = 0; test< T; test++) {
			
			st=new StringTokenizer(br.readLine());
			xi=Integer.parseInt(st.nextToken());
			di=Integer.parseInt(st.nextToken());
			ki=Integer.parseInt(st.nextToken());
			
			//1. xi�� ����� ���� ������
			for (int i =1; i <= N/xi; i++) {
				Deque<Integer> deque=new ArrayDeque<Integer>();
				for (int j = 1; j <=M; j++) {
					deque.add(arr[i*xi][j]);
				}
				
				if(di==0) {
				//�ð����	
					for (int j = 0; j <ki; j++) {
						int tmp=deque.removeLast();
						deque.addFirst(tmp);
					}
				}
				else {
				//�ݽð����
					for (int j = 0; j <ki; j++) {
						int tmp=deque.removeFirst();
						deque.addLast(tmp);
					}
				}
				
				//���� �� �ٽ� �־��ֱ�
				for (int j = 1; j <=M; j++) {
					arr[i*xi][j]=deque.poll();
				}
				
			}
			
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= M; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();a
//			}
//			System.out.println();
			
			flag=false;
			visited=new boolean[N+1][M+1];
			//2. ���� �� ������ ã��
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(arr[i][j]!=0) {
						check(i,j);
					}
				}
			}
			
			//3. �����¿� �� üũ
			for (int i = 1; i <= M; i++) {
				for (int j = 1; j <=N-1; j++) {
					if(arr[j][i]!=0&&arr[j][i]==arr[j+1][i]) {
						flag=true;
						visited[j][i]=true;
						visited[j+1][i]=true;
					}	
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(arr[i][1]!=0&&arr[i][1]==arr[i][M]) {
					flag=true;
					visited[i][1]=true;
					visited[i][M]=true;
				}
			}
			

			
			//true�ΰ� ������
			int sumAllNum=0;
			int cntNum=0;
			answer=0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					//���ڰ� �����ϸ� ���� ���ֱ�
					if(arr[i][j]!=0) cntNum++;
					
					sumAllNum+=arr[i][j];
					
					if(visited[i][j]==true) {
						//true�̸� 0���� ������
						arr[i][j]=0;
					}
					else {
						answer+=arr[i][j];
					}
				}
			}
			
			
			//true�� �������
			//���� �� �ϳ��� ������ ���-1, +1
			if(flag==false) {
				answer=0;
				double everage=(double)sumAllNum/cntNum;
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= M; j++) {
						if(arr[i][j]!=0) {
							if(arr[i][j]<everage) {
								answer+=++arr[i][j];
							}
							else if(arr[i][j]>everage) {
								answer+=--arr[i][j];
							}
						}
					}
				}
			}
//			
//			System.out.println("+++++++++++���� �� +++++++++++++++");
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= M; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			
			
		}
		System.out.println(answer);
		
	}
	
	static void check(int x,int y) {
		for (int i = 0; i < 4; i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			
			//���� ����� ����
			if(nx<1||ny<1||nx>N||ny>M) continue;
			
			if(arr[x][y]==arr[nx][ny]) {
				//������
				flag=true;
				visited[x][y]=true;
				visited[nx][ny]=true;
			}
		}
	}

}
