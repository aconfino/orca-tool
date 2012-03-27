<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
	<%@ include file="include/reportSubMenu.jspf"%>
	<%@ include file="include/reportUrls.jspf"%>
	<div id="noRightRailContent">
		<div class="post">
			<span class="reportControls">
				<h2>Report Summary</h2>
				Use our reporting tool to compare the strengths and weaknesses of each software survey.
				  Once you generate the report, you can print the graph and summary scores using the link
				  below the graph.
				<br><br><br>
				Select the type of graph:
				<form:form action="viewGraph.html" method="POST" commandName="reportForm">
					<input name="evaluationId" type="hidden" value="${evaluation.id}"/>
						<form:select path="type">
						<form:option value="straightRadar" selected="selected">Straight Radar Graph</form:option>
						<form:option value="curvedRadar">Curved Radar Graph</form:option>
						<form:option value="barGraph">Bar Graph</form:option>
						<form:option value="overUnderBarGraph">Over Under Bar Graph</form:option>
						</form:select>
					<br/>
					Select surveys to include:
					<br/>
					<form:select path="firstSurveyId">
						<form:option value="">Select</form:option>
						<form:options items="${surveyList}" itemValue="id" itemLabel="surveyName" />		
					</form:select>
					<br/>
					<c:if test="${fn:length(surveyList) > 1}">
						<form:select path="secondSurveyId">
							<form:option value="">Select</form:option>
							<form:options items="${surveyList}" itemValue="id" itemLabel="surveyName" />
						</form:select>
						<br/>
					</c:if>
					<c:if test="${fn:length(surveyList) > 2}">
						<form:select path="thirdSurveyId">
							<form:option value="">Select</form:option>		
							<form:options items="${surveyList}" itemValue="id" itemLabel="surveyName" />
						</form:select>
						<br/>
					</c:if>
					<c:if test="${fn:length(surveyList) > 3}">
						<form:select path="fourthSurveyId">
							<form:option value="">Select</form:option>	
							<form:options items="${surveyList}" itemValue="id" itemLabel="surveyName" />
						</form:select>
					</c:if>
					<input type="submit"  name="submit"  value="Generate Graph">			
				</form:form>			
			</span>
			<span class="reports">
				<c:if test="${report.type == 'straightRadar'}">
					<img src="${StraightRadar}" width="600" height="400" alt="" />
					<p><a href="printableGraph.html" target="_blank">Printer friendly summary</a></p>
				</c:if>	
				<c:if test="${report.type == 'curvedRadar'}">
					<img src="${CurvedRadar}" width="600" height="400" alt="" />
					<p><a href="printableGraph.html" target="_blank">Printer friendly summary</a></p>
				</c:if>
				<c:if test="${report.type == 'barGraph'}">
					<img src="${ClassicBarGraph}" width="750" height="200" alt="" />
					<p><a href="printableGraph.html" target="_blank">Printer friendly summary</a></p>
				</c:if>
				<c:if test="${report.type == 'overUnderBarGraph'}">
					<img src="${OverUnderBarGraph}" width="750" height="200" alt="" />
					<p><a href="printableGraph.html" target="_blank">Printer friendly summary</a></p>
				</c:if>
			</span>
		</div>
	</div>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>
