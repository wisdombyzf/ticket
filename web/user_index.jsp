<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>乘客预定航班主页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/master/bower_components/bootstrap/dist/css/bootstrap.min.css" >
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/master/bower_components/font-awesome/css/font-awesome.min.css" >
    <!-- Ionicons -->
    <link rel="stylesheet" href="/master/bower_components/Ionicons/css/ionicons.min.css" >
    <!-- BootstrapTables -->
    <link rel="stylesheet" href="/master/bower_components/bootstrap-table-master/dist/bootstrap-table.css" >
    <link rel="stylesheet" href="/master/bower_components/bootstrap-table-click-edit-row/bootstrap-table-click-edit-row.css" >
    <!-- Theme style -->
    <link rel="stylesheet" href="/master/dist/css/AdminLTE.min.css" >
    <!-- AdminLTE Skins. Choose a skin from the css/skins
    folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/master/dist/css/skins/skin-blue.css" >

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">




    <!-- jQuery 3 -->
    <script src="/master/bower_components/jquery/dist/jquery.min.js" ></script>
    <!-- Bootstrap 3.3.7 -->
    <script src="/master/bower_components/bootstrap/dist/js/bootstrap.min.js" ></script>
    <!-- BootstrapTables -->
    <script src="/master/bower_components/bootstrap-table-master/dist/bootstrap-table.js" ></script>
    <script src="/master/bower_components/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.js" ></script>
    <script src="/master/bower_components/bootstrap-table-click-edit-row/bootstrap-table-click-edit-row.js" ></script>
    <script src="/master/bower_components/bootstrap-table-toolbar/bootstrap-table-toolbar.js" ></script>
    <!-- SlimScroll -->
    <script src="/master/bower_components/jquery-slimscroll/jquery.slimscroll.min.js" ></script>
    <!-- FastClick -->
    <script src="/master/bower_components/fastclick/lib/fastclick.js" ></script>
    <!-- AdminLTE App -->
    <script src="/master/dist/js/adminlte.min.js" ></script>
    <!-- AdminLTE for demo purposes -->
    <script src="/master/dist/js/demo.js" ></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="." class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b></b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b></b><small>航班管理系统</small></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="/master/dist/img/user2-160x160.jpg"   class="user-image" alt="User Image">
                            <span class="hidden-xs">CodeofJackie</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="/master/dist/img/user2-160x160.jpg"   class="img-circle" alt="User Image">

                                <p>
                                    CodeofJackie - Web Developer
                                    <small>Member since Nov. 2012</small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">用户</a>
                                </div>
                                <div class="pull-right">
                                    <a href="LogoutAdmin" class="btn btn-default btn-flat">登出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
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
                        <li><a href="user_index.jsp"><i class="fa fa-circle-o"></i>可预订的航班信息</a></li>
                    </ul>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-user"></i> <span>订单信息</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="user_orders.jsp"><i class="fa fa-circle-o"></i>我的订单</a></li>
                    </ul>

        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                航班
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-user"></i>航班</a></li>
                <li class="active">航班信息</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    <div class="box">
                        <div class="box-body">
                            <div id="toolbar">

                                <button id="create"
                                        class="btn btn-default"
                                        data-toggle="modal"
                                        data-target="#exampleModal">
                                    预定航班
                                </button>
                            </div>
                            <table id="player" class="table table-bordered table-striped">
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
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.0.0
        </div>
        <strong>Copyright &copy; 2017 codeofjackie.</strong> All rights
        reserved.Support by <a href="https://adminlte.io">Almsaeed Studio</a>
    </footer>
</div>
<!-- ./wrapper -->


<!-- page script -->

<script src="/master/bower_components/bootstrap-select/dist/js/bootstrap-select.min.js" ></script>
<script src="/master/bower_components/bootstrap-select/dist/js/i18n/defaults-zh_CN.min.js" ></script>

<script>
    $(function () {
        $('#player').bootstrapTable({
            url: "http://"+window.location.hostname+":8080/getFlightList",
            clickEdit: true,
            pagination:true,
            search:true,
            showRefresh:true,
            showToggle:true,
            showColumns:true,
            advancedSearch:true,
            uniqueId:"Flight",
            toolbar:"#toolbar",
            sortable:true,
            idTable:"advancedTable",
            columns: [{
                field: 'id',
                title: '航班id',
                sortable: true
            }, {
                field: 'startPlace',
                title: '出发地点',
                sortable: true,
            }, {
                field: 'endPlace',
                title: '到达地点',
                sortable: true,
            },{
                field: 'time',
                title: '起飞时间',
                sortable: true,
            },{
                field: 'endTime',
                title: '降落时间',
                sortable: true,
            }, {
                field: 'price',
                title: '价格',
                sortable: true,
            }, {
                field: 'discount',
                title: '票价折扣',
                sortable: true,
            },{
                field: 'seatLeft',
                title: '剩余座位',
                sortable: true,
            }],
            responseHandler: function (res) {
                return res;
            }
        });
    })

    $(function () {
        $('#delete').click(function () {

            var pk = $.map($("#player").bootstrapTable('getSelections'),
                function (row) {
                    alert(row.pk)
                    return row.pk;
                });
            $.post("Set",{
                    Type:"Delete",
                    Table:"Player",
                    pk:pk[0]
                },
                $("#player").bootstrapTable('refresh')
            )
            //并且执行向服务器的提交过程
        });
    });

</script>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">预定航班</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid" style="padding-right: 0px;padding-left: 0px;">

                    <form class="form-horizontal" method="post" action="bookFlight.action">


                        <div class="form-group">
                            <label for="ID" class="control-label col-sm-4">请输入将要预定的航班id</label>
                            <div class="col-sm-6"><input required type="text" class="form-control input-md" id="flightId" name="flightId"></div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6"><button type="submit" class="btn btn-primary pull-right">确认预定</div>
                            <div class="col-xs-6"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    $.ajax({
        // get请求地址
        url: 'http://'+window.location.hostname+':8080/getFlightList',
        dataType: "json",
        success: function (data) {
            alert(data)
            var optArr = [];
            for (var i = 0; i < data.length; i++) {
                $('#TeamName').append('<option value="' + data[i].pk + '">'+
                    data[i].pk +'</option>');
            }
            // 缺一不可
            $('#TeamName').selectpicker('refresh');
            $('#TeamName').selectpicker('render');
        }
    });
</script>
</body>
</html>
