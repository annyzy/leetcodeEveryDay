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

    public List<List<Integer>> levelOrder(TreeNode root) {
        // A extension of BFS approach
        // Creat a list of list to store the levelOrder result
        List<List<Integer>> list = new ArrayList<>();

        // Creat a queue to temporarily store the nodes of each level
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            System.out.println("This tree is invalid.");
            return list;
        } else {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int n = queue.size();
            // Creat a list to store each level of the tree
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // Remove the head element of the queue and put it into each level
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            System.out.println("This tree is invalid.");
            return list;
        } else {
            queue.add(root);
        }

        // level order from left to right(even level) or right to left(odd level)
        boolean evenLevel = true;

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (evenLevel) {
                    level.add(node.val);
                } else {
                    // Add a new node val at index 0 to realize right to left order
                    level.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            evenLevel = !evenLevel;
            list.add(level);
        }
        return list;
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

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.right)
                    && isBalanced(root.left);
        }
    }

    long previous = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        // visit left subtree
        if (!isValidBST(root.left))
            return false;

        // visit current node
        if (root.val <= previous)
            return false;

        previous = root.val;

        // visit left subtree
        return isValidBST(root.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }

        if ((root == a || root == b) || (root == a && root == b)) {
            System.out.println("Lowest common ancestor of Node " + a.val + " and Node " + b.val + " is " + root.val);
            return root;
        }

        TreeNode leftSearchTree = lowestCommonAncestor(root.left, a, b);
        TreeNode rightSearchTree = lowestCommonAncestor(root.right, a, b);

        if (leftSearchTree == null && rightSearchTree == null) {
            return null;
        }
        if (leftSearchTree == null) {
            return rightSearchTree;
        }
        if (rightSearchTree == null) {
            return leftSearchTree;
        }
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length - 1;
        return helper3(nums, 0, n);
    }

    public TreeNode helper3(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper3(nums, left, mid - 1);
        root.right = helper3(nums, mid + 1, right);
        return root;
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
        isSymmetric(root1);
        int tree1Depth = maxDepth(root1);
        System.out.println("Tree1 depth is " + tree1Depth + ".");
        if (isBalanced(root1) == true) {
            System.out.println("Tree1 is a balanced tree.");
        } else {
            System.out.println("Tree1 is not a balanced tree.");
        }

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
        isSymmetric(root2);
        int tree2Depth = maxDepth(root2);
        System.out.println("Tree2 depth is " + tree2Depth + ".");
        if (isBalanced(root2) == true) {
            System.out.println("Tree2 is a balanced tree.");
        } else {
            System.out.println("Tree2 is not a balanced tree.");
        }

        System.out.println("");

        BinaryTree tree3 = new BinaryTree();
        TreeNode root3 = new TreeNode(1);
        System.out.println("Creating a symmetric binary tree3 with root value " + root3.val);
        ;
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        System.out.print("Traversing tree3 in order: ");
        tree3.inorderTraversal(root3);
        if (isBalanced(root3) == true) {
            System.out.println("Tree3 is a balanced tree.");
        } else {
            System.out.println("Tree3 is not a balanced tree.");
        }
    }
}
