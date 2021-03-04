package 알고리즘;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class d {

	static class Info{
		int vote, time;
		Info(int vote){
			this.vote = vote;
		}
		Info(int vote, int time){
			this.vote = vote;
			this.time = time;
		}
	}

	static int N, TOTAL_STUDENT;
	static HashMap<Integer, Info> photoFrame = new HashMap<>();
	static ArrayList<Integer> answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		TOTAL_STUDENT = Integer.parseInt(br.readLine());

		solve();

		printAnswer();
	}

	public static void solve() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i=0; i<TOTAL_STUDENT; i++) {
			int vote = 1;
			int studentNum = Integer.parseInt(st.nextToken());

			if(photoFrame.containsKey(studentNum)) {
				vote = photoFrame.get(studentNum).vote + 1;
			}else {
				if(photoFrame.size()>=N) {
					int minVoteKey = getMinVoteKey();
					int minOldestKey = getOldestKey(minVoteKey);
					photoFrame.remove(minOldestKey);
				}
			}

			photoFrame.put(studentNum, new Info(vote));

			increaseTime();
		}
	}

	public static int getMinVoteKey() {
		int minVoteKey = 0;
		int minVote = Integer.MAX_VALUE;

		for(Integer key : photoFrame.keySet()) {
			Info info = photoFrame.get(key);

			if(info.vote < minVote) {
				minVote = info.vote;
				minVoteKey = key;
			}
		}

		return minVoteKey;
	}

	public static int getOldestKey(int minVoteKey) {
		int oldestKey = minVoteKey;
		Info minVoteInfo = photoFrame.get(minVoteKey);

		for(Integer key : photoFrame.keySet()) {
			Info info = photoFrame.get(key);

			if(info.vote==minVoteInfo.vote && info.time>=minVoteInfo.time) {
				minVoteInfo = info;
				oldestKey = key;
			}
		}

		return oldestKey;
	}

	public static void increaseTime() {
		for(Integer key : photoFrame.keySet()) {
			Info info = photoFrame.get(key);
			info.time++;

			photoFrame.put(key, new Info(info.vote, info.time));
		}
	}

	public static void printAnswer() {
		answer = new ArrayList<Integer>(photoFrame.keySet());
		Collections.sort(answer);
		for(Integer ans : answer) {
			System.out.print(ans + " ");
		}
	}

}