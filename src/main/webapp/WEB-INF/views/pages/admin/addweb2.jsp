<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="step-pane" data-step="2">

	<div class="row">
		<div class="news_list col-sm-6">
			<p class="tabhelp">
				<i class="icon-hand-right"></i> 请确保采集到的列表页和原网址的列表页相符,再点击下一步
			</p>
			<input type="hidden" name="listCssPath" id ="listCssPath"
				value="" />
			<div class="list-unstyled" id="url_list"></div>
		</div>
		<div class="bytext col-sm-4">
			<!-- <p>
				<i class="icon-hand-right"></i>没有得到列表页，换个模式试试，js模式有点慢请耐心等待,
			</p> -->
			<div class="control-group">
				<!-- <label class="control-label bolder blue">请选择模式</label> -->
				<div class="radio" id="webModelRadio">
					<label> <input name="webModel" type="radio" class="ace"
						checked="checked" value="1" /> <span class="lbl"> 普通模式</span>
					</label>
					<!-- <label> <input name="webModel" type="radio" class="ace"
						value="2" /> <span class="lbl"> js模式</span>
					</label> -->
				</div>
			</div>
			<p>
				<i class="icon-hand-right"></i>得到结果不对？ 请输入列表页中的某个标题
			</p>

			<div class="input-group">
				<input type="text" id="listText" class="form-control search-query" />
				<span class="input-group-btn">
					<button class="btn btn-purple btn-sm" type="button"
						onclick="fillWebList()">
						<i class="icon-pencil align-top bigger-125"></i> 调试一下
					</button>
				</span>
			</div>
			<!-- <p>
				<i class="icon-hand-right"></i>懂技术？cssPath输入下面即可，不懂技术请无视
			</p> -->

			<!-- <div class="input-group">
				<input type="text" id="checkListCssPath"
					class="form-control search-query" disabled="disabled" /> <span
					class="input-group-btn">
					<button class="btn btn-purple btn-sm" type="button"
						onclick="fillurlcheckList()" disabled="disabled">
						<i class="icon-pencil align-top bigger-125"></i> 调试一下
					</button>
				</span>

			</div> -->

		</div>
	</div>
</div>