<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<h2 class="float-left">Member List</h2>
<div class="form-group float-left ml-3">
	<form action="/member/list" class="form-inline">
		<select class="form-control" name="range">
			<option value="en" <c:out value="${pghdl.pgvo.range eq 'en' ? 'selected' : '' }"/>>Email+Nickname</option>
			<option value="e" <c:out value="${pghdl.pgvo.range eq 'e' ? 'selected' : '' }"/>>Email</option>
			<option value="n" <c:out value="${pghdl.pgvo.range eq 'n' ? 'selected' : '' }"/>>Nickname</option>
			<option value="r" <c:out value="${pghdl.pgvo.range eq 'r' ? 'selected' : '' }"/>>Regdate</option>
		</select>
		<input class="form-control" type="text" placeholder="검색어 입력" name="keyword"
		value='<c:out value="${pghdl.pgvo.keyword }"/>'>
		<button type="submit" class="btn btn-success">검색</button>
	</form>
</div>
<c:choose>
	<c:when test="${ses.email eq 'admin@admin.com' }">
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Email</th>
        <th>Nickname</th>
        <th>Regdate</th>
        <th>Feature</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${m_list }" var="mvo">
      <tr>
        <td>${mvo.email }</td>
        <td>${mvo.nickname }</td>
        <td>${mvo.regdate }</td>
        <td>
        	<a href="/member/modify?email=${mvo.email }" 
        	class="btn btn-warning mod-btn">EDIT</a>
        	<button type="button" class="btn btn-danger del-btn">DEL</button>
        </td>
      </tr>
      </c:forEach>      
    </tbody>
    <tfoot>
    	<tr>
    		<td	colspan="5">
    			<jsp:include page="../common/pagingMem.jsp"/>
    		</td>
    	</tr>
    </tfoot>
  </table>
  <form action="/member/remove" method="post" id="rmForm">
  	<input type="hidden" name="email">
  </form>
  <script>
  	$(function() {
  		/* $(document).on("cliic", ".mod-btn", function(){
  			let email_val = $(this).closest("tr").find("td").eq(0).text();
  			location.href="/member/modify?email="+email_val; // get 방식(이렇게 하는 건 별로임 a태그로 하는게 맞음 ㅎㅎ)
  		}); */
		$(document).on("click",".del-btn", function(e) {
			e.preventDefault();
			let email_val = $(this).closest("tr").find("td").eq(0).text();
			$("#rmForm > input[name=email]").val(email_val);
			$("#rmForm").submit();
		});		
	});
  </script>
	</c:when>
	<c:otherwise>
		<script>
			alert("관리자 로그인이 필요한 페이지 입니다!");
			location.replace("/member/login");
		</script>
	</c:otherwise>
</c:choose>
  
<jsp:include page="../common/footer.jsp" />