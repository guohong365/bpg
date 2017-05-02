package com.uc.bpg.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uc.bpg.domain.MenuTree;
import com.uc.bpg.domain.MenuTreeItem;
import com.uc.bpg.domain.Role;
import com.uc.bpg.domain.UserProfile;
import com.uc.bpg.service.CodesService;
import com.uc.bpg.uitls.SystemFormHelper;
import com.uc.utils.ObjectCacheImpl;
import com.uc.web.controller.basic.IntegerKeyControllerSupportImpl;
import com.uc.web.domain.basic.NoParentFoundException;
import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeView;
import com.uc.web.utils.SystemConfig;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RootController extends IntegerKeyControllerSupportImpl {

	private static final String ROLE_RECEPTIONIST = "HOTEL_RECEPTION";

	@Resource(name="${service.codes}")
	private CodesService codesService;

	@Resource(name="${util.menu.formator}")
	private IUIFormator<TreeView> menuFormator;
	
	@RequestMapping(value = {"/"}, method = {RequestMethod.GET})
	public String home(Model model) {
		getLogger().info("------------------------------");
		getLogger().info("          Welcome home!       ");
		getLogger().info("------------------------------");
		
		if(SystemConfig.isDebug()){
			MenuTree menuTree=ObjectCacheImpl.getInstance().get("MENU_TREE");
			if(menuTree==null){
				List<MenuTreeItem> items=codesService.selectAllMenus();
				try {
					menuTree= MenuTree.buildMenuTree(items);
					ObjectCacheImpl.getInstance().put("MENU_TREE", menuTree);
				} catch (NoParentFoundException e) {
					e.printStackTrace();
				}				
			}
			TreeView menuTreeView=ObjectCacheImpl.getInstance().get("MENU_TREE_VIEW");
			if(menuTreeView==null){
				menuTreeView=SystemFormHelper.buildMenuTreeView(menuTree);
				ObjectCacheImpl.getInstance().put("MENU_TREE_VIEW", menuTreeView);
			}			
			StringBuilder menus=new StringBuilder();
			menuFormator.formatHTML(menuTreeView, menus);
			model.addAttribute("menus", menus.toString());
			model.addAttribute("userName", "游客");
			
			return "/ajax";			
		}
		
	
		UserProfile user=(UserProfile) getUserProfile();		
		if(user!=null){			
			for(int i=0; i< user.getRoles().size(); i++){
				Role role=(Role) user.getRoles().get(i);
				if(role.getUuid().equals(ROLE_RECEPTIONIST)){
					return "redirect:/hotel/reception/";
				}
			}
			
			StringBuilder menus=new StringBuilder();
			TreeView menuTreeView=SystemFormHelper.buildMenuTreeView((MenuTree) user.getMenu());			
			menuFormator.formatHTML(menuTreeView, menus);
			model.addAttribute("menus", menus.toString());
			model.addAttribute("userName",user.getOrgnization().getName() +" " + user.getUser().getName());
			return "/ajax";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcome(Model model){
		getLogger().warn("load WELCOM PAGE");
		return "/welcome";
	}
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public String page403(){
		return "/errors/403";
	}
	@RequestMapping(value="/404", method=RequestMethod.GET)
	public String page404(){
		return "/errors/404";
	}
	
	@RequestMapping(value="/500", method=RequestMethod.GET)
	public String page500(){
		return "/errors/500";
	}
}
