
$import("mx.containers.HSplit");				
$import("mx.containers.Container");				
$import("mx.controls.ToolBar");				
$import("mx.datacontrols.DataGrid");
$import("mx.datacontainers.GridEntityContainer");
$import("mx.datacontrols.PageNaviBar");				
$import("mx.windows.Window");				
$import("demo.views.DepartmentGridView");				
$import("demo.views.DepartmentGridViewController");				
$import("demo.views.DepartmentGridViewUserController");				
$import("mx.datacontrols.DataForm");
$import("mx.datacontainers.FormEntityContainer");				
$import("demo.views.DepartmentFormView");				
$import("demo.views.DepartmentFormViewController");				
$import("demo.views.DepartmentFormViewUserController");				

mx.weblets.WebletManager.register(
{
    id: "demo",
    name: "demo",
    requires: [],
    onload: function (e) {
		
    }, 
    onstart: function (e) {
    	var mvc = new demo.views.DepartmentGridViewUserController();
		e.context.rootViewPort.setViewController(mvc);
    }
});