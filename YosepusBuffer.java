package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class YosepusBuffer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			for(int i = 1; i <= k; i++) {
				int num = queue.poll();
				
				if(i != k) {
					queue.offer(num);
				}else {
					sb.append(num);
					sb.append(", ");
				}
			}
		}
		
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		
		System.out.println(sb);
	}

}
