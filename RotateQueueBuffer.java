package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class RotateQueueBuffer {
	
	static Deque<Integer> deque = new LinkedList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			deque.addFirst(i);
		}
		
		int idx = 0;
		int answer = 0;
		
		while(idx < m) {
			int num = arr[idx];
			
			if(leftcount(num) <= rightcount(num)) {
				while(deque.peekLast() != num) {
					answer++;
					deque.addFirst(deque.pollLast());
				}
			}else {
				while(deque.peekLast() != num) {
					answer++;
					deque.addLast(deque.pollFirst());
				}
			}
			
			deque.pollLast();
			idx++;
		}
		
		System.out.println(answer);
	}
	
	public static int rightcount(int num) {
		int count = 1;
		Deque<Integer> newDeque = new LinkedList<Integer>(deque);
		
		while(newDeque.pollFirst() != num) {
			count++;
		}
		
		return count;
	}
	
	public static int leftcount(int num) {
		int count = 0;
		Deque<Integer> newDeque = new LinkedList<Integer>(deque);
		
		while(newDeque.pollLast() != num) {
			count++;
		}
		
		return count;
	}

}
