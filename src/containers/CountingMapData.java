package containers;

import java.util.*;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/29 21:53
 */
class CountingMapData extends AbstractMap<Integer,String>{
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        if(size < 0) this.size = 0;
        this.size = size;
    }

    /**
     * Entry中的方法主要
     */
    private class Entry implements Map.Entry<Integer,String> {
        int index;
        Entry(int index) { this.index = index; }
        public boolean equals(Object o) {
            return o instanceof Entry && index == ((Entry)o).index; //根据index来比较Entry是否相同
        }
        public Integer getKey() { return index; } //key为index
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
    //主要
    class EntrySet extends AbstractSet<Map.Entry<Integer,String>> {
        public int size() {
            return size;
        }

        private class Iter implements Iterator<Map.Entry<Integer,String>> {
            private Entry entry = new Entry(-1);
            public boolean hasNext() {
                return entry.index < size - 1;
            }
            public Map.Entry<Integer,String> next() {
                entry.index++;
                return entry;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public Iterator<Map.Entry<Integer,String>> iterator() {
            return new Iter();
        }
    }

    private Set<Map.Entry<Integer,String>> entries = new EntrySet();
    public Set<Map.Entry<Integer,String>> entrySet() {
        return entries;
    }

    public static void main(String[] args){
        Random random = new Random(47);
        int index = random.nextInt(10);
        String s = chars[index % chars.length] + Integer.toString(index / chars.length);
        System.out.println(s);
    }
}
