package stackandqueue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class BuildQueueByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        this.stack1.add(node);
    }

    public int pop(){
//        int s1len = stack1.size();
//        for(int i=0; i<s1len; i++){
//            stack2.add(stack1.pop());
//        }
//        int popnum = stack2.pop();
//        int s2len = stack2.size();
//        for(int i=0; i<s2len; i++){
//            stack1.add(stack2.pop());
//        }
        if(stack2.empty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args){
//        BuildQueueByStack bqb = new BuildQueueByStack();
//        bqb.push(1);
//        bqb.push(2);
//        bqb.push(3);
//        System.out.println(bqb.pop());
//        System.out.println(bqb.pop());
//        bqb.push(4);
//        System.out.println(bqb.pop());
//        bqb.push(5);
//        System.out.println(bqb.pop());
//        System.out.println(bqb.pop());
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for(int i=0; i<10; i++){
            s1.add(i);
        }
        System.out.println(s1.toString());
        for(int i=0; i<s1.size(); i++){
            s2.add(s1.pop());
        }
        System.out.println(s2.toString());
    }
}
