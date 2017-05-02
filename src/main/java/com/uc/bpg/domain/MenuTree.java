package com.uc.bpg.domain;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.uc.utils.BasicTreeNode;
import com.uc.utils.TreeNode;
import com.uc.utils.TreeImpl;
import com.uc.web.domain.IMenuTree;
import com.uc.web.domain.basic.NoParentFoundException;
import com.uc.web.forms.MenuTreeItem;

public class MenuTree extends TreeImpl<MenuTreeItem<Long>> implements IMenuTree<Long, MenuTreeItem<Long>> {
	private Logger logger;
	public static MenuTree buildMenuTree(List<? extends MenuTreeItem<Long>> items) throws NoParentFoundException{
		MenuTree menuTree=new MenuTree();
		for (MenuTreeItem<Long> menuTreeItem : items) {
			menuTree.addMenuItem(menuTreeItem);
		}
		supressEmpty(menuTree);
		return menuTree;
	}
	
	private static void supressEmpty(MenuTree menuTree) {
		
		Iterator<TreeNode<MenuTreeItem<Long>>> iterator=menuTree.getRoot().getChildren().iterator();
		while(iterator.hasNext()){
			TreeNode<MenuTreeItem<Long>> item=iterator.next();
			supressEmpty(item, iterator);
		}
	}
	
	private static void supressEmpty(TreeNode<MenuTreeItem<Long>> node, Iterator<TreeNode<MenuTreeItem<Long>>> current){
		if(node.hasChildren()){
			Iterator<TreeNode<MenuTreeItem<Long>>> children=node.getChildren().iterator();
			while(children.hasNext()){
				TreeNode<MenuTreeItem<Long>> item=children.next();
				supressEmpty(item, children);
			}
		}
		if(node.getData()!=null && StringUtils.isEmpty(node.getData().getUri()) && !node.hasChildren()){
			current.remove();
		}
	}
	
	
	public MenuTree() {
		logger=LoggerFactory.getLogger(getClass());
	}

	@Override
	public void	addMenuItem(MenuTreeItem<Long> item) throws NoParentFoundException{
		if (item==null) return;
		logger.debug("add item {}-{}-{}", item.getId(), item.getName(), item.getParent());
		TreeNode<MenuTreeItem<Long>> node=new BasicTreeNode<>(item);
		if(item.getParent()==null){
			logger.debug("{} no parent add to root", item.getId());
			getRoot().addChild(node);
			return;
		}
		
		TreeNode<MenuTreeItem<Long>> parent=findItem(item.getParent());
		if(parent!=null){
			parent.addChild(node);
			return;
		}
		throw new NoParentFoundException(item.getParent()+"");
	}
	
	@Override
	public TreeNode<MenuTreeItem<Long>> findItem(Long menuId){
		for(TreeNode<MenuTreeItem<Long>> node:getRoot().getChildren()){
		   TreeNode<MenuTreeItem<Long>> item=findItem(node, menuId);
		   if(item!=null) return item;
		}
		return null;
	}
	
	@Override
	public TreeNode<MenuTreeItem<Long>> findItem(TreeNode<MenuTreeItem<Long>> from, Long menuId){
		if(from.getData()!=null && from.getData().getId().equals(menuId)){
			logger.debug("found {}-{}", from.getData().getId(), from.getData().getName());
			return from;
		}
		for(TreeNode<MenuTreeItem<Long>> item:from.getChildren()){
			TreeNode<MenuTreeItem<Long>> subItem=findItem(item, menuId);
			if(subItem!=null) return subItem;
		}		
		return null;
	}
}
