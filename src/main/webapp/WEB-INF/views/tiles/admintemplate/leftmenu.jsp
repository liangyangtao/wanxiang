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
<div class="sidebar-shortcuts" id="sidebar-shortcuts">
	<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
		<button class="btn btn-success">
			<i class="ace-icon fa fa-signal"></i>
		</button>

		<button class="btn btn-info">
			<i class="ace-icon fa fa-pencil"></i>
		</button>

		<button class="btn btn-warning">
			<i class="ace-icon fa fa-users"></i>
		</button>

		<button class="btn btn-danger">
			<i class="ace-icon fa fa-cogs"></i>
		</button>
	</div>

	<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
		<span class="btn btn-success"></span> <span class="btn btn-info"></span>

		<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
	</div>
</div>
<!-- /.sidebar-shortcuts -->
<ul class="nav nav-list">
	<li class="active"><a href="admin.jsp"> <i
			class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
				大厅首页 </span>
	</a> <b class="arrow"></b></li>

	<li class="open"><a href="#"> <i
			class="menu-icon fa fa-tasks"></i> <span class="menu-text">
				数据源市场 </span><b class="arrow fa fa-angle-down"></b>
	</a> <b class="arrow"></b>
		<ul class="submenu">
			<li class=""><a href="website"> <i
					class="menu-icon fa fa-caret-right"></i> 数据源列表
			</a> <b class="arrow"></b></li>
			<li class=""><a href="addwebsite"> <i
					class="menu-icon fa fa-caret-right"></i> 创建数据源
			</a> <b class="arrow"></b></li>
		</ul></li>


	<li class="open"><a href="#" class="dropdown-toggle"> <i
			class="menu-icon fa fa-user"></i> <span class="menu-text">
				会员管理 </span> <b class="arrow fa fa-angle-down"></b>
	</a> <b class="arrow"></b>

		<ul class="submenu">
			<li class=""><a href="#" class="dropdown-toggle"> <i
					class="menu-icon fa fa-caret-right"></i> 我的资料
			</a> <b class="arrow"></b></li>

			<li class=""><a href="#"> <i
					class="menu-icon fa fa-caret-right"></i> 充值提现
			</a> <b class="arrow"></b></li>

			<li class=""><a href="#"> <i
					class="menu-icon fa fa-caret-right"></i> 交易管理
			</a> <b class="arrow"></b></li>

			<li class=""><a href="#"> <i
					class="menu-icon fa fa-caret-right"></i> 邮箱设置
			</a> <b class="arrow"></b></li>

			<li class=""><a href="#"> <i
					class="menu-icon fa fa-caret-right"></i> 密码设置
			</a> <b class="arrow"></b></li>


		</ul></li>
</ul>

<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
	<i id="sidebar-toggle-icon"
		class="ace-icon fa fa-angle-double-left ace-save-state"
		data-icon1="ace-icon fa fa-angle-double-left"
		data-icon2="ace-icon fa fa-angle-double-right"></i>
</div>