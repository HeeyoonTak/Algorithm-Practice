package baeckjoon11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] location = new int[N][2];
		for(int i=0; i<location.length; i++) {
			location[i][0]=Integer.parseInt(br.readLine());
			location[i][0]=Integer.parseInt(br.readLine());
		}
	}

}
