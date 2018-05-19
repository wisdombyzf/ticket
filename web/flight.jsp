<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>航班管理主页</title>
  <jsp:include page="Common_css_js.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <jsp:include page="teamHeader.jsp"></jsp:include>
  <!-- Left side column. contains the logo and sidebar -->
  <jsp:include page="teamSider.jsp"></jsp:include>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        航班
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-user"></i>航班</a></li>
        <li class="active">航班信息管理</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">

          <div class="box">
            <div class="box-body">
              <div id="toolbar">
                <button id="delete" class="btn btn-danger"
                        data-toggle="modal"
                    data-target="#deleteModal">
                  删除</button>

                <button id="create"
                        class="btn btn-default"
                        data-toggle="modal"
                        data-target="#exampleModal">
                  添加
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
            uniqueId:"Player",
            toolbar:"#toolbar",
            sortable:true,
            idTable:"advancedTable",
            columns: [{
                field: 'id',
                title: '航班id',
                sortable: true
            }, {
                field: 'flightNo',
                title: '航班号',
                sortable: true,
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
                title: '花费时间',
                sortable: true,
            }, {
                field: 'price',
                title: '价格',
                sortable: true,
            }, {
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
            var pk = $.map($("#player").bootstrapTable('getSelections'), function (row) {
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
        <h4 class="modal-title" id="exampleModalLabel">添加航班记录</h4>
      </div>
      <div class="modal-body">
        <div class="container-fluid" style="padding-right: 0px;padding-left: 0px;">
          <form class="form-horizontal" method="post" action="addFlight.action">
            <div class="form-group" style="display:none">
              <label for="Type" class="control-label col-sm-4">操作类型</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="Type" name="Type" value="Add"></div>
            </div>
            <div class="form-group" style="display:none">
              <label for="Table" class="control-label col-sm-4">操作表</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="Table" name="Table" value="Player"></div>
            </div>


            <div class="form-group">
              <label for="ID" class="control-label col-sm-4">航班id</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="id" name="id"></div>
            </div>
            <div class="form-group">
              <label for="Name" class="control-label col-sm-4">航班号</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="flightNo" name="flightNo"></div>
            </div>
            <div class="form-group">
              <label for="Age" class="control-label col-sm-4">出发地点</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="startPlace" name="startPlace"></div>
            </div>
            <div class="form-group">
              <label for="Group" class="control-label col-sm-4">到达地点</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="endPlace" name="endPlace"></div>
            </div>
            <div class="form-group">
              <label for="CultureScore" class="control-label col-sm-4">起飞时间</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="time" name="time"></div>
            </div>

            <div class="form-group">
              <label for="CultureScore" class="control-label col-sm-4">价格</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="price" name="price"></div>
            </div>
            <div class="form-group">
              <label for="CultureScore" class="control-label col-sm-4">座位数</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="seatLeft" name="seatLeft"></div>
            </div>

            <div class="form-group">
              <div class="col-xs-6"><button type="submit" class="btn btn-primary pull-right">确认</div>
              <div class="col-xs-6"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button></div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModal">删除航班记录</h4>
      </div>
      <div class="modal-body">
        <div class="container-fluid" style="padding-right: 0px;padding-left: 0px;">
          <form class="form-horizontal" method="post" action="deleteFlight.action">

            <div class="form-group" style="display:none">
              <label for="Table" class="control-label col-sm-4">操作表</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="Table" name="Table" value="Player"></div>
            </div>


            <div class="form-group">
              <label for="ID" class="control-label col-sm-4">删除航班的航班id</label>
              <div class="col-sm-6"><input required type="text" class="form-control input-md" id="flightId" name="flightId"></div>
            </div>


            <div class="form-group">
              <div class="col-xs-6"><button type="submit" class="btn btn-primary pull-right">确认</div>
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
