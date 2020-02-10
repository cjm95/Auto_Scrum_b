<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/member.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/member2.css" />" rel="stylesheet" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
<script src="<c:url value="/resources/js/member.js"/>"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
<title>Page Title</title>
</head>
<body>

<div id="login-page" class="row">
  <div class="col s12 z-depth-4 card-panel">
    <form class="login-form" method="post">
      <div class="row">
        <div class="input-field col s12 center">
          <h4>Register</h4>
          <p class="center">Join to our community now !</p>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <input id="num" name="num" type="number" required/>
          <label for="num">사번 (BG 뒷자리 숫자 입력)</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <input id="name" name="name" type="text" style="cursor: auto;" required />
          <label for="name">이름</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">vpn_key</i> -->
          <input id="age" name="age" type="number"  required/>
          <label for="age">나이</label>
        </div>
      </div>
      
      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">vpn_key</i> -->
          <input id="team" name="team" type="text" required/>
          <label for="team">부서</label>
        </div>
      </div>
      <!-- 등록 버튼 -->
      	<div class="row2">
        <div class="input-field col s12">
           <button type="submit" id="signup" class="btn waves-effect waves-light col s12">REGISTER NOW</button>       
       	 </div>
       	 
    <!-- 목록 조회 버튼 -->
        <div class="input-field col s12">
          <button onclick= "location.href='/auto/members'" class="btn waves-effect waves-light col s12">SHOW LIST</button>
           <br/> <br/> <br/>
        </div>
      </div>

  </div>
</div>

</body>

</script>

</html>