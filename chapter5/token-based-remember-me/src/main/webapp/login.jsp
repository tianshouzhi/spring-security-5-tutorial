<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>spring secuirty 自定义登录页面</title>
    <link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <script src="/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</head>
<body style="padding-top: 50px">
        <form class="form-horizontal col-md-4 col-md-offset-4" role="form" action="/login" method="post">
            <fieldset>
                <legend class="text-center">自定义登录表单</legend>
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                    <div class="alert alert-danger">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
                    </c:if>
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">用户名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="username" name="username"
                               placeholder="请输入用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label pull-left">密 码</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="请输入密码">
                    </div>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="form-group">
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="remember-me"/> 请记住我
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </div>
            </fieldset>
        </form>
</body>
</html>