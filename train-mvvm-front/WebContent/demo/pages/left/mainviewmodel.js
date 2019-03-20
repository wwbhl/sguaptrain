//页面视图模型绑定的数据内容
define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.url = cube.gatewayURL + "/department/tree";
		self.onSelectedChanged = function(p_value){
			params.depId(p_value.id);
		};
		cube.endViewModel(self, params);
	};
	return PageViewModel;
});