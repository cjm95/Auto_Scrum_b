<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="./member.css" rel="stylesheet" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
<script src="./member.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
<title>Page Title</title>
</head>
<body>
<div id="login-page" class="row">
  <div class="col s12 z-depth-4 card-panel">
    <form class="login-form">
    <!-- <form action="memberOK2.jsp" method="post" name="memberForm" onsubmit="return passwordCheck(this)"> -->
      <div class="row">
        <div class="input-field col s12 center">
          <h4>Register</h4>
          <p class="center">Join to our community now !</p>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">account_circle</i> -->
          <input id="usernum" name="usernum" type="text" value="BG"/>
          <label for="usernum">사번</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">email</i> -->
          <input id="username" name="username" type="text" style="cursor: auto;" />
          <label for="username">이름</label>
        </div>
      </div>

      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">vpn_key</i> -->
          <input id="age" name="age" type="text" />
          <label for="age">나이</label>
        </div>
      </div>
      
      <div class="row margin">
        <div class="input-field col s12">
          <!-- <i class="material-icons prefix">vpn_key</i> -->
          <input id="department" name="department" type="text" />
          <label for="department">부서</label>
        </div>
      </div>
    </form>
    
      <div class="row">
        <div class="input-field col s12">
          <button type="submit" class="btn waves-effect waves-light col s12">REGISTER NOW</button>
        </div>
        <div class="input-field col s12">
          <button onclick= "location.href='./member2.jsp'" class="btn waves-effect waves-light col s12">SHOW LIST</button>
        </div>
      </div>

  </div>
</div>

</body>
</html>