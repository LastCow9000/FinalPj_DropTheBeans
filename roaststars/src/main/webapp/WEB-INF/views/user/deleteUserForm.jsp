<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	 var checkPass=""; 
     $("#passwordC").keyup(function() {
    	checkPass="";
    	 var passValue= $(this).val().trim();
        $.ajax({
           type : "post",
           url : "${pageContext.request.contextPath}/pass-checkAjax.do",
           data : "password="+passValue,
           beforeSend : function(xhr){   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
                   xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
               }, 
           success : function(result) {
              
              if (result == "ok"){
                 $("#passwordResult").html("비밀번호가 맞습니다.").css(
                       "color", "green");
                 checkPass = passValue; 
              } else {
                 $("#passwordResult").html("비밀번호가 틀립니다.").css(
                       "color", "red");
              }
           }//success
        });//ajax
     });//keyup
     $("#deleteUserForm").submit(function() {
         if(checkPass==""){
            alert("비밀번호를 확인해주세요!");
            return false;
         }
      });//submit
      
     
});//ready
</script>
</head>
<body>
<sec:authorize access="hasAnyRole('ROLE_MEMBER','ROLE_MANAGER')">
 <div class="container" style="width: 500px; float: center;">
  <h2>회원탈퇴</h2>
  <hr style="width: 300px; float:left;"><br><br>
  <form method="post" action="${pageContext.request.contextPath}/delete-useraction.do" class="was-validated" id="deleteUserForm" enctype="multipart/form-data">
  <sec:csrfInput/>
    <div class="form-group">
      <label for="memberId">아이디 : </label>
      <input type="text" name="id" value="<sec:authentication property="principal.id"/>" class="form-control" placeholder="Enter Id" readonly>
      <div class="valid-feedback"></div>
      <div class="invalid-feedback">  아이디를 입력해주세요.</div>
    </div>
    <div class="form-group">
      <label for="passwordC">비밀번호 : </label>
      <input type="password" name="password" id="passwordC" class="form-control" placeholder="Enter password" required>
      <div class="valid-feedback"><span id="passwordResult"></span></div>
      <div class="invalid-feedback">  비밀번호를 입력해주세요.</div>
    </div>

    <hr style="width: 480px; float:left;"><br>


	<input type="submit" value="회웥탈퇴" class="btn btn-primary" style="float:center;">
	
  </form>
 <%--  <form method="post" action="${pageContext.request.contextPath}/delete-useraction.do" id="deleteUserForm">
	<input type="hidden" name="command" value="delete">
	 
	 		csrf 토큰 : csrf 공격을 막기 위한 1회성 인증키인 
	 		              csrf토큰을 함께 전달해야 전송이 가능하다
	
	<sec:csrfInput/>
	아이디 : <input type="text" name="id" value="<sec:authentication property="principal.id"/>" readonly>
	<br>패스워드 <input type="password" id="passwordChecked" required="required"><span id="passwordCheckResult"></span><br>
	<br><input type="submit" value="탈퇴하기">
 </form> --%>
</div><!-- container -->
</sec:authorize>
</body>
</html>






