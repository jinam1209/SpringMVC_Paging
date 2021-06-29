<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<h2>Product Register</h2>
<c:choose>
	<c:when test="${ses.email ne '' && ses.email ne null }">
		<form action="/product/register" method="post" enctype="multipart/form-data">
		  <div class="form-group">
		    <label for="title">Title:</label>
		    <input type="text" class="form-control" placeholder="Enter Title" id="title" name="title">
		  </div>
		  <div class="form-group">
		    <label for="writer">Writer:</label>
		    <input type="text" class="form-control" id="writer" name="writer" value="${ses.email }" readonly>
		  </div>
		  <div class="form-group">
		    <label for="price">Price:</label>
		    <input type="text" class="form-control" placeholder="Enter Price" id="price" name="price">
		  </div>
		  <div class="form-group">
		  	<label for="content">Content:</label>
		 	 <textarea class="form-control" rows="5" id="content" name="content"></textarea>
		  </div>
		  <div class="form-group">
		    <input type="file" class="form-control" id="files" name="files" multiple style="display: none;">
		    <button type="button" class="btn btn-outline-info btn-block" id="fileTrigger">File Upload</button>
		  </div>
		  <div class="form-group">
		    <ul class="list-group" id="fileZone"></ul>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<script>
		$(document).on("click", "#fileTrigger", function() {
			$("#files").click();
		});
		let regExp = new RegExp("\.(exe|sh|bat|js|msi|dll)$");
		let maxSize = 1048576; // 1 MB
		function fileValidation(fname, fsize) {
			if(regExp.test(fname)) {
				alert(fname + "(은)는 허용되지 않은 파일 형식입니다! ");
				return false;
			}else if(fsize > maxSize) {
				alert("1MB 이하의 파일만 허용됩니다!");
				return false;
			}else{
				return true; // 62번 줄
			}
		}
		$(document).on("change", "#files", function() {
			$("button[type=submit]").attr("disabled", false);
			let formObj = $("#files"); // 하나여도 배열로 가져옴
			let fileObjs = formObj[0].files; // file 객체들 가져옴
			let fileZone = $("#fileZone");
			fileZone.html(""); // fileZone 초기화
			
			for (let fobj of fileObjs) {
			      let li = '<li class="list-group-item d-flex justify-content-between align-items-center">';
			      if(fileValidation(fobj.name, fobj.size)){
			         // 정상출력
			         li += fobj.name + '<span class="badge badge-success badge-pill">';
			      }else{
			         // 경고출력 후 서브밋 버튼 비활성화
			         li += '<i class="fa fa-times-rectangle" style="font-size:24px;color:red"></i>';
			         li += fobj.name + '<span class="badge badge-danger badge-pill">';
			         $("button[type=submit]").attr("disabled", true);
			      }
			      li += (fobj.size/1024).toFixed(2) +' KB</span></li>';
			      fileZone.append(li);
			   }
			});
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("로그인이 필요한 페이지입니다!");
			location.replace("/member/login"); // login page로 이동
		</script>
	</c:otherwise>
</c:choose>

<jsp:include page="../common/footer.jsp" />