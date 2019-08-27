package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] bubble = new int[N];
		for (int i = bubble.length -1; i >=1; i--) {
			bubble[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < bubble.length; i++) {
			int temp;
			for(int j=0; j<i; j++) {
				if(bubble[i]>bubble[i+1]) {
					temp=bubble[i];
					bubble[i]= bubble[i+1];
					bubble[i+1]=temp;
				}
			}
			
		}
		for(int i=0; i<bubble.length; i++) {
			System.out.println(bubble[i]);
		}
	}

}
