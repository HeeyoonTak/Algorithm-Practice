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

		n = Integer.parseInt(st.nextToken()); // Ʈ�� ��
		w = Integer.parseInt(st.nextToken()); // �ٸ� ����
		L = Integer.parseInt(st.nextToken()); // �ִ� ����

		int[] truck = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> bridge = new LinkedList(); // �ٸ�
		int time = 0;
		int weight = 0; // �ٸ� �� Ʈ�� ����
		for (int i = 0; i < n; i++) {
			while (true) {
				if (bridge.isEmpty()) { // �ٸ��� �ƹ��͵� ���� ���
					// ť�� ���� Ʈ���� �ְ�, �ð��� ����, �ٸ��� ���� ����, while�� ��������
					bridge.offer(truck[i]);
					time++;
					weight+=truck[i];
					break;
				} else if (bridge.size() == w) { // Ʈ�� ���� �ٸ� ���̿� ���� ��(�� á�� ��)
					// ť���� �� �� Ʈ�� ����, ������ Ʈ����ŭ �ٸ� �� Ʈ�� ���� ����
					weight -= bridge.remove();
				} else { // �ٸ��� Ʈ���� ���� ��
					if(truck[i] + weight > L) { //���� �������� Ʈ���� ���Կ� �ٸ��� �ִ� Ʈ���� ���Ը� ��ģ ���� �ִ����ߺ��� �� ũ�� ť�� 0�� �߰����ְ�, �ð��� ����
						bridge.offer(0);
						time++;
					}else { //���� �������� Ʈ���� ���Կ� �ٸ��� �ִ� Ʈ���� ���Ը� ��ģ ���� �ִ����ߺ��� ���ų� ������ ť�� ���� Ʈ���� �ְ�, �ð��� ����, �ٸ��� ���� ����,while���� ��������
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
