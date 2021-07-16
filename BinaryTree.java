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
        helper1(root, res);
        System.out.println(res.toString());
        return res;
    }

    public void helper1(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        if (root.left != null) {
            helper1(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper1(root.right, res);
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        boolean ans = helper2(root, root);
        if (ans == true) {
            System.out.println("It's a symmetric tree. ");
        } else {
            System.out.println("It's not a symmetric tree. ");
        }

        return ans;
    }

    public static boolean helper2(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }

        return helper2(tree1.left, tree2.right) && helper2(tree1.right, tree2.left);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            int max = Math.max(leftHeight, rightHeight) + 1;
            return max;
        }
    }

    public static void main(String args[]) {
        BinaryTree tree1 = new BinaryTree();
        TreeNode root1 = new TreeNode(5);
        System.out.println("Creating a binary tree1 with root value " + root1.val);
        tree1.add(root1, 2);
        tree1.add(root1, 4);
        tree1.add(root1, 8);
        tree1.add(root1, 6);
        tree1.add(root1, 7);
        tree1.add(root1, 3);
        tree1.add(root1, 9);
        System.out.print("Traversing tree in order: ");
        tree1.inorderTraversal(root1);
        boolean ans1 = isSymmetric(root1);
        int tree1Depth = maxDepth(root1);
        System.out.println("Tree1 depth is " + tree1Depth);

        System.out.println("");

        BinaryTree tree2 = new BinaryTree();
        TreeNode root2 = new TreeNode(2);
        System.out.println("Creating a symmetric binary tree2 with root value " + root2.val);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.left.right = new TreeNode(5);
        root2.left.left = new TreeNode(9);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(9);
        System.out.print("Traversing tree2 in order: ");
        tree2.inorderTraversal(root2);
        boolean ans2 = isSymmetric(root2);
        int tree2Depth = maxDepth(root2);
        System.out.println("Tree2 depth is " + tree2Depth);
    }
}
