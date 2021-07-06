package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Deque {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			switch (str) {
			case "pop_front":
				pop_front();
				break;

			case "pop_back":
				pop_back();
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
				int num = Integer.parseInt(st.nextToken());
				push(str, num);
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void pop_front() {
		if(list.size() == 0) {
			answer.append(-1);
			answer.append("\n");
		}else {
			answer.append(list.get(0));
			answer.append("\n");
			list.remove(0);
		}
	}
	
	public static void pop_back() {
		if(list.size() == 0) {
			answer.append(-1);
			answer.append("\n");
		}else {
			answer.append(list.get(list.size() - 1));
			answer.append("\n");
			list.remove(list.size() - 1);
		}
	}
	
	public static void size() {
		answer.append(list.size());
		answer.append("\n");
	}
	
	public static void empty() {
		if(list.size() == 0) {
			answer.append(1);
			answer.append("\n");
		}else {
			answer.append(0);
			answer.append("\n");
		}
	}
	
	public static void front() {
		if(list.size() == 0) {
			answer.append(-1);
			answer.append("\n");
		}else {
			answer.append(list.get(0));
			answer.append("\n");
		}
	}
	
	public static void back() {
		if(list.size() == 0) {
			answer.append(-1);
			answer.append("\n");
		}else {
			answer.append(list.get(list.size() - 1));
			answer.append("\n");
		}
	}
	
	public static void push(String str, int num) {
		String s = str.substring(5, str.length());
		
		if(s.equals("front")) {
			list.add(0, num);
		}else if(s.equals("back")) {
			list.add(num);
		}
	}

}
