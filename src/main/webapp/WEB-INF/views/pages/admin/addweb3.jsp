<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="step-pane" data-step="3">
	<div class="row">
		<div class="col-sm-6">
			<h1 id="title"></h1>
			<div>
				<p class="lead" id="time"></p>
			</div>
			<div id="content"></div>
		</div>
		<div class="col-sm-4">
			<div>
				<label for="form-field-select-1"><b>请点击下面的网址进行比对，看看是否获取结果都正常</b>
				</label> <select class="form-control" id="url_select">
				</select>
			</div>
			<p>
				<i class="icon-hand-right"></i>标题不对？请输入正确的标题
			</p>

			<div class="input-group">
				<input type="hidden" id="titleCssPath" value="" /> <input
					type="text" id="titleText" class="form-control search-query" /> <span
					class="input-group-btn">
					<button class="btn btn-purple btn-sm" type="button">
						<i class="icon-pencil align-top bigger-125"></i> 测试一下
					</button>
				</span>

			</div>
			<p>
				<i class="icon-hand-right"></i>时间不对？请粘贴正确的时间
			</p>

			<div class="input-group">
				<input type="hidden" id="timeCssPath" value="" /> <input
					type="text" id="timeText" class="form-control search-query" /> <span
					class="input-group-btn">
					<button class="btn btn-purple btn-sm" type="button">
						<i class="icon-pencil align-top bigger-125"></i> 测试一下
					</button>
				</span>

			</div>
			<p>
				<i class="icon-hand-right"></i>内容不对？请粘贴一段内容
			</p>

			<div class="input-group">
				<input type="hidden" id="contentCssPath" value="" /> <input
					type="text" id="contentText" class="form-control search-query" />
				<span class="input-group-btn">
					<button class="btn btn-purple btn-sm" type="button">
						<i class="icon-pencil align-top bigger-125"></i> 测试一下
					</button>
				</span>

			</div>

		</div>
	</div>
</div>