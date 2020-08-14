package baekjoon5397;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();

			// str���� ���� ���� ����
			Stack<Character> s1 = new Stack<>();
			// �ʿ�� s1���� �Űܵ� ����
			Stack<Character> s2 = new Stack<>();

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '<') { // <������ s1���� s2�� ������
					if (!s1.isEmpty()) {
						s2.push(s1.pop());
					}
				} else if (str.charAt(j) == '>') { // >�϶� s2 �迭���� s1���� �̵�
					if (!s2.isEmpty()) {
						s1.push(s2.pop());
					}
				} else if (str.charAt(j) == '-') { // -���� s1 pop
					if (!s1.isEmpty()) {
						s1.pop();
					}
				} else {
					s1.push(str.charAt(j)); // �Ϲ� ���ڵ��� str���� s1����
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			// >��� s1���� �� �ѱ�� �ѱ�� �۾�
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			
			while(!s1.isEmpty()) {
				sb.append(s1.pop());
			}
			System.out.println(sb.reverse());
		}
	}
}
