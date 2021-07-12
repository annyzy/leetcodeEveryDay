import java.util.*;
import java.util.Arrays;

public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void add(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left != null) {
                add(node.left, val);
            } else {
                System.out.println(" Added " + val + " to the left of " + node.val);
                node.left = new TreeNode(val);
            }
        } else if (val > node.val) {
            if (node.right != null) {
                add(node.right, val);
            } else {
                System.out.println(" Added " + val + " to the right of " + node.val);
                node.right = new TreeNode(val);
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        System.out.println(res.toString());
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(5);
        System.out.println("Creating a binary tree with root value " + root.val);
        tree.add(root, 2);
        tree.add(root, 4);
        tree.add(root, 8);
        tree.add(root, 6);
        tree.add(root, 7);
        tree.add(root, 3);
        tree.add(root, 9);
        System.out.print("Traversing tree in order: ");
        tree.inorderTraversal(root);
    }
}
