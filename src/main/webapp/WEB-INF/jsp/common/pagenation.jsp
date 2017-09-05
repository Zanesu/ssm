<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${!empty page.content }">
	<div style="text-align: right">
		<ul class="pager">
			<li class="previous"><c:if test="${page.page==1}">
					<a href="#" class="disabled">«上一页</a>
				</c:if> <c:if test="${page.page>1}">
					<a href="#" onclick="toPage(${page.page-1})">«上一页</a>
				</c:if></li>
			<c:forEach begin="${page.startPage}" end="${page.endPage }"
				varStatus="statu">
				<li onclick="toPage(${page.startPage+statu.count-1})"
					class="${page.page==(page.startPage+statu.count-1)?'active':''}"><a
					href="#">${ page.startPage+statu.count-1}</a></li>
			</c:forEach>
			<li class="next"><c:if test="${page.page==page.totalPage}">
					<a href="#" class="disabled">下一页»</a>
				</c:if> <c:if test="${page.page<page.totalPage}">
					<a href="#" onclick="toPage(${page.page+1})">下一页»</a>
				</c:if></li>
		</ul>
	</div>
</c:if>

