package Problem_2634;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int M, N, L;
 
        st = new StringTokenizer(br.readLine(), " ");
 
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine(), " ");
 
        int[] Ms = new int[M];
        ArrayList<int[]> Ns = new ArrayList();
        boolean[] isVisited = new boolean[N];
        for (int i = 0; i < M; i++)
            Ms[i] = Integer.parseInt(st.nextToken());
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
 
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken()) - L;
            if (b > 0)
                continue;
            else {
                Ns.add(new int[] { a, b });
            }
 
        }
        Arrays.sort(Ms);
        Collections.sort(Ns, new Comparator<int[]>() {
 
            @Override
            public int compare(int[] o1, int[] o2) {
 
                return o1[0] < o2[0] ? 1 : -1;
            }
        });
        int cnt = 0;
        for (int j = 0; j < Ns.size(); j++) {
 
            int left = 0;
            int right = M - 1;
            int mid = (left + right) / 2;
            while (left <= right) {
                if (Ms[mid] <= Ns.get(j)[0] - Ns.get(j)[1] && Ms[mid] >= Ns.get(j)[0] + Ns.get(j)[1]) {
                    isVisited[j] = true;
                    break;
                } else if (Ms[mid] < Ns.get(j)[0] + Ns.get(j)[1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
 
                mid = (left + right) / 2;
            }
        }
        for (int i = 0; i < N; i++)
            if (isVisited[i])
                cnt++;
        System.out.println(cnt);
 
    }
}