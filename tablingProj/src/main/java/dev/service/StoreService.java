package dev.service;

import java.util.ArrayList;
import java.util.List;

import dev.domain.Criteria;
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
      // 사진 url 세팅
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
   public List<Store> findFilterStores(String keyword, String[] area, String[] food){
	   List<Store> list = storeRepository.searchFilter(keyword, area, food);
	   for (Store store : list) {
	         String url = store.getStoreImgUrl().get(0);
	         List<String> urlList = new ArrayList<String>();
	         urlList.add(url.substring(0, url.indexOf("-")));
	         store.setStoreImgUrl(urlList);
	      }
	   return list;
   }
//   //페이징
   public List<Store> findAllPagingStores(Criteria cri, String keyword) {
	 List<Store> list = storeRepository.searchPagingkeyword(cri, keyword);
     // 사진 url 세팅
     for (Store store : list) {
        String url = store.getStoreImgUrl().get(0);
        List<String> urlList = new ArrayList<String>();
        urlList.add(url.substring(0, url.indexOf("-")));
        store.setStoreImgUrl(urlList);
     }
	return list;
	}  
//
//   public List<Store> printStoreList(){
//	List<Store> list = storeRepository.getList();
//    // 사진 url 세팅
//    for (Store store : list) {
//       String url = store.getStoreImgUrl().get(0);
//       List<String> urlList = new ArrayList<String>();
//       urlList.add(url.substring(0, url.indexOf("-")));
//       store.setStoreImgUrl(urlList);
//    }
//	return list;
//	}  

public List<Store> findAllFilterPagingStores(Criteria cri, String keyword, String[] area, String[] food) {
	 List<Store> list = storeRepository.searchPagingkeywordFilter(cri, keyword, area, food);
     // 사진 url 세팅
     for (Store store : list) {
        String url = store.getStoreImgUrl().get(0);
        List<String> urlList = new ArrayList<String>();
        urlList.add(url.substring(0, url.indexOf("-")));
        store.setStoreImgUrl(urlList);
     }
	return list;
}

}