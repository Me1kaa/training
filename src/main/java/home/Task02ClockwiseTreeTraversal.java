package home;

import java.util.ArrayList;
import java.util.List;

/*
Print out the boundary of the tree (clockwise)
          1
        /   \
      2       -1
       \        \
        3        7

  [1, -1, 7, 3, 2, 1]


         1
        /   \
      2       -1
    /   \        \
   0     3        7

  [1, -1, 7, 3, 0, 2, 1]


           1
        /      \
       2         -1
     /   \       / \
    0     3     9   10
   /       \    / \
 10        100 150   1000
                      /
                     5000
  [1, -1, 7, 9, 1000, 5000, 100, 10, 0, 2]


  [1, -1, 9, 1000


*/
public class Task02ClockwiseTreeTraversal {

    public static class TreeNode<T> {

        TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(T val) {
            this.val = val;
        }

        T val;
        TreeNode<T> left;
        TreeNode<T> right;
    }

    public static void main(String[] args) {
        TreeNode<Integer> tree = new TreeNode<>(6, new TreeNode<>(4, new TreeNode<>(3),
                new TreeNode<>(5)), new TreeNode<>(8, new TreeNode<>(7), new TreeNode<>(9)));

        System.out.println(traverseClockwise(tree));

        tree = new TreeNode<>(1, new TreeNode<>(2, null,
                new TreeNode<>(3)), new TreeNode<>(-1, null, new TreeNode<>(7)));
        System.out.println(traverseClockwise(tree));
    }

    public static <T> List<T> traverseClockwise(TreeNode<T> node) {
        List<T> result = new ArrayList<>();
        //I assumed that root node at least have left and right nodes, because otherwise I don't know what should I return
        result.add(node.val);
        traverseRight(node.right, result);
        traverseBottom(node, result);
        traverseLeft(node.left, result);
        return result;
    }

    public static <T> void traverseRight(TreeNode<T> node, List<T> result) {
        result.add(node.val);
        if (node.right != null) {
            if (!isLeaf(node.right)) {
                traverseRight(node.right, result);
            }
        } else if (node.left != null) {
            if (!isLeaf(node.left)) {
                traverseRight(node.left, result);
            }
        }
    }

    public static <T> void traverseBottom(TreeNode<T> node, List<T> result) {
        if (node.right != null) {
            traverseBottom(node.right, result);
        }
        if (node.left != null) {
            traverseBottom(node.left, result);
        }
        if (isLeaf(node)) {
            result.add(node.val);
        }

    }

    public static <T> void traverseLeft(TreeNode<T> node, List<T> result) {
        if (node.left != null) {
            traverseLeft(node.left, result);
            result.add(node.val);
        } else if (node.right != null) {
            traverseLeft(node.right, result);
            result.add(node.val);
        }
    }

    private static <T> boolean isLeaf(TreeNode<T> node) {
        return node.right == null && node.left == null;
    }


}


