package ArrayStackEx;

import java.util.Arrays;

/**
 * @author Yunmeng Zhang
 * @version 2022.1
 * @date 2022/9/2 16:47
 */
public class ArrayStack {
    public static void main(String[] args) {
        //测试
        Stack stack = new Stack(4);
        //添加数据
        stack.addStack("安柏");
        stack.addStack("诺艾尔");
        stack.addStack("菲谢尔");
        stack.addStack("琴");

        stack.showStack();

    }
}

class Stack {
    int maxSize;
    int top = 0;
    String[] arr;

    //构造器
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        arr = new String[maxSize];//注意要在构造器里new一个数组
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == 0;
    }

    //入栈方法
    public void addStack(String name) {
        if (isFull()) {
            System.out.println("队列已满,不能加入数据");
            return;
        }
        arr[top] = name;
        System.out.println(name + "已加入队列");
        ++top;
    }

    //出栈方法
    public void outStack() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的,没有数据");
        }
        --top;
        System.out.println(arr[top] + "已退出队列");
    }

    //显示队列方法
    public void showStack() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的,没有数据");
        }
        System.out.println("========队列情况========");
        for (int i = 0; i < top; i++) {
            System.out.println("队列" + (i + 1) + ":" + arr[i] + " ");
        }
        System.out.println("");
    }
}