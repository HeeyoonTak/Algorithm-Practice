package baekjoon1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		// 큐에 숫자 대입
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (queue.size() != 1) {
			for (int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}
			//큐에 하나 남기 전까지 옮겨 담는다
			sb.append(queue.poll() + ", ");
		}

		//마지막 하나 남은 원소 추가하고 괄호 닫기
		sb.append(queue.poll() + ">");
		bw.write(sb.toString() + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

}
