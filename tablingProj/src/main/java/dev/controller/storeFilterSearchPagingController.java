package dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.Utils;
import dev.domain.Criteria;
import dev.domain.Store;
import dev.service.StoreService;

public class storeFilterSearchPagingController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String job = req.getParameter("job");
		req.setAttribute("job", job);
		//페이지 
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		Criteria cri = new Criteria();
		cri.setPageNum(Integer.parseInt(pageNum));
		cri.setAmount(Integer.parseInt(amount));
		
		//지역, 음식 선택
		String[] area = req.getParameterValues("area");
		String[] food = req.getParameterValues("food");
		
		//세션에서 키워드 불러오기
		HttpSession session = req.getSession();
		String keyword = (String)session.getAttribute("keyword");
		if(keyword.equals("중앙로")) {
			keyword="중앙대로";
		}
		session.setAttribute("keyword", keyword);
		
		StoreService storeService = StoreService.getStoreService();
		List<Store> pageFilterList = storeService.findAllFilterPagingStores(cri, keyword, area, food);
		session.setAttribute("list", pageFilterList);
		Utils.forward(req, resp, "jsp/storeSearchOutput.jsp");
	}

}
