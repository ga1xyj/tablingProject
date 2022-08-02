package dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.Utils;
import dev.domain.Criteria;
import dev.domain.Page;
import dev.domain.Store;
import dev.service.StoreService;

public class recommendOutputController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		
		Criteria cri = new Criteria();
		cri.setPageNum(Integer.parseInt(pageNum));
		cri.setAmount(Integer.parseInt(amount));
		
		StoreService storeService = StoreService.getStoreService();
		
		List<Store> list = storeService.findRecoStores(cri);
		req.setAttribute("recoList", list);
		List<Store>totalList = storeService.printStoreList();
		int total = totalList.size();
		req.setAttribute("pageInfo", new Page(cri, total));
		Utils.forward(req, resp, "index.jsp");
	}

}
