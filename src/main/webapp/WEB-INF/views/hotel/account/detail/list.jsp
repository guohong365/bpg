<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>设备分配历史记录</title>

<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css' />" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="<c:url value='/resources/css/ace-fonts.css' />" />

<!-- ace styles -->
<link rel="stylesheet" href="<c:url value='/resources/css/ace.min.css' />" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="<c:url value='/resources/css/ace-part2.min.css' />" />
		<![endif]-->
<link rel="stylesheet" href="<c:url value='/resources/css/ace-skins.min.css' />" />
<link rel="stylesheet" href="<c:url value='/resources/css/ace-rtl.min.css' />" />
<link rel="stylesheet" href="<c:url value='/resources/css/chosen.css' />" />
<link rel="stylesheet" href="<c:url value="/resources/css/uc.data.css" />" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<c:url value='/resources/css/ace-ie.min.css' />" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="<c:url value='/resources/js/ace-extra.min.js' />"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="<c:url value='/resources/js/html5shiv.min.js' />" ></script>
		<script src="<c:url value='/resources/js/respond.min.js' />"></script>
		<![endif]-->
</head>

<body class="no-skin">
  <div class="main-container" id="main-container">
    <div class="main-content">
      <div class="page-content">
        <div class="page-content-area">
          <div class="row">
            <div class="col-xs-12">
              <!-- PAGE CONTENT BEGINS -->
              <div class="widget-box">
                <div class="widget-header blue">
                  <h4 class="widget-title">账单信息</h4>
                </div>
                <div class="widget-body">
                  <div class="widget-main">
                    <div class="row">
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">生成时间：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue"><fmt:formatDate value="${detailInput.generatedTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">酒店：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue">${detailInput.hotelName}</p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">酒店收入：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue"><fmt:formatNumber type="currency" pattern="￥0.00" value="${detailInput.income}" /></p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">分成收入：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue"><fmt:formatNumber type="currency" pattern="￥0.00" value="${detailInput.basicCharge}" /></p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">应付分成：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue"><fmt:formatNumber type="currency" pattern="￥0.00" value="${detailInput.rent}" /></p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">状态：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue">${detailInput.state}</p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">付款时间：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue"><fmt:formatDate value="${detailInput.payTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">付款人：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue">${detailInput.payerName}</p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">确认时间：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue"><fmt:formatDate value="${detailInput.verifyTime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></p>
                          </div>
                        </div>
                      </div>
                      <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                          <label class="control-label col-xs-12 col-sm-4">确认人：</label>
                          <div class="col-xs-12 col-sm-8">
                            <p class="form-control-static blue">${detailInput.verifierName}</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-xs-12">&nbsp;</div>
              </div>
              <div class="row" id="content_container">
                <div class="col-xs-12">
                  <!-- PAGE CONTENT BEGINS -->
                  <div class="row">
                    <!-- search condition begin -->
                    <div class="col-xs-12">
                      <form:form class="form-horizontal" role="form" modelAttribute="queryInput" action="#">
                        <form:hidden path="queryMainId" />
                        <form:hidden path="queryHotel" />
                        <div class="row"></div>
                        <div class="row">
                          <div class="col-xs-12">
                            <div class="form-group align-right">
                              <button class="btn btn-sm btn-success" id="btnReset" type="button">
                                <i class="ace-icon fa fa-refresh"></i>重置
                              </button>
                              <button class="btn btn-sm btn-primary" id="btnSearch" type="button">
                                <i class="ace-icon fa fa-search"></i>查询
                              </button>
                            </div>
                          </div>
                        </div>
                      </form:form>
                    </div>
                  </div>
                  <!-- search condition end -->
                  <div class="hr hr-8"></div>
                  <div class="row">
                    <!-- result table begin -->
                    <div class="col-xs-12">
                      <div id="listResult">
                        <form id="FORM_TABLE_FUNCTION" role="form" action="#" method="post">
                          <div class="dataTables_wrapper form-inline no-footer">
                            <div class="row">
                              <!-- functon button begin -->
                              <div class="col-xs-12">
                                <div class="btn-group">
                                  <button class="btn btn-sm btn-success" data-action="new" type="button">
                                    <i class="ace-icon fa fa-pencil"></i>新建
                                  </button>
                                </div>
                              </div>
                            </div>
                            <!-- function button end -->
                            <input type="hidden" id="action" name="action" value="${action}" />
                            <input type="hidden" id="selectedId" name="selectedId" value="" />
                            <input type="hidden" id="queryInput.queryMainId" name="queryInput.queryMainId" value="${queryInput.queryMainId}">
                            <input type="hidden" id="queryInput.queryOrderBy" name="queryInput.queryOrderBy" value="${queryInput.queryOrderBy }" />
                            <input type="hidden" id="queryInput.queryOrder" name="queryInput.queryOrder" value="${queryInput.queryOrder}" />
                            <input type="hidden" id="pageCtrl.pageCount" name="pageCtrl.pageCount" value="${pageCtrl.pageCount}" />
                            <input type="hidden" id="pageCtrl.total" name="pageCtrl.total" value="${pageCtrl.total }" />
                            <input type="hidden" id="pageCtrl.current" name="pageCtrl.current" value="${pageCtrl.current }" />
                            <!-- table data begin-->
                            <table class="table table-striped table-bordered table-hover dataTable no-footer">
                              <thead>
                                <tr>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='使用时间' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="使用时间">使用时间</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="使用时间">使用时间</th>
                                    </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='酒店收款' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="酒店收款">酒店收款</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="酒店收款">酒店收款</th>
                                    </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='结算标准' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="结算标准">结算标准</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="结算标准">结算标准</th>
                                    </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='分成比例' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="分成比例">分成比例</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="分成比例">分成比例</th>
                                    </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='应付款' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="应付款">应付款</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="应付款">应付款</th>
                                    </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='房间' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="房间">房间</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="房间">房间</th>
                                    </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='设备名称' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="设备名称">设备名称</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="设备名称">设备名称</th>
                                    </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='序列号' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="序列号">序列号</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="序列号">序列号</th>
                                    </c:otherwise>
                                  </c:choose>
                                  <c:choose>
                                    <c:when test="${queryInput.queryOrderBy =='已结账' }">
                                      <th class="center sorting_${queryInput.queryOrder }" data-active="true" data-column="已结账">已结账</th>
                                    </c:when>
                                    <c:otherwise>
                                      <th class="center sorting" data-column="已结账">已结账</th>
                                    </c:otherwise>
                                  </c:choose>
                                </tr>
                              </thead>
                              <tbody>
                                <c:forEach var="item" items="${records}">
                                  <tr>
                                    <td>${item.useTime}</td>
                                    <td>${item.charge}</td>
                                    <td>${item.chagingStandard}</td>
                                    <td>${item.ratio}</td>
                                    <td>${item.payable}</td>
                                    <td>${item.roomNo}</td>
                                    <td>${item.deviceName}</td>
                                    <td>${item.deviceSerial}</td>
                                    <td>${item.payed}</td>
                                  </tr>
                                </c:forEach>
                              </tbody>
                            </table>
                            <!-- table data end -->
                            <div class="row">
                              <!-- functon button begin -->
                              <c:choose>
                                <c:when test="${pageCtrl.total > 0 }">
                                  <div class="col-xs-12 col-sm-6">共${pageCtrl.pageCount }页${pageCtrl.total }条记录, 当前第${pageCtrl.current + 1}页</div>
                                </c:when>
                                <c:otherwise>
                                  <div class="col-xs-12 col-sm-6">无记录</div>
                                </c:otherwise>
                              </c:choose>
                              <div class="col-xs-12 col-sm-6">
                                <div>
                                  <c:set var="disableFirst" value="btn-info"></c:set>
                                  <c:if test="${pageCtrl.current==0}">
                                    <c:set var="disableFirst" value="disabled"></c:set>
                                  </c:if>
                                  <c:set var="disableLast" value="btn-info"></c:set>
                                  <c:if test="${pageCtrl.current==0 or pageCtrl.current==pageCtrl.pageCount -1 }">
                                    <c:set var="disableLast" value="disabled"></c:set>
                                  </c:if>
                                  <ul class="pagination">
                                    <li>
                                      <button id="firstPage" class="btn btn-xs ${disableFirst }" data-page="first" type="button">首页</button>
                                    </li>
                                    <li>
                                      <button id="priorPage" class="btn btn-xs ${disableFirst }" data-page="prior" type="button">上一页</button>
                                    </li>
                                    <li>
                                      <button id="nextPage" class="btn btn-xs ${disableLast }" data-page="next" type="button">下一页</button>
                                    </li>
                                    <li>
                                      <button id="lastPage" class="btn btn-xs ${disableLast }" data-page="last" type="button">末尾</button>
                                    </li>
                                  </ul>
                                </div>
                              </div>
                            </div>
                            <!-- function button end -->
                          </div>
                        </form>
                      </div>
                      <div id="dialogPanel"></div>
                    </div>
                  </div>
                </div>
                <!-- result table end -->
              </div>
              <!-- PAGE CONTENT ENDS -->
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.page-content-area -->
      </div>
      <!-- /.page-content -->
    </div>
    <!-- /.main-content -->
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
      <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
  </div>
  <!-- /.main-container -->

  <!-- basic scripts -->
  <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
  <!--[if !IE]> -->
  <script type="text/javascript">
			window.jQuery
					|| document.write("<script src='"
							+ "<c:url value='/resources/js/jquery.min.js' />"
							+ "'><"+" /script>");
		</script>
  <!-- <![endif]-->

  <!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='"+ "<c:url value='/resources/js/jquery1x.min.js' />"+"'><"+"/script>");
</script>
<![endif] -->
  <script type="text/javascript">
			if ('ontouchstart' in document.documentElement)
				document
						.write("<script src='"
								+ "<c:url value='/resources/jquery.mobile.custom.min.js' />"
								+ "'><"+"/script>");
		</script>

  <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>

  <!-- page specific plugin scripts -->

  <!-- ace scripts -->
  <script src="<c:url value='/resources/js/ace-elements.min.js' />"></script>
  <script src='<c:url value="/resources/js/jquery-ui.custom.min.js" />'></script>
  <script src='<c:url value="/resources/js/jquery.ui.touch-punch.min.js" />'></script>
  <script src='<c:url value="/resources/js/jquery.validate.min.js" />'></script>
  <script src='<c:url value="/resources/js/additional-methods.min.js" />'></script>
  <script src='<c:url value="/resources/js/bootbox.min.js" />'></script>
  <script src='<c:url value="/resources/js/date-time/moment.min.js" />'></script>
  <script src='<c:url value="/resources/js/date-time/bootstrap-datepicker.min.js" />'></script>
  <script src='<c:url value="/resources/js/date-time/daterangepicker.min.js" />'></script>
  <script src='<c:url value="/resources/js/date-time/locales/bootstrap-datepicker.zh-CN.js" />'></script>
  <script src='<c:url value="/resources/js/chosen.jquery.min.js" />'></script>
  <script src='<c:url value="/resources/js/uc/jquery.uc.page-helper.js" />'></script>
  <script src='<c:url value="/resources/js/uc/jquery.uc.form-helper.js" />'></script>
  <script src='<c:url value="/resources/js/uc/jquery.uc.validate.methods.js" />'></script>

  <script type="text/javascript">
			console.log('detail list loaded.....');
			$(document)
					.ready(
							function() {
								$('.chosen-select').chosen({
									width : '100%'
								});

								$('.input-daterange').datepicker({
									format : 'yyyy-mm-dd',
									autoclose : true,
									todayHighlight : true,
									todayBtn : true,
									language : 'zh-CN'
								});

								$('#content_container')
										.bindPage(
												{
													bindPagation : false,
													reset : function() {
														$(
																'#queryInput [name="queryOperateTimeFrom"]')
																.val("");
														$(
																'#queryInput [name="queryOperateTimeTo"]')
																.val("");
														$(
																'#queryInput [name="queryHotelName"]')
																.val("");
														$(
																'#queryInput [name="queryRoomNo"]')
																.val("");
														$(
																'#queryInput [name="queryOperaterName"]')
																.val("");
														$(
																'#queryInput [name="queryOperation"]')
																.val("");
														$(
																'#queryInput [name="queryOperation"]')
																.trigger(
																		'chosen:update');
													},
													baseUrl : '<c:url value="${baseUrl}/detail" />',
												});
							});
		</script>
</body>
</html>
