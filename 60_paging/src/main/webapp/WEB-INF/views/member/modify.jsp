<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<h2>Member Modify</h2>
<c:choose>
	<c:when test="${ses.email eq mvo.email }">
		<c:if test="${ses.email ne 'admin@admin.com' }">
		<form action="/member/modify" method="post">
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" value="${mvo.email }"
					readonly>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" name="pwd" value="${mvo.pwd }">
			</div>
			<div class="form-group">
				<label for="nickname">Nickname:</label> <input type="text"
					class="form-control" id="nickname" name="nickname"
					value="${mvo.nickname }">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		</c:if>
	</c:when>
	<c:otherwise>
		<script>
			alert("로그인이 필요한 페이지 입니다!");
			location.replace("/member/login");
		</script>
	</c:otherwise>
</c:choose>

<jsp:include page="../common/footer.jsp" />