<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月度计价常规类统计表</title>
</head>
<body>
	<div>
		<table width="100%">
			<tr>
				<td align="center">总包单位月度计价汇总表</td>
			</tr>
		</table>
		<table width="100%">
			<tr>
				<td align="left">${unit}</td>
				<td align="right">${time}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
			</tr>
		</table>
		<table border="1" width="100%">
			<tr>
				<th width="5%">序号</th>
				<th width="10%">计价期</th>
				<th width="5%">编号</th>
				<th width="5%">申报额（元）</th>
				<th width="10%">申报额中变洽签金额（元）</th>
				<th width="5%">审定额（元）</th>
				<th width="10%">审定额中变洽签金额（元）</th>
				<th width="5%">应付比例（%）</th>
				<th width="5%">应付额（元）</th>
				<th width="10%">申报时间</th>
				<th width="10%">审定时间</th>
				<th width="10%">付款时间</th>
				<th width="10%">实际支付金额（元）</th>
			</tr>
			<c:forEach var="map" items="${data }" varStatus="status">
				<tr>
				  <td>${status.index+1}</td>
				  <td>${map['1']}</td>
				  <td>${map['2']}</td>
				  <td>${map['3']}</td>
				  <td>${map['4']}</td>
				  <td>${map['5']}</td>
				  <td>${map['6']}</td>
				  <td>${map['7']}</td>
				  <td>${map['8']}</td>
				  <td>${map['11']}</td>
				  <td>${map['12']}</td>
				  <td>${map['13']}</td>
				  <td>${map['er']}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
