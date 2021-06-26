package enumerated;

/**
 * @version 1.0
 * @Description:
 * @author: bingyu
 * @date: 2021/6/26
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
