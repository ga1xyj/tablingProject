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
				urlList.add(rs.getString("store_img_url"));
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
				urlList.add(rs.getString("store_img_url"));
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
	
	//전체 리스트 조회
//	public List<Store> getList() {
//		String sql = "SELECT * FROM stores";
//		List<Store> list = new ArrayList<>();
//		connect();
//		try {
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
//			while (rs.next()) {
//				Store store = new Store();
//				store.setStoreId(rs.getString("store_id"));
//				store.setStoreName(rs.getString("store_name"));
//				store.setMemberId(rs.getString("member_id"));
//				store.setStoreAddress(rs.getString("store_address"));
//				store.setTelephone(rs.getString("telephone"));
//				store.setSitCapacity(rs.getInt("sit_capacity"));
//				store.setAvailableTime(rs.getString("available_time"));
//				store.setHoliday(rs.getInt("holiday"));
//				store.setRepresnetMenu(rs.getString("represent_menu"));
//				store.setFoodCategory(rs.getString("food_category"));
//				List<String> urlList = new ArrayList<String>();
//				urlList.add(rs.getString("store_img_url"));
//				store.setStoreImgUrl(urlList);
//				store.setApprovalStatus(rs.getString("approval_status"));
//				list.add(store);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//		return list;
//	}
	
	//페이징 
	public List<Store> searchPagingkeyword(Criteria cri, String keyword) {
		String sql = "select * from(select rownum rn, store_id, store_name, member_id, store_address, telephone, sit_capacity, available_time, holiday, represent_menu, store_img_url, food_category, approval_status"    
						+" from (SELECT *" 
						+ " from stores"
						+ " where store_name like '%'||?||'%' "
						+ " or store_address like '%'||?||'%' "
						+ " or represent_menu like '%'||?||'%' "
						+ " or food_category like '%'||?||'%' )"
						+ " where rownum <= ?)"
						+ " where rn > ?";
		// ORDER BY 별점순 구현
		List<Store> list = new ArrayList<>();
		connect();
		int cnt = 1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(cnt++, keyword);
			ps.setString(cnt++, keyword);
			ps.setString(cnt++, keyword);
			ps.setString(cnt++, keyword);
			ps.setInt(cnt++, cri.getAmount()*cri.getPageNum());
			ps.setInt(cnt++, cri.getAmount()*(cri.getPageNum()-1));
			rs = ps.executeQuery();
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
				urlList.add(rs.getString("store_img_url"));
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
	
}
	