package dev.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.domain.Criteria;
import dev.domain.Store;

public class StoreRepository extends DAO {

	// 단건조회(키워드)-리스트출력
	public List<Store> searchKeyword(String keyword) {
		String sql = "SELECT * FROM stores" + " WHERE store_name like '%" + keyword + "%'" + " OR store_address like '%"
				+ keyword + "%'" + " OR represent_menu like '%" + keyword + "%'" + " OR food_category like '%" + keyword
				+ "%'";
		// ORDER BY 별점순 구현
		List<Store> list = new ArrayList<>();
		connect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Store store = new Store();
				store.setStoreId(rs.getString("store_id"));
				store.setStoreName(rs.getString("store_name"));
				store.setMemberId(rs.getString("member_id"));
				store.setStoreAddress(rs.getString("store_address"));
				store.setTelephone(rs.getString("telephone"));
				store.setSitCapacity(rs.getInt("sit_capacity"));
				store.setAvailableTime(rs.getString("available_time"));
				store.setHoliday(rs.getInt("holiday"));
				store.setRepresnetMenu(rs.getString("represent_menu"));
				store.setFoodCategory(rs.getString("food_category"));
				List<String> urlList = new ArrayList<String>();
				urlList.add(rs.getString(10));
				store.setStoreImgUrl(urlList);
				store.setApprovalStatus(rs.getString("approval_status"));
				list.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//상세 조건 검색
	public List<Store> searchFilter(String keyword, String[] area, String[] food) {
		String sql = "SELECT * FROM"
				+ "(SELECT * FROM stores WHERE store_name like '%" + keyword + "%'" + " OR store_address like '%" + keyword + "%'" + " OR represent_menu like '%" + keyword + "%'" + " OR food_category like '%" + keyword+ "%')";
		if(area.length>1||food.length>1) {
			sql += "WHERE store_address ='"+area[0]+"' OR food_category='"+food[0]+"'";
			for (int i=1; i<area.length; i++) {
				sql += " OR store_address LIKE '%"+ area[i]+ "%'";
			}
			for (int i=1; i<food.length; i++) {
				sql += " OR food_category='"+food[i]+"'";
			}
		}
				
	
		List<Store> list = new ArrayList<>();
		connect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Store store = new Store();
				store.setStoreId(rs.getString("store_id"));
				store.setStoreName(rs.getString("store_name"));
				store.setMemberId(rs.getString("member_id"));
				store.setStoreAddress(rs.getString("store_address"));
				store.setTelephone(rs.getString("telephone"));
				store.setSitCapacity(rs.getInt("sit_capacity"));
				store.setAvailableTime(rs.getString("available_time"));
				store.setHoliday(rs.getInt("holiday"));
				store.setRepresnetMenu(rs.getString("represent_menu"));
				store.setFoodCategory(rs.getString("food_category"));
				List<String> urlList = new ArrayList<String>();
				urlList.add(rs.getString(10));
				store.setStoreImgUrl(urlList);
				store.setApprovalStatus(rs.getString("approval_status"));
				list.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		//System.out.println(sql);
		return list;
	}
	/*
	//추천 맛집 출력
	public List<Store> getRecoStores(Criteria cri) {
		String sql = "SELECT store_id, store_name, store_address, represent_menu, food_category, store_img_url "
				+ "FROM(SELECT rownum rn, store_id, store_name, store_address, represent_menu, food_category, store_img_url "
				+ "FROM (SELECT store_id, store_name, store_address, represent_menu, food_category,  store_img_url "
				+ "FROM stores WHERE rownum <=12 ORDER by store_id ) "
					//store_id -> 별점순으로 변경해야함
				+ "WHERE rownum <= ?) "
				+ "WHERE rn > ?";
		// ORDER BY 별점순 구현
		List<Store> listPage = new ArrayList<>();
		connect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cri.getAmount()*cri.getPageNum()); // 10건씩 첫번째 페이지 10 * 1
			ps.setInt(2, cri.getAmount()*(cri.getPageNum()-1)); // 10
			rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setStoreId(rs.getString("store_id"));
				store.setStoreName(rs.getString("store_name"));
				//store.setMemberId(rs.getString("member_id"));
				store.setStoreAddress(rs.getString("store_address"));
				//store.setTelephone(rs.getString("telephone"));
				//store.setSitCapacity(rs.getInt("sit_capacity"));
				//store.setAvailableTime(rs.getString("available_time"));
				//store.setHoliday(rs.getInt("holiday"));
				store.setRepresnetMenu(rs.getString("represent_menu"));
				store.setFoodCategory(rs.getString("food_category"));
				List<String> urlList = new ArrayList<String>();
				urlList.add(rs.getString("store_img_url"));
				store.setStoreImgUrl(urlList);
				//store.setApprovalStatus(rs.getString("approval_status"));
				listPage.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return listPage;
	}
	//전체 리스트 조회
	public List<Store> getList() {
		String sql = "SELECT * FROM stores";
		List<Store> list = new ArrayList<>();
		connect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Store store = new Store();
				store.setStoreId(rs.getString("store_id"));
				store.setStoreName(rs.getString("store_name"));
				store.setMemberId(rs.getString("member_id"));
				store.setStoreAddress(rs.getString("store_address"));
				store.setTelephone(rs.getString("telephone"));
				store.setSitCapacity(rs.getInt("sit_capacity"));
				store.setAvailableTime(rs.getString("available_time"));
				store.setHoliday(rs.getInt("holiday"));
				store.setRepresnetMenu(rs.getString("represent_menu"));
				store.setFoodCategory(rs.getString("food_category"));
				List<String> urlList = new ArrayList<String>();
				urlList.add(rs.getString(10));
				store.setStoreImgUrl(urlList);
				store.setApprovalStatus(rs.getString("approval_status"));
				list.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	*/
	
}
	