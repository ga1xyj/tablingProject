<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- left < -->
    <c:if test="${pageInfo.prev }">
  		<a href="index.do?pageNum=${pageInfo.startPage - 1 }&amount=${pageInfo.cri.amount}">&lt;</a>
  	</c:if>
    	<div id="recommend-container">
    		<h2>추천 맛집 리스트</h2>
    			<c:forEach var="reco-store" items="${recoList }">
		    		<!-- 이미지 -->
		    		<c:forEach var="img" items="${reco-store.storeImgUrl }">
		    			<img src="${pageContext.request.contextPath }/img/tabling_img/${img }" width="300" height="200">
					</c:forEach>
					<div id="store-info">
						<!-- 가게명 -->
						<br>${reco-store.storeName }
						<!-- 주소 -->
						<c:set var="add" value="${reco-store.storeAddress }" />
						<c:set var="lo" value="${fn:indexOf(add, '로') }" />
						<br>${fn:substring(add,9,lo+1) } 
						<!-- 대표메뉴 -->
						<br>${reco-store.representMenu }.replaceAll("[0-9]", "")
					</div>
					<div class="pagination-circle">
					 	<c:forEach var="num" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
  							<a href="index.do?pageNum=${num }&amount=${pageInfo.cri.amount}">•</a>
 						</c:forEach>
					</div>
				</c:forEach>
    	</div>
    	<!-- right > -->
   		<c:if test="${pageInfo.next }">
  			<a href="inedx.do?pageNum=${pageInfo.startPage - 1 }&amount=${pageInfo.cri.amount}">&gt;</a>
  		</c:if>
</body>
</html>