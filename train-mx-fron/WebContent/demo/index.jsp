<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/mx-framework" prefix="mx" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<mx:Framework debugMode="true"/>
		<title>demo</title>
		<style>
			html, body{ width:100%; height:100%; margin:0; overflow:hidden;}
		</style>
	</head>
	<script  language='javascript' id='$config$' src="../conf/config.js"></script>
	<body>
		<mx:WebletContainer id="demoContainer" webletID="demo" bundleName=""></mx:WebletContainer>
	</body>
</html>
