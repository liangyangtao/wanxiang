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
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li>
								<a href="website">数据源市场</a>
							</li>
							
						</ul><!-- /.breadcrumb -->
					</div>

					<div class="page-content">
							<%-- 	<jsp:include page="settingbox.jsp"></jsp:include> --%>
						<div class="page-header">
							<h1>
								数据源市场
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									 创建数据源
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="widget-box">
									<div class="widget-body">
										<div class="widget-main">
											<div id="fuelux-wizard-container">
												<div>
													<ul class="steps">
														<li data-step="1" class="active">
															<span class="step">1</span>
															<span class="title">录入列表页网址</span>
														</li>

														<li data-step="2">
															<span class="step">2</span>
															<span class="title">获取新闻列表页</span>
														</li>

														<li data-step="3">
															<span class="step">3</span>
															<span class="title">获取新闻属性</span>
														</li>

														<li data-step="4">
															<span class="step">4</span>
															<span class="title">填入数据来源</span>
														</li>
													</ul>
												</div>

												<hr />

												<div class="step-content pos-rel">
													<jsp:include page="addweb1.jsp" flush="true"></jsp:include>
													<jsp:include page="addweb2.jsp" flush="true"></jsp:include>
													<jsp:include page="addweb3.jsp" flush="true"></jsp:include>
													<jsp:include page="addweb4.jsp" flush="true"></jsp:include>
												</div>
											</div>

											<hr />
											<div class="wizard-actions">
												<button class="btn btn-prev">
													<i class="ace-icon fa fa-arrow-left"></i>
													上一步
												</button>

												<button class="btn btn-success btn-next" data-last="完成">
													下一步
													<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
												</button>
											</div>
										</div><!-- /.widget-main -->
									</div><!-- /.widget-body -->
								</div>

								<div id="modal-wizard" class="modal">
									<div class="modal-dialog">
										<div class="modal-content">
											<div id="modal-wizard-container">
												<div class="modal-header">
													<ul class="steps">
														<li data-step="1" class="active">
															<span class="step">1</span>
															<span class="title">Validation states</span>
														</li>

														<li data-step="2">
															<span class="step">2</span>
															<span class="title">Alerts</span>
														</li>

														<li data-step="3">
															<span class="step">3</span>
															<span class="title">Payment Info</span>
														</li>

														<li data-step="4">
															<span class="step">4</span>
															<span class="title">Other Info</span>
														</li>
													</ul>
												</div>

												
											</div>

											<div class="modal-footer wizard-actions">
												<button class="btn btn-sm btn-prev">
													<i class="ace-icon fa fa-arrow-left"></i>
													上一步
												</button>

												<button class="btn btn-success btn-sm btn-next" data-last="完成">
													下一步
													<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
												</button>

												<button class="btn btn-danger btn-sm pull-left" data-dismiss="modal">
													<i class="ace-icon fa fa-times"></i>
													取消
												</button>
											</div>
										</div>
									</div>
								</div><!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->