//页面视图模型绑定的数据内容
define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.url = cube.gatewayURL_emp + "/employee/";
		//修改成网关地址
		//self.url = cube.gatewayURL + "/employee/";
		self.id = cube.obj(params.id);
		self.fields = [
		{name:"name",caption:"员工姓名",nullable:false},
		{name:"num",caption:"员工编号"},
		{name:"age",caption:"年龄",editorType:"NumberEditor"},
		{name:"sex",caption:"性别",editorType:"DropDownEditor"},
		{name:"inductiontime",caption:"入职时间",editorType:"DateTimeEditor"},
		{name:"address",caption:"地址"},
		{name:"tel",caption:"电话"},
		{name:"depId",caption:"部门ID",visible: false,value:params.depId}
		    ];

		self.saved = function(){
		cube.indicate("保存成功");
		}

		cube.endViewModel(self, params);
	};
	return PageViewModel;
});
