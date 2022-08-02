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
    <div id="recommend-container">
    	<h2>추천 맛집 리스트</h2>
    		<!-- slide -->
    		<div id="slideShow">
	    		<ul class="slides">
				    <li><img src="http://www.rainbowfestival.co.kr/wp-content/uploads/2017/05/585be1aa1600002400bdf2a6-970x658.jpeg" alt=""></li>
				    <li><img src="http://www.rainbowfestival.co.kr/wp-content/uploads/2017/05/585be1aa1600002400bdf2a6-970x658.jpeg" alt=""></li>
				    <li><img src="http://www.rainbowfestival.co.kr/wp-content/uploads/2017/05/585be1aa1600002400bdf2a6-970x658.jpeg" alt=""></li>
				    <li><img src="http://www.rainbowfestival.co.kr/wp-content/uploads/2017/05/585be1aa1600002400bdf2a6-970x658.jpeg" alt=""></li>
				    <li><img src="http://www.rainbowfestival.co.kr/wp-content/uploads/2017/05/585be1aa1600002400bdf2a6-970x658.jpeg" alt=""></li>
				    <li><img src="http://www.rainbowfestival.co.kr/wp-content/uploads/2017/05/585be1aa1600002400bdf2a6-970x658.jpeg" alt=""></li>
    			</ul>  
    			<p class="controller">
			      <!-- &lt: 왼쪽 방향 화살표
			      &gt: 오른쪽 방향 화살표 -->
			      <span class="prev">&lt;</span>  
			      <span class="next">&gt;</span>
    			</p>
  			</div>
   	</div>
   	<script>
	   	const slides = document.querySelector('.slides'); //전체 슬라이드 컨테이너
	   	const slideImg = document.querySelectorAll('.slides li'); //모든 슬라이드들
	   	let currentIdx = 0; //현재 슬라이드 index
	   	const slideCount = slideImg.length; // 슬라이드 개수
	   	const prev = document.querySelector('.prev'); //이전 버튼
	   	const next = document.querySelector('.next'); //다음 버튼
	   	const slideWidth = 400; //한개의 슬라이드 넓이
	   	const slideMargin = 100; //슬라이드간의 margin 값
	
	   	//전체 슬라이드 컨테이너 넓이 설정
	   	slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';
	
	   	function moveSlide(num) {
	   	  slides.style.left = -num * 400 + 'px';
	   	  currentIdx = num;
	   	}
	
	   	prev.addEventListener('click', function () {
	   	  /*첫 번째 슬라이드로 표시 됐을때는 
	   	  이전 버튼 눌러도 아무런 반응 없게 하기 위해 
	   	  currentIdx !==0일때만 moveSlide 함수 불러옴 */
	
	   	  if (currentIdx !== 0) moveSlide(currentIdx - 1);
	   	});
	
	   	next.addEventListener('click', function () {
	   	  /* 마지막 슬라이드로 표시 됐을때는 
	   	  다음 버튼 눌러도 아무런 반응 없게 하기 위해
	   	  currentIdx !==slideCount - 1 일때만 
	   	  moveSlide 함수 불러옴 */
	   	  if (currentIdx !== slideCount - 1) {
	   	    moveSlide(currentIdx + 1);
	   	  }
	   	});
   	</script>
  </body>
</html>