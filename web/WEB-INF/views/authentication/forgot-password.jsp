<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:auth-layout title="Reset password">
    <jsp:attribute name="content">
        <div class="login-box">
            <div class="login-logo">
                <b>Test</b>App
            </div>
            <jsp:include page="/WEB-INF/tags/notifications.jsp"/>
            <div class="login-box-body">
                <p class="login-box-msg">Enter your email address. We will send a reset link on that email.</p>

                <form action="<c:url value="/forgot-password"/>" method="post">
                    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                    <div class="form-group has-feedback">
                        <input type="email" name="email" class="form-control" placeholder="Email">
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Submit</button>
                        </div>
                    </div>
                </form>
                <a href="<c:url value="/login"/> ">Back</a>
            </div>
        </div>
    </jsp:attribute>
</t:auth-layout>