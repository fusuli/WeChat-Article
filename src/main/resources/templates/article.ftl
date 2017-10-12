<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">
<title>${article.title}</title>
<!-- 引入 WeUI -->
<link href="//lib.baomitu.com/weui/1.1.2/style/weui.min.css"
	rel="stylesheet">
</head>
<body>
	<!--  <button type="button" class="am-btn am-btn-default am-radius">默认样式</button>
	<button type="button" class="am-btn am-btn-success am-round">默认样式</button>
	<a href="javascript:;" class="weui_btn weui_btn_mini weui_btn_primary">按钮</a>-->
	<p
		style="font-size: 15px; color: #333333; font-family: 'Microsoft YaHei', Arial, Helvetica, sans-serif; text-align: justify; background-color: #FFFFFF;">
		<br />
	</p>
	<h1 style="text-align: center;">
		${article.title}<span
			style="font-size: 12px; font-weight: normal; line-height: 1.5;"></span>
	</h1>
	<br>
	<p>
		<span style="font-size: 12px; font-weight: normal; line-height: 1.5;">访问量：${article.pageview}</span>
	</p>
	<br>
	<p>
		<span style="font-size: 12px; font-weight: normal; line-height: 1.5;">${article.content}</span>
	</p>
	<div align="right">${.now}</div>
	<br>
	<br>
	<a href="javascript:;" class="weui-btn weui-btn_primary">返回</a>
</body>
</html>