<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:admin-layout title="Users" userName="Admin">
    <jsp:attribute name="content">
<section class="content">
    <jsp:include page="/WEB-INF/tags/notifications.jsp"/>
    <div class="row">
        <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">Data Table With Full Features</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
                <table id="example1" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>State</th>
                        <th><a href="<c:url value="/admin/user/create"/>" class="btn btn-success btn-sm" style="width: 163px">Create</a></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td><span class="label label-<c:choose><c:when test="${user.state.equals('ACTIVE')}">success</c:when><c:when test="${user.state.equals('INACTIVE')}">warning</c:when><c:when test="${user.state.equals('LOCKED')}">danger</c:when></c:choose>">
                            ${user.state}</span></td>
                        <td>
                            <a href="<c:url value="/admin/user/edit/${user.id}"/>" class="btn btn-primary btn-sm" style="width: 80px">
                                <i class="fa fa-pencil-square-o"></i> Edit</a>
                            <a href="<c:url value="/admin/user/delete/${user.id}"/>" class="btn btn-danger btn-sm" style="width: 80px">
                                <i class="fa fa-trash"></i> Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- /.box-body -->
        </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    </jsp:attribute>
</t:admin-layout>
