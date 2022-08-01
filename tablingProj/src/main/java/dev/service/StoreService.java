package dev.service;

import java.util.ArrayList;
import java.util.List;

import dev.domain.Store;
import dev.repository.StoreRepository;

public class StoreService {
	private static StoreService storeService = new StoreService();
	StoreRepository storeRepository = new StoreRepository();
	
	private StoreService() {};
	
	public static StoreService getStoreService() {
		return storeService;
	}
	/*
	//키워드 조회
	public List<Store> findStore(String keyword) {
		return storeRepository.searchKeyword(keyword);
	}
	*/
	//키워드 조회
   public List<Store> findAllStores(String keyword) {
      List<Store> list = storeRepository.searchKeyword(keyword);
      for (Store store : list) {
         String url = store.getStoreImgUrl().get(0);
         List<String> urlList = new ArrayList<String>();
         urlList.add(url.substring(0, url.indexOf("-")));
         store.setStoreImgUrl(urlList);
      }
      return list;
   }
   //필터 조회
   	//order 추가 해야함
   public List<Store> findFilterStores(String[] storeId, String[] area, String[] food){
	   List<Store> list = storeRepository.searchFilter(storeId, area, food);
	   return list;
   }
}