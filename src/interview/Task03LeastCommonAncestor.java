package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task03LeastCommonAncestor {
    // Least Common Ancestor of Binary Tree (Medium Question)

/*
LCA (0,2) => 1
LCA(3,0) => 0
LCA(3,5) => 1
LCA(3,3) => 3


1 -> 2 -> 3 -> 4 -> 5

     1
   /    \
  0      2
/       /  \
3      7    5
              \
              10


        1
      /    \
      0      2
    /       /  \
    3      7    5
  /       /        \
 1       0          0


     5 2 1
     x x x

  10 5 2 1
     x x x

     3 0 1
 1 10 5 2 1

*/

    //N is number of nodes in tree
    class TreeNode<T> {
        TreeNode left;
        TreeNode right;
        T val;
    }

//Possible solution
//    public <T> TreeNode<T> leastCommonAncestor(TreeNode<T> root, TreeNode<T> p, TreeNode<T> q) {
//        if (root == null) {
//            return null;
//        }
//
//        if (p == root) {
//            return p;
//        } else if (q == root) {
//            return q;
//        } else {
//            TreeNode left = leastCommonAncestor(root.left, p, q);
//            TreeNode right = leastCommonAncestor(root.right, p, q);
//            if (left != null && right != null) {
//                return root;
//            } else {
//                return left == null ? right : left;
//            }
//        }
//
//    }


    public <T> TreeNode<T> leastCommonAncestor(TreeNode<T> root, TreeNode<T> firstNode, TreeNode<T> secondNode) {

        Map<TreeNode<T>, TreeNode<T>> child2ParentMap = new HashMap<>();
        //2N
        constuctTreeMap(root, null, child2ParentMap);
        //logN
        List<TreeNode<T>> firstPath2Root = constructPath2Root(firstNode, child2ParentMap);
        //logN
        List<TreeNode<T>> secondPath2Root = constructPath2Root(secondNode, child2ParentMap);

        //2N 2logn = 2 (N +logN)
        for (TreeNode<T> firstParent : firstPath2Root) {
            for (TreeNode<T> secondParent : secondPath2Root) {
                if (secondParent.equals(firstParent)) return firstParent;
            }
        }

        return null;
    }

    private<T> List<TreeNode<T>> constructPath2Root(TreeNode<T> node, Map<TreeNode<T>, TreeNode<T>> child2ParentMap) {
        List<TreeNode<T>> path = new ArrayList<>();
        path.add(node);
        while ((node = child2ParentMap.get(node)) != null) {
            path.add(node);
        }
        return path;
    }

    private<T> void constuctTreeMap(TreeNode<T> node, TreeNode<T> parent, Map<TreeNode<T>, TreeNode<T>> child2ParentMap) {
        child2ParentMap.put(node, parent);
        if (node.left != null) constuctTreeMap(node.left, node, child2ParentMap);
        if (node.right != null) constuctTreeMap(node.right, node, child2ParentMap);
    }

}
