<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:admin-layout title="Event From" userName="TEST">
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
                                    <h3 class="box-title">Create Event</h3>
                                </c:when>
                                <c:otherwise>
                                    <h3 class="box-title">Edit Event</h3>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form method="post" modelAttribute="event"
                                   action="${create == true ? '/admin/event/create' : '/admin/event/edit'}" cssClass="form">
                                <div class="box-body">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <form:hidden path="id"/>
                                <spring:bind path="name">
                                <div class="${status.error ? 'alert alert-danger' : ''}">
                                    <p><form:errors path="name"/></p>
                                </div>
                                 <div class="form-group has-feedback">
                                     <form:input path="name" cssClass="form-control" placeholder="Name"/>
                                 </div>
                                </spring:bind>
                                <spring:bind path="date">
                                <div class="${status.error ? 'alert alert-danger' : ''}">
                                    <p><form:errors path="date"/></p>
                                </div>
                                  <div class="form-group has-feedback">
                                      <form:input path="date" cssClass="form-control" placeholder="Date" id="datepicker"/>
                                  </div>
                                </spring:bind>
                                <spring:bind path="description">
                                <div class="${status.error ? 'alert alert-danger' : ''}">
                                    <p><form:errors path="description"/></p>
                                </div>
                                  <div class="form-group has-feedback">
                                      <form:input path="description" cssClass="form-control" placeholder="Description"/>
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
          <script>
              $('#datepicker').datepicker({
                  autoclose: true,
                  dateFormat: "dd/mm/yyyy"
              })
          </script>
    </jsp:attribute>

</t:admin-layout>