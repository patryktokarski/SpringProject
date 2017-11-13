<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag description="AdminPanelLayout" pageEncoding="UTF-8"%>
<%@ attribute name="content" fragment="true" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="userName" required="true" %>
<%@ attribute name="customScript" fragment="true"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title}</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/font-awesome/css/font-awesome.min.css"/>">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/Ionicons/css/ionicons.min.css"/>">
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value="/webjars/AdminLTE/2.4.2/dist/css/AdminLTE.min.css"/>">
    <!-- jvectormap -->
    <link rel="stylesheet" href="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/jvectormap/jquery-jvectormap.css"/>">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="<c:url value="/webjars/AdminLTE/2.4.2/dist/css/skins/_all-skins.min.css"/>">
    <!-- Select2 -->
    <link rel="stylesheet" href="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/select2/dist/css/select2.min.css"/>">
    <!-- bootstrap datepicker -->
    <link rel="stylesheet" href="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"/>">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="/WEB-INF/views/admin/partials/header.jsp"/>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->

        <jsp:include page="/WEB-INF/views/admin/partials/sidebar.jsp"/>

        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->

        <jsp:invoke fragment="content"/>

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="/WEB-INF/views/admin/partials/footer.jsp"/>

    <!-- Control Sidebar -->

    <jsp:include page="/WEB-INF/views/admin/partials/settings.jsp"/>

    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>

</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js"/>"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<!-- Select2 -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/select2/dist/js/select2.full.min.js"/>"></script>
<!-- InputMask -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/plugins/input-mask/jquery.inputmask.js"/>"></script>
<script src="<c:url value="/webjars/AdminLTE/2.4.2/plugins/input-mask/jquery.inputmask.date.extensions.js"/>"></script>
<script src="<c:url value="/webjars/AdminLTE/2.4.2/plugins/input-mask/jquery.inputmask.extensions.js"/>"></script>
<!-- FastClick -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/fastclick/lib/fastclick.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/dist/js/adminlte.min.js"/>"></script>
<!-- Sparkline -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"/>"></script>
<!-- jvectormap  -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>"></script>
<script src="<c:url value="/webjars/AdminLTE/2.4.2/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/>"></script>
<!-- SlimScroll -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"/>"></script>
<!-- iCheck 1.0.1 -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/plugins/iCheck/icheck.min.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/dist/js/adminlte.min.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/dist/js/demo.js"/>"></script>
<!-- bootstrap datepicker -->
<script src="<c:url value="/webjars/AdminLTE/2.4.2/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"/>"></script>

<jsp:invoke fragment="customScript"/>
</body>
</html>