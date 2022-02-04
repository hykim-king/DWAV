<%--
/**
  file name: 
  description:
  user: Dosn
  create date: 2022-02-03
  version: 0.5
  Copyright (c) by PCWK All right reserved.
  Modification Information
   수정일   수정자    수정내용
 -----------------------------------------------------
  2022-02-03 최초생성
 -----------------------------------------------------
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String login_id         =(String)session.getAttribute("login_id"        );
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

<title>편의시설 등록</title>
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
    	
        //등록 버튼 이벤트 정의
        $("#doInsert").on("click",function(e){
           console.log("doInsert:");
           
           //등록
           let accom_id     = $("#accom_id").val();
           let amenity_type = $("#amenity_type").val();
           let amenity_val  = $("#amenity_val").val();
           let reg_id       = "<%= login_id %>";
           
           
           if(eUtil.ISEmpty(accom_id)){
               alert("숙소id를 입력 하세요.");
               $("#accom_id").focus();
               return;
           }
           
           if(eUtil.ISEmpty(amenity_type)){
               alert("편의시설 타입을 입력 하세요.");
               $("#amenity_type").focus();
               return;
           }
           
           if(eUtil.ISEmpty(amenity_val)){
               alert("편의시설 명을 입력 하세요.");
               $("#amenity_val").focus();
               return;
           }
           
            
           
           let url ="${CP}/facilities/doInsertAmen.do";
           let parameters = {
                    "accom_id":accom_id,
                    "amenity_type":amenity_type,
                    "amenity_val":amenity_val,
                    "reg_id":reg_id
                 };
           let method = "POST";
           let async  = true;
           
           if(confirm("등록 하시겠습니까?")==false)return;
           
           EClass.callAjax(url,parameters,method,async,function(data){
               console.log("data.msgId:"+data.msgId);
               console.log("data.msgContents:"+data.msgContents);
               
               if("1" == data.msgId){
                  alert(data.msgContents);
                  
                  init();
               }else{
                   alert(data.msgContents);
               }
               
           });
           
           //향후 메인 jsp를 받게 되면, 회원가입 완료 시 메인 페이지로 이동할 수 있게 함.
           /* window.location.href ="${CP}/main/main; */

           
        });
    	
        
        function init(){
            let initValue = "";
            
            $("#accom_id ").val(initValue);
            $("#amenity_type").val(initValue);
            $("#amenity_val").val(initValue);
            $("#reg_id").val(initValue);           
        }
        //초기화 
        
    });
    </script>
</head>
<body>
	   <!-- 반응형 고정폭 콘테이너 : container-->
    <div class="container">

        <!-- 제목 -->
        <div class="row col-xs-14 col-sm-14 col-md-14 col-lg-14">
            <div class="text-center page-header">
                <h2>편의시설 등록</h2>
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
              <div class="form-group form-inline">
                <label for="user_id" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">숙소id</label>
                <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" >
                  <input type="text" maxlength="20" class="form-control" style="width: auto;" name="user_id" id="accom_id" placeholder="숙소id">
                </div>
              </div> 
              
              <div class="form-group">
                <label for="amenity_type" class="col-sm-2 control-label">편의시설 타입</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" class="form-control" name="amenity_type" id="amenity_type" placeholder="편의시설 타입">
                </div>
              </div>
                          
              <div class="form-group">
                <label for="amenity_val" class="col-sm-2 control-label">편의시설 명</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" class="form-control" name="amenity_val" id="amenity_val" placeholder="편의시설 명">
                </div>
              </div>
                          
              <div class="form-group">
                <label for="amenity_val" class="col-sm-2 control-label">등록자</label>
                <div class="col-sm-10">
                  <input type="text" maxlength="50" readonly="readonly" class="form-control" name="amenity_val" id="amenity_val" placeholder="<%=login_id%>">
                </div>
              </div>
              

          </form>   
    
    <!-- //반응형 고정폭 콘테이너 : container-->
    </div>
</body>
</html>