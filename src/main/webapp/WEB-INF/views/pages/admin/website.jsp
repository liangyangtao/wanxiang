<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs ace-save-state" id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">首页</a>
				</li>
				<li class="active">数据源市场</li>
			</ul>
			<!-- /.breadcrumb -->

			<div class="nav-search" id="nav-search"></div>
			<!-- /.nav-search -->
		</div>

		<div class="page-content">
			<%-- 	<jsp:include page="settingbox.jsp"></jsp:include> --%>

			<div class="page-header">
				<h1>
					数据源市场 <small> <i class="ace-icon fa fa-angle-double-right"></i>
						数据源列表
					</small> <span class="block pull-right"> <span
						class="btn-toolbar inline middle no-margin"> <span
							data-toggle="buttons" class="btn-group no-margin"> <a
								href="#" class="btn btn-sm btn-yellow "  id="myorder"> <i
									class="ace-icon fa fa-shopping-cart"></i>我定购的数据源
							</a> <a href="#" class="btn btn-sm btn-yellow " id="mycreate"> <i
									class="ace-icon fa fa-gavel"></i>我发布的数据源
							</a>
						</span>
					</span>
					</span>
				</h1>

			</div>
			<!-- /.page-header -->

			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<jsp:include page="alertbox.jsp"></jsp:include>

					<div class="widget-body">
						<div class="widget-main">
							<form>
								<label>网站名称：</label> <input id="sitename" type="text"
									placeholder="新浪网" /> <label>栏目名称：</label> <input
									id="sectionname" type="text" placeholder="金融要闻" /> <input
									type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</div>
					</div>
					<table id="grid-table"></table>

					<div id="grid-pager"></div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
</div>
<!-- /.main-content -->