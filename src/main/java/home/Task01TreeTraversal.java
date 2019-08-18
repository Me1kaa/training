package home;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implement in-post-pre order tree traversal, using recursion and iteration.
 */
public class Task01TreeTraversal {

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

    //test
    public static void main(String[] args) {
        TreeNode<Integer> tree = new TreeNode<>(6, new TreeNode<>(4, new TreeNode<>(3),
                new TreeNode<>(5)), new TreeNode<>(8, new TreeNode<>(7), new TreeNode<>(9)));
        System.out.println(createPreOrderRec(tree));
        System.out.println(createPreOrderIter(tree));
        System.out.println(createInOrderRec(tree));
        System.out.println(createInOrderIter(tree));
        System.out.println(createPostOrderRec(tree));
    }

    private static <T> List<T> createPreOrderRec(TreeNode<T> node) {
        List<T> preordered = new ArrayList<>();
        createPreOrderInternalRec(node, preordered);
        return preordered;
    }

    private static <T> void createPreOrderInternalRec(TreeNode<T> root, List<T> result) {
        result.add(root.val);
        if (root.left != null) createPreOrderInternalRec(root.left, result);
        if (root.right != null) createPreOrderInternalRec(root.right, result);
    }

    private static <T> List<T> createInOrderRec(TreeNode<T> node) {
        List<T> inordered = new ArrayList<>();
        createInOrderInternalRec(node, inordered);
        return inordered;
    }

    private static <T> void createInOrderInternalRec(TreeNode<T> root, List<T> result) {
        if (root.left != null) createInOrderInternalRec(root.left, result);
        result.add(root.val);
        if (root.right != null) createInOrderInternalRec(root.right, result);
    }

    private static <T> List<T> createPostOrderRec(TreeNode<T> node) {
        List<T> postordered = new ArrayList<>();
        createPostOrderInternalRec(node, postordered);
        return postordered;
    }

    private static <T> void createPostOrderInternalRec(TreeNode<T> root, List<T> result) {
        if (root.left != null) createPostOrderInternalRec(root.left, result);
        if (root.right != null) createPostOrderInternalRec(root.right, result);
        result.add(root.val);
    }

    private static <T> List<T> createInOrderIter(TreeNode<T> node) {
        List<T> result = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    private static <T> List<T> createPostOrderIter(TreeNode<T> node) {
        if(node == null) return Collections.emptyList();
        Deque<T> resultStack = new ArrayDeque<>();
        Deque<TreeNode<T>> traversalStack = new ArrayDeque<>();
        resultStack.push(node.val);
        traversalStack.push(node);
        do {
            while (node.right != null) {
                resultStack.push(node.right.val);
                traversalStack.push(node.right);
                node = node.right;
            }

            while(!traversalStack.isEmpty()
                    && (node = traversalStack.pop()).left == null);
            if(node.left != null) {
                resultStack.push(node.left.val);
                traversalStack.push(node.left);
                node = node.left;
            }
        } while (!traversalStack.isEmpty());

        return new ArrayList<>(resultStack);
    }

    private static <T> List<T> createPreOrderIter(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);
        while ((root = stack.pollFirst()) != null) {
            result.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return result;
    }

}
