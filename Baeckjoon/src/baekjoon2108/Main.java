package baekjoon2108;
//�����
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
ù° �ٿ��� �������� ����Ѵ�. �Ҽ��� ���� ù° �ڸ����� �ݿø��� ���� ����Ѵ�.

��° �ٿ��� �߾Ӱ��� ����Ѵ�.

��° �ٿ��� �ֺ��� ����Ѵ�. ���� �� ���� ������ �ֺ� �� �� ��°�� ���� ���� ����Ѵ�.

��° �ٿ��� ������ ����Ѵ�.
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
		
		bw.write(sum/N); //���
		bw.write(array[array.length-1/2]); //�߰���
		System.out.println();
		bw.write(((int)Math.abs(array[N-1]-array[0]))); //�ִ� �ּ� ����
	}

}
