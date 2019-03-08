package 面试题代码;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Description: 编写一段泛型程序来实现LRU缓存
 * @author: hxw
 * @date: 2019/3/8 11:09
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int cacheSize; //设定缓存阈值

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true); //构造一个带指定初始容量、加载因子和排序模式的空LinkedHashMap实例   设置true为访问顺序，为true；false为插入顺序
        this.cacheSize = cacheSize;
    }

    //LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
    //我们要做的就是重写这个方法，当满足一定条件时删除老数据
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize; //当里面的数据大于等于设定的数据量时开始删除老数据
    }

    public static void main(String[] args){
        LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>(5);
        lruCache.put("a",1);
        lruCache.put("b",2);
        lruCache.put("c",3);
        lruCache.put("d",4);
        lruCache.put("e",5);
        System.out.println(lruCache); //{b=2, c=3, d=4, e=5}
        lruCache.put("f",6);
        System.out.println(lruCache); //{b=2, c=3, d=4, e=5}
    }
}
