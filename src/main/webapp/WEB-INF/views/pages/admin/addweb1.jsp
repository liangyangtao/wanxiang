<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="step-pane active" data-step="1">
	<h3 class="lighter block green">录入新闻列表页网址</h3>
	<p class="tabhelp">
		<i class="ace-icon fa fa-hand-o-right red"></i>
		数据来源的入口，请不要把不是列表类型的网址输入
	</p>
	<div class="form-group has-warning">
		<label for="inputWarning"
			class="col-xs-12 col-sm-3 control-label no-padding-right"></label>
		<div class="col-xs-12 col-sm-5">
			<span class="block input-icon input-icon-right"> <input
				type="text" id="url" class="width-100"
				placeholder="http://roll.news.sina.com.cn/news/gjxw/gjmtjj/index.shtml" /> <i
				class="icon-list"></i> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
			</span>
		</div>
		<div class="help-block col-xs-12 col-sm-reset inline">例如:
			http://roll.news.sina.com.cn/news/gjxw/gjmtjj/index.shtml</div>
	</div>
	<!-- <div id="dialog-message" class="hide">
		<div class='widget-header widget-header-small'>
			<h4 class='smaller'>
				<i class='ace-icon fa  fa-exclamation-circle'></i>请输入正确的网址！！！
			</h4>
		</div>
	</div>
	<div id="dialog-message2" class="hide">
		<div class='widget-header widget-header-small'>
			<h4 class='smaller'>
				<i class='ace-icon fa  fa-exclamation-circle'></i>已经存在的数据源！！！
			</h4>
		</div>
	</div> -->
	<!-- #dialog-message -->
</div>