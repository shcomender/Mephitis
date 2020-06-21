<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";%>
<base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   <link rel="stylesheet" href="<%=basePath%>https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="<%=basePath%>fonts/icomoon/style.css">

    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/magnific-popup.css">
    <link rel="stylesheet" href="<%=basePath%>css/jquery-ui.css">
    <link rel="stylesheet" href="<%=basePath%>css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/owl.theme.default.min.css">


    <link rel="stylesheet" href="<%=basePath%>css/aos.css">

    <link rel="stylesheet" href="<%=basePath%>css/style.css">

    <title>Ramayana - Free Bootstrap 4 CSS Template</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!--
Ramayana CSS Template
https://templatemo.com/tm-529-ramayana
-->

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">
    <link rel="stylesheet" href="assets/css/owl.css">
 <script type="text/javascript">
    	function check(){
    		
    		var warn = confirm("确认修改吗？");
    		if(!warn)return false;
    		var firstname = document.getElementById("firstname").value;
    		var secondname = document.getElementById("secondname").value;
    		var shortname = document.getElementById("shortname").value;
    		var carno = document.getElementById("carno").value;
    		var email = document.getElementById("email").value;
    		var pw = document.getElementById("pw").value;
    		
    		if(firstname == "" || secondname == "" || shortname == "" || carno == "" || email == "" || pw == "" )
    			{
    				alert("必填信息必须填写");
    				return false;
    			}
    		else if(carno - '0' > 99 || carno - '0' < 0 ){
    			alert("赛车号限制在0-99");return false;
    		}
    		else if(shortname.length != 3){
    			alert("短名必须为三位英文字母！");return false;
    		}
    		else {
    			return true;
    		}
    	}
    	
    	
    	function check1(){
    		var warn = confirm("确认修改吗？");
    		if(!warn)return false;
    		var mod_tname = document.getElementById("mod_tname").value;
    		var mod_tleader = document.getElementById("mod_tleader").value;
    		var mod_tlogo = document.getElementById("mod_tlogo").value;
    		if(mod_tname =="" || mod_tleader =="" || mod_tlogo==""){
    			alert("信息不得修改为空！");
    			return false;
    		}
    		return true;
    	}
    </script>
<script type="text/javascript">  

//删除当前行
			function del_prrecords(this1){
				var warn = confirm("确认修改吗？");
	    		if(!warn)return;
				var value = $(this1).parent().parent();
				 var mid = value.children("td").eq(0).text();
				 var shortname = value.children("td").eq(2).text();
				 window.location.href="./deletPrrecords?mid="+mid+"&shortname="+shortname;
			}


			
			function a(){
				$.ajax({  
            		url:"${pageContext.request.contextPath }/getall",//servlet文件的名称
            		type:"GET",
            	});
			}
        </script>  
<script type="text/javascript">
	window.attachEvent("onload", a);<span style="white-space:pre">	</span>//initLoad后不能有（）
</script>

  </head>
  
<body class="is-preload" onload="a();">
<!-- 
     Object message = session.getAttribute("modifyerror");
 	Object m = session.getAttribute("flag");
 	
     if(message!=null && !"".equals(message)){
  
     <script type="text/javascript">
        alert("=m%>+1");
     </script>
  message="";} else{
   
  <script type="text/javascript">
     </script>
  }%> -->
 
  
  
 
