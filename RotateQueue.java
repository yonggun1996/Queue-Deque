package Deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class RotateQueue {
	
	static Deque<Integer> deque = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] arr = new int[m];
		for(int i = 0; i < m; i++) {
			arr[i] = in.nextInt();
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
