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
<c:set var="CP" value="${pageContext.request.contextPath}" />
<c:set var="resource" value="/resources" />
<c:set var="CP_RES" value="${CP }${resource}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<title>회원가입</title>
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
	$(document).ready(function() {

		//id중복 체크
        $("#idCheck").on("click",function(e){
            console.log("idCheck:");
            
            let user_id = $("#user_id").val();
            
            if(eUtil.ISEmpty(user_id)){
                alert("ID를 입력 하세요.");
                $("#user_id").focus();
                return;
            }
            
            let url = "${CP}/user/idCheck.do";
            let parameters = {"user_id":user_id};
            let method     = "GET";
            let async      = true;
            
            EClass.callAjax(url,parameters,method,async,function(data){
                console.log("data.msgId:"+data.msgId);
                console.log("data.msgContents:"+data.msgContents);
                                //uIdStatus
                if("0" == data.msgId ){
                    $("#idCheckYN").val("1");//사용할수 있음!
                }else{
                    $("#idCheckYN").val("0");//사용할수 없음
                }
                alert(data.msgContents);                
            });
            
        });
		
		
        //등록 버튼 이벤트 정의
        $("#doInsert").on("click",function(e){
           console.log("doInsert:");
           
           //등록
           let user_id     = $("#user_id").val();
           let idCheckYN   = $("#idCheckYN").val();
           let user_pwd    = $("#user_pwd").val();
           let first_name  = $("#first_name").val();
           let last_name   = $("#last_name").val();
           let birth_date  = $("#birth_date").val();
           let email       = $("#email").val();
           let user_ph_num = $("#user_ph_num").val();
           let user_img    = $("#user_img").val();
           let user_intro  = $("#user_intro").val();
           
           console.log("eUtil.ISEmpty(name):"+eUtil.ISEmpty(name));
           
           if(eUtil.ISEmpty(user_id)){
               alert("ID를 입력 하세요.");
               $("#user_id").focus();
               return;
           }
           
           if(eUtil.ISEmpty(idCheckYN)){
               alert("아이디 중복체크를 하세요");
               $("#idCheck").focus();
               return;
           }
           
           if("1" != idCheckYN){
               alert("다른 아이디를 사용 하세요");
               $("#idCheck").focus();
               return;                 
           }
           
           
           if(eUtil.ISEmpty(first_name)){
               alert("이름을 입력 하세요.");
               $("#first_name").focus();
               return ;
           } 

           if(eUtil.ISEmpty(last_name)){
               alert("성을 입력 하세요.");
               $("#last_name").focus();
               return ;
           } 
           
           if(eUtil.ISEmpty(user_pwd)){
               alert("비밀번호를 입력 하세요.");
               $("#user_pwd").focus();
               return ;
           } 
           
           if(eUtil.ISEmpty(birth_date)){
               alert("생일을 8자리로 입력 하세요.");
               $("#birth_date").focus();
               return ;
           }    
           
           if(eUtil.ISEmpty(email)){
               alert("이메일을 입력 하세요.");
               $("#email").focus();
               return ;
           }  
           
           if(eUtil.ISEmpty(user_ph_num)){
               alert("핸드폰 번호를 입력 하세요.");
               $("#user_ph_num").focus();
               return ;
           } 
           
           if(eUtil.ISEmpty(user_img)){
               alert("사진을 업로드 하세요.");
               $("#user_img").focus();
               return ;
           } 
           
           if(eUtil.ISEmpty(user_intro)){
               alert("자기소개를 입력 하세요.");
               $("#user_intro").focus();
               return ;
           } 
           
           let url ="${CP}/user/add.do";
           let parameters = {
                    "user_id":user_id,
                    "first_name":first_name,
                    "last_name":last_name,
                    "user_pwd":user_pwd,
                    "birth_date":birth_date,
                    "email":email,
                    "user_ph_num":user_ph_num,
                    "user_img":user_img,
                    "user_intro":user_intro
                 };
           let method = "POST";
           let async  = true;
           
           if(confirm("등록 하시겠습니까?")==false)return;
           
           EClass.callAjax(url,parameters,method,async,function(data){
               console.log("data.msgId:"+data.msgId);
               console.log("data.msgContents:"+data.msgContents);
               
               if("1" == data.msgId){
                  alert(data.msgContents);
                  doRetrieve(1);
                  init();
               }else{
                   alert(data.msgContents);
               }
               
           });
           
           //향후 메인 jsp를 받게 되면, 회원가입 완료 시 메인 페이지로 이동할 수 있게 함.
           window.location.href ="${CP}/main/main;

           
        });
	});
</script>
</head>
<body>
	<!-- 반응형 고정폭 콘테이너 : container-->
	<div class="container">

		<!-- 제목 -->
		<div class="row col-xs-14 col-sm-14 col-md-14 col-lg-14">
			<div class="text-center page-header">
				<h2>회원 가입</h2>
			</div>
		</div>
		<!--// 제목 ------------------------------------------------------------->
		 <!-- 버튼 -->
		<div class="row text-right">
			<input type="button" class="btn btn-default btn-sm" value="등록" id="doInsert">
		</div>
		<!--// 버튼 ------------------------------------------------------------->
		<!-- 등록 -->
		<form action="#" class="form-horizontal">
			<input type="hidden" name="idCheckYN" id="idCheckYN" />
			  <div class="form-group form-inline">
                <label for="user_id" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">아이디</label>
                <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" >
                  <input type="text" maxlength="20" class="form-control" style="width: auto;" name="user_id" id="user_id" placeholder="아이디">
                  <input type="button" class="btn btn-default btn-sm" value="중복확인" id="idCheck">
                </div>
              </div> 
              
              <div class="form-group">
                <label for="user_pwd" class="col-sm-2 control-label">비밀번호</label>
                <div class="col-sm-10">
                  <input type="password" maxlength="50" class="form-control" name="user_pwd" id="user_pwd" placeholder="비밀번호">
                </div>
              </div>
                          
              <div class="form-group">
                <label for="first_name" class="col-sm-2 control-label">이름</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" class="form-control" name="first_name" id="first_name" placeholder="이름">
                </div>
              </div>
              <div class="form-group">
                <label for="last_name" class="col-sm-2 control-label">성</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" class="form-control" name="last_name" id="last_name" placeholder="성">
                </div>
              </div>  
              
               <div class="form-group">
                <label for="birth_date" class="col-sm-2 control-label">생일</label>
                <div class="col-sm-10">
                  <input type="date" class="numberOnly form-control " name="birth_date" id="birth_date" placeholder="생일">
                </div>
               </div>                
               
               <div class="form-group">
                <label for="email" class="col-sm-2 control-label">이메일</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" class="form-control" name="email" id="email" placeholder="이메일">
                </div>
               </div> 
                  
               <div class="form-group">
                <label for="user_ph_num" class="col-sm-2 control-label">전화번호</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" class="form-control" name="user_ph_num" id="user_ph_num" placeholder="전화번호">
                </div>
               </div>                                 
               
               <div class="form-group">
                <label for="user_img" class="col-sm-2 control-label">사진</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" class="form-control" name="user_img" id="user_img" placeholder="사진">
                </div>
               </div>
                                              
               <div class="form-group">
                <label for="user_intro" class="col-sm-2 control-label">자기소개</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" class="form-control" name="user_intro" id="user_intro" placeholder="자기소개">
                </div>
               </div>
          </form>   
	
	<!-- //반응형 고정폭 콘테이너 : container-->
    </div>
</body>
</html>