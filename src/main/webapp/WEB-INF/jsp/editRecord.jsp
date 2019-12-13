<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 选项卡 &amp; 面板</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=4.1.0" rel="stylesheet">
	<style>
		.des{display:block;line-height:25px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;}
	</style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeIn">
        
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox">
                    <div class="ibox-title">
                        <a type='button' class='btn btn-info' href='#'>保存 </a>
                    </div>
                    <div class="ibox-content">
						<center><font size="5" ><a>门诊病历</a></font></center>
						<div class="row" id="recordID" style="float:right;font-size:14px;">
						</div>
					</div>
					<div class="ibox-content" style="font-size:14px;">
						<div class="row" id="deptType" style="float:left;">
                        </div>
                        <div class="row" id="visitTime" style="float:right;">
                        </div>
                    </div>
                    <div class="ibox-content" style="font-size:18px;">
						<table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                            </thead>
                            <tbody id="patientInfo">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<!-- 脚本 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.js"></script>
    <!-- 语言包 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/zh-cn.js"></script>

    <!-- 全局js -->
    <script src="/static/js/jquery.min.js?v=2.1.4"></script>
    <script src="/static/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="/static/js/content.js?v=1.0.0"></script>
    <script src="/static/js/plugins/layer/layer.min.js"></script>
    
    <script src="/static/js/laydate/laydate.js"></script>
    <script type="text/javascript" src="/static/js/jquery.cookie.js"></script>
	<script>

		function Date2String(date) {
			return  moment(date).format("YYYY-MM-DD");
		};
		function getCurrRecord(){
			var ID = '<%= session.getAttribute("record_ID") %>';
			$("#recordID").append(
					"<p><a>No：</a>" + ID + "</p>");
			
			$.ajax({
	        		url: '/doctor/getRecordByID',
	        		type: 'POST',
	        		data:{'ID':ID},
	        		dataType: 'JSON',
	        		success: function(res){
	        			$("#deptType").append("<p><a>科室：</a>" + res.department.type + "</p>");
	        			$("#visitTime").append("<p><a>就诊时间：</a>" + Date2String(res.recordWithBLOBs.time) + "</p>");
	        			
	        			line1 = "<tr>" +
                		"<td>姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + 
                				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + 
                				res.patient.name + "</td>" +
                		"<td>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + 
                				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                				res.patient.sex + "</td>" +
                		"<td>年龄：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + 
                				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                				res.patient.age + "</td>" +
            			"</tr>";
            			line2 = "<tr>" +
            			"<td>电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + 
        						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + 
        						res.patient.phone + "</td>" +
        				"<td colspan='2'>身份证号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + 
        						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
        						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;xxxxxxxxxxxx" +
        						res.patient.id + "</td>"
            			"</tr>";
	        			$("#patientInfo").append(line1+line2);
	        		},
	        		error: function(res){
	        			layer.msg('加载失败');
	        		}
	        	});
		}
		function getDoctorById(id){
			$.ajax({
	        		url: '../getDocById.do',
	        		type: 'POST',
	        		data:{'doctorId':id},
	        		dataType: 'JSON',
	        		success: function(res){
	        			doctorDatas = res;
	        				var status =  res.workStatus == 1?"正常":"请假";
	        				$("#doctors").append(
	        					"<div class='col-sm-4'>"+
	                                "<div class='panel panel-success'>"+
	                                    "<div class='panel-heading'>"+res.doctorName+" 相关信息</div>"+
	                                    "<div class='panel-body'>"+
	                                    	"<p>医生姓名: "+res.doctorName+"</p>"+
	                                        "<p class='des'>医生简介: "+res.doctorDes+"</p>"+
	                                        "<p>所属科室: "+res.deptName+"</p>"+
	                                        "<p>出诊时间: "+res.workTime+"</p>"+
	                                        "<p style='color:red'>当前工作状态: "+status+"</p>"+
	                                        
	                                        "<div class='form-group'>"+
	                                        	"<label class='col-sm-2 control-label' style='padding:0px'>挂号时间：</label>" +
		                                        "<div class='col-sm-10'>" +
		                                        	"<input id='time' class='laydate-icon form-control layer-date'>" +
		                                        "</div>"+
	                                        "</div>" +
	                                        "<button class='btn btn-info' onclick='register(-1)'>挂号</button>"+
	                                    "</div>"+
	                                "</div>"+
	                            "</div>"
	        				);
	        				laydate.render({
	        					  elem: '#time' //指定元素
	        				});
	        		},
	        		error: function(res){
	        			layer.msg('加载失败');
	        		}
	        	});
		}
	
		
		function checknums(ID,index){
			
			if(index >= 0){
				var mydoctor = doctorDatas[index];
			}else{
				var mydoctor = doctorDatas;
			}
			
			if(mydoctor == -1){
				var registerTime = $('#time').val();
			}else{
				var registerTime = $('#time'+index).val();
			}
			
			var now = new Date();
			var nowTime = now.getFullYear() + "-" +((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+"-"+(now.getDate()<10?"0":"")+now.getDate();
			
			var timestamp =(new Date()).valueOf();
			var timestamp1=new Date(Date.parse(registerTime)).valueOf();
			
			if(registerTime==""){
				layer.msg("请选择预约日期！",{time:800});
			}else{
				if(	timestamp>=timestamp1){
					layer.msg("不可选择今日以前的日期！",{time:800});
				}else{
					$.ajax({
	        			url: '/patient/getRemainedByIDAndDate',
	        			type: 'POST',
	        			data: {
		        			'ID':ID,
		        			'Date':registerTime	
	        				},
	        			dataType: 'text',
	        			success: function(result){
	        				var patient_ID = $.cookie('loginID');
	        				if(result<=0){
	        					layer.msg("当前剩余预约名额已满！无法预约！");
	        				}else{
	        					layer.confirm('该医生剩余可预约名额为：'+result+'</br>    确认预约该医生的诊疗？', {
		    	        		  	btn: ['确定','取消'] //按钮
		    	        			}, function(){
		    	        			//提交
		    	        				
		    							$.ajax({
		    								url: '/patient/insertReservation',
		    			        			type: 'POST',
		    			        			data: {
		    			        				'ID':patient_ID,
		    			        				'Date':registerTime,
		    			        				'doc_ID':ID,
		    			        				'depart_ID':mydoctor.departId
		    			        			},
		    			        			dataType: 'JSON',
		    			        			success: function(result){
		    			        				if(result>0){
		    			        					
		    			        					layer.alert('挂号预约成功!',function(index){
		    			        						layer.close(index);
		    			        						parent.layer.closeAll();
		    			        					});
		    			        				}
		    			        			},
		    			        			error: function(res){
		    			        				layer.msg('挂号预约失败');
		    			        			}
		    							})
		    	        			},function(){
		    	        			});
	        				}
	        				
	        			},
	        			error: function(res){
	        				layer.msg("查询失败");
	        			},
	        		});
			}}
		}
	
		
		
	</script>

    
    

</body>

</html>
