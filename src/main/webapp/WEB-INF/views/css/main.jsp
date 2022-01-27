<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
    
    <title>숙소, 트립, 장소를 모두 한 곳에서 - DWAV </title>
    <!-- <link rel="stylesheet" href="/DWAV/src/main/webapp/WEB-INF/CSS/main.css"> -->   
     <!-- 부트스트랩 -->
    <link rel="stylesheet" href="/DWAV/src/main/webapp/WEB-INF/CSS/DWAVCSS.css"> 
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
    
    
    </script>    
</head>
<body>
<body>




    <div class="nav">
      <div class="container">
        <ul class='pull-left'>
          <li><a href="#">Name</a></li>
          <li><a href="#">Browse</a></li>
        </ul>
        <ul class='pull-right'>
          <li><a href="#">호스트되기</a></li>
          <li><a href="#">회원가입</a></li>
          <li><a href="#">로그인</a></li>
          <li><a href="#">마이페이지</a></li>
          <li><a href="#">지원센터</a></li>
        </ul>
      </div>
    </div>

    <div class="jumbotron">
      <div class="container">
        <h1>머물 곳을 찾으십시오.</h1>
        <p>다양한 나라와 수많은 도시에 있는 사람들로부터 임대하세요.</p>
        <a href="#">Learn More</a>
      </div>
    </div> 
  <div class="neighborhood-guides">
    <div class="container">
        <h2>근처 가이드</h2>
        <p>숙박할 곳이 확실하지 않으세요?  전 세계 도시에 대한 지역 가이드를 만들었습니다.</p>
        <div class='row'>
            <div class='col-md-4'>
            <div class='thumbnail'>
                <img src="사진첨부">
            </div>
            <div class='thumbnail'>
                <img src="사진첨부">
            </div>
            </div>

  <div class="col-md-4">
    <div class="thumbnail">
      <img src="사진첨부" >
    </div>
    <div class="thumbnail">
      <img src="사진첨부">
    </div>
  </div>

  <div class="col-md-4">
    <div class="thumbnail">
      <img src="사진첨부" >
    </div>
  </div>
        </div>
    </div>
</div>
    <div class="learn-more">
    <div class="container">
    <div class='row'>
        <div class='col-md-4'>
      <h3>여행</h3>
      <p>아파트와 객실에서 나무 위의 집과 보트까지 다양한 나라에서 독특한 공간에서 숙박하세요.</p>
      <p><a href="#">See how to travel </a></p>
        </div>
      <div class='col-md-4'>
      <h3>호스트</h3>
      <p>사용하지 않은 공간을 임대하면 청구서를 지불하거나 다음 휴가 비용을 충당할 수 있습니다</p>
      <p><a href="#">Learn more about hosting</a></p>
      </div>
      <div class='col-md-4'>
      <h3>신뢰와 안전</h3>
      <p> 전 세계 고객 지원 팀에 이르기까지 모든 것을 지원합니다.</p>
      <p><a href="#">Learn about trust DWAV</a></p>
      </div>
      </div>
    </div>
  </div>
  </body>
</html>
</body>
</html>

























