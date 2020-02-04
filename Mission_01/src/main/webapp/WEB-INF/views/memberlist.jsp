<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.bespin.auto.User"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<link href="<c:url value="/resources/css/member.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/css/member2.css" />" rel="stylesheet" />
<!--
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet" />
  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/handsontable@7.3.0/dist/handsontable.full.min.css" rel="stylesheet" media="screen">

<script src="<c:url value="/resources/js/member.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-3.4.1.js"/>"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/handsontable@7.3.0/dist/handsontable.full.min.js"></script>

<title>Page Title</title>
</head>
<body>

<script>
// 체크박스 전체 선택
$(document).ready(function(){
    var flag = true;
    var checkbox= $('.selectC');

    $('.selectA').click(function(){
        if(flag){
            checkbox.prop({
                'checked': true
            });
            flag = false;
        }else{
            checkbox.prop({
                'checked': false
            });
            flag = true;
        }
    });
});
</script>
<script>
//체크박스 생성 및 소멸 함수
function chtype(){
	if($('.selectC').css('display')=='none'){
		$('.selectC').show();
		$(".selectC").css("visibility", "visible" );
		$('.selectA').show();
		$(".selectA").css("visibility", "visible" );

				
		}else{
			$('.selectA').hide();
			$('.selectC').hide();

			}
	if($('.selectC').css('display')=='none'){
		$('#selectBtn').hide();
		}else{

			$('#selectBtn').show();
			$("#selectBtn").css("visibility", "visible" );
			}
}


</script>

<script>/* 행에서 사번값 빼오는 함수 */
//상단 선택버튼 클릭시 체크된 Row의 값을 가져온다.
$(document).on('click', '#selectBtn', function(){

	
	var rowData = new Array();
	var tdArr = new Array();
	var checkbox = $("input[name=user_CheckBox]:checked");
	
	// 체크된 체크박스 값을 가져온다
	checkbox.each(function(i) {

		// checkbox.parent() : checkbox의 부모는 <td>이다.
		// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		
		// 체크된 row의 모든 값을 배열에 담는다.
		rowData.push(tr.text());
		
		// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
		var no = td.eq(1).text()
		
		// 가져온 값을 배열에 담는다.
		tdArr.push(no);

	});
/* FIXME */

	$('#form-delete').attr('action', '/auto/removal/'+tdArr).submit();


});

</script>
    <form action= "/auto/member" method = "get" name = "textform" class="col s12 z-depth-4 card-panel">
        <div class="row">
	        <div class="input-field col s12 center">
	          <h4>Member List</h4>
	          <p class="center">Enter your name to find the member !</p>
	        </div>
      	</div>
      	
      	<table>
	      	<tr>
	      		<td><select name='selectAttr' style="width:80px;height:30px;">
				  <option value='num' >사번</option>
				  <option value='name' selected>이름</option>
				  <option value='team' >부서</option>
				</select> </td>
		      	<td> <input type="text" name= "action"> </td>
			    <td> <Button id="button1" type= "submit"> 검색 </Button> </td>
			</tr>
		</table>
		<br/>
	
	<div align="right">
    <Button type="button" id = "showButton" style="cursor:pointer" onclick ="chtype()"> 선택 </Button> <!-- onclick= "location.href='Main.jsp'" -->
    <Button type="button" id = "selectBtn" onclick="">삭제</button>
    </div>
    
    <table id="members" border= "1">
        <tr>
             <td><input type="checkbox"  class="selectA"></td>
             <th> 사번 </th> <th> 이름 </th> <th> 부서 </th> <th> 나이 </th>
        </tr>
    <% 		

	    String slt = request.getParameter("action");
	    if(slt != null) slt = new String(slt.getBytes("8859_1"), "EUC-KR");
	    String slt2 = request.getParameter("selectAttr");
	   
	    try {
		 	User user = new User();
			%>
			<c:forEach items="${listAll}" var="user">
			<tr id="susu">
			    <td> <input type="checkbox" class="selectC" name="user_CheckBox"></td>
		    	<td onClick="location.href ='/auto/details?num=${user.num}'"> BG00<c:out value="${user.num}"/> </td> 
		        <td onClick="location.href ='/auto/details?num=${user.num}'"> <c:out value="${user.name}"/> </td>
		        <td onClick="location.href ='/auto/details?num=${user.num}'"> <c:out value="${user.team}"/> </td> 
		        <td onClick="location.href ='/auto/details?num=${user.num}'"> <c:out value="${user.age}"/> </td>
		    </tr>
		    </c:forEach>
		<%	}catch(NullPointerException e) {}%>

    </table> <br/>
    </form>
    
	<form id="form-delete" action="/questions/${question.questionId}" method="post">
	  <input type="hidden" name="_method" value="delete" />
	</form>
</body>
</html>