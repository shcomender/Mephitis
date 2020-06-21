<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>	
<head>
<title>Login Form with Flat Responsive template :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
        <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";%>
<base href="<%=basePath%>">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="<%=basePath%>css/loginstyle.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href='<%=basePath%>http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
<link href='<%=basePath%>http://fonts.googleapis.com/css?family=Lato:100,300,400,700' rel='stylesheet' type='text/css'>



    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
<!--//webfonts-->

<script src="js/loginjquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/login.css">
	<script type="text/javascript">
		function refreshImage() {
			// 刷新图片使用：就是修改image标签的src指向，重新访问链接即可
			var image = document.getElementById("code");
			// image.src = "${pageContext.request.contextPath }/verificationCode?date=" + new Date().getMilliseconds();
			image.src = "${pageContext.request.contextPath }/Vercode?date=" + new Date().getMilliseconds();
		}
	</script>
	
	<script type="text/javascript">
	function check(){
		var checkcd = '<%=request.getSession().getAttribute("checkcode")%>';
		if(document.getEletmentById("email").value == "" || document.getEletmentById("password").value == ""){
			alert("密码或账号不得为空！");
			return false;
		}
		else  return true;
	}
	</script>
	
	
</head>
<body>
  <div class="site-wrap">
<div class="site-mobile-menu">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-logo">
          <a href="#"><img src="images/logo.png" alt="Image"></a>
        </div>
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
 <header class="site-navbar absolute transparent" role="banner">
 
      <nav class="site-navigation position-relative text-right bg-black text-md-right" role="navigation">
        <div class="container position-relative">
          <div class="site-logo">
            <a href="index.html"><img src="images/logo.png" alt=""></a>
          </div>
          <ul class="site-menu js-clone-nav d-none d-md-block">
           <li>
              <a href="${pageContext.request.contextPath }/homepage.jsp" >主页</a></li>
           <li class="active"><a href="${pageContext.request.contextPath }/queryteampoints?page=1&size=5">赛事排名</a></li>
            <li ><a href="${pageContext.request.contextPath }/driverinfo.jsp">个人主页</a></li>
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
<div class="login-form">
	<div class="close"> </div>
		<h1>车手登录</h1>
			<form method="get" action="${pageContext.request.contextPath }/driver/doLogin" onsubmit="check();">
				<input type="text" class="email" placeholder="邮箱" required="" name="email"/>
				<input type="password" class="password" placeholder="密码" required="" name="password"/>
				<div class="username">
						<div class="left fl">
						<input class="yanzhengma" type="text" name="inputcode"
								placeholder="请输入验证码" id="inputcode"/>
						</div>
						<div class="right fl">
							<img onclick="refreshImage();" id="code" title="看不清点击刷新" src="${pageContext.request.contextPath }/Vercode">
						</div> 
						<div class="clear"></div>
					</div>
					<div>
					<span style="font-family:'楷体',font-size='90px'">
						${sessionScope.erro}
					</span>
						<input type="submit" value="登录">
					</div>
							
			</form>
						<p><a href="./register.jsp" class="sign">立即注册</a></p>
</div>
</div>
</body>
</html>