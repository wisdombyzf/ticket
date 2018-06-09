<%@ page language="java" pageEncoding="utf-8"%>


<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar">
    <!-- 侧边栏 用户 面板 -->
    <div class="user-panel">
        <div class="pull-left image">
            <img src="/master/dist/img/user2-160x160.jpg"   class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
            <p>CodeofJackie</p>
            <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
        </div>
    </div>
    <!-- 侧边栏菜单: : style can be found in sidebar.less -->
    <ul class="sidebar-menu" data-widget="tree">
        <li class="header">主菜单</li>

        <li class="treeview">
            <a href="#">
                <i class="fa fa-user"></i> <span>航班信息</span>
                <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
            </a>
            <ul class="treeview-menu">
                <li><a href="flight.jsp"><i class="fa fa-circle-o"></i>管理航班信息</a></li>
            </ul>
        </li>
        <li class="active treeview">
            <a href="Match">
                <i class="fa fa-flag"></i> <span>会员信息</span>
                <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
            </span>
            </a>
            <ul class="treeview-menu">
                <li><a href="passenger.jsp"><i class="fa fa-circle-o"></i>管理乘客信息</a></li>
            </ul>
        </li>
        <li class="active treeview">
            <a href="Match">
                <i class="fa fa-flag"></i> <span>订单信息</span>
                <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
            </span>
            </a>
            <ul class="treeview-menu">
                <li><a href="order.jsp"><i class="fa fa-circle-o"></i>管理订单信息</a></li>
            </ul>
        </li>
        <%--<li class="treeview">--%>
            <%--<a href="#">--%>
                <%--<i class="fa fa-table"></i> <span>订单信息</span>--%>
                <%--<span class="pull-right-container">--%>
              <%--<i class="fa fa-angle-left pull-right"></i>--%>
            <%--</span>--%>
            <%--</a>--%>
            <%--<ul class="treeview-menu">--%>
                <%--<li><a href="order.jsp"><i class="fa fa-circle-o"></i>管理订单信息</a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
    </ul>
</section>
    <!-- /.sidebar -->
</aside>