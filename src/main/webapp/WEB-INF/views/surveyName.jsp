<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="content">
		<div class="post">
			<div class="entry">
				<form:form action="saveSurveyName.html" commandName="survey">
					<form:label path="surveyName">Survey name:</form:label>	
					<form:input path="surveyName" /><br><br>  
					<input name="surveyId" type="hidden" value="${survey.id}"/>
					<p>Give your survey a name -- for example -- <i>JQuery mobile framework.  
					Once you create a software survey, you can begin to evaluate it's software metrics.  
					Create multiple software surveys and compare them against each other with our 
					reporting tooling.</p>
					<input type="submit" name="submit" value="Begin Metrics" />  	or  
					<input type="submit" name="submit" value="Go to Summary" />		
					</form:form>
			</div>
		</div>
	</div>
	<%@ include file="include/evaluationRightRail.jsp"%>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>
