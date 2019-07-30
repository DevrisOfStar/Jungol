package Problem_1809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int[] arr;

	public static void solution(int N) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st_tower = new Stack<>();
		Stack<Integer> st_idx = new Stack<>();
		st_tower.push(arr[0]);
		st_idx.push(1);
		sb.append("0 ");
		for (int i = 1; i < N; i++) {
			while (!st_tower.isEmpty()) {
				if (arr[i] < st_tower.peek()) { // 타워에 부딪히는 경우
					sb.append(st_idx.peek() + " "); // 결과 추가
					break;
				}
				// 필요없는 정보 없애기
				st_tower.pop();
				st_idx.pop();
			}

			if (st_tower.isEmpty()) { // 모든 타워에 미치지 못할 경우
				sb.append("0 ");
			}
			// 정보주입
			st_tower.push(arr[i]); 
			st_idx.push(i+1);
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(str[i]);

		solution(N);
	}
}
