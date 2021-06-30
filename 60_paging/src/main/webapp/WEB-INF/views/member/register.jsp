<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

  <h2>Member Register</h2>
  <form action="/member/register" method="post">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
      <button type="button" class="btn btn-success btn-sm" id="checkEmail">중복확인</button>
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <div class="form-group">
      <label for="nickname">Nickname:</label>
      <input type="text" class="form-control" id="nickname" placeholder="Enter Nickname" name="nickname">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
<script>
	$(function() {
		$("#checkEmail").on("click", function(e) {
			e.preventDefault();
			let email_val = $("#email").val();
			$.ajax({
				url: "/member/checkEmail",
				type: "post",
				data: {email: email_val}
			}).done(function(result) {
				if(parseInt(result)==0){
					alert("사용 가능한 이메일!");
					$("#pwd").focus();
				}else{
					$("#email").val("");
					$("#email").focus();
					alert("중복되는 이메일!");
				}
			});
			
		});
	});
</script>
<jsp:include page="../common/footer.jsp" />