package Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcase = in.nextInt();
		
		for(int i = 0; i < testcase; i++) {
			Queue<PrintData> queue = new LinkedList<PrintData>();
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int j = 0; j < n; j++) {
				int imp = in.nextInt();
				list.add(imp);
				PrintData pd = new PrintData(imp, j);
				queue.offer(pd);
			}
			
			Collections.sort(list);
			Collections.reverse(list);
			
			int answer = 0;
			int idx = 0;
			
			while(list.size() > 0) {
				PrintData pd = queue.poll();
				
				if(pd.imp == list.get(idx)) {
					answer++;
					++idx;
					if(pd.idx == m) {
						break;
					}
				}else {
					queue.offer(pd);
				}
			}//while
			
			System.out.println(answer);
		}//out - for
		
	}

}

class PrintData{
	int imp;//중요도
	int idx;//몇 번째 문서인지
	
	public PrintData(int imp, int idx) {
		this.imp = imp;
		this.idx = idx;
	}
}
