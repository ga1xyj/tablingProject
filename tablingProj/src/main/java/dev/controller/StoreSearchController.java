package dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.Utils;
import dev.domain.Store;
import dev.service.StoreService;

public class StoreSearchController implements Controller{

	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		
		String keyword = req.getParameter("keyword");
		StoreService storeService = StoreService.getStoreService();
		List<Store> list = storeService.findAllStores(keyword);
		req.setAttribute("keyword", keyword);
		req.setAttribute("list", list);
		Utils.forward(req, resp, "jsp/storeSearchOutput.jsp");
		
		session.setAttribute("list", list);
	}

}
