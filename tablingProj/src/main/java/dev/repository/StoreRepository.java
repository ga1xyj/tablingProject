package dev.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	// 필터조회
	public List<Store> searchFilter(String storeId[], String[] area, String[] food) {
		String sql = "SELECT * FROM (SELECT * FROM stores WHERE store_id =";
		if(storeId.length==0) {
			storeId[0]="0";
		}
		sql += storeId[0];
		if(storeId.length>0) {
		for(int i=1; i<storeId.length; i++) {
			sql += " OR store_id = " + storeId[i];
			}
		}
		sql +=")";
		if(area.length > 0 || food.length > 0) {
			sql += " WHERE ";
		}
		if(area.length > 0) {
			sql += "store_address LIKE '%" + area[0] + "%'";
			for (int i=1; i<area.length; i++) {
				sql += " OR store_address LIKE '%"+ area[i]+ "%'";
			}
		}
		if(food.length > 0) {
			sql += "food = " + food[0];
			for (int i=1; i<food.length; i++) {
				sql += " OR food category= "+food[i];
			}
		}
		/*
		String sql = "SELECT * FROM stores WHERE 1=1 ";
		if (area.length > 0) {
			sql += "(";
			for (int i = 1; i < area.length; i++) {
				sql += "store_address like '%'||" + area[i] + "||'%'";
				if(i != area.length) {
					sql += " or ";
				}
			}
			sql += ")";
		}
		if (food.length > 0) {
			sql += "(";
			for (int i = 1; i < food.length; i++) {
				sql += "food_category="+ food[i];
				if(i != food.length) {
					sql += " or ";
				}
			}
			sql += ")";
		}
		if (storeId.length > 0) {
			for (int i = 0; i < storeId.length; i++) {
				sql += " AND WHERE store_id="+storeId[i];
			}
		}
		*/
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
		System.out.println(sql);
		return list;
	}
}
