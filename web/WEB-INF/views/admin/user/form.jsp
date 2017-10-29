<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:admin-layout title="User From" userName="TEST">
    <jsp:attribute name="content">

        <section class="content">
            <jsp:include page="/WEB-INF/tags/notifications.jsp"/>
            <div class="row">
                <!-- left column -->
                <div class="col-md-12">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <c:choose>
                                <c:when test="${create == true}">
                                    <h3 class="box-title">Create User</h3>
                                </c:when>
                                <c:otherwise>
                                    <h3 class="box-title">Edit User</h3>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form method="post" modelAttribute="user"
                                   action="${create == true ? '/user/create' : '/user/edit'}" cssClass="form">
                                <div class="box-body">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <form:hidden path="id"/>
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
                                      <form:password path="passwordConfirmation" cssClass="form-control"
                                                     placeholder="Password Confirmation"/>
                                      <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                  </div>
                                </spring:bind>
                                <spring:bind path="state">
                                    <div class="form-group">
                                        <form:select path="state" items="${stateList}" cssClass="form-control" />
                                    </div>
                                </spring:bind>
                                <spring:bind path="roles">
                                    <div class="${status.error ? 'alert alert-danger' : ''}">
                                        <form:errors path="roles"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Roles</label>
                                        <form:select path="roles" cssClass="form-control select2"
                                                     multiple="true" id="roles"
                                                     cssStyle="width: 100%" data-placeholder="Select role">
                                            <form:options items="${rolesSet}" itemLabel="type" itemValue="id"/>
                                        </form:select>
                                    </div>
                                </spring:bind>
                                    <div class="form-group">
                                        <c:choose>
                                            <c:when test="${create == true}">
                                                <input type="submit" value="Create" class="btn btn-success btn-flat">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="submit" value="Save Changes" class="btn btn-success btn-flat">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>

    </jsp:attribute>

    <jsp:attribute name="customScript">
             <script type="text/javascript">
                 //Initialize Select2 Elements
                 $(document).ready(function() {
                     $('.select2').select2({
                         theme: "classic"
                     })
                 });
             </script>
    </jsp:attribute>
</t:admin-layout>