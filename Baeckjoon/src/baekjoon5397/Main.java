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

			// str에서 담을 메인 스택
			Stack<Character> s1 = new Stack<>();
			// 필요시 s1에서 옮겨둘 스택
			Stack<Character> s2 = new Stack<>();

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '<') { // <에서는 s1에서 s2로 빼놓고
					if (!s1.isEmpty()) {
						s2.push(s1.pop());
					}
				} else if (str.charAt(j) == '>') { // >일때 s2 배열에서 s1으로 이동
					if (!s2.isEmpty()) {
						s1.push(s2.pop());
					}
				} else if (str.charAt(j) == '-') { // -에선 s1 pop
					if (!s1.isEmpty()) {
						s1.pop();
					}
				} else {
					s1.push(str.charAt(j)); // 일반 문자들은 str에서 s1으로
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			// >없어서 s1으로 못 넘긴거 넘기는 작업
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
