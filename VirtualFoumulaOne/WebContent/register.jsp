<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title>加入比赛</title>
    <meta charset="utf-8">
        <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";%>
<base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="<%=basePath%>https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="<%=basePath%>fonts/icomoon/style.css">

    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/magnific-popup.css">
    <link rel="stylesheet" href="<%=basePath%>css/jquery-ui.css">
    <link rel="stylesheet" href="<%=basePath%>css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=basePath%>css/owl.theme.default.min.css">


    <link rel="stylesheet" href="<%=basePath%>css/aos.css">

    <link rel="stylesheet" href="<%=basePath%>css/style.css">
    
    <script type="text/javascript">
    	function check(){
    		var firstname = document.getElementById("firstname").value;
    		var secondname = document.getElementById("secondname").value;
    		var shortname = document.getElementById("shortname").value;
    		var carno = document.getElementById("carno").value;
    		var email = document.getElementById("email").value;
    		var pw = document.getElementById("pw").value;
    		var checkpw = document.getElementById("checkpw").value;
    		
    		if(firstname == "" || secondname == "" || shortname == "" || carno == "" || email == "" || pw == "" || checkpw == "")
    			{
    				alert("必填信息必须填写");
    				return false;
    			}
    		else if(!(pw==checkpw)){
    			alert("两次密码不一致！");return false;
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
      <div class="py-3">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-6 col-md-3">
              <a href="#" class="text-secondary px-2 pl-0"><span class="icon-facebook"></span></a>
              <a href="#" class="text-secondary px-2"><span class="icon-instagram"></span></a>
              <a href="#" class="text-secondary px-2"><span class="icon-twitter"></span></a>
              <a href="#" class="text-secondary px-2"><span class="icon-linkedin"></span></a>
            </div>
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
             <li  >
              <a href="${pageContext.request.contextPath }/homepage.jsp" >主页</a></li>
           <li><a href="${pageContext.request.contextPath }/queryteampoints?page=1&size=5">赛事排名</a></li>
            <li ><a href="${pageContext.request.contextPath }/driverinfo.jsp">个人主页</a></li>
            <li class="active"><a href="${pageContext.request.contextPath }/register.jsp">注册</a></li>
            <li>
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
  
    <div class="site-blocks-cover overlay" style="background-image: url(images/image1_register.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
      <div class="container">
        <div class="row align-items-center justify-content-start">
          <div class="col-md-6 text-center text-md-left" data-aos="fade-up" data-aos-delay="400">
            <h1 class="bg-text-line">即刻加入</h1>
            <p class="mt-4">填写信息加入比赛，与现役车手一起决胜时刻！</p>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section bg-light" data-aos="fade-up">
      <div class="container">
        <div class="row align-items-first">
          <div class="col-md-7">
         
            <form action="./driver/driverRegister" method="get" class="bg-white" onsubmit="return check();">
              
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="c_fname" class="text-black">姓<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="firstname" name="firstname">
                  </div>
                  <div class="col-md-6">
                    <label for="c_lname" class="text-black">名<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="secondname" name="secondname">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="c_fname" class="text-black">英文短名<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="shortname" name="shortname">
                  </div>
                  <div class="col-md-6">
                    <label for="c_lname" class="text-black">赛车号码<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="carno" name="carno">
                  </div>
                </div> 
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">电子邮箱 <span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">密码<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="pw" name="pw" placeholder="">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">确认密码<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="checkpw" name="checkpw" placeholder="">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">参赛队伍邀请码</label>
                    <input type="text" class="form-control" id="teamcode" name="teamcode">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Join Now!" >
                  </div>
                </div>
              </div>
            </form>
          </div>
          <div class="col-md-5">
            <div class="p-4 border mb-3 bg-white">
             <p>参赛须知</p>
			<p>1.请如实填写您的基本信息，以保证不会影响您和您的队伍获取最终奖励。</p>
			<p>2.每个邮箱只可绑定一个账号。</p>
			<p>3.必填信息请务必填写。</p>
			<p>4.队伍信息可暂时不必填写，稍后可加入队伍。</p>
			<p>5.如若需要参加比赛，需要您加入不小于三人响应组队方可。</p>
			<p>6.最终解释权归赛会所有。</p>
            </div>
          </div>   
        </div>
      </div>
    </div>

    <footer class="site-footer border-top">
      <div class="container">
        <div class="row">
          <div class="col-lg-4">
            <div class="mb-5">
              <h3 class="footer-heading mb-4">About Sportz</h3>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe pariatur reprehenderit vero atque, consequatur id ratione, et non dignissimos culpa? Ut veritatis, quos illum totam quis blanditiis, minima minus odio!</p>
            </div>

            <div class="mb-5">
              <h3 class="footer-heading mb-4">Recent Blog</h3>
              <div class="block-25">
                <ul class="list-unstyled">
                  <li class="mb-3">
                    <a href="#" class="d-flex">
                      <figure class="image mr-4">
                        <img src="images/img_1.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <h3 class="heading font-weight-light">Lorem ipsum dolor sit amet consectetur elit</h3>
                      </div>
                    </a>
                  </li>
                  <li class="mb-3">
                    <a href="#" class="d-flex">
                      <figure class="image mr-4">
                        <img src="images/img_1.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <h3 class="heading font-weight-light">Lorem ipsum dolor sit amet consectetur elit</h3>
                      </div>
                    </a>
                  </li>
                  <li class="mb-3">
                    <a href="#" class="d-flex">
                      <figure class="image mr-4">
                        <img src="images/img_1.jpg" alt="" class="img-fluid">
                      </figure>
                      <div class="text">
                        <h3 class="heading font-weight-light">Lorem ipsum dolor sit amet consectetur elit</h3>
                      </div>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            
          </div>
          <div class="col-lg-4 mb-5 mb-lg-0">
            <div class="row mb-5">
              <div class="col-md-12">
                <h3 class="footer-heading mb-4">Quick Menu</h3>
              </div>
              <div class="col-md-6 col-lg-6">
                <ul class="list-unstyled">
                  <li><a href="#">Home</a></li>
                  <li><a href="#">Matches</a></li>
                  <li><a href="#">News</a></li>
                  <li><a href="#">Team</a></li>
                </ul>
              </div>
              <div class="col-md-6 col-lg-6">
                <ul class="list-unstyled">
                  <li><a href="#">About Us</a></li>
                  <li><a href="#">Privacy Policy</a></li>
                  <li><a href="#">Contact Us</a></li>
                  <li><a href="#">Membership</a></li>
                </ul>
              </div>
            </div>

            <div class="row">
              <div class="col-md-12">
                <h3 class="footer-heading mb-4">Follow Us</h3>

                <div>
                  <a href="#" class="pl-0 pr-3"><span class="icon-facebook"></span></a>
                  <a href="#" class="pl-3 pr-3"><span class="icon-twitter"></span></a>
                  <a href="#" class="pl-3 pr-3"><span class="icon-instagram"></span></a>
                  <a href="#" class="pl-3 pr-3"><span class="icon-linkedin"></span></a>
                </div>
              </div>
            </div>

          </div>

          <div class="col-lg-4 mb-5 mb-lg-0">
            <div class="mb-5">
              <h3 class="footer-heading mb-4">Watch Video</h3>

              <div class="block-16">
                <figure>
                  <img src="images/img_1.jpg" alt="Image placeholder" class="img-fluid rounded">
                  <a href="https://vimeo.com/channels/staffpicks/93951774" class="play-button popup-vimeo"><span class="icon-play"></span></a>
                </figure>
              </div>

            </div>

            <div class="mb-5">
              <h3 class="footer-heading mb-2">Subscribe Newsletter</h3>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit minima minus odio.</p>

              <form action="#" method="post">
                <div class="input-group mb-3">
                  <input type="text" class="form-control border-secondary text-white bg-transparent" placeholder="Enter Email" aria-label="Enter Email" aria-describedby="button-addon2">
                  <div class="input-group-append">
                    <button class="btn btn-primary" type="button" id="button-addon2">Send</button>
                  </div>
                </div>
              </form>

            </div>

          </div>
          
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
          </div>
          
        </div>
      </div>
    </footer>
  </div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>

  <script src="js/main.js"></script>
    
  </body>
</html>