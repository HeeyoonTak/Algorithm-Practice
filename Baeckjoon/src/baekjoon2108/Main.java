package baekjoon2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		for(int i=0; i<array.length; i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if(array[j-1]>array[j]) {
					int temp = array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
		int sum=0;
		for(int i=0; i<array.length; i++) {
			sum+=array[i];
		}
		System.out.println(sum/N); //평균
		System.out.println(array[array.length-1/2]); //중간값
		System.out.println();
		System.out.println(((int)Math.abs(array[N-1]-array[0]))); //최대 최소 차이
	}

}
