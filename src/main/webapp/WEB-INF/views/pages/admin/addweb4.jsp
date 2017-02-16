<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<div class="step-pane" data-step="4">
	<p class="tabhelp">
		<i class="ace-icon fa fa-hand-o-right red"></i> 请输入网址名称和板块名称
	</p>
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						> 网站名称: </label>

					<div class="col-sm-9">
						<input  placeholder="新浪网"
							class="col-xs-10 col-sm-5" type="text" id="siteName">
					</div>
				</div>

			</form>
			<div class="space-4"></div>
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right"
						> 板块名称 :</label>
					<div class="col-sm-9">
						<input  placeholder="财经要闻"
							class="col-xs-10 col-sm-5" type="text" id="sectionName">
					</div>
				</div>

			</form>
			<div class="space-4"></div>
		</div>
	</div>
</div>