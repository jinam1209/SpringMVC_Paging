<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</div>
<!-- container end -->

<div class="jumbotron text-center" style="margin-bottom:0; margin-top: 50px;">
  <p>© 2021 Spring, Inc. or its affiliates. Terms of Use • Privacy • Trademark Guidelines • Incheon Korea Privacy Rights </p>
</div>

<script>
	let result = '<c:out value="${result}"/>';
	if(result != ""){
		alert(result);
	}
</script>
</body>
</html>