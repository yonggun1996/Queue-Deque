package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testcase; i++) {
			Deque<Integer> dq = new LinkedList<Integer>();
			String fun = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				dq.offer(num);
			}
			
			String answer = "";
			boolean forward = true;
 			for(int j = 0; j < fun.length(); j++) {
 				if(fun.charAt(j) == 'R') {
 					forward = (forward) ? false : true;
 				}else {
 					if(forward) {
 						if(dq.isEmpty()) {
 							answer = "error";
 							break;
 						}else {
 	 						dq.pollFirst();
 						}
 					}else {
 						if(dq.isEmpty()) {
 							answer = "error";
 							break;
 						}else {
 	 						dq.pollLast();
 						}
 					}
 				}
 			}
 			
 			if(answer.equals("error")) {
 				System.out.println(answer);
 			}else {
 				StringBuilder sb = new StringBuilder();
 	 			sb.append("[");
 	 				
 	 			if(forward) {
 	 				while(!dq.isEmpty()) {
 	 					sb.append(dq.pollFirst());
 	 						
 	 					if(!dq.isEmpty()) {
 	 						sb.append(",");
 	 					}
 	 				}
 	 			}else {
 	 				while(!dq.isEmpty()) {
 	 					sb.append(dq.pollLast());
 	 						
 	 					if(!dq.isEmpty()) {
 	 						sb.append(",");
 	 					}
 	 				}
 	 			}
 	 				
 	 			sb.append("]");
 	 			System.out.println(sb.toString());
 			
 			}
		}
	}
}
