package lintCode;

import java.util.LinkedList;
import java.util.List;

public class P376 {

	public  List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		/*
		 * traverse the tree 
		 * cache the items
		 * compare with the results
		 */

		System.out.println("pass");
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		LinkedList<Integer> tempQ = new LinkedList<Integer>();
		if(root == null){
			
			return results;
		}
		tempQ.add(root.val);

		findPath(root, tempQ, target, results);
		return results;
    }
	
	public  void findPath(TreeNode root, List<Integer> tempQ, int target, List<List<Integer>> results){
		// if leaf, compare, yes --> add
		// not --> list--
		// if not leaf, list++
		int sum = 0;
		for(int i = 0; i < tempQ.size(); i++){
			sum = sum+tempQ.get(i);
		}
		System.out.println("sum: "+sum);
		if(root.left == null && root.right == null && sum == target){
			results.add(new LinkedList<Integer>(tempQ));
			for(int i = 0; i < tempQ.size(); i++){
				System.out.println(tempQ.get(i));
			}
		}
		if(root.left != null){
			tempQ.add(root.left.val);
			findPath(root.left, tempQ, target, results);
			tempQ.remove(tempQ.size()-1);
		}
		if(root.right != null){
			tempQ.add(root.right.val);
			findPath(root.right, tempQ, target, results);
			tempQ.remove(tempQ.size()-1);
		}
		
	}
	
	
	static List<Integer> preOrderList = new LinkedList<Integer>();
	static List<Integer> breadthList = new LinkedList<Integer>();
	static List<TreeNode> que = new LinkedList<TreeNode>();
	
	public static void breadthOrder(TreeNode root){
		que.add(root);
		while(!que.isEmpty()){
			TreeNode temp = que.remove(0);
			breadthList.add(temp.val);
			if(temp.left != null){
				que.add(temp.left);
			}
			if(temp.right != null){
				que.add(temp.right);
			}
		}
		
	}
	
	public static void preOrder(TreeNode a){
		preOrderList.add(a.val);
		if(a.left != null){
			preOrder(a.left);
			preOrderList.add(0);
		}
		if(a.right != null){
			preOrder(a.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		P376 test = new P376();
		System.out.println("pass");
		List<List<Integer>> results = test.binaryTreePathSum(null, 5);
//		P376.breadthOrder(root);
		for(int i = 0; i < results.size(); i++){
			System.out.println(results.get(i));
		}
	}

}



class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = null;
          this.right = null;
      }
  }
