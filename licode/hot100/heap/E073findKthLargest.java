package heap;


/**
 * 数组中第K个最大元素
 */
public class E073findKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        //构建一个大根堆
        int[] maxHeap = new int[nums.length+1];
        System.arraycopy(nums,0,maxHeap,1,nums.length);
        maxHeap = buildMaxHeap(maxHeap);
        int res = Integer.MIN_VALUE;
        int range = maxHeap.length - 1;
        while (k >= 0) {
            res = delMax(maxHeap,range);
            --range;
            --k;
        }
        return res;
    }

    /**
     * 删除堆中最大的节点
     */
    public static int delMax(int[] maxHeap,int range) {
        //交换根节点和数组最大索引处的节点
        int max = maxHeap[1];
        swap(maxHeap, 1, range);
        //将最大索引处的节点删除
        maxHeap[range] = 0;
        //元素格式 -1
        range--;
        //使用下沉算法，使二叉树重新有序
        sink(maxHeap, 1, range);
        return max;
    }

    public static void swap(int[] maxHeap, int i, int j) {
        //交换两个节点
        int temp = maxHeap[i];
        maxHeap[i] = maxHeap[j];
        maxHeap[j] = temp;
    }

    private static int[] buildMaxHeap(int[] maxHeap) {
        //从一半的位置开始下沉
        for (int i = (maxHeap.length) / 2 ; i > 0; i--) {
            sink(maxHeap, i, maxHeap.length);
        }
        return maxHeap;
    }

    private static void sink(int[] maxHeap, int k, int range) {
        while (2*k < range) {
            int max;
            if (2 * k + 1 < range) {
                if (maxHeap[2 * k] > maxHeap[2 * k + 1]) {
                    //左节点da
                    max = 2 * k;
                } else {
                    max = 2 * k + 1;
                }
            } else {
                max = 2*k;
            }
            //判断是否需要下沉
            if (maxHeap[k] > maxHeap[max]) {
                break;
            }
            swap(maxHeap,k,max);
            k = max;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,0};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }
}
