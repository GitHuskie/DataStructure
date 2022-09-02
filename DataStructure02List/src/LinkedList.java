/**
 * @author Yunmeng Zhang
 * @version 2022.1
 * @date 2022/9/1 19:46
 */
/*
= = = = = = = = = = = 数据结构 Day02 = = = = = = = = = =
【代码】  实现在单向链表里添加元素,直接添加在链表最后

【思路】
        【1】初始化节点
         1.定义Person类,每个Person对象就是一个节点
         2.定义Person属性
         3.定义Person属性(把类作为一个属性,用来记录链表的下一个对象)
         4.重写toString

        【2】初始化链表,用于管理节点
         1.初始化一个头节点:头节点不动,不存放具体的数据
         2.添加节点到单向链表
         2.1定义一个辅助变量temp遍历链表
         2.2利用temp找到当前链表的最后节点
         2.3将最后这个节点的next指向新的节点

         【3】显示链表
         1.判断链表是否为空
         2.利用一个辅助变量遍历链表
         3.输出节点信息
= = = = = = = = = = = = = = = = = = = = = = = = = = = =
 */
public class LinkedList {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        Person p1 = new Person(1, "安柏");
        Person p2 = new Person(2, "诺艾尔");
        Person p3 = new Person(3, "菲谢尔");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.add(p1);
        singleLinkedList.add(p2);
        singleLinkedList.add(p3);
        //显示
        singleLinkedList.list();
    }
}

//1.定义Person类,每个Person对象就是一个节点
class Person {
    //2.定义Person属性
    public int number;
    public String name;
    //3.定义Person属性(把类作为一个属性,用来记录链表的下一个对象)
    public Person next;//指向下一个节点
    //【详解】要记录"下一个节点"就得有存放该节点的地方,所以就把类作为一个属性,用来记录链表的下一个对象,这样.next就能拿到

    //构造器
    public Person(int number, String name) {
        this.number = number;
        this.name = name;
    }

    //4.重写toString
    //【注意】不打印next域
    @Override
    public String toString() {
        return "Person{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}

//定位SingleLinkedList管理Person
class SingleLinkedList {
    // 1.初始化一个头节点:头节点不动,不存放具体的数据
    //【详解】Person属性不传入是因为该属性是头节点,链表的数据是从头节点的next开始的
    public Person head = new Person(0, "");

    //2.添加节点到单向链表
    public void add(Person person) {

        //2.1定义一个辅助变量temp遍历链表
        //因为head节点不能动,因此需要一个辅助变量temp
        Person temp = head;
        //2.2利用temp找到当前链表的最后节点
        //遍历链表,找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
                //【详解】.next就是链表当前节点的下一个对象
            }
            //2.3将最后这个节点的next指向新的节点
            //如果没有找到最后,将temp后移
            temp = temp.next;
            //【详解】这里不能写成temp += 1,因为这里不是数组。链表的下一个对象的关系是维护在next属性上的
        }
        //当退出while循环时,temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = person;
    }

    //显示链表
    public void list() {
        //1.判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //2.利用一个辅助变量遍历链表
        //因为头节点不能动,因此我们需要一个辅助变量来遍历
        Person temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //3.输出节点信息
            System.out.println(temp);
            //将temp后移,一定小心
            temp = temp.next;
        }
    }
}