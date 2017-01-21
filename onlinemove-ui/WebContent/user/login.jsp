<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>

<script type="text/javascript" src="jquery-3.1.0.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
    	  $("#regist").click(function(){
				$("#loginForm")[0].action="regist.do";
				$("#loginForm").submit();
    	  });
    	});
</script>

</head>
<body>

  <form method="post" action="http://www.huawei.com/cn/my-huawei/login?redirect=http%3a%2f%2fwww.huawei.com%2fcn%2f" id="form1">
<div class="aspNetHidden">
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUJMzcwNzgzMDM4DxYCHhNWYWxpZGF0ZVJlcXVlc3RNb2RlAgFkZNw4063QVdvildmwtHlnLwH5Zjnl">
</div>

        
        
<input type="hidden" id="HidPostLoginUrl" name="HidPostLoginUrl" value="https://webaccount.huawei.com/en/LoginPost">
<input type="hidden" id="gLanguageCurrent" name="gLanguageCurrent" value="zh">

<div id="container">
    <div class="sign-up-top">
        <div class="container">
            <div class="row">
                <div class="clearfix">
                    <div class="logo pull-left"> 
                        <a href="http://www.huawei.com/cn">
                            <img alt="Huawei" src="./登录 - 华为_files/logo_new.png">
                        </a> 
                    </div>
                    <div class="language pull-right">
                        <!--<a href="http://www-beta.huawei.com/cn/accounts/login" class="bule">中文</a>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container  login-info-cell">
    <div class="row">
        <div class="col-sm-7 center-block float-none">
            <div class="red-title clearboth">登录</div>
            <div class="sign-contact">
                <div class="red-line">&nbsp;</div>
                
                    <input type="hidden" id="Language">
                    <input type="hidden" value="用户名不能为空" id="userNameTip">
                    <input type="hidden" value="密码不能为空" id="pwdTip">
                    <input type="hidden" value="其他" id="Other">
                    <div class="login-input">
                        <div class="row">
                            <div class="col-sm-8 center-block float-none">
                                <div class="user clearfix">
                                    <input type="text" placeholder="邮箱/账号" maxlength="50" name="userName" id="userName" class="placeholder">
                                    <span>&nbsp;</span>
                                    <div id="userNameErrMsg" class="field_message"></div>
                                </div>
                                <div class="user powss clearfix">
                                    <input type="password" placeholder="密码" maxlength="60" name="pwd" id="pwd" class="placeholder">
                                    <span>&nbsp;</span>
                                    <div id="pwdErrMsg" class="field_message"></div>
                                </div>
                                <div class="sign-btn">
                                    <input type="button" class="update-btn" value="登录" id="btnLogin">
                                </div>
                                <div class="logon clearfix">
                                    <a class="bule" href="http://www.huawei.com/cn/my-huawei/register?method=toRegister&amp;nls=zh&amp;appurl=">立即注册</a>
                                    <a class="bule" href="https://uniportal.huawei.com/uniportal/modifyInfo.do?actionFlag=toGetPassword&amp;nls=zh"> 忘记密码 </a>
                                </div>
                                <div class="other-way">
                                    <p>也可以用以下账号登录：</p>
                                    <a class="linkedinLogin" href="javascript:void();">
                                        <img alt="" src="./登录 - 华为_files/sign-in.jpg">
                                    </a>
                                </div>
                                <div class="help">
                                    <!-- <a class="bule" href="https://uniportal.huawei.com/uniportal/help_en.html">Needs to help?</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                
            </div>
        </div>
    </div>
</div></form>
<!-- 	<form action="login.do" method="post" id="loginForm" name="loginForm"> -->
<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<td><span>用户名：</span></td> -->
<!-- 				<td><input id="username" name="username" /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td><span>密&nbsp;&nbsp;码：</span></td> -->
<!-- 				<td><input id="pwd" name="pwd" /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td><input type="submit"  style="cursor: pointer;" id="login" name="login" value="登录" /></td> -->
<!-- 				<td> -->
<!-- 					<input type="button" style="cursor: pointer;" id="regist" name="regist" onclick="" value="注册" />  -->
<!-- 					<span style="color: red; cursor: pointer;" id="forget" name="forget" onclick="">忘记密码</span> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 	</form> -->
</body>
</html>