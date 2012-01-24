<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Computers - View computer</title>
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
		<s:form theme="simple">
			<table class="table">
				<tr>
					<td> <!-- Picture -->
						<s:if test="computer.clazz.name == 'Personal'">
							<img alt="Personal" src="img/personal.jpg">
						</s:if><s:elseif test="computer.clazz.name == 'Notebook'">
							<img alt="Notebook" src="img/notebook.png">
						</s:elseif>
					</td>
				</tr>
				
				<!-- Common information -->
				<tr><td colspan="2" class="detail headerRow">Common information</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.name"/></td></tr>
				<tr><td class="detailProperty">Class:</td>
					<td><s:property value="computer.clazz.name"/></td></tr>
				<tr><td class="detailProperty">Platform:</td>
					<td><s:property value="computer.platform.name"/></td></tr>
				
				<!-- Processor -->
				<tr><td colspan="2" class="detail headerRow">Processor</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.processor.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.processor.name"/></td></tr>
				<tr><td class="detailProperty">Cores:</td>
					<td><s:property value="computer.processor.coresCount"/></td></tr>
				<tr><td class="detailProperty">Socket:</td>
					<td><s:property value="computer.processor.socket.name"/></td></tr>
				<tr><td class="detailProperty">Frequency, MHz:</td>
					<td><s:property value="computer.processor.frequency"/></td></tr>
				<tr><td class="detailProperty">Cache, KB:</td>
					<td><s:property value="computer.processor.cacheSize"/></td></tr>
				
				<!-- Motherboard -->
				<tr><td colspan="2" class="detail headerRow">Motherboard</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.motherboard.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.motherboard.name"/></td></tr>
				<tr><td class="detailProperty">Socket:</td>
					<td><s:property value="computer.motherboard.socket.name"/></td></tr>
				<tr><td class="detailProperty">Chipset:</td>
					<td><s:property value="computer.motherboard.chipset"/></td></tr>
				<tr><td class="detailProperty">Memory:</td>
					<td><s:property value="computer.motherboard.memoryType.name"/></td></tr>
				<tr><td class="detailProperty">Formfactor:</td>
					<td><s:property value="computer.motherboard.formfactor.name"/></td></tr>
					
				<!-- RAM -->
				<tr><td colspan="2" class="detail headerRow">RAM</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.ram.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.ram.name"/></td></tr>
				<tr><td class="detailProperty">Type:</td>
					<td><s:property value="computer.ram.type.name"/></td></tr>
				<tr><td class="detailProperty">Volume, MB:</td>
					<td><s:property value="computer.ram.volume"/></td></tr>
				<tr><td class="detailProperty">Frequency, MHz:</td>
					<td><s:property value="computer.ram.frequency"/></td></tr>
				
				<!-- Video card -->
				<tr><td colspan="2" class="detail headerRow">Video card</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.videoCard.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.videoCard.name"/></td></tr>
				<tr><td class="detailProperty">Socket:</td>
					<td><s:property value="computer.videoCard.socket.name"/></td></tr>
				<tr><td class="detailProperty">Processor manufacturer:</td>
					<td><s:property value="computer.videoCard.processorManufacturer"/></td></tr>
				<tr><td class="detailProperty">Memory:</td>
					<td><s:property value="computer.videoCard.memoryType.name"/></td></tr>
				<tr><td class="detailProperty">Memory volume, MB:</td>
					<td><s:property value="computer.videoCard.memoryVolume"/></td></tr>
				
				<!-- HDD -->
				<tr><td colspan="2" class="detail headerRow">HDD</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.hdd.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.hdd.name"/></td></tr>
				<tr><td class="detailProperty">Formfactor:</td>
					<td><s:property value="computer.hdd.formfactor.size"/></td></tr>
				<tr><td class="detailProperty">Volume, MB:</td>
					<td><s:property value="computer.hdd.volume"/></td></tr>
				<tr><td class="detailProperty">Interface:</td>
					<td><s:property value="computer.hdd.connectionInterface.name"/></td></tr>
				<tr><td class="detailProperty">Spindle speed, rpm:</td>
					<td><s:property value="computer.hdd.spindleSpeed"/></td></tr>
					
				<!-- Monitor -->
				<tr><td colspan="2" class="detail headerRow">Monitor</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.monitor.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.monitor.name"/></td></tr>
				<tr><td class="detailProperty">Diagonal, ":</td>
					<td><s:property value="computer.monitor.diagonal"/></td></tr>
				<tr><td class="detailProperty">Format:</td>
					<td><s:property value="computer.monitor.format.name"/></td></tr>
				<tr><td class="detailProperty">Resolution:</td>
					<td><s:property value="computer.monitor.resolution.name"/></td></tr>
				<tr><td class="detailProperty">Matrix:</td>
					<td><s:property value="computer.monitor.matrix.name"/></td></tr>
				
				<s:if test="clazz == 'Personal'">
				<!-- Keyboard -->
				<tr><td colspan="2" class="detail headerRow">Keyboard</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.keyboard.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.keyboard.name"/></td></tr>
				<tr><td class="detailProperty">Type:</td>
					<td><s:property value="computer.keyboard.type.name"/></td></tr>
				<tr><td class="detailProperty">Interface:</td>
					<td><s:property value="computer.keyboard.connectionInterface.name"/></td></tr>
				
				<!-- Mouse -->
				<tr><td colspan="2" class="detail headerRow">Mouse</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:property value="computer.mouse.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:property value="computer.mouse.name"/></td></tr>
				<tr><td class="detailProperty">Type:</td>
					<td><s:property value="computer.mouse.type.name"/></td></tr>
				<tr><td class="detailProperty">Interface:</td>
					<td><s:property value="computer.mouse.connectionInterface.name"/></td></tr>
				<tr><td class="detailProperty">Sensor:</td>
					<td><s:property value="computer.mouse.sensor.name"/></td></tr>
				</s:if>
				
				<tr><td colspan="2"><hr/></td></tr>
				<tr>
					<td colspan="2" align="center">
						<s:hidden name="computerId" value="%{computer.id}"/>
						<s:submit action="addEditComputerAction" method="index" value="Edit"/>
						<s:submit action="listComputersAction" value="Cancel"/>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	<div id="footer">
		Created by Iryna Shtanko
	</div>
</body>
</html>