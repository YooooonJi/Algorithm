package 알고리즘개념정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다익스트라 {
	
	static int distance[]; //각 정점의 최단경로 저장할 배열
	static boolean checked[];//정점에 방문했는지 여부
	static int arr[][];//가중치 
	static int V,E,K;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(br.readLine());
		
		distance=new int[V+1];
		checked=new boolean[V+1];
		arr=new int[V+1][V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE); //거리값 최대로 초기화
		
		//1.초기화
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			
			if(arr[start][end]<weight) {
			arr[start][end]=weight;
			}
		}
		
		//2.시작하는 정점 초기화
		distance[K]=0;
		checked[K]=true;
		
		//3.시작 정점이랑 연결된 정점 distance 갱신
		for (int i = 1; i < V+1; i++) {
			if(arr[K][i]!=0&&checked[i]!=true) {
				distance[i]=arr[K][i];
			}
		}
		
		//4.최단경로 찾기
		//1)현재 distance배열 중 가장 작은 값 찾기
		//2)가장 작은값 인덱스의 checked를 true로 갱신
		//3)가장 작은값 인덱스와 연결된 정점 distance 갱신
		//4)갱신 시, distance[연결된 정점]>distance[가장 작은값 인덱스]+arr[가장 작은값 인덱스][연결된 정점] 이면
		//distance[연결된 정점]=distance[가장 작은값 인덱스]+arr[가장 작은값 인덱스][연결된 정점] 갱신
		
		for (int i = 0; i < V-1; i++) {
			
			int min=Integer.MAX_VALUE;
			int min_idx=0;
			
			//1)현재 distance배열 중 가장 작은 값 찾기
			for (int j =1; j <V+1; j++) {
				if(distance[j]<min&&checked[j]!=true) {
					min=distance[j];
					min_idx=j;
				}
			}
			
			//2)가장 작은값 인덱스의 checked를 true로 갱신
			checked[min_idx]=true;
			
			//3)가장 작은값 인덱스와 연결된 정점 distance 갱신
			for (int j = 1; j <V+1; j++) {
				//4)갱신 시, distance[연결된 정점]>distance[가장 작은값 인덱스]+arr[가장 작은값 인덱스][연결된 정점] 이면
				//distance[연결된 정점]=distance[가장 작은값 인덱스]+arr[가장 작은값 인덱스][연결된 정점] 갱신
				if(arr[min_idx][j]!=0&&checked[j]!=true) {
					if(distance[j]>distance[min_idx]+arr[min_idx][j]) {
						distance[j]=distance[min_idx]+arr[min_idx][j];
					}
				}
			}
			
		}
		
		for (int i = 1; i < V+1; i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
			System.out.println(distance[i]);
			}
		}

	}

}
