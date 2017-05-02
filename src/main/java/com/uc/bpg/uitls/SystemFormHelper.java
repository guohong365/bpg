package com.uc.bpg.uitls;

import com.uc.utils.TreeNode;
import com.uc.web.domain.IMenuTree;
import com.uc.web.domain.basic.IntegerCode;
import com.uc.web.forms.MenuTreeItem;
import com.uc.web.forms.ui.TreeView;
import com.uc.web.forms.ui.TreeViewNode;


public class SystemFormHelper {
	public static IntegerCode createCodetable(Long code, String value, boolean valid){
		IntegerCode codeTable=new IntegerCode(code, value, valid);
		return codeTable;
	}
	
	public static IntegerCode createAllOption(){
		return createCodetable((long) 0, "所有", true);
	}
	
	public static IntegerCode createSelecetOption(String value) {
		return createCodetable((long) 0, value, true);
	}
	
	static void addMenuNode(TreeView treeView, 
			TreeViewNode parent, 
			TreeNode<MenuTreeItem<Long>> menuitem){
		TreeViewNode current=menuitem.getData()==null ? parent : 
			treeView.add(parent, new TreeViewNode(menuitem.getData().getName(), menuitem.getData().getName(), menuitem.getData()));
		for(TreeNode<MenuTreeItem<Long>> item: menuitem.getChildren()){
			addMenuNode(treeView, current, item);
		}
	}
	public static TreeView buildMenuTreeView(IMenuTree<Long, MenuTreeItem<Long>> menuTree){
		TreeView treeView= new TreeView();
		addMenuNode(treeView, treeView.getRoot(), menuTree.getRoot());
		return treeView;
	}
}
