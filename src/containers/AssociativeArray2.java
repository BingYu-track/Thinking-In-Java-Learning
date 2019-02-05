package containers;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/5 19:59
 */
public class AssociativeArray2<K,V> {

    private Object[][] pairs;
    private int index;
    public AssociativeArray2(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        for(int i = 0; i < index; i++){
            if(key.equals(pairs[i][0])) {
                pairs[i] = new Object[]{ key, value };
                return;
            }
        }
        if(index >= pairs.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{ key, value };
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for(int i = 0; i < index; i++){
            if(key.equals(pairs[i][0]))
                return (V)pairs[i][1];
        }
        return null; // Did not find key
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if(i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }
}
