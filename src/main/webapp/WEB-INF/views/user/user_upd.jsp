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
<%
    String login_id = (String)session.getAttribute("login_id");
%>
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

<title>사용자 정보 수정</title>
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

    	
    	
    	$("#doDelete").on("click",function(e){
    		/* 세션정보 : login_id */
            console.log("login_id:"+login_id);
            if(eUtil.ISEmpty(login_id) ==true){
                alert("로그인 여부를 확인 하세요.");
                return;
            }
            
            if(confirm("탈퇴 하시겠습니까?")==false)return;
            
            let url = "${CP}/user/doDelete.do";
            let parameters = {
                    "login_id":login_id
            };
            let method = "GET";
            let async  = true;      
            EClass.callAjax(url,parameters,method,async,function(data){
                console.log("data.msgId:"+data.msgId);
                console.log("data.msgContents:"+data.msgContents);    
                if("1" == data.msgId){
                    alert(data.msgContents);
                }else{
                    alert(data.msgContents);
                }                   
            });
            
        });
    });
    </script>
</head>
<body>
     <!-- 반응형 고정폭 콘테이너 : container-->
     <div class="container">
        <!-- 제목 -->
        <div class="row">
          <div class="page-header">
            <h2>사용자 정보 수정</h2>
          </div>
        </div>
        <!--// 제목 ------------------------------------------------------------->

        <!-- 버튼 -->
           <div class="row text-right col-xs-12 col-sm-12 col-md-12 col-lg-12">
              <input type="button" class="btn btn-default btn-sm btn-primary" value="수정" id="doUpdate">
              <input type="button" class="btn btn-default btn-sm btn-primary" value="삭제" id="doDelete">
              <input type="button" class="btn btn-default btn-sm btn-primary" value="목록" id="moveToList">
           </div>
        <!--// 버튼 ------------------------------------------------------------->
        
                     
           
        <c:out value=""></c:out>
        <!-- 등록 -->
        <div class="row col-xs-12 col-sm-12 col-md-12 col-lg-12">
          <form action="#" class="form-horizontal">
              <div class="form-group">
                <label for="boardId" class="col-sm-2 control-label">사용자 ID</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_id}'  />" readonly="readonly" maxlength="20" class="form-control" name="user_id" id="user_id" placeholder="사용자 ID">
                </div>
              </div>
                        
              <div class="form-group">
                <label for="regId" class="col-sm-2 control-label">등록자</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${vo.regId}'  />"  maxlength="20" class="form-control" name="regId" id="regId" placeholder="등록자">
                </div>
              </div>
              <div class="form-group">
                <label for="regDt" class="col-sm-2 control-label">등록일</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${vo.regDt}'  />" readonly="readonly" maxlength="20" class="form-control" name="regDt" id="regDt" placeholder="등록일">
                </div>
              </div>
                          
              <div class="form-group">
                <label for="name" class="col-sm-2 control-label">제목</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${vo.title}'  />" maxlength="50" class="form-control" name="title" id="title" placeholder="제목">
                </div>
              </div>            
              <div class="form-group">
                <label for="name" class="col-sm-2 control-label">내용</label>
                <div class="col-sm-10">
                  <textarea rows="10" cols="20" name="contents" id="contents" class="form-control"><c:out value='${vo.contents}'  /></textarea>
                </div>
              </div>                                        
          </form>
        </div>             
        <!--// 등록 ------------------------------------------------------------->
        
        
     </div>  
     <!--// 반응형 고정폭 콘테이너 ------------------------------------------------------------->
            login_id : <%=login_id %><br/>
</body>
</html>