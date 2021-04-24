package baekjoon_java.StepByStepProblem.bruteForce;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		int card[] = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		sc.close();
		int result = search(card, N, M);
		System.out.println(result);
		
	}
	static int search(int[] card, int N, int M) {
		int result = 0;
 
		// 3개를 고르기 때문에 첫번째 카드는 N - 2 까지만 순회
		for (int i = 0; i < N - 2; i++) {
			
			// 카드가 M 보다 크면 skip
			if(card[i] > M) continue;
			
			// 두 번째 카드는 첫 번째 카드 다음부터 N - 1 까지만 순회
			for (int j = i + 1; j < N - 1; j++) {
 
				// 두 번째 카드와 첫 번째 카드의 합이 M보다 크면 skip
				if(card[i] + card[j] > M) continue;
				
				// 세 번째 카드는 두 번째 카드 다음부터 N 까지 순회
				for (int k = j + 1; k < N; k++) {
					
					// 3개 카드의 합 변수 temp
					int temp = card[i] + card[j] + card[k];
					
					// M과 세 카드의 합이 같다면 temp return 및 종료 
					if (M == temp) {	
						return temp;
					}
					
					// 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신 
					if(result < temp && temp < M) {
						result = temp;
					}
				}
			}
		}
		
		// 모든 순회를 마치면 result 리턴 
		return result;
	}

}
