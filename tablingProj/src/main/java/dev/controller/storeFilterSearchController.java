package dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.Utils;
import dev.domain.Store;
import dev.service.StoreService;

public class storeFilterSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		StoreService storeService = StoreService.getStoreService();
		//String order = req.getParameter("order");
		String[] area = req.getParameterValues("area");
		String[] food = req.getParameterValues("food");
		/*
		String[] storeId = req.getParameterValues("storeId");
		List<Store> list = storeService.findFilterStores(storeId, area, food);
		*/
		HttpSession session = req.getSession();
		String keyword = (String)session.getAttribute("keyword");
		List<Store> list = storeService.findFilterStores(keyword, area, food);
		req.setAttribute("list", list);
		Utils.forward(req, resp, "jsp/storeSearchOutput.jsp");
	}

}
