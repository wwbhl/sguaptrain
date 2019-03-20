//页面视图模型绑定的数据内容
define([], function() {
	var PageViewModel = function(params) {
		var self = this;
		self.url = cube.gatewayURL + "/department/tree";
		self.onSelectedChanged = function(p_value){
			params.depId(p_value.id);
		};
		
		PubSub.subscribe("1",'depSave',function(topics,data){
			//用uap生成的包，调用此方法，后续平台发布后重新调用load()方法
			cube.getPageViewModelByNode($("#tree"))._init();
			
//			cube.getPageViewModelByNode($("#tree")).load();
		});
		
		cube.endViewModel(self, params);
	};
	return PageViewModel;
});