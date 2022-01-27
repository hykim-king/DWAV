<%--
/**
  file name: 
  description:
  user: Dosn
  create date: 2022-01-26
  version: 0.5
  Copyright (c) by PCWK All right reserved.
  Modification Information
   수정일   수정자    수정내용
 -----------------------------------------------------
  2022-01-26 최초생성
 -----------------------------------------------------
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="CP"        value="${pageContext.request.contextPath}"/>
<c:set var="resource"  value="/resources"/>  
<c:set var="CP_RES"    value="${CP }${resource}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<title>로그인</title>
<!-- 부트스트랩 -->
<link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script type="text/javascript" src="${CP_RES}/js/jquery-3.6.0.min.js"></script>
<!-- ajax 통신 -->
<script type="text/javascript" src="${CP_RES}/js/eclass.js"></script>
<script type="text/javascript" src="${CP_RES}/js/eUtil.js"></script>

<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="${CP_RES}/js/bootstrap.min.js"></script>
<script src="${CP_RES}/js/jquery.bootpag.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
    	$("#doLogin").on("click",function(e){
    		console.log("doLogin");
    		
    		let user_id = $("#user_id").val();
            let user_pwd = $("#user_pwd").val();
            
            if(eUtil.ISEmpty(user_id)){
                alert("ID를 입력 하세요.");
                $("#user_id").focus();
                return;
            } 
            
            if(eUtil.ISEmpty(user_pwd)){
                alert("비번을 입력 하세요.");
                $("#user_pwd").focus();
                return;
                
                
            }
            
            if(confirm("로그인 하시겠습니까?")==false)return;
            
            let url = "${CP}/user/doLogin.do";
            let parameters = {"user_id":user_id,
                              "user_pwd":user_pwd
                             };
            let method     = "POST";
            let async      = true;
            
            EClass.callAjax(url,parameters,method,async,function(data){
                console.log("data.msgId:"+data.msgId);
                console.log("data.msgContents:"+data.msgContents);
                
                if("10" == data.msgId){
                    alert(data.msgContents);
                    $("#user_id").focus();
                }else if("20" == data.msgId){
                    alert(data.msgContents);
                    $("#user_pwd").focus();                       
                }else if("30" == data.msgId){
                    alert(data.msgContents);
                    //main페이지로 이동
                    //MainController.java
                    //main.jsp
                    //http://localhost:8080/ehr/main/login_view.do
                    /* window.location.href ="${CP}/main/main_view.do"; */
                }else if("40" == data.msgId){
                    alert(data.msgContents);
                    $("#user_id").focus();
                }
                
            });
            
            
    	});
    });
    </script>
</head>
<body>
	     <div class="container">
        <!-- 제목 -->
        <div class="row">
          <div class="page-header">
            <h2>로그인</h2>
          </div>
        </div>
        <!--// 제목 ------------------------------------------------------------->
         
         <div class="row text-center col-xs-12 col-sm-12 col-md-12 col-lg-12">
             <div class=" col-xs-4 col-sm-4 col-md-4 col-lg-4">
                  <form class="form-horizontal" action="${CP}/user/doLogin.do" method="post">
                     <input type="text" class="form-control" name="user_id" id="user_id" 
                     maxlength="20" placeholder="아이디">
                     <input type="password"  class="form-control"  name="user_pwd" id="user_pwd"
                     maxlength="50" placeholder="비밀번호"
                     />
                  </form>
                  <input type="button" class="btn btn-default btn-primary btn-block" value="로그인" id="doLogin">
             </div>  
        </div>
        
        </div>
        
</body>
</html>