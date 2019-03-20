//页面视图模型绑定的数据内容
define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.url = cube.gatewayURL + "/department/";
		self.args = cube.obj({"depParentId":params.depId()});
		self.columns = [
			{name:"depName",width:"200px",caption:"部门名称",nullable:false},
			{name:"depDesc",caption:"描述"},
			{name:"depParentId",caption:"父ID",visible:false}];
		cube.subscribe(params.depId,function(){
			self.args({"depParentId":params.depId()});
		});
		cube.endViewModel(self, params);
	};
	return PageViewModel;
});