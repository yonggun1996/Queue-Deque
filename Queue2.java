package Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Queue2 {

	static LinkedList<Integer> queue = new LinkedList<Integer>();
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), "\n");
			String str = st.nextToken();
			
			switch (str) {
			case "pop":
				pop();
				break;

			case "size":
				size();
				break;
				
			case "empty":
				empty();
				break;
				
			case "front":
				front();
				break;
				
			case "back":
				back();
				break;
				
			default:
				String[] pusharr = str.split(" ");
				push(Integer.parseInt(pusharr[1]));
				break;
			}
		}
		
		bw.write(answer.toString());
		bw.flush();
		bw.close();
		
	}
	
	public static void push(int num) {
		queue.offer(num);
	}
	
	public static void pop() {
		if(queue.isEmpty()) {
			//System.out.println(-1);
			answer.append("-1");
			answer.append("\n");
		}else {
			//System.out.println(queue.get(0));
			answer.append(queue.get(0));
			answer.append("\n");
			queue.remove(0);
		}
	}
	
	public static void size() {
		//System.out.println(queue.size());
		answer.append(queue.size());
		answer.append("\n");
	}
	
	public static void empty() {
		if(queue.isEmpty()) {
			//System.out.println(1);
			answer.append(1);
			answer.append("\n");
		}else {
			//System.out.println(0);
			answer.append(0);
			answer.append("\n");
		}
	}
	
	public static void front() {
		if(queue.isEmpty()) {
			//System.out.println(-1);
			answer.append(-1);
			answer.append("\n");
		}else {
			//System.out.println(queue.get(0));
			answer.append(queue.get(0));
			answer.append("\n");
		}
	}
	
	public static void back() {
		if(queue.isEmpty()) {
			//System.out.println(-1);
			answer.append(-1);
			answer.append("\n");
		}else {
			//System.out.println(queue.get(queue.size() - 1));
			answer.append(queue.get(queue.size() - 1));
			answer.append("\n");
		}
	}

}
