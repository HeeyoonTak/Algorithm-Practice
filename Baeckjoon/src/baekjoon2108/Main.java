package baekjoon2108;
//통계학
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.
*/
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		
		bw.write(sum/N); //평균
		bw.write(array[array.length-1/2]); //중간값
		System.out.println();
		bw.write(((int)Math.abs(array[N-1]-array[0]))); //최대 최소 차이
	}

}
