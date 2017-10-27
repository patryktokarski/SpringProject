<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:app-layout title="User Panel" userName="User">
    <jsp:attribute name="content">
            <section class="content-header">
                <h1>
                    User Main Panel
                    <small>Version 2.0</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Dashboard</li>
                </ol>
            </section>
    </jsp:attribute>
</t:app-layout>