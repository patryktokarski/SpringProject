<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:auth-layout title="Reset Password">
    <jsp:attribute name="content">
                <div class="login-box">
                    <div class="login-logo">
                        <b>Test</b>App
                    </div>
                    <jsp:include page="/WEB-INF/tags/notifications.jsp"/>
                    <div class="login-box-body">
                        <p class="login-box-msg">Enter new password.</p>
                        <form action="<c:url value="/reset-password"/>" method="post">
                            <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                            <input type="hidden" value="${token}">
                            <div class="form-group has-feedback">
                                <input type="password" name="password" class="form-control" placeholder="Email">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="password" name="passwordConfirmation" class="form-control" placeholder="Email">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                            <div class="row">
                                <div class="col-xs-4">
                                    <button type="submit" class="btn btn-primary btn-block btn-flat">Save</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
    </jsp:attribute>
</t:auth-layout>