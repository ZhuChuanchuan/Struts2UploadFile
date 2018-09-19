<%--
  Created by IntelliJ IDEA.
  User: ZHCC
  Date: 2018/9/19
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>上传成功</title>
</head>
<body>
上传成功<br/>
文件标题<s:property value=" +title"/><br/>
文件为：<img src="<s:property value="'uploadFiles/'+uploadFileName"/>"/><br/>
</body>
</html>
