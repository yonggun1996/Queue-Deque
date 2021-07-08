package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueueBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < testcase; i++) {
			Queue<PrintBufferData> queue = new LinkedList<PrintBufferData>();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int j = 0; j < n; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int imp = Integer.parseInt(st2.nextToken());
				list.add(imp);
				PrintBufferData pd = new PrintBufferData(imp, j);
				queue.offer(pd);
			}
			
			Collections.sort(list);
			Collections.reverse(list);
			
			int answer = 0;
			int idx = 0;
			
			while(list.size() > 0) {
				PrintBufferData pd = queue.poll();
				
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

class PrintBufferData{
	int imp;//중요도
	int idx;//몇 번째 문서인지
	
	public PrintBufferData(int imp, int idx) {
		this.imp = imp;
		this.idx = idx;
	}
}
