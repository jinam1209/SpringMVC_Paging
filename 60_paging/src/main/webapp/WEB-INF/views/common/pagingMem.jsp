<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul class="pagination">
<c:if test="${pghdl.prev }">
	<li class="page-item"><a class="page-link"
	 href="/member/list?pageIndex=${pghdl.firstPageIndex-1 }&countPerPage=${pghdl.pgvo.countPerPage}&range=${pghdl.pgvo.range}&keyword=${pghdl.pgvo.keyword}">
	 Prev</a></li>
</c:if>	
<c:forEach begin="${pghdl.firstPageIndex }" end="${pghdl.lastPageIndex }" var="i">
	<li class="page-item ${pghdl.pgvo.pageIndex == i ? 'active' : '' }"><a class="page-link"
	 href="/member/list?pageIndex=${i }&countPerPage=${pghdl.pgvo.countPerPage}&range=${pghdl.pgvo.range}&keyword=${pghdl.pgvo.keyword}">
	 ${i }</a></li>
</c:forEach>
<c:if test="${pghdl.next }">	
	<li class="page-item"><a class="page-link"
	 href="/member/list?pageIndex=${pghdl.lastPageIndex+1 }&countPerPage=${pghdl.pgvo.countPerPage}&range=${pghdl.pgvo.range}&keyword=${pghdl.pgvo.keyword}">
	 Next</a></li>
</c:if>
</ul>