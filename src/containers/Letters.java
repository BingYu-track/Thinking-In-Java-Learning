package containers;

import net.mindview.util.Generator;

import java.util.Iterator;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/1/20 22:58
 */
class Letters implements Generator<Pair<Integer,String>>, Iterable<Integer>{

    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            public Integer next() {
                return number++;
            }
            public boolean hasNext() {
                return number < size;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

    }

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer,String>(number++, "" + letter++);
    }
}