<header class="site-navbar absolute transparent" role="banner">
      <div class="py-3">
        <div class="container">
          <div class="row align-items-center">
           
            <div class="col-6 col-md-9 text-right">
              <div class="d-inline-block">
              	
            </div>
              
          </div>
        </div>
      </div>
      <nav class="site-navigation position-relative text-right bg-black text-md-right" role="navigation">
        <div class="container position-relative">
          <div class="site-logo">
            <a href="index.html"><img src="images/logo.png" alt=""></a>
          </div>

          <div class="d-inline-block d-md-none ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>

          <ul class="site-menu js-clone-nav d-none d-md-block">
           <li>
              <a href="${pageContext.request.contextPath }/homepage.jsp" >主页</a></li>
            <li><a href="${pageContext.request.contextPath }//queryteampoints?page=1&size=5">赛事排名</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/driverinfo.jsp">个人主页</a></li>
            <li><a href="${pageContext.request.contextPath }/register.jsp">注册</a></li>
            <li class="active">
            <c:choose>
            	<c:when test="${empty driver}">
            	<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
            	</c:when>
            	<c:otherwise>
            	<a href="${pageContext.request.contextPath }/driverinfo.jsp">欢迎你 ${driver.firstname }</a>
            	</c:otherwise>

            </c:choose>
			</li>
          </ul>
        </div>
      </nav>
    </header>
    <!-- Wrapper -->
    <div id="wrapper">

      <!-- Main -->
        <div id="main">
          <div class="inner">
            <!-- Banner -->
            <section class="main-banner" >
              <div class="container-fluid" id="section1">
                <div class="row">
                  <div class="col-md-12">
                    <div class="banner-content">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="banner-caption">
                                      
            <form action="${pageContext.request.contextPath }/driver/driverModify" method="get" class="bg-white" onsubmit="return check();">
              
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">选手编号<span class="text-danger" ></span></label>
                    <input type="text" class="form-control" id="id" name="id" value="${sessionScope.driver.id}" readonly>
                  </div>
                
                  <div class="col-md-6">
                    <label for="c_fname" class="text-black">姓<span class="text-danger"></span></label>
                    <input type="text" class="form-control" id="firstname" name="firstname" value="${sessionScope.driver.firstname}">
                  </div>
                  <div class="col-md-6">
                    <label for="c_lname" class="text-black">名<span class="text-danger"></span></label>
                    <input type="text" class="form-control" id="secondname" name="secondname" value="${sessionScope.driver.secondname}">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="c_fname" class="text-black">英文短名<span class="text-danger"></span></label>
                    <input type="text" class="form-control" id="shortname" name="shortname" value="${sessionScope.driver.shortname}">
                  </div>
                  <div class="col-md-6">
                    <label for="c_lname" class="text-black">赛车号码<span class="text-danger"></span></label>
                    <input type="text" class="form-control" id="carno" name="carno" value="${sessionScope.driver.carno}">
                  </div>
                </div> 
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">电子邮箱 <span class="text-danger"></span></label>
                    <input type="email" class="form-control" id="email" name="email" value="${sessionScope.driver.email}" readonly>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">密码<span class="text-danger"></span></label>
                    <input type="text" class="form-control" id="pw" name="pw" value="${sessionScope.driver.password}">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">队伍名称<span class="text-danger"></span></label>
                    <input type="text" class="form-control" id="tname" name="tname" value="${sessionScope.driver.teamname}" readonly>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="更新信息" >
                  </div>
                </div>
              </div>
            </form>
                          </div>
                         
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>

            <!-- Services -->
            <section class="team-info"  >
            <div class="container-fluid" id="section2">
            	<table>
            		<tr>
            			<td align="center">车队信息</td>
            		</tr>
            	</table>
				<table class="table" style="table-layout:fixed">
					<tr >
						<td >车队名称</td>
						<td >车队领队</td>
						<td >车队得分</td>
						<td >车队邀请码</td>
						<td >车队图标</td>
						<td align="center">操作</td>
					</tr>
					</table>
					<form action="${pageContext.request.contextPath }/modteam" method="get" onsubmit="return check1();">
					<table class="table" id="teaminfo" style="table-layout:fixed">
					<tr>
						<td ><input type="text" class="form-control" value="${sessionScope.team.tname}" name="mod_tname" id="mod_tname"></td>
						<td ><input type="text" class="form-control" value="${sessionScope.team.tleader}" name="mod_tleader" id="mod_tleader"></td>
						<td align="left"><input type="text" class="form-control" value="${sessionScope.team.tpoints}" name="mod_tpoints" readonly></td>
						<td ><input type="text" class="form-control" value="${sessionScope.team.tcode}" name="mod_tcode" readonly></td>
						<td ><input type="text" class="form-control" value="${sessionScope.team.tlogo}"name="mod_tlogo" id = "mod_tlogo"></td>
						<td align="center"><button type="submit">修改</button></td>
					</tr>
					</table>
					</form>
					<table class="table">
					<tr >
						<td align="center">车队队员</td>
					</tr>
					</table>
						<table class="table" style="table-layout:fixed">
							<tr >
							<td align="center">赛车号</td>
							<td align="center">英文短名</td>
							<td align="center">姓</td>
							<td align="center">操作</td>
							</tr>
							</table>
							<form action="${pageContext.request.contextPath }/deletdriver" method="get">
							<table class="table" style="table-layout:fixed">
						<c:forEach items="${team_drivers}" var="teamDrivers">
						<tr>
							<td align="center" ><input type="text" class="form-control" value="${teamDrivers.carno}" readonly name="decarno"></td>
							<td align="center"><input type="text" class="form-control" value="${teamDrivers.shortname}" readonly name="deshortname"></td>
							<td align="center"><input type="text" class="form-control" value="${teamDrivers.firstname}" readonly name="defirstname"></td>
							<td align="center"><button type="submit">删除</button></td>
							</tr>
						</c:forEach>
						</table>
						</form>
				</div>
            </section>

            <!-- Top Image -->
            <section class="matche-records">
              <div class="container-fluid" id="section3">
               <table>
            		<tr>
            			<td align="center">比赛记录</td>
            		</tr>
            	</table>
            	<form action="#" method="get">
						<table class="table">
							<tr >
							<td align="center">比赛编号</td>
							<td align="center">比赛时间</td>
							<td align="center">车手短名</td>
							<td align="center">赛车号</td>
							<td align="center">成绩</td>
							<td align="center">积分</td>
							</tr>
							<c:forEach items="${match_records}" var="mrecords">
						<tr>
							<td align="center">${mrecords.matchid}</td>
							<td align="center">${mrecords.matchdate}</td>
							<td align="center">${mrecords.shortname}</td>
							<td align="center">${mrecords.carno}</td>
							<td align="center">${mrecords.matchtime}</td>
							<td align="center">${mrecords.points}</td>
							</tr>
						</c:forEach>
						</table>
					</form>
            	
              </div>
            </section>

            <!-- LeftImage -->
            <section class="match-records-info">
              <div class="container-fluid" id="section4">
               <table>
            		<tr>
            			<td align="center">比赛安排</td>
            		</tr>
            	</table>
            	<form >
						<table class="table" >
							<tr >
							<td align="center">比赛编号</td>
							<td align="center">比赛时间</td>
							<td align="center">车手短名</td>
							<td align="center">赛车号</td>
							<td align="center">其他操作</td>
							</tr>
							<c:forEach items="${pr_match_records}" var="pr_mrecords">
						<tr>
							<td align="center" id="1">${pr_mrecords.matchid}</td>
							<td align="center">${pr_mrecords.matchdate}</td>
							<td align="center">${pr_mrecords.shortname}</td>
							<td align="center">${pr_mrecords.carno}</td>
							<td align="center"><button onclick="del_prrecords(this);">删除</button></td>
							</tr>
						</c:forEach>
						</table>
					</form>
              </div>
            </section>


          </div>
        </div>

      <!-- Sidebar -->
        <div id="sidebar">

          <div class="inner">              
            <!-- Menu -->
            <nav id="menu">
              <ul>
                <li><a href="./driverinfo.jsp#section1">个人信息</a></li>
                <li><a href="./driverinfo.jsp#section2">车队信息</a></li>
                  <li><a href="./driverinfo.jsp#section3">比赛记录</a></li>
                <li>
                  <a href="./driverinfo.jsp#section4">比赛安排</a>
                </li>
              </ul>
            </nav>

          </div>
        </div>

    </div>

  <!-- Scripts -->
  <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/transition.js"></script>
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/custom.js"></script>
</body>


  </body>

</html>
