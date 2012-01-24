<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Computers - Computers list</title>
</head>
<body>
	<div id="header" align="left">
		<h3>Computers</h3>
	</div>
	<div id="menu">
		<ul>
			<li><s:a action="listComputersAction">Computers list</s:a></li>
			<li><s:a action="addEditComputerAction" method="index">Add computer</s:a></li>
		</ul>
	</div>
	<div id="content">
		<s:if test="computersList.isEmpty()">
			<s:a action="addEditComputerAction" method="index">Add computer</s:a>
		</s:if>
		<s:else>
			<table>
				<s:iterator value="computersList" var="computer">
					<tr> <!-- Picture -->
						<s:if test="clazz.name == 'Personal'">
							<td rowspan="10"><img alt="Personal" src="img/personal.jpg"><td>
						</s:if>
						<s:elseif test="clazz.name == 'Notebook'">
							<td rowspan="8"><img alt="Notebook" src="img/notebook.png"><td>
						</s:elseif>
					</tr>
					<tr>
						<td colspan="2"><b><i>
							<s:a action="viewComputerAction">
								<s:param name="computerId" value="id"/>
								<s:property value="manufacturer"/>&nbsp;
								<s:property value="name"/>
							</s:a>
						</i></b></td>
					</tr>
					<tr>
						<td><b>Processor:</b></td>
						<td><s:property value="processor.name"/>,&nbsp;
							<s:property value="processor.coresCount"/>&nbsp;core(s),&nbsp;
							<s:property value="processor.socket.name"/>,&nbsp;
							<s:property value="processor.frequency"/>&nbsp;MHz,&nbsp;
							<s:property value="processor.cacheSize"/>&nbsp;KB cache
						</td>
					</tr>
					<tr>
						<td><b>Motherboard:</b></td>
						<td><s:property value="motherboard.socket.name"/>,&nbsp;
							<s:property value="motherboard.chipset"/>,&nbsp;
							<s:property value="motherboard.memoryType.name"/>,&nbsp;
							<s:property value="motherboard.formfactor.name"/>
						</td>
					</tr>
					<tr>
						<td><b>RAM:</b></td>
						<td><s:property value="ram.type.name"/>,&nbsp;
							<s:property value="ram.volume"/>&nbsp;MB,&nbsp;
							<s:property value="ram.frequency"/>&nbsp;MHz
						</td>
					</tr>
					<tr>
						<td><b>Video card:</b></td>
						<td><s:property value="videoCard.socket.name"/>,&nbsp;
							<s:property value="videoCard.processorManufacturer"/>,&nbsp;
							<s:property value="videoCard.memoryType.name"/>&nbsp;
							<s:property value="videoCard.memoryVolume"/>&nbsp;MB
						</td>
					</tr>
					<tr>
						<td><b>HDD:</b></td>
						<td><s:property value="hdd.formfactor.size"/>,&nbsp;
							<s:property value="hdd.volume"/>&nbsp;MB,&nbsp;
							<s:property value="hdd.connectionInterface.name"/>,&nbsp;
							<s:property value="hdd.spindleSpeed"/>&nbsp;rpm
						</td>
					</tr>
					<tr>
						<td><b>Monitor:</b></td>
						<td><s:property value="monitor.diagonal"/>",&nbsp;
							<s:property value="monitor.format.name"/>,&nbsp;
							<s:property value="monitor.resolution.name"/>,&nbsp;
							<s:property value="monitor.matrix.name"/>
						</td>
					</tr>
					<s:if test="clazz.name == 'Personal'">
					<tr>
						<td><b>Keyboard:</b></td>
						<td><s:property value="keyboard.type.name"/>,&nbsp;
							<s:property value="keyboard.connectionInterface.name"/>
						</td>
					</tr>
					<tr>
						<td><b>Mouse:</b></td>
						<td><s:property value="mouse.type.name"/>,&nbsp;
							<s:property value="mouse.connectionInterface.name"/>,&nbsp;
							<s:property value="mouse.sensor.name"/>
						</td>
					</tr>
					</s:if>
					<tr>
						<td align="center">
							<s:a action="addEditComputerAction" method="index">
							Edit<s:param name="computerId" value="id"/>
							</s:a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:else>
	</div>
	<div id="search">
		search
	</div>
	<div id="footer">
		Created by Iryna Shtanko
	</div>
</body>
</html>