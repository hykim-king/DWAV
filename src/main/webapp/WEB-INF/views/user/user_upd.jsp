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
String login_id         =(String)session.getAttribute("login_id"        );
String login_pwd        =(String)session.getAttribute("login_pwd"       );
String login_ln         =(String)session.getAttribute("login_fn"        );
String login_fn         =(String)session.getAttribute("login_ln"        );
String login_birthdate  =(String)session.getAttribute("login_birthdate" );
String login_email      =(String)session.getAttribute("login_email"     );
String login_phnum      =(String)session.getAttribute("login_phnum"     );
String login_img        =(String)session.getAttribute("login_img"       );
String login_intro      =(String)session.getAttribute("login_intro"     );
String login_state      =(String)session.getAttribute("login_state"     );
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
        	
        	let login_id = "<%= login_id %>";
        	
        	if(eUtil.ISEmpty(login_id) ==true){
                alert("ID를 확인 하세요.");
                return;
        
        	}
        	
        	if(confirm("아이디를 삭제하시겠습니까?")==false)return;
        	
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
                    window.location.href ="${CP}/main/main_view.do";
                }else{
                    alert(data.msgContents);
                }                   
            });
        	window.location.href ="${CP}/user/logout.do";
        });
        
        
        
        $("#doUpdate").on("click",function(e){
        	 console.log("doUpdate");
             let url = "${CP}/user/doUpdate.do";
             
             let user_id        =$("#login_id").val();
             let user_pwd       =$("#login_pwd").val();
             let last_name        =$("#login_ln").val();
             let first_name        =$("#login_fn").val();
             /* let login_birthdate =$("#login_birthdate").val(); */
             let email     =$("#login_email").val();
             let user_ph_num     =$("#login_phnum").val();
             let user_intro     =$("#login_intro").val();
             let user_state     =$("#login_state").val();
        	 
             console.log("user_id       ="+user_id         );
             console.log("user_pwd      ="+user_pwd        );
             console.log("last_name       ="+first_name         );
             console.log("first_name       ="+last_name         );
             /* console.log("login_birthdate="+login_birthdate  ); */
             console.log("email    ="+email      );
             console.log("user_ph_num    ="+user_ph_num      );
             console.log("user_intro    ="+user_intro      );
             console.log("user_state    ="+user_state      );
        	
             if(eUtil.ISEmpty(user_id) ==true){
                 alert("아이디를 확인 하세요.");
                 return;
             }
             if(eUtil.ISEmpty(user_pwd) ==true){
                 alert("비밀번호를 확인 하세요.");
                 return;
             }
             
             if(eUtil.ISEmpty(last_name) ==true){
                 alert("성을 확인 하세요.");
                 return;
             }
             
             if(eUtil.ISEmpty(first_name) ==true){
                 alert("이름을 확인 하세요.");
                 return;
             }
             
/*              if(eUtil.ISEmpty(login_birthdate) ==true){
                 alert("생일을 확인 하세요.");
                 return;
             } */
             
             if(eUtil.ISEmpty(email) ==true){
                 alert("이메일을 확인 하세요.");
                 return;
             }
             if(eUtil.ISEmpty(user_ph_num) ==true){
                 alert("전화번호를 확인 하세요.");
                 return;
             }
             if(eUtil.ISEmpty(user_intro) ==true){
                 alert("자기소개항목을 확인 하세요.");
                 return;
             }
             
             
             let parameters = {
            		 "user_id":user_id,        
            		 "user_pwd":user_pwd,      
            		 "last_name":last_name,        
            		 "first_name":first_name,        
            		 /* "login_birthdate":login_birthdate,   */
            		 "email":email,      
            		 "user_ph_num":user_ph_num,      
            		 "user_intro":user_intro,      
            		 "user_state":user_state       
             };
             
             let method = "POST";
             let async  = true;
             if(confirm("수정 하시겠습니까?")==false)return;
             
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
              <input type="button" class="btn btn-default btn-sm btn-primary" value="정보 수정" id="doUpdate">
              <input type="button" class="btn btn-default btn-sm btn-primary" value="회원 탈퇴" id="doDelete">
           </div>
        <!--// 버튼 ------------------------------------------------------------->
        <c:out value=""></c:out>
        <!-- 수정 -->
        <div class="row col-xs-12 col-sm-12 col-md-12 col-lg-12">
          <form action="#" class="form-horizontal">
              <div class="form-group">
                <label for="login_id" class="col-sm-2 control-label">사용자 ID</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_id}'  />" readonly="readonly" maxlength="20" class="form-control" name="login_id" id="login_id" placeholder="사용자 ID">
                </div>
              </div>

              <div class="form-group">
                <label for="login_pwd" class="col-sm-2 control-label">비밀번호</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_pwd}'  />" class="form-control" name="login_pwd" id="login_pwd" placeholder="비밀번호">
                </div>
              </div>

              <div class="form-group">
                <label for="login_ln" class="col-sm-2 control-label">성</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_ln}'  />" class="form-control" name="login_ln" id="login_ln" placeholder="성">
                </div>
              </div>

              <div class="form-group">
                <label for="login_fn" class="col-sm-2 control-label">이름</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_fn}'  />" class="form-control" name="login_fn" id="login_fn" placeholder="이름">
                </div>
              </div>

<%--               <div class="form-group">
                <label for="login_birthdate" class="col-sm-2 control-label">생일</label>
                <div class="col-sm-10">
                  <input type="date" value="<c:out value='${login_birthdate}'  />" class="form-control" name="login_birthdate" id="login_birthdate" placeholder="생일">
                </div>
              </div> --%>

              <div class="form-group">
                <label for="login_email" class="col-sm-2 control-label">이메일</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_email}'  />" class="form-control" name="login_email" id="login_email" placeholder="이메일">
                </div>
              </div>

              <div class="form-group">
                <label for="login_phnum" class="col-sm-2 control-label">전화번호</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_phnum}'  />" class="form-control" name="login_phnum" id="login_phnum" placeholder="전화번호">
                </div>
              </div>

              <div class="form-group">
                <label for="login_intro" class="col-sm-2 control-label">자기소개</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_intro}'  />" class="form-control" name="login_intro" id="login_intro" placeholder="자기소개">
                </div>
              </div>

              <div class="form-group">
                <label for="login_state" class="col-sm-2 control-label">자격 상태</label>
                <div class="col-sm-10">
                  <input type="text" value="<c:out value='${login_state}'  />" readonly="readonly" class="form-control" name="login_state" id="login_state" placeholder="자격 상태">
                </div>
              </div>
                           
          </form>
        </div>             
        <!--// 수정 ------------------------------------------------------------->
        
        
     </div>  
     <!--// 반응형 고정폭 콘테이너 ------------------------------------------------------------->
<%-- login_id        : <%=login_id        %><br/>    
login_pwd       : <%=login_pwd       %><br/>
login_ln        : <%=login_ln        %><br/>    
login_fn        : <%=login_fn        %><br/>    
login_birthdate : <%=login_birthdate %><br/>
login_email     : <%=login_email     %><br/>
login_phnum     : <%=login_phnum     %><br/>
login_img       : <%=login_img       %><br/>
login_intro     : <%=login_intro     %><br/>
login_state     : <%=login_state     %><br/> --%>
</body>
</html>