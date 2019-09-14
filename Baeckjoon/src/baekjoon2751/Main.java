package baekjoon2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] quick = new int[Integer.parseInt(br.readLine())];
		//베열에 저장
		for(int i=0; i<quick.length; i++) {
			quick[i]=Integer.parseInt(br.readLine());
		}
		
	}
}
