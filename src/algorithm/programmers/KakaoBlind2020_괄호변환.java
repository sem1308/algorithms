package algorithm.programmers;

import java.util.Stack;

public class KakaoBlind2020_괄호변환 {

    public static void main(String[] args) {
    }
    class Solution {
        public boolean validate(String s){
            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(c=='('){
                    if(stack.isEmpty()) stack.add(c);
                    else{
                        Character cc = stack.peek();
                        if(cc=='(') stack.push(cc);
                        else stack.pop();
                    }
                }else{
                    if(stack.isEmpty()) return false;
                    Character cc = stack.peek();
                    if(cc==')') stack.push(cc);
                    else stack.pop();
                }
            }
            return true;
        }
        public String createStr(String p){
            if(p.isEmpty()) return "";
            int cntOpen = 0, cntClose = 0;
            for(int i=1; i<p.length(); i++){
                if(p.charAt(i)=='(') cntOpen++;
                else cntClose++;
                if(cntOpen == cntClose) break;
            }
            String u = p.substring(0,cntOpen+cntClose);
            String v = p.substring(cntOpen+cntClose);

            if(validate(u)){
                u += createStr(v);
            }else{
                String temp = "("+createStr(v)+")";
                u = u.substring(1,u.length()-1);
                for(int i=0; i<u.length(); i++){
                    temp += (u.charAt(i) == '(' ? ")" : "(");
                }
                u = temp;
            }
            return u;
        }
        public String solution(String p) {
            return createStr(p);
        }
    }
}