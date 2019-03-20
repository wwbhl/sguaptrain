//页面视图模型绑定的数据内容
define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.menuItems = [{
		   	text: '部门管理',
		   	route: "#department",
		   	hasChildren: false,
		   	 },
		     {
		   		 text: '员工管理',
		   		 route: "#employee",
		   		 hasChildren: false
		     }];
		self.onSelectItemChanged = function(p_value){
			
		};
		cube.endViewModel(self, params);
	};
	return PageViewModel;
});