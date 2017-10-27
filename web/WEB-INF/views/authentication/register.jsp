<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:auth-layout title="Register">
    <jsp:attribute name="content">
    <div class="login-box">
        <div class="login-logo">
            <b>Test</b>App
        </div>
        <div class="login-box-body">
            <p class="login-box-msg">Register</p>
            <form:form method="post" modelAttribute="user" action="/register">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="id">
                <spring:bind path="firstName">
                    <div class="${status.error ? 'alert alert-danger' : ''}">
                        <p><form:errors path="firstName"/></p>
                    </div>
                     <div class="form-group has-feedback">
                         <form:input path="firstName" cssClass="form-control" placeholder="First Name"/>
                         <span class="glyphicon glyphicon-user form-control-feedback"></span>
                     </div>
                </spring:bind>
                <spring:bind path="lastName">
                    <div class="${status.error ? 'alert alert-danger' : ''}">
                        <p><form:errors path="lastName"/></p>
                    </div>
                      <div class="form-group has-feedback">
                          <form:input path="lastName" cssClass="form-control" placeholder="Last Name"/>
                          <span class="glyphicon glyphicon-user form-control-feedback"></span>
                      </div>
                </spring:bind>
                      <spring:bind path="email">
                    <div class="${status.error ? 'alert alert-danger' : ''}">
                        <p><form:errors path="email"/></p>
                    </div>
                      <div class="form-group has-feedback">
                          <form:input path="email" cssClass="form-control" placeholder="Email"/>
                          <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                      </div>
                </spring:bind>
                      <spring:bind path="password">
                    <div class="${status.error ? 'alert alert-danger' : ''}">
                        <p><form:errors path="password"/></p>
                    </div>
                        <div class="form-group has-feedback">
                          <form:password path="password" cssClass="form-control" placeholder="Password"/>
                          <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                </spring:bind>
                <spring:bind path="passwordConfirmation">
                    <div class="${status.error ? 'alert alert-danger' : ''}">
                        <p><form:errors path="passwordConfirmation"/></p>
                    </div>
                      <div class="form-group has-feedback">
                          <form:password path="passwordConfirmation" cssClass="form-control" placeholder="Password Confirmation"/>
                          <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                      </div>
                </spring:bind>
                <div class="form-group">
                    <input type="submit" value="Register" class="btn btn-primary btn-flat">
                </div>
            </form:form>
            <a href="<c:url value="/login"/>" class="text-center">Back</a>

        </div>
    </div>
    </jsp:attribute>
</t:auth-layout>