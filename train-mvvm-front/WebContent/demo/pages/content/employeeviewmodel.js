//页面视图模型绑定的数据内容
define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.url = cube.gatewayURL_emp + "/employee/";
		self.args = cube.obj({
			"depId" : params.depId()
		});
		self.columns = [ {
			name : "name",
			caption : "员工姓名",
			nullable : false
		}, {
			name : "num",
			caption : "员工编号"
		}, {
			name : "age",
			caption : "年龄"
		}, {
			name : "sex",
			caption : "性别"
		}, {
			name : "address",
			caption : "地址"
		}, {
			name : "tel",
			caption : "电话"
		}, {
			name : "inductiontime",
			caption : "入职时间"
		} ];
		cube.subscribe(params.depId, function() {
			self.args({
				"depId" : params.depId()
			});
		});
		self.customOperations = [ {
			caption : "编辑",
			icon : "icon-edit",// Font Awesome 3.0.2中的图标样式，当icon没有设置时显示caption
			click : function(item) {
				app.setLocation("#empDetail?id=" + item.id);

			}
		} ];

		self.toolbarContent = [ {
			group : [ {
				text : "新建",
				icon : "plus",
				func : "onNewClick"
			}, {
				text : "删除",
				icon : "trash",
				func : "onDeleteClick"
			}, {
				text : "发送流程",
				icon : "tasks",
				func : "sendBPM"
			} ]
		} ];
		
		self.onSelectedItems = function(item){
			selectId = item[0];
		}

		
		self.onItemClick = function(e) {
			if (e == "onNewClick") {
				app.setLocation("#empDetail");
			} else if (e == "onDeleteClick") {
				cube.getPageViewModelByNode($("#empgrid")).delCheckedItem();
			}else if(e == "sendBPM"){
				var restClient = new RestClient();
				restClient.get("http://localhost:9995/uap/startBPM/"+selectId,function(data){
					cube.indicate("发送成功");
				});
			}
		};
		self.fields = [ {
			name : "name",
			caption : "员工姓名",
			editorType : "TextEditor"
		} ];
		cube.endViewModel(self, params);
	};
	return PageViewModel;
});