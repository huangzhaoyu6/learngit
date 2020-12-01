package com.structure;

/**
 * @author huangzhaoyu
 * 手动实现栈
 * @date 2020/11/30 17:24
 */
public class MyStack {

    //栈顶
    private int top;
    //栈的大小
    private int maxSize;
    //存放元素的数组
    private int[] arr;

    public MyStack(int maxSize){
        top = -1;
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断栈是否满了
    public boolean isFull(){
        return maxSize-1 == top;
    }
    //入栈
    public void push(int value){
        arr[++top] = value;
    }
    //出栈
    public int pop(){
        return arr[top--];
    }
    //访问栈顶元素
    public int peek(){
        return arr[top];
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.isFull());
        myStack.pop();
        myStack.pop();
        myStack.pop();
    }

}
