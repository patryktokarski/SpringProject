<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:admin-layout title="Events" userName="Admin">
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
                            <th>Name</th>
                            <th>Date</th>
                            <th><a href="<c:url value="/event/create"/>" class="btn btn-success btn-sm" style="width: 163px">Create</a></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${events}" var="event">
                    <tr>
                        <td>${event.id}</td>
                        <td>${event.name}</td>
                        <td>${event.date}</td>
                        <td>
                            <a href="<c:url value="/event/edit/${event.id}"/>" class="btn btn-primary btn-sm" style="width: 80px">
                                <i class="fa fa-pencil-square-o"></i> Edit</a>
                            <a href="<c:url value="/event/delete/${event.id}"/>" class="btn btn-danger btn-sm" style="width: 80px">
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
