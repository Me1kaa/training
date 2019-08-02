package interview;

import java.util.LinkedList;
import java.util.Queue;

public class Task02ConnectLevelNodes {

    // 1.)Populate pointer to right tree node
// Assume the tree is full and complete

/*



          1 -> NULL
        /   \
      1   ->  1  -> NULL
       \        \
        1  ->    7 -> NULL


    queue
    1
    1 -> null

    2 3

    2 -> 3 -> null
    4x 5

    4 -> 5  -> null


*/

    public class TreeQuestions {

        class TreeNode {
            TreeNode left;
            TreeNode right;
            TreeNode next;
            int val;
        }

        public void populateRightPointer(TreeNode node) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(node);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = q.poll();
                    if (i == size - 1) {
                        temp.next = null;
                    } else {
                        temp.next = q.peek();
                    }

                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }


        /*
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);

        while((node = queue.pollFirst()) != null) {
            List<Integer> list = new ArrayList<>();
            list.add(node);
            while(!queue.isEmpty()) {
                  Node next = queue.pollFirst();
                  list.add(next);
                  node.next = next;
                  node = next;
            }
            for(Integer elem : list) {
              if(elem.left != null) queue.add(elem.left);
              if(elem.right != null) queue.add(elem.right);
            }
        }
        */
        }

    }
}
