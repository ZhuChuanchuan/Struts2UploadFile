<%--
  Created by IntelliJ IDEA.
  User: ZHCC
  Date: 2018/9/19
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>简单的文件上传</title>
  </head>
  <body>
    <s:form action="upload" enctype="multipart/form-data">
        <s:textfield name="title" label="文件标题"/>
        <s:file name="upload" label="选择文件"/>
        <s:submit value="上传"/>
    </s:form>
  <s:fielderror/>
  </body>
</html>
