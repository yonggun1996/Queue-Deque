package Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class CardBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		
		bw.write(String.valueOf(queue.poll()));
		bw.flush();
		bw.close();
	}

}
