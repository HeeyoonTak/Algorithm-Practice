package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] bubble = new int[N];
		int temp;
		for (int i = 0; i < bubble.length; i++) {
			bubble[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < bubble.length; i++) {
			for (int j = 1; j < bubble.length; j++) {
				if(bubble[j-1]>bubble[j]) {
					temp=bubble[j];
					bubble[j]=bubble[j-1];
					bubble[j-1]=temp;
				}
			}
		}
		/*
		 * for (int i = bubble.length ; i >= 1; i--) { int temp; for (int j = 1; j <
		 * bubble.length; j++) { if (bubble[i] > bubble[i + 1]) { temp = bubble[i];
		 * bubble[i] = bubble[i + 1]; bubble[i + 1] = temp; } }
		 * 
		 * }
		 */
		for (int i = 0; i < bubble.length; i++) {
			System.out.println(bubble[i]);
		}
	}

}
