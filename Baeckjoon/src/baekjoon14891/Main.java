package baekjoon14891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static int[][] wheel = new int[4][8];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = line.charAt(j) - '0';
			}
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int who = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			if (dir == 1) {
				if (who < 3) {
					for (int i1 = who; i1 < 3; i1++) {
						if(checkRight(i1)) {
							changeDir(dir);
							
						}
					}
					if(who > 0) {
						
					}
					rightRotation(who);
				}
			}
		}
	}

	public static void changeDir(int dir) {
		if(dir == 1) {
			dir = -1;
		}else {
			dir = 1;
		}
	}
	
	public static void rightRotation(int who) {
		int temp = wheel[who][7];
		for (int i = 7; i >= 0; i--) {
			wheel[who][i] = wheel[who][i - 1];
		}
		wheel[who][0] = temp;
	}

	public static void leftRotation(int who) {
		int temp = wheel[who][0];
		for (int i = 0; i < 7; i++) {
			wheel[who][i] = wheel[who][i + 1];
		}
		wheel[who][7] = temp;
	}

	public static void rotate(int who, int dir) {
		if(dir == 1) {
			rightRotation(who);
		}else {
			leftRotation(who);
		}
	}
	
	public static boolean checkRight(int who) {
		if (wheel[who][2] == wheel[who + 1][6]) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkLeft(int who) {
		if (wheel[who][6] == wheel[who - 1][3]) {
			return true;
		} else {
			return false;
		}
	}

//	public static boolean check(int i) {
//		 if(wheel[i][2] == )
//	}
}
