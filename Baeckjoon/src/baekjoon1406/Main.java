package baekjoon1406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine(); // 초기 입력 문자열

		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();

		int tc = Integer.parseInt(br.readLine()); // 입력할 명령어 갯수(테스트케이스 갯수)

		for (int i = 0; i < str.length(); i++) {
			s1.push(str.charAt(i));
		}

		for (int i = 0; i < tc; i++) {
			String command = br.readLine();
			if (command.startsWith("L")) {
				if (!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			} else if (command.startsWith("D")) {
				if (!s2.isEmpty()) {
					s1.push(s2.pop());
				}
			} else if (command.startsWith("B")) {
				if (!s1.isEmpty()) {
					s1.pop();
				}
			} else if (command.startsWith("P")) {
				String[] stringArray = command.split(" ");
				s1.push(stringArray[1].toCharArray()[0]);
			}
		}

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		while(!s2.isEmpty()) {
			bw.write(s2.pop());
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
