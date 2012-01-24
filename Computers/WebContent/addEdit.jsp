<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Computers - Add/Edit computer</title>
<script type="text/javascript" src="jquery/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	var cancelButtonClicked = false;
	
	function setCancelButtonClicked(value) {
		cancelButtonClicked = value;
	}
	
	$(document).ready(function() {
		$('#computerForm').submit(function() {
			var result = true;
			if (!cancelButtonClicked) {
				$('input[type="text"]').each(function() {
					if ($(this).val() == "") {	
						result = false;
					}
				});
			
				if (result == false) {
					alert('You have empty fields. Please fill them.');
				}
			}
			
			return result;
		});
	});
</script>
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
		<s:form id="computerForm" theme="simple">
			<table class="table">
				<tr>
					<td> <!-- Picture -->
						<s:if test="clazz == 'Personal'">
							<img alt="Personal" src="img/personal.jpg">
						</s:if><s:elseif test="clazz == 'Notebook'">
							<img alt="Notebook" src="img/notebook.png">
						</s:elseif>
					</td>
				</tr>
				
				<!-- Common information -->
				<tr><td colspan="2" class="detail headerRow">Common information</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.name"/></td></tr>
				<tr><td class="detailProperty">Class:</td>
					<td><s:select list="classesList" name="clazz"/></td></tr>
				<tr><td class="detailProperty">Platform:</td>
					<td><s:select list="platformsList" name="platform"/></td></tr>
				
				<!-- Processor -->
				<tr><td colspan="2" class="detail headerRow">Processor</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.processor.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.processor.name"/></td></tr>
				<tr><td class="detailProperty">Cores:</td>
					<td><s:textfield name="computer.processor.coresCount"/></td></tr>
				<tr><td class="detailProperty">Socket:</td>
					<td><s:select list="processorSocketsList" name="processorSocket"/></td></tr>
				<tr><td class="detailProperty">Frequency, MHz:</td>
					<td><s:textfield name="computer.processor.frequency"/></td></tr>
				<tr><td class="detailProperty">Cache, KB:</td>
					<td><s:textfield name="computer.processor.cacheSize"/></td></tr>
				
				<!-- Motherboard -->
				<tr><td colspan="2" class="detail headerRow">Motherboard</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.motherboard.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.motherboard.name"/></td></tr>
				<tr><td class="detailProperty">Socket:</td>
					<td><s:select list="processorSocketsList" name="motherboardProcessorSocket"/></td></tr>
				<tr><td class="detailProperty">Chipset:</td>
					<td><s:textfield name="computer.motherboard.chipset"/></td></tr>
				<tr><td class="detailProperty">Memory:</td>
					<td><s:select list="motherboardMemoryTypesList" name="motherboardMemoryType"/></td></tr>
				<tr><td class="detailProperty">Formfactor:</td>
					<td><s:select list="motherboardFormfactorsList" name="motherboardFormfactor"/></td></tr>
					
				<!-- RAM -->
				<tr><td colspan="2" class="detail headerRow">RAM</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.ram.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.ram.name"/></td></tr>
				<tr><td class="detailProperty">Type:</td>
					<td><s:select list="ramTypesList" name="ramType"/></td></tr>
				<tr><td class="detailProperty">Volume, MB:</td>
					<td><s:textfield name="computer.ram.volume"/></td></tr>
				<tr><td class="detailProperty">Frequency, MHz:</td>
					<td><s:textfield name="computer.ram.frequency"/></td></tr>
				
				<!-- Video card -->
				<tr><td colspan="2" class="detail headerRow">Video card</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.videoCard.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.videoCard.name"/></td></tr>
				<tr><td class="detailProperty">Socket:</td>
					<td><s:select list="videoCardSocketsList" name="videoCardSocket"/></td></tr>
				<tr><td class="detailProperty">Processor manufacturer:</td>
					<td><s:textfield name="computer.videoCard.processorManufacturer"/></td></tr>
				<tr><td class="detailProperty">Memory:</td>
					<td><s:select list="videoCardGraphicsMemoriesList" name="videoCardGraphicsMemory"/></td></tr>
				<tr><td class="detailProperty">Memory volume, MB:</td>
					<td><s:textfield name="computer.videoCard.memoryVolume"/></td></tr>
				
				<!-- HDD -->
				<tr><td colspan="2" class="detail headerRow">HDD</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.hdd.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.hdd.name"/></td></tr>
				<tr><td class="detailProperty">Formfactor:</td>
					<td><s:select list="hddFormfactorsList" name="hddFormfactor"/></td></tr>
				<tr><td class="detailProperty">Volume, MB:</td>
					<td><s:textfield name="computer.hdd.volume"/></td></tr>
				<tr><td class="detailProperty">Interface:</td>
					<td><s:select list="hddConnectionInterfacesList" name="hddConnectionInterface"/></td></tr>
				<tr><td class="detailProperty">Spindle speed, rpm:</td>
					<td><s:textfield name="computer.hdd.spindleSpeed"/></td></tr>
					
				<!-- Monitor -->
				<tr><td colspan="2" class="detail headerRow">Monitor</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.monitor.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.monitor.name"/></td></tr>
				<tr><td class="detailProperty">Diagonal, ":</td>
					<td><s:textfield name="computer.monitor.diagonal"/></td></tr>
				<tr><td class="detailProperty">Format:</td>
					<td><s:select list="monitorFormatsList" name="monitorFormat"/></td></tr>
				<tr><td class="detailProperty">Resolution:</td>
					<td><s:select list="monitorResolutionsList" name="monitorResolution"/></td></tr>
				<tr><td class="detailProperty">Matrix:</td>
					<td><s:select list="monitorMatrixesList" name="monitorMatrix"/></td></tr>
				
				<s:if test="clazz == 'Personal'">
				<!-- Keyboard -->
				<tr><td colspan="2" class="detail headerRow">Keyboard</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.keyboard.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.keyboard.name"/></td></tr>
				<tr><td class="detailProperty">Type:</td>
					<td><s:select list="keyboardTypesList" name="keyboardType"/></td></tr>
				<tr><td class="detailProperty">Interface:</td>
					<td><s:select list="keyboardConnectionInterfasesList" name="keyboardConnectionInterface"/></td></tr>
				
				<!-- Mouse -->
				<tr><td colspan="2" class="detail headerRow">Mouse</td></tr>
				<tr><td class="detailProperty">Manufacturer:</td>
					<td><s:textfield name="computer.mouse.manufacturer"/></td></tr>
				<tr><td class="detailProperty">Name:</td>
					<td><s:textfield name="computer.mouse.name"/></td></tr>
				<tr><td class="detailProperty">Type:</td>
					<td><s:select list="mouseTypesList" name="mouseType"/></td></tr>
				<tr><td class="detailProperty">Interface:</td>
					<td><s:select list="mouseConnectionInterfasesList" name="mouseConnectionInterface"/></td></tr>
				<tr><td class="detailProperty">Sensor:</td>
					<td><s:select list="mouseSensorsList" name="mouseSensor"/></td></tr>
				</s:if>
				
				<tr><td colspan="2"><hr/></td></tr>
				<tr>
					<td colspan="2" align="center">
						<s:submit action="addEditComputerAction" value="Save" onclick="setCancelButtonClicked(false);"/>
						<s:submit action="listComputersAction" value="Cancel" onclick="setCancelButtonClicked(true);"/>
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