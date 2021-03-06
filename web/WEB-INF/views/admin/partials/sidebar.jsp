<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="sidebar">
    <!-- Sidebar user panel -->
    <div class="user-panel">
        <div class="pull-left image">
            <img src="<c:url value="/webjars/AdminLTE/2.4.2/dist/img/user2-160x160.jpg"/>" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
            <p><c:out value="${param.userName}"/></p>
            <p><%= request.getParameter("email")%></p>
            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
    </div>
    <!-- search form -->
    <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
            <input type="text" name="q" class="form-control" placeholder="Search...">
            <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat">
                  <i class="fa fa-search"></i>
                </button>
              </span>
        </div>
    </form>
    <!-- /.search form -->
    <!-- sidebar menu: : style can be found in sidebar.less -->
    <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>
        <li>
            <a href="<c:url value="/admin/user/list"/>">
                <i class="fa fa-user"></i>
                <span>Users</span>
            </a>
        </li>
        <li>
            <a href="<c:url value="/admin/event/list"/>">
                <i class="fa fa-star"></i>
                <span>Events</span>
            </a>
        </li>
    </ul>
</section>