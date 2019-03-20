define(['./app'], function(){
	//cube.bundleName = "uaptext";//uap config
	//cube.name = "app_demo";//
	//
	
	var PageViewModel = function(){
		var self = this;
		self.depId = cube.obj("");
	};
	
	var pvm = new PageViewModel();
	
	$(document).ready(function(e){
		cube.startWebPage(pvm);
	});
});