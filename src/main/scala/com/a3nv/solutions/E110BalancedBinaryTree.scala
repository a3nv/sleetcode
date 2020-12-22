package com.a3nv.solutions

import com.a3nv.utils.TreeNode

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *      3
 *     / \
 *    9   20
 *       /  \
 *     15    7
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 *           1
 *          / \
 *         2   2
 *       /  \
 *      3    3
 *    /  \
 *   4    4
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 * Input: root = []
 * Output: true
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 * @author Ivan Asonov
 *         Date: December 22, 2020
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">110. Balanced Binary Tree</a>
 */
class E110BalancedBinaryTree {

  def getHeight(node: TreeNode): Int = node match {
    case null => 0
    case r if r.left == null && r.right == null => 1
    case r => 1 + math.max(getHeight(node.left), getHeight(node.right))
  }

  def isBalanced(root: TreeNode): Boolean = root match {
    case null => true
    case r => isBalanced(root.left) && isBalanced(root.right) && (math.abs(getHeight(root.left) - getHeight(root
      .right)) <= 1)
  }
}