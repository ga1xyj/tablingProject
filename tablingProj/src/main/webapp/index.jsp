<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>줄서: 맛집 검색 및 예약</title>
<link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet">
<link href="css/slide.css" rel="stylesheet">
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
        <form action="${pageContext.request.contextPath }/storeSearchPaging.do">
          <input type="text" id="window" name="keyword" placeholder="지역, 식당 또는 음식" />
          <input type="hidden" name="pageNum" value="1">
          <input type="hidden" name="amount" value="6">
          <input id="search" type="submit" value="검색">
         </form>
        </div>
    </header>
    <hr>
    <div id="recommend-container">
    	<h2>추천 맛집 리스트</h2>
    	<!-- slide -->
    	  <div id="container">
    <div class="slide_wrap">    
      <div class="slide_box">      
        <div class="slide_list clearfix">        
          <div class="slide_content slide01">          
            <p>1</p>        
          </div>        
          <div class="slide_content slide02">          
            <p>2</p>        
          </div>        
          <div class="slide_content slide03">          
            <p>3</p>        
          </div>        
          <div class="slide_content slide04">          
            <p>4</p>        
          </div>        
          <div class="slide_content slide05">          
            <p>5</p>        
          </div>      
        </div>     
         <!-- // .slide_list -->    
        </div>    
        <!-- // .slide_box -->    
        <div class="slide_btn_box">     
           <a class="slide_btn_prev">&lt;</a>      
           <a type="button" class="slide_btn_next">&gt;</a>    
          </div>    
          <!-- // .slide_btn_box -->   
           <ul class="slide_pagination"></ul>    
           <!-- // .slide_pagination -->  
          </div>  
          <!-- // .slide_wrap -->
        </div>
        <!-- // .container -->
        		
     	<script src="js/slide.js"></script>
    </div>
  </body>
</html>