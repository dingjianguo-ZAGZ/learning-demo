package map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表
 */
public class E053canFinish {
    //存储学习课程的列表
    List<List<Integer>> edges;
    //存储学习这一门课程需要学习的先修课程的数量（入度）
    int[] indeg;

    /**
     * 有向图的广度优先搜索
     * 从入度入手，如果一个节点的入度等于0，说明该课程没有先修课程，可以学习，将这个课程放入队列
     * 这个课程学习完之后，将这个课程指向的课程的入度 -1
     * @param numCourses 需要学习课程的数量
     * @param prerequisites 需要先修的课程，1 表示需要先修的课程
     * @return
     */

}
