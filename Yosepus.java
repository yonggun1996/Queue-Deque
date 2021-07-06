package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yosepus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int n = in.nextInt();
		int k = in.nextInt();
		
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
