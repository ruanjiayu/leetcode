package leetcode.cn;

import basedata.DLinkedNode;
import handle.DLinkedHandle;
import org.junit.Test;
import util.PrintUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: LRU 算法
 * @Author: Summer
 * @DateTime: 2021/4/29 5:43 下午
 * @Version: 0.0.1-SNAPSHOT
 */
public class No_146_LRU {

    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    /**
     * 当前容器中存在有效数据的个数
     */
    private int size;

    /**
     * 设置能存储的容量
     */
    private int capacity;

    private DLinkedHandle dLinkedHandle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        No_146_LRU lru = null;
        while(true) {
            String in = scanner.next();
            System.out.println("收到夏天指令:" + in);
            if (in.contains("new")) {
                String[] split = in.split("\\s");
                lru = new No_146_LRU(Integer.parseInt(split[1]));
                continue;
            }

            if (in.contains("put")) {
                String[] split = in.split("\\s");
                lru.put(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                System.out.println("放入成功！！！");
                continue;
            }

            if (in.contains("get")) {
                String[] split = in.split("\\s");
                System.out.println(lru.get(Integer.parseInt(split[1])));
                continue;
            }

            if (in.contains("show")) {
                PrintUtils.print(lru.dLinkedHandle.head);
                continue;
            }
        }
    }


    public No_146_LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        dLinkedHandle = new DLinkedHandle();
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        dLinkedHandle.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if  (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            dLinkedHandle.addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = dLinkedHandle.removeTail();
                cache.remove(tail.key);
                -- size;
            }
        } else {
            node.value = value;
            dLinkedHandle.moveToHead(node);
        }
    }

}
