<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<h2 class="float-left">Product List</h2>
<div class="form-group float-left ml-3">
	<form action="/product/list" class="form-inline">
		<select class="form-control" name="range">
			<option value="tcw" <c:out value="${pghdl.pgvo.range eq 'tcw' ? 'selected' : '' }"/>>
			전체</option>
			<option value="t" <c:out value="${pghdl.pgvo.range eq 't' ? 'selected' : '' }"/>>
			제목</option>
			<option value="c" <c:out value="${pghdl.pgvo.range eq 'c' ? 'selected' : '' }"/>>
			내용</option>
			<option value="w" <c:out value="${pghdl.pgvo.range eq 'w' ? 'selected' : '' }"/>>
			작성자</option>
			<option value="tc" <c:out value="${pghdl.pgvo.range eq 'tc' ? 'selected' : '' }"/>>
			제목+내용</option>
		</select>
		<input class="form-control" type="text" placeholder="검색어 입력" name="keyword"
		value='<c:out value="${pghdl.pgvo.keyword }"/>'>
		<button type="submit" class="btn btn-success">검색</button>
	</form>
</div>
<c:if test="${ses.email ne '' && ses.email ne null }">
	<a href="/product/register" class="btn btn-success float-right">등록</a>
</c:if>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Pno</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Readcount</th>
        <th>Moddate</th>
      </tr>
    </thead>
    <c:choose>
    	<c:when test="${list.size() ne 0 }">
    		<tbody>
  		 	 <c:forEach items="${list }" var="pvo">
    		  <tr>
     		   <td>${pvo.pno }</td>
     		   <td><a href="/product/detail?pno=${pvo.pno }">${pvo.title }</a></td>
     		   <td>${pvo.writer }</td>
     		   <td>${pvo.readcount }</td>
     		   <td>${pvo.moddate }</td>
    		  </tr>
    	 	 </c:forEach>
   		 	</tbody>
   		 	<tfoot>
    			<tr>
    				<td	colspan="5">
    					<jsp:include page="../common/paging.jsp"/>
    				</td>
    			</tr>
    		</tfoot>
    	</c:when>
    	<c:otherwise>
    		<tbody>
    			<tr>
    				<td colspan="5" class="text-center">
    					<h3>등록된 상품이 없습니다!</h3>
    				</td>
    			</tr>
    		</tbody>
    	</c:otherwise>
    </c:choose>
    
  </table>

<jsp:include page="../common/footer.jsp" />