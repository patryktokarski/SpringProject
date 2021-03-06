<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:auth-layout title="Log in">
    <jsp:attribute name="content">
    <div class="login-box">
        <div class="login-logo">
            <b>Test</b>App
        </div>
        <jsp:include page="/WEB-INF/tags/notifications.jsp"/>
        <c:if test="${param.error != null}">
        <div class="callout callout-danger">
            <h4>Error!</h4>
            <p>Invalid credentials</p>
        </div>
        </c:if>
        <div class="login-box-body">
            <p class="login-box-msg">Sign in to start your session</p>

            <form action="<c:url value="/login"/>" method="post">
                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                <div class="form-group has-feedback">
                    <input type="email" name="email" class="form-control" placeholder="Email">
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" name="password" class="form-control" placeholder="Password">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                        <%--<div class="col-xs-8">--%>
                        <%--<div class="checkbox icheck">--%>
                        <%--<label>--%>
                        <%--<input type="checkbox"> Remember Me--%>
                        <%--</label>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                    <!-- /.col -->
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                    </div>
                </div>
            </form>
            <a href="<c:url value="/forgot-password"/> ">I forgot my password</a><br>
            <a href="<c:url value="/register"/>" class="text-center">Register a new membership</a>
        </div>
    </div>
    </jsp:attribute>
</t:auth-layout>



