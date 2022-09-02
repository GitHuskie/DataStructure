package ArrayQueueEx;

/**
 * @author Yunmeng Zhang
 * @version 2022.1
 * @date 2022/9/2 15:37
 */
/*
= = = = = = = = = = = 数据结构 Day03 = = = = = = = = = =
【代码】  实现用数组模拟队列
         1.maxSize是队列的最大容量
         2.因为队列的输出、输入是分别从前后端处理,因此需要两个变量front和rear
         3.front:记录队列前端下标,随着数据输出而改变
         4.rear:记录队列后端下标,随着数据输入而改变
         5.数据存入队列为addQueue
         5.1将尾指针后移:rear+1(front == rear 空)
         5.2若尾指针rear小于队列的最大下标maxSize-1,则将数据存入rear所指的数组元素中,否则无法存入(rear == maxSize 满)
【思路】
        【1】初始化数组
         1.ArrayQueue类
         2.表示数组的最大容量
         3.队列头
         4.队列尾
         5.队列,用于存放数据
         6.创建队列的构造器
         7.指向队列头部,分析出front是指向队列头的前一个位置
         8.指向队列尾部,指向队列尾的数据(即就是队列最后一个数据)

        【2】编写队列方法
         1.判断队列是否是满的
         2.判断队列是否是空的
         3.添加数据到队列

        【3】获取队列的数据,出队列
         1.判断队列是否空
         2.抛出异常(不能直接返回-1，而是通过抛异常处理),throw会马上返回，所以不需要在throw后面写个return
         3.front后移

        【4】显示队列
         1.显示队列的所有数据
         2.显示队列的头数据,注意不是取出数据
= = = = = = = = = = = = = = = = = = = = = = = = = = = =
 */
public class ArrayQueueEx {
    public static void main(String[] args) {
        //测试
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(4);
        //添加数据
        arrayQueue.addQueue("安柏");
        arrayQueue.addQueue("诺艾尔");
        arrayQueue.addQueue("菲谢尔");

        arrayQueue.outQueue();
        arrayQueue.showQueue();

    }
}

class ArrayQueue {
    int maxSize;
    int front = 0;
    int rear = 0;
    String[] arr;

    //创建队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new String[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(String name) {
        if (isFull()) {
            System.out.println("队列已满,不能加入数据");
            return;
        }
        arr[rear] = name;
        ++rear;
    }

    //出队列
    public void outQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空,不能取数据");
        }
        ++front;
    }

    //显示队列的所有信息
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    //显示队列的头数据,注意不是取出数据
    public void headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的,没有数据");
        }
        System.out.println(arr[front]);
    }
}