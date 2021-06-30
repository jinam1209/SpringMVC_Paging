<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="/">INDEX</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<c:choose>
				<c:when test="${ses.email ne null && ses.email ne '' }">
					<c:choose>
						<c:when test="${ses.email eq 'admin@admin.com' }">
							<li class="nav-item"><a class="nav-link" href="/member/list">
									${ses.nickname }(${ses.email }) </a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="/member/modify?email=${ses.email }"> ${ses.nickname }(${ses.email })
							</a></li>
						</c:otherwise>
					</c:choose>
					<li class="nav-item"><a class="nav-link" href="/member/logout">로그아웃</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="/member/register">회원가입</a></li>
					<li class="nav-item"><a class="nav-link" href="/member/login">로그인</a>
					</li>
				</c:otherwise>
			</c:choose>
			<li class="nav-item"><a class="nav-link" href="/product/list">상품목록</a>
			</li>
		</ul>
	</div>
</nav>

<div class="container" style="margin-top: 30px">