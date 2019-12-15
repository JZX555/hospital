<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 数据表格</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="/static/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=4.1.0" rel="stylesheet">
	<style>
		.float-e-margins .btn {margin-bottom: 0px;}		
		.tableBtn{float:left;width:30%;margin-top:0px;margin-left:5px;padding:2px 8px;}
	</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>当前患者</h5>
                        <div class="ibox-tools">
                        </div>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th>患者ID</th>
                                    <th>挂号类型</th>
                                    <th>门诊病历</th>
                                    <th>检验项目</th>
                                    <th>药品处方</th>
                                    <th>历史病历</th>
                                </tr>
                            </thead>
                            <tbody id="currentPatient">
                            
                            </tbody>
                        </table>
						<div style = "text-align:right;">
                       		<a type='button' class='btn btn-info' href='#' onclick=getNextPatient()>下一个 </a>
                     	</div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>

    <!-- 全局js -->
    <script src="/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="/static/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/static/js/plugins/jeditable/jquery.jeditable.js"></script>
    <!-- Data Tables -->
    <script src="/static/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <!-- 自定义js -->
    <script src="/static/js/content.js?v=1.0.0"></script>
	<script src="/static/layer/layer.js"></script>

    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
        	
        });
        function editRecord() {
        	layer.open({
	       		  type: 2,
	       		  title: '病历',
	       		  shadeClose: true,
	       		  shade: 0.8,
	       		  area: ['70%', '90%'],
	       		  content: '/doctor/editRecord_doctor',
	       		  success: function (layero, index) {
        			var iframe = window['layui-layer-iframe' + index];
                  	iframe.getCurrRecord()
                }
       		});
        };
        function editPrescription() {
        	layer.open({
	       		  type: 2,
	       		  title: '处方列表',
	       		  shadeClose: true,
	       		  shade: 0.8,
	       		  area: ['70%', '90%'],
	       		  content: '/doctor/editPrescriptionList_doctor',
	       		  success: function (layero, index) {
        			var iframe = window['layui-layer-iframe' + index];
                  	iframe.getPrescriptionList()
                }
       		});
        };
       	function getNextPatient() {
           	var ID = $.cookie("loginID");
        
        	$.ajax({
        		url: '/doctor/getNextPatientByDoctor',
        		type: 'POST',
        		async:false,
        		data: {
	        			'ID':ID,
    				},
        		dataType: 'JSON',
        		success: function(res){
        			
        			var data = res;
        			line = "<tr>" +
                    		"<th>" + data.patientId + "</th>" +
                    		"<th>" + data.type + "</th>" +
                    		"<th><a type='button' class='btn btn-info' href='#' onclick=editRecord()>编辑 </a></th>" +
                    		"<th><a type='button' class='btn btn-info' href='#'>申请 </a></th>" +
                    		"<th><a type='button' class='btn btn-info' href='#' onclick=editPrescription()>编辑 </a></th>" +
                    		"<th><a type='button' class='btn btn-info' href='#'>查看 </a></th>" +
                			"</tr>";
        			$('#currentPatient').append(line);
        		},
        		error: function(res){
        			layer.msg('今日已无病人就诊');
        		}
        	});
        }
    </script>
	
    
    

</body>

</html>
