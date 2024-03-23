package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boomStr = br.readLine();

        int len = str.length();
        int boomLen = boomStr.length();

        Stack<Character> words = new Stack<>();
        Stack<Character> temp = new Stack<>();

        for (int i = 0; i < len; i++) {
            words.add(str.charAt(i));
            int idx = boomLen-1;
            while(idx >= 0 && words.peek() == boomStr.charAt(idx--)){
                temp.push(words.pop());
            }
            if(idx == -1){
                temp.clear();
            }else{
                while(!temp.isEmpty()) {
                    words.push(temp.pop());
                }
            }
        }

        StringBuilder result = new StringBuilder();

        while(!words.isEmpty()){
            result.append(words.pop());
        }
        result.reverse();

        System.out.println(result.length() == 0 ? "FRULA" : result.toString());
    }
}