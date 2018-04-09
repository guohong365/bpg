<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<form id="FORM_TABLE_FUNCTION" role="form" action="#" method="post">
  <div class="dataTables_wrapper form-inline no-footer">
    <div class="row">
      <!-- functon button begin -->
      <div class="col-xs-12">
        <div class="btn-group pull-right">
          <button class="btn btn-primary" type="button" data-export="export" id="btnExport">
            <i class="ace-icon fa fa-file-excel-o"></i>导出Excel
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
    <input type="hidden" id="pageCtrl.pageSize" name="pageCtrl.pageSize" value="${pageCtrl.pageSize}" />
    <input type="hidden" id="pageCtrl.total" name="pageCtrl.total" value="${pageCtrl.total }" />
    <input type="hidden" id="pageCtrl.offset" name="pageCtrl.offset" value="${pageCtrl.offset }" />
    <!-- table data begin-->
    <table class="table table-striped table-bordered table-hover dataTable no-footer">
      <thead>
        <tr>
          <th class="center sorting${queryInput.queryOrderBy =='使用时间' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='使用时间' ? 'data-active=\"true\"' : ''} data-column="使用时间">使用时间</th>
          <th class="center sorting${queryInput.queryOrderBy =='酒店收款' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='酒店收款' ? 'data-active=\"true\"' : ''} data-column="酒店收款">酒店收款</th>
          <th class="center sorting${queryInput.queryOrderBy =='结算标准' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='结算标准' ? 'data-active=\"true\"' : ''} data-column="结算标准">结算标准</th>
          <th class="center sorting${queryInput.queryOrderBy =='分成比例' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='分成比例' ? 'data-active=\"true\"' : ''} data-column="分成比例">分成比例</th>
          <th class="center sorting${queryInput.queryOrderBy =='应付款' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='应付款' ? 'data-active=\"true\"' : ''} data-column="应付款">应付款</th>
          <th class="center sorting${queryInput.queryOrderBy =='房间' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='房间' ? 'data-active=\"true\"' : ''} data-column="房间">房间</th>
          <th class="center sorting${queryInput.queryOrderBy =='设备名称' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='设备名称' ? 'data-active=\"true\"' : ''} data-column="设备名称">设备名称</th>
          <th class="center sorting${queryInput.queryOrderBy =='序列号' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='序列号' ? 'data-active=\"true\"' : ''} data-column="序列号">序列号</th>
          <th class="center sorting${queryInput.queryOrderBy =='已结账' ? '_'.concat(queryInput.queryOrder) : '' }" ${queryInput.queryOrderBy =='已结账' ? 'data-active=\"true\"' : ''} data-column="已结账">已结账</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="item" items="${records}">
          <tr>
            <td>
              <fmt:formatDate value="${item.useTime}" pattern="yyyy年MM月dd日 HH:mm:ss" />
            </td>
            <td>
              <fmt:formatNumber type="CURRENCY" value="${item.charge}" currencySymbol="￥" maxFractionDigits="2" minFractionDigits="2" />
            </td>
            <td>
              <fmt:formatNumber type="CURRENCY" value="${item.chargeStandard}" currencySymbol="￥" maxFractionDigits="2" minFractionDigits="2" />
            </td>
            <td>
              <fmt:formatNumber type="PERCENT" value="${item.ratio}" maxFractionDigits="2" />
            </td>
            <td>
              <fmt:formatNumber type="CURRENCY" value="${item.rent}" currencySymbol="￥" maxFractionDigits="2" />
            </td>
            <td>${item.publicUsage?'公用':item.roomNo}</td>
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
          <div class="col-xs-12 col-sm-6">共${pageCtrl.pageCount }页${pageCtrl.total }条记录, 当前第${pageCtrl.page + 1}页</div>
        </c:when>
        <c:otherwise>
          <div class="col-xs-12 col-sm-6">无记录</div>
        </c:otherwise>
      </c:choose>
      <div class="col-xs-12 col-sm-6">
        <div>
          <c:set var="disableFirst" value="btn-info"></c:set>
          <c:if test="${pageCtrl.page==0}">
            <c:set var="disableFirst" value="disabled"></c:set>
          </c:if>
          <c:set var="disableLast" value="btn-info"></c:set>
          <c:if test="${pageCtrl.total==0 or pageCtrl.page==pageCtrl.pageCount -1 }">
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
<!-- page specific plugin scripts -->
<script type="text/javascript">
  $(document).ready(function() {
    $('[data-rel="tooltip"]').tooltip();
  });
</script>