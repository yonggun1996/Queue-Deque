package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
문자열을 입력받은 문자에 따라서 수정해야하는 문제
StringBuilder나 LinkedList를 사용해 문제를 풀었지만 시간초과
Deque를 이용해서 문제를 해결
커서 왼쪽에 있는 문제는 deque1에 커서 오른쪽의 문자는 deque2에 저장한 후 문자열을 합쳐 답을 출력한다
 */

public class No1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Deque<Character> deque1 = new LinkedList<>();//왼쪽 커서의 문자
        Deque<Character> deque2 = new LinkedList<>();//커서 기준 오른쪽 문자를 담는다
        for(int i = 0; i < str.length(); i++){//우선 시작은 커서가 제일 오른쪽이기 때문에 deque1에 모두 담는다
            deque1.offerFirst(str.charAt(i));
        }

        for(int i = 0; i < n; i++){
            String[] str_Arr = br.readLine().split(" ");
            if(str_Arr[0].equals("L") && !deque1.isEmpty()){//왼쪽으로 옮김
                //왼쪽 덱의 내용중 최근 내용을 꺼내 오른쪽 덱에 삽입
                char c = deque1.pollFirst();
                deque2.offerFirst(c);
            }else if(str_Arr[0].equals("D") && !deque2.isEmpty()){
                //오른쪽 덱의 내용중 최근 내용을 꺼내 오른쪽 덱에 삽입
                char c = deque2.pollFirst();
                deque1.offerFirst(c);
            }else if(str_Arr[0].equals("B") && !deque1.isEmpty()){
                //커서기준 왼쪽 문자열을 지우는 것은 왼쪽 덱의 문자열을 꺼낸다
                deque1.pollFirst();
            }else if(str_Arr[0].equals("P")){
                //추가는 왼쪽 덱에 문자열을 추가만 한다
                deque1.offerFirst(str_Arr[1].charAt(0));
            }
        }

        StringBuilder answer = new StringBuilder();
        while(!deque1.isEmpty()){
            //왼쪽 문자 덱은 큐 처럼 삽입했던 곳과 다른 곳에서 데이터를 꺼내 합친다
            answer.append(deque1.pollLast());
        }

        while(!deque2.isEmpty()){
            //오른쪽 문자 덱은 스택처럼 삽입했던 곳과 같은 곳에서 데이터를 꺼내 합친다
            answer.append(deque2.pollFirst());
        }

        System.out.print(answer);
    }
}
