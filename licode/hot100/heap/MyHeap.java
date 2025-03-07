package heap;

/**
 * 实现堆
 */
public class MyHeap<T extends Comparable> {
    //数组
    private T[] items;
    //元素个数
    private int N;

    public MyHeap(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.N = 0;
    }

    //比较大小
    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }
    //交换节点
    public void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    //插入元素
    public void insert(T t){
        items[++N] = t;
        //将元素放入合适的位置
        swim(N); //此时插入元素的下标是 N
    }

    /**
     * 插入元素时，上浮元素到合适的位置
     * @param k
     */
    private void swim(int k) {
        //将当前节点和父节点（k/2）比较，如果当前节点大于父节点，则交换，并且堆每一个二叉树都进行判断
        while (k > 1){
            //0 位置不存放数据，所以1 和 0 不进行比较
            if(less(k/2,k)){
                exch(k,k/2);
            }
            k = k/2;
        }
    }

    /**
     * 删除堆中最大的节点
     */
    public T delMax(){
        //交换根节点和数组最大索引处的节点
        T max = items[1];
        exch(1,N);
        //将最大索引处的节点删除
        items[N] = null;
        //元素格式 -1
        N--;
        //使用下沉算法，使二叉树重新有序
        sink(1);
        return max;
    }

    private void sink(int k) {
        //找到子节点中较大的值并与之交换
        while (2*k <= N){
            int max;
            //如果右子节点存在
            if(2*k+1 <= N){
                if (less(2*k,2*k+1)) {
                    //左节点小于右节点
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else {
                //右子节点不存在
                max = 2*k;
            }
            //根节点和左右子节点中的较大值比较，是否需要交换
            if(!less(k,max)){
                break;
            }
            exch(k,max);
            k = max;
        }
    }
}
