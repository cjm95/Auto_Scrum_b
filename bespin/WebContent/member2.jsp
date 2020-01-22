<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bespin.ConnectDB"%>
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
 
    회원 목록 입니다 <br/><br/>
    
    <form action= "SerchUser.jsp" method = "post" name = "textform">    
    검색할 ID 
        <input type= "text" name= "SERCH_ID">
        <Button type= "submit"> 검색 </Button> <br/><br/>
    
    <table border= "1">
        <tr>
            <th> 사번 </th> <th> 이름 </th> <th> 부서 </th> <th> 나이 </th>
        </tr>
    <% 		
    ConnectDB conn = ConnectDB.getInstance();
	
	String returns = conn.selectdb(); 
	System.out.println(returns);
	%>
    <tr>
    	<th> BG00<%=returns.split("/")[0]%> </th> 
        <th> <%=returns.split("/")[1]%> </th>
        <th> <%=returns.split("/")[2]%> </th> 
        <th> <%=returns.split("/")[3]%> </th>
    </tr>
		<!-- jsp 구조는 데이터 입력 확인 후 적용예정 -->

    </table> <br/>
    </form>    
    <Button onclick= "location.href='UserView_ASC.jsp'"> 수정 </Button>
    <Button onclick= "location.href='Main.jsp'"> 삭제 </Button>
    
</body>
</html>