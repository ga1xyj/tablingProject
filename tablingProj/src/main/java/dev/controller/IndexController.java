package dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.Utils;
import dev.domain.Criteria;
import dev.domain.Page;
import dev.domain.Store;
import dev.service.StoreService;

public class IndexController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		Utils.forward(req, resp, "index.jsp");
	}

}
