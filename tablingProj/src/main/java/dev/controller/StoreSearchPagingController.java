package dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.Utils;
import dev.domain.Criteria;
import dev.domain.Page;
import dev.domain.Store;
import dev.service.StoreService;

public class StoreSearchPagingController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		
		//키워드
		HttpSession session = req.getSession();
		String keyword = req.getParameter("keyword");
		if(keyword.equals("중앙로")) {
			keyword="중앙대로";
		}
		session.setAttribute("keyword", keyword);
		
		Criteria cri = new Criteria();
		cri.setPageNum(Integer.parseInt(pageNum));
		cri.setAmount(Integer.parseInt(amount));
		
		StoreService storeService = StoreService.getStoreService();
		List<Store> pageList = storeService.findAllPagingStores(cri, keyword);
		
		req.setAttribute("list", pageList);
		
		List<Store> list = storeService.findAllStores(keyword);
		int total = list.size();
		req.setAttribute("pageInfo", new Page(cri, total));
		Utils.forward(req, resp, "jsp/storeSearchOutput.jsp");
	}

}
