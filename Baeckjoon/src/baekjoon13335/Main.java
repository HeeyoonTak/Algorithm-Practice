package baekjoon13335;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, w, L;
	public int[] truck;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 트럭 수
		w = Integer.parseInt(st.nextToken()); // 다리 길이
		L = Integer.parseInt(st.nextToken()); // 최대 하중

		int[] truck = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> bridge = new LinkedList(); // 다리
		int time = 0;
		int weight = 0; // 다리 위 트럭 무게
		for (int i = 0; i < n; i++) {
			while (true) {
				if (bridge.isEmpty()) { // 다리에 아무것도 없을 경우
					// 큐에 현재 트럭을 넣고, 시간을 증가, 다리의 무게 증가, while문 빠져나옴
					bridge.offer(truck[i]);
					time++;
					weight+=truck[i];
					break;
				} else if (bridge.size() == w) { // 트럭 수가 다리 길이와 같을 때(꽉 찼을 때)
					// 큐에서 맨 앞 트럭 삭제, 삭제한 트럭만큼 다리 위 트럭 무게 감소
					weight -= bridge.remove();
				} else { // 다리에 트럭이 있을 때
					if(truck[i] + weight > L) { //현재 넣으려는 트럭의 무게와 다리에 있는 트럭의 무게를 합친 것이 최대하중보다 더 크면 큐에 0을 추가해주고, 시간을 증가
						bridge.offer(0);
						time++;
					}else { //현재 넣으려는 트럭의 무게와 다리에 있는 트럭의 무게를 합친 것이 최대하중보다 같거나 작으면 큐에 현재 트럭을 넣고, 시간을 증가, 다리의 무게 증가,while문을 빠져나옴
						bridge.offer(truck[i]);
						time++;
						weight+=truck[i];
						break;
					}
				}
			}
		}
		bw.write(time + w +"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
