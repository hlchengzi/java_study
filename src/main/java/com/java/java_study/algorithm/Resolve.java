package com.java.java_study.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Resolve {
    static String resolve(String expr) {
        if(expr == null ){
            return null;
        }
        int left =0,right =0;
        char[] chars = expr.toCharArray();
        for (int i = 0; i < expr.length() ; i++) {
            if(chars[i]=='('){
                left++;
            }
            if(chars[i] == ')'){
                right++;
            }
        }
        if(left!=right){
            return "";
        }
        if(left==0){
            return expr;
        }
        if(left==1){
            StringBuffer stringBuffer = new StringBuffer();
            for (char a:chars){
                if(a!='(' && a != ')'){
                    stringBuffer.append(a);
                }
            }
            return stringBuffer.toString();
        }


        Stack<Character> stack = new Stack<>();
        String s = "";
        int len = expr.length();
        for(int i=0;i<len;i++){
            char c = expr.charAt(i);
            if(c!=')'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return "";
                }
                s = "";
                while(!stack.isEmpty()&&stack.peek()!='('){
                    s+=stack.pop();
                }
                if(stack.isEmpty()||stack.pop()!='('){
                    return "";
                }
                int l = s.length();
                for(int j=0;j<l;j++){
                    stack.push(s.charAt(j));
                }
            }
        }
        s = "";
        while(!stack.isEmpty()){
            //注意不是s = s + stack.pop();
            s = stack.pop()+ s;
        }
        return s;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }

}
