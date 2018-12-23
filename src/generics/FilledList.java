package generics;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2018/12/23 20:40
 */
class FilledList<T> extends ArrayList<T> {

    public FilledList(Class<? extends T> type, int size) {
        try {
            for(int i = 0; i < size; i++){
                // 使用反射创建对象并填充list到中
                add(type.newInstance());
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
