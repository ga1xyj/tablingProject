<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>줄서: 맛집 검색 및 예약</title>
<link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet">
</head>
<body>
    <header>
    <nav>
      <table class="head_table">
        <tr>
          <td>
            <a href="#"><img src="https://i.ibb.co/9GBqh4x/logo.png" alt="" /></a>
          </td>
          <td class="td_width">
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">게시판</span>
              </button>
              <div class="dropdown-content">
                <a href="#">공지게시판</a>
                <a href="#">자유게시판</a>
              </div>
            </div>
          </td>
          <td class="td_width">
            <div class="dropdown">
              <button class="dropbtn">
                <span class="dropbtn_icon">마이페이지</span>
              </button>
              <div class="dropdown-content">
                <a href="#">정보수정</a>
                <a href="#">찜목록</a>
                <a href="#">예약확인</a>
              </div>
            </div>
          </td>
         </tr>
        </table>
      </nav>
        <!-- nav -->
       <div id="search-container">
        <form action="${pageContext.request.contextPath }/storeSearch.do">
          <input type="text" id="window" name="keyword" placeholder="지역, 식당 또는 음식" />
          <input id="search" type="submit" value="검색">
         </form>
        </div>
    </header>
    <hr>
  </body>
</html>