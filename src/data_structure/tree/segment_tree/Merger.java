package data_structure.tree.segment_tree;

/**
 * Created by lyn
 */
public interface Merger<E> {
    E merge(E a, E b);
}
