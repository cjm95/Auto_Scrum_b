<%@page import="com.bespin.auto.domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/member.css" />" rel="stylesheet" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
<script src="<c:url value="/resources/css/member.js"/>"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
<title>정보 수정</title>
</head>

<script>/* 행에서 사번값 빼오는 함수 */
//상단 선택버튼 클릭시 체크된 Row의 값을 가져온다.
$(document).on('click', '#singleDel', function(){
	var num = new Array();
	num.push($("#usernum").attr("value"));
	$('#single-delete').attr('action','/auto/removal/'+num).submit();
/* FIXME */
});

</script>

<body>

<div id="login-page" class="row">
  <div class="col s12 z-depth-4 card-panel">
  <c:forEach items="${listAll}" var="user">
    <form class="login-form" action="modification/${user.num} }" method="post" name="updateform">
 <input type="hidden" name="_method" value="put" name ="num" /> 
      <div class="row">
        <div class="input-field col s12 center">
          <h4>Update</h4>
        </div>
      
      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">account_circle</i> -->
          <input id="usernum" name="usernum" type="text"  value="${user.num}" />
          <label for="usernum"><b>사번</b>(BG생략)</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">email</i> -->
          <input id="username" name="username" type="text" style="cursor: auto;" maxlength='20'  value="${user.name}" />
          <label for="username">이름</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">vpn_key</i> -->
          <input id="age" name="age" type="text"  value= "${user.age}" />
          <label for="age">나이</label>
        </div>
      </div>
      
      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">vpn_key</i> -->
          <input id="department" name="department" type="text"  value= "${user.team}" />
          <label for="department">부서</label>
        </div>
      </div>
       <div class="row">
        <div class="input-field col s12">
          <button type="submit" class="btn waves-effect waves-light col s12" id ="infoUpdate" style="cursor: pointer;">Complete</button>
        </div>
        
        <div class="input-field col s12" align="center">
    	<Button type="button" class="btn waves-effect waves-light col s12" id = "singleDel">Delete</button>
	    </div>
      </div>
      </c:forEach>
    </form>
    
     <!-- single-delete 구현 -->
	<form id="single-delete" action="/questions/${question.questionId}" method="post">
		<input type="hidden" name="_method" value="DELETE" />
	</form>


  </div>
</div>

</body>
<script>

</script>
</html>