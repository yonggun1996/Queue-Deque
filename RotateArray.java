package Avatar;
import java.io.*;
import java.util.*;

/*
배열들을 여러 방향으로 회전하는 문제
큐를 이용해서 데이터를 담고 특정 배열칸에 데이터를 순서대로 삽입하는 과정을 코드로 구현했습니다.
 */

public class RotateArray {
    static int[][] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());//세로 수
        int width = Integer.parseInt(st.nextToken());//가로 수
        int r = Integer.parseInt(st.nextToken());

        array = new int[height][width];
        for(int i = 0; i < height; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < width; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < r; i++){
            int n = Integer.parseInt(st.nextToken());
            switch (n){
                case 1 :
                    operator1();
                    break;

                case 2 :
                    operator2();
                    break;

                case 3 :
                    operator3();
                    break;

                case 4 :
                    operator4();
                    break;

                case 5 :
                    operator5(array.length / 2, array[0].length / 2);
                    break;

                case 6 :
                    operator6(array.length / 2, array[0].length / 2);
                    break;
            }//switch - case
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //상하반전 메서드
    //맨 위 데이터를 맨 아래로
    public static void operator1(){
        int[][] arr = new int[array.length][array[0].length];
        Queue<Integer> queue = new LinkedList<>();

        int index = 0;
        for(int i = array.length - 1; i >= 0; i--){
            for(int j = 0; j < array[0].length; j++){
                queue.offer(array[i][j]);
            }

            for(int j = 0; j < array[0].length; j++){
                arr[index][j] = queue.poll();
            }
            index++;
        }

        array = arr;
    }

    //좌우반전 메서드
    //맨 왼쪽 데이터를 맨 오른쪽으로 이동
    public static void operator2(){
        int[][] arr = new int[array.length][array[0].length];
        Queue<Integer> queue = new LinkedList<>();

        int index = 0;
        for(int i = array[0].length - 1; i >= 0; i--){
            for(int j = 0; j < array.length; j++){
                queue.offer(array[j][i]);
            }

            for(int j = 0; j < array.length; j++){
                arr[j][index] = queue.poll();
            }
            index++;
        }

        array = arr;
    }

    //오른쪽으로 90도 회전
    //맨 위 가로축 배열을 토대로 맨 오른쪽 세로축 순으로 넣는다
    public static void operator3(){
        int[][] arr = new int[array[0].length][array.length];
        Queue<Integer> queue = new LinkedList<>();

        int index = arr[0].length - 1;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                queue.offer(array[i][j]);
            }

            for(int j = 0; j < arr.length; j++){
                arr[j][index] = queue.poll();
            }
            index--;
        }

        array = arr;
    }

    //왼쪽으로 90도 회전
    //왼쪽 데이터부터 세로축을 기준으로 새로운 배열에는 맨 아래 가로축에 넣는다
    public static void operator4(){
        int[][] arr = new int[array[0].length][array.length];
        Queue<Integer> queue = new LinkedList<>();

        int index = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                queue.offer(array[i][j]);
            }

            for(int j = arr.length - 1; j >= 0; j--){
                arr[j][index] = queue.poll();
            }
            index++;
        }

        array = arr;
    }

    //4개의 구역으로 나눠 오른쪽으로 회전
    //1/4로 나눠 왼쪽 위 배열을 토대로 나눈다
    public static void operator5(int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int num1 = array[i][j];
                int num2 = array[i][j + m];
                int num3 = array[i + n][j + m];
                int num4 = array[i + n][j];

                array[i][j] = num4;
                array[i][j + m] = num1;
                array[i + n][j + m] = num2;
                array[i + n][j] = num3;
            }
        }
    }

    //4개의 구역으로 나눠 왼쪽으로 회전
    //배열을 1/4해서 왼쪽 위 배열을  토대로 값을 바꾼다
    public static void operator6(int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int num1 = array[i][j];
                int num2 = array[i][j + m];
                int num3 = array[i + n][j + m];
                int num4 = array[i + n][j];

                array[i][j] = num2;
                array[i][j + m] = num3;
                array[i + n][j + m] = num4;
                array[i + n][j] = num1;
            }
        }
    }
}
