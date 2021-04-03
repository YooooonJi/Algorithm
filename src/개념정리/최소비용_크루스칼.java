package 알고리즘개념정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
 */
public class 최소비용_크루스칼 {

	static public class Edge implements Comparable <Edge> {
		int from,to,weight;

	public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {//가중치로 크기 비교
			return this.weight-o.weight;
		}
	}
	static int N,M,answer,use_num;//N 정점개수, M간선개수
	static Edge[] list;
	static int parents[];
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		list=new Edge[M];//간선들 저장할 배열
		parents=new int[N];//부모가 누구인지 표현할 배열
		
		for (int i = 0; i <M; i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			list[i]=new Edge(from-1,to-1,weight);
		}
		
		//step1.가중치가 적은 순으로 확인할 수 있도록 list를 정렬시켜준다
		Arrays.sort(list);
		
		//step2.자기자신을 부모로 가르키는 정점들 생성
		make();
		
		//step3. 배열에 저장되어있는 간선들을 뽑으며,싸이클을 이루지 않을경우 이어준다
		for (int i = 0; i < list.length; i++) {
			if(union(list[i].from,list[i].to)) {
				answer+=list[i].weight;
				use_num++;
				if(use_num==N-1) break; //정점이 N개이면 최소 간선수는 N-1개, 즉 최소간선수랑 뽑은 간선 수가 같으면
 			}
		}
		System.out.println(answer);
	}
	
	//자기자신을 부모로 가르키는 정점들 만들어준다.
	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int i) {
		if(i==parents[i]) return i;//자기 자신이 부모일경우, 자기 자신 리턴
		return parents[i]=find(parents[i]);//재귀로 루트노드까지 타고 타고 들어가서 찾음
	}

	static boolean union(int a,int b) {
		int a_root=find(a);
		int b_root=find(b);
		
		if(a_root==b_root) return false; //같은 부모를 가져 연결하면 사이클이 생성되므로
		else {
			parents[a]=b;//한 개가 나머지 하나의 부모를 가리킨다.
			return true;
		}
	}
}
