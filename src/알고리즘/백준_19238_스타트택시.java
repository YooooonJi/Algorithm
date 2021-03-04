package �˰���;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ����_19238_��ŸƮ�ý� {
	static int N,M,oil,distance;
	static int taxi_x,taxi_y;
	static Variety map[][];
	static boolean visited[][];
	static Point flag[];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static Queue<Point> queue=new LinkedList<Point>();
	static PriorityQueue<Point> pq=new PriorityQueue<Point>();
	
	static public class Point implements Comparable<Point>{
		int x,y,depth;

		public Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

		public int compareTo(Point p) {
			if(this.depth==p.depth) {
				if(this.x==p.x) {
					if(this.y>p.y) {
						return 1;
					}
					else return -1;
				}
				else if(this.x>p.x) {
					return 1;
				}
				else return -1;
			}
			else if(this.depth>p.depth) {
				return 1;
			}
			else return -1;
		}
		
	}
	
	static public class Variety{
		int type,number;

		public Variety(int type,int number) {
			this.type = type;//0:�ϰ͵�����, 1:��, 2:���
			this.number = number;//��ȣ
		}
	}
	
	public static void main(String[] args)throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		oil=Integer.parseInt(st.nextToken());
		
		map=new Variety[N+1][N+1];
		flag=new Point[M+1];
		
		for (int i = 1; i <N+1; i++) {
			 st=new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				int num=Integer.parseInt(st.nextToken());
				if(num==0) map[i][j]=new Variety(0,0);
				else map[i][j]=new Variety(1,0);
			}
		}
		
		st=new StringTokenizer(br.readLine());
		taxi_x=Integer.parseInt(st.nextToken());
		taxi_y=Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int person_x=Integer.parseInt(st.nextToken());
			int person_y=Integer.parseInt(st.nextToken());
			int flag_x=Integer.parseInt(st.nextToken());
			int flag_y=Integer.parseInt(st.nextToken());
			map[person_x][person_y]=new Variety(2,i+1);
			//map[flag_x][flag_y]=new Variety(3,i+1);
			//flag�迭�� x,y,����� �Ÿ� �־���
			flag[i+1]=new Point(flag_x,flag_y,0);
		}
		
		while(oil>0&&M>0) {
			pq.clear();
			queue.clear();
			//1. ����� �ý��� �ִܰŸ� ���ϱ�
			bfs();
			
			//2.���� ����� ��� ã��, ���������� �̵�
			
			if(pq.isEmpty()==true) {
				System.out.println("-1");
				return;
			}
			Point person=pq.poll();
			
			oil-=person.depth;//��� �ڸ����� �̵�
			
			if(oil<0) {//���� �ٴ�?
				System.out.println("-1");
				return;
			}
			
			int number=map[person.x][person.y].number;//������ �ѹ�
			
			visited=new boolean[N+1][N+1];
			boolean avail=check(person.x,person.y,flag[number].x,flag[number].y);//���������� �����ִ���
			if(avail==false) {
				System.out.println("-1");
				return;
			}
			
			oil=oil-distance;//���������� �̵�
			taxi_x=flag[number].x;
			taxi_y=flag[number].y;
			
			if(oil<0) {//���� �ٴ�?
				System.out.println("-1");
				return;
			}
			
			map[person.x][person.y]=new Variety(0,0);
			M--;
			
			//���� ����
			oil=oil+2*(distance);		
		}
		
		System.out.println(oil);
	}
	
	static boolean check(int x,int y,int f_x,int f_y) {
		distance=0;
		queue.add(new Point(x,y,0));
		
		while(!queue.isEmpty()) {
			Point now=queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				//���� �����ų�, ���̰ų�, visit������
				if(nx>=N+1||ny>=N+1||nx<1||ny<1||map[nx][ny].type==1||visited[nx][ny]==true) continue;
				visited[nx][ny]=true;
				if(nx==f_x&&ny==f_y) {
					distance=now.depth+1;
					return true;
				}
				queue.add(new Point(nx,ny,now.depth+1));
			}
		}
		return false;
	}
	
	static void bfs() {
		visited=new boolean[N+1][N+1];
		queue.add(new Point(taxi_x,taxi_y,0));
		
		if(map[taxi_x][taxi_y].type==2) {//����̸�
			pq.add(new Point(taxi_x,taxi_y,0));
		}
		
		while(!queue.isEmpty()) {
			Point now=queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				//���� �����ų�, ���̰ų�, visit������
				if(nx>=N+1||ny>=N+1||nx<1||ny<1||map[nx][ny].type==1||visited[nx][ny]==true) continue;
				visited[nx][ny]=true;
				queue.add(new Point(nx,ny,now.depth+1));
				if(map[nx][ny].type==2) {//����̸�
					//System.out.println(nx+" "+ny+" "+(now.depth+1));
					pq.add(new Point(nx,ny,now.depth+1));
				}
			}
		}
	}

}
