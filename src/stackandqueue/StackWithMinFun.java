package stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class StackWithMinFun {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void push(int node){
        if(s1.isEmpty()){
            s1.push(node);
            s2.push(node);
        }else{
            if(node < s2.peek()){
                s2.push(node);
            }
            s1.push(node);
        }

    }

    public void pop(){
        if(!s1.isEmpty()){
            int temp = s1.pop();
            if(temp == s2.peek()){
                s2.pop();
            }
        }else
            System.out.println("Stack is empty");

    }

    public int top(){
        if(s1.isEmpty()){
            System.out.println("Stack is empty");
            return -999;
        }
        return s1.peek();
    }
    public int min(){
        if(s1.isEmpty() && s2.isEmpty()){
            System.out.println("Stack is empty");
            return -999;
        }
        return s2.peek();
    }


    public void desc() {
        System.out.println("s1:"+s1.toString());
        System.out.println("s2:"+s2.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StackWithMinFun s = new StackWithMinFun();
        while (true){
            System.out.println("1.PUSH--2.POP--3.TOP--4.MIN");
            int select = in.nextInt();

            switch (select){
                case 1:
                    s.push(in.nextInt());
                    s.desc();
                    break;
                case 2:
                    s.pop();
                    s.desc();
                    break;
                case 3:
                    System.out.println("Top:"+s.top());
                    break;
                case 4:
                    System.out.println("Min:"+s.min());
                    break;

            }
        }
    }

}
