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

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
	if ('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="assets/js/jquery-ui.min.js"></script>
<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="assets/js/wizard.min.js"></script>
<script src="assets/js/jquery.validate.min.js"></script>
<script src="assets/js/jquery-additional-methods.min.js"></script>
<script src="assets/js/bootbox.js"></script>
<script src="assets/js/jquery.maskedinput.min.js"></script>
<script src="assets/js/select2.min.js"></script>

<!-- ace scripts -->
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">

	function fillWebList() {
		$.ajax({
			type : "POST",
			url : "addsitelist",
			data : {
				url : $("#url").val(),
				listText : $("#listText").val()
			},
			beforeSend : function(xhr) {
				xhr.setRequestHeader('X-CSRF-Token', $("input[name=_csrf]").val());
			},
			async : false,
			success : function(data) {
				var urlList = data.urls;
				var ullist = '';
				var selectList = '';
				if (urlList.length == 0) {
					bootbox.alert({
						buttons : {
							ok : {
								label : '确定',
								className : 'btn-myStyle'
							}
						},
						message : '暂时不支持该网址！！！',
						callback : function() {
							window.location.reload();
						},
						title : "警告",
					});

					return;
				}


				for (var i = 0; i < urlList.length; i++) {
					var temp = '<li><i class="icon-caret-right blue" ></i>'
						+ urlList[i] + '</li>';
					var href = urlList[i].match('http*.*?"');
					href = href[0].substring(0, href[0].length - 1);
					var text = urlList[i].match('>.*<');
					text = text[0].substring(1, text[0].length - 1);
					var temp2 = '<option value="' + href + '">' + text + '</option>';
					ullist += temp;
					selectList += temp2;
				}
				$('#url_list').html(ullist);
				$('#url_select').html(selectList);
				$('#listCssPath').val(data.listCssPath);
			}
		});
	}

	function fillContent() {
		var url = $("#url_select option:selected").val();
		var titleText = $("#url_select option:selected").text();
		$("#titleText").val(titleText);
		var timeText = $("#timeText").val();
		var contentText = $("#contentText").val();

		$.ajax({
			type : "POST",
			url : "addsiteInfo",
			data : {
				url : url,
				titleText : titleText,
				timeText : timeText,
				contentText : contentText
			},
			beforeSend : function(xhr) {
				xhr.setRequestHeader('X-CSRF-Token', $("input[name=_csrf]").val());
			},
			async : false,
			success : function(data) {
				var title = data.title;
				var content = data.content;
				var time = data.time;
				$("#title").html(title);
				$("#titleCssPath").val(data.titleCssPath);
				$("#time").html(time);
				$("#content").html(content);
				$("#contentCssPath").val(data.contentCssPath);
			}
		});
	}

	jQuery(function($) {

		$('[data-rel=tooltip]').tooltip();

		$('.select2').css('width', '200px').select2({
			allowClear : true
		})
			.on('change', function() {
				$(this).closest('form').validate().element($(this));
			});

		var $validation = false;
		$('#fuelux-wizard-container')
			.ace_wizard({
				//step: 2 //optional argument. wizard will jump to step "2" at first
				//buttons: '.wizard-actions:eq(0)'
			})
			.on('actionclicked.fu.wizard', function(e, info) {
				if (info.step == 1) {
					var fdStart = $("#url").val().indexOf("http");
					if (fdStart == -1) {
						bootbox.alert({
							buttons : {
								ok : {
									label : '确定',
									className : 'btn-myStyle'
								}
							},
							message : '请输入正确的网址！！！',
							callback : function() {},
							title : "警告",
						});
						return false;
					} else {
						var html = $.ajax({
							type : "POST",
							url : "urlexit",
							data : {
								url : $("#url").val()
							},
							beforeSend : function(xhr) {
								xhr.setRequestHeader('X-CSRF-Token', $("input[name=_csrf]").val());
							},
							async : false
						}).responseText;
						if (html.indexOf("true") > -1) {
							bootbox.alert({
								buttons : {
									ok : {
										label : '确定',
										className : 'btn-myStyle'
									}
								},
								message : '您输入的网址已经有啦！！！',
								callback : function() {},
								title : "警告",
							});
							return false;
						} else {
							fillWebList();
						}
					}

				} else if (info.step == 2) {
					fillContent();
				} else if (info.step == 3) {
				}
			})
			.on('changed.fu.wizard', function(e, info) {})
			.on('finished.fu.wizard', function(e) {

				var sectionName = $("#sectionName").val();
				var siteName = $("#siteName").val();
				var contentCssPath = $("#contentCssPath").val();
				var timeCssPath = $("#timeCssPath").val();
				var titleCssPath = $("#titleCssPath").val();
				var listCssPath = $("#listCssPath").val();
				var url = $("#url").val();

				if (siteName == null || siteName == '' || sectionName == null || sectionName == '') {
					bootbox.dialog({
						message : "请输入网址名称和板块名称",
						buttons : {
							"success" : {
								"label" : "OK",
								"className" : "btn-sm btn-primary"
							}
						}
					});
					return;
				}
				$.ajax({
					type : "POST",
					url : "addsite",
					data : {
						url : url,
						siteName : siteName,
						sectionName : sectionName,
						listCssPath : listCssPath,
						titleCssPath : titleCssPath,
						timeCssPath : timeCssPath,
						contentCssPath : contentCssPath
					},
					beforeSend : function(xhr) {
						xhr.setRequestHeader('X-CSRF-Token', $("input[name=_csrf]").val());
					},
					async : false,
					success : function(data) {
						bootbox.dialog({
							message : "感谢您的录入，您的数据源已经保存",
							buttons : {
								"success" : {
									"label" : "OK",
									"className" : "btn-sm btn-primary",
									"callback" : function() {
										window.location.reload();
									}
								}
							}
						});
					}
				});
			}).on('stepclick.fu.wizard', function(e) {
			//e.preventDefault();//this will prevent clicking and selecting steps
		});


		//jump to a step
		/**
		var wizard = $('#fuelux-wizard-container').data('fu.wizard')
		wizard.currentStep = 3;
		wizard.setState();
		*/

		//determine selected step
		//wizard.selectedItem().step



		//hide or show the other form which requires validation
		//this is for demo only, you usullay want just one form in your application
		$('#skip-validation').removeAttr('checked').on('click', function() {
			$validation = this.checked;
			if (this.checked) {
				$('#sample-form').hide();
				$('#validation-form').removeClass('hide');
			} else {
				$('#validation-form').addClass('hide');
				$('#sample-form').show();
			}
		})



		//documentation : http://docs.jquery.com/Plugins/Validation/validate


		$.mask.definitions['~'] = '[+-]';
		$('#phone').mask('(999) 999-9999');

		jQuery.validator.addMethod("phone", function(value, element) {
			return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
		}, "Enter a valid phone number.");

		$('#validation-form').validate({
			errorElement : 'div',
			errorClass : 'help-block',
			focusInvalid : false,
			ignore : "",
			rules : {
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					minlength : 5
				},
				password2 : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				},
				name : {
					required : true
				},
				phone : {
					required : true,
					phone : 'required'
				},
				url : {
					required : true,
					url : true
				},
				comment : {
					required : true
				},
				state : {
					required : true
				},
				platform : {
					required : true
				},
				subscription : {
					required : true
				},
				gender : {
					required : true,
				},
				agree : {
					required : true,
				}
			},

			messages : {
				email : {
					required : "Please provide a valid email.",
					email : "Please provide a valid email."
				},
				password : {
					required : "Please specify a password.",
					minlength : "Please specify a secure password."
				},
				state : "Please choose state",
				subscription : "Please choose at least one option",
				gender : "Please choose gender",
				agree : "Please accept our policy"
			},


			highlight : function(e) {
				$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
			},

			success : function(e) {
				$(e).closest('.form-group').removeClass('has-error'); //.addClass('has-info');
				$(e).remove();
			},

			errorPlacement : function(error, element) {
				if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
					var controls = element.closest('div[class*="col-"]');
					if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
					else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
				} else if (element.is('.select2')) {
					error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
				} else if (element.is('.chosen-select')) {
					error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
				}
				else error.insertAfter(element.parent());
			},

			submitHandler : function(form) {},
			invalidHandler : function(form) {}
		});




		$('#modal-wizard-container').ace_wizard();
		$('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');


		/**
		$('#date').datepicker({autoclose:true}).on('changeDate', function(ev) {
			$(this).closest('form').validate().element($(this));
		});
		
		$('#mychosen').chosen().on('change', function(ev) {
			$(this).closest('form').validate().element($(this));
		});
		*/


		$(document).one('ajaxloadstart.page', function(e) {
			//in ajax mode, remove remaining elements before leaving page
			$('[class*=select2]').remove();
		});


		$("#url_select").change(function() {
			fillContent();
		});



	})
</script>