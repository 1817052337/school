<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>student模块的FK查询展示页面</title></head>
<a href="${path}/user.action?method=addpage">进入添加页面</a>
     <table border="1">
         <tr>
             <td>用户id</td>
             <td>用户名</td>
             <td>操作</td>
         </tr>
         <#list list as user >
             <tr>
                 <td>${user.id}</td>
                 <td>${user.name}</td>
                 <td>
                 <a href="${path}/user.action?method=editpage&id=${user.id}">修改</a>
                 <a href="${path}/user.action?method=delete&id=${user.id}">删除</a>
                 </td>
             </tr>
         </#list>
     </table>
</body>
</html>