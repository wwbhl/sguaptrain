//页面视图模型绑定的数据内容
define(["RESTClient"], function(RestClient) {
	var PageViewModel = function(params) {
		var self = this;
		self.count = cube.obj(0);
		//修改成网关地址，统一路由
		self.url = cube.gatewayURL + "/department/";
		self.args = cube.obj({"depParentId":params.depId()});
		self.columns = [
			{name:"depName",width:"200px",caption:"部门名称",nullable:false},
			{name:"depDesc",caption:"描述"},
			{name:"depParentId",caption:"父ID",visible:false,value:params.depId}];
		
		self.onItemSaved = function(item){
			PubSub.publish('depSave',item);
		};
		
		var restClient = new RestClient();
		
		cube.subscribe(params.depId,function(){
			self.args({"depParentId":params.depId()});
			restClient.get(cube.gatewayURL + "/department/count/"+(params.depId()!=""?params.depId():"null"),function(data){
        		self.count(data);
        		});
		});
		cube.endViewModel(self, params);
	};
	return PageViewModel;
});