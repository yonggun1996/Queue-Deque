package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 알고리즘 13335번문제
다리에 올라갈 수 있는 최대 무게, 최대 트럭의 수, 주어진 트럭의 수가 주어진다.
큐를 이용해 트럭을 순서대로 offer 한다
배열을 다리의 길이만큼 생성해 차의 무게를 담아 한 칸씩 이동한다
while문을 이용해 다리 위에 차가 없고 대기하는 차가 없을 때 까지 반복 후 counting을 해 변수를 출력한다
 */

public class No13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();//대기하는 트럭을 담은 큐
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int[] bridge = new int[w];//다리를 배열로 선언
        int count = 0;//다리를 지나가는 시간
        int bridge_weight = 0;//다리 위 차들의 무게

        while(!queue.isEmpty() || bridge_weight > 0){
            if(bridge_weight == 0){//다리에 아무것도 없을 경우
                bridge[0] = queue.poll();
                bridge_weight += bridge[0];
            }else {
                //조건문 전에 제일 다리 마지막 부분을 무게에서 뺀다.
                bridge_weight -= bridge[w - 1];
                bridge[w - 1] = 0;
                if(queue.isEmpty()){//트럭이 다 들어왔을 경우
                    for(int i = w - 2; i >= 0; i--){//한칸씩 이동
                        bridge[i + 1] = bridge[i];
                    }
                }else if(bridge_weight + queue.peek() > l){//다음차가 들어올 때 하중을 넘길 경우
                    for(int i = w - 2; i >= 0; i--){
                        bridge[i + 1] = bridge[i];
                    }
                    bridge[0] = 0;//처음칸에 차가 들어오지 않고 이전 차들이 앞으로 한 칸 이동한다
                }else if(bridge_weight + queue.peek() <= l){//다음 차도 들어올 수 있는 경우
                    for(int i = w - 2; i >= 0; i--){
                        bridge[i + 1] = bridge[i];
                    }

                    bridge[0] = queue.poll();//처음 칸에 차가 들어온다
                    bridge_weight += bridge[0];
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
