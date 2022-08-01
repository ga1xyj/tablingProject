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
		String[] storeId = req.getParameterValues("storeId");
		String[] area = req.getParameterValues("area");
		String[] food = req.getParameterValues("food");
		
		for(String a : storeId) {
			System.out.println(a);
		}
		for(String a : area) {
			System.out.println(a);
		}
		for(String a : food) {
			System.out.println(a);
		}
		List<Store> list = storeService.findFilterStores(storeId, area, food);
		req.setAttribute("list", list);
		Utils.forward(req, resp, "jsp/storeSearchOutput.jsp");
	}

}
