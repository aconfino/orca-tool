<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
	<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Code Design</h2>
					<p>The <b>Code Design</b> metric achieved by a code review.  It is usually not practical or 
					necessary to examine every source file.  A sufficient code review can be performed 
					by identifying some key source files, such as the main bootstrapping class, and 
					drilling down into other classes from there.  It is important to “time box” the code 
					review activity, that is to restrict the code review time to a firm schedule to not allow 
					the process to continue endlessly.  Rate each key aspect of the code.  
					While there are many good resources available, <u>The Clean Coder: A Code of Conduct for Professional Programmers</u>
					is a top notch work on this topic.
					</p>
				</div>
				<div id="objectOrientedDescription" style="display:none;">Does the code adhere to object oriented best practices and principles?</div>
				<div id="understandabilityDescription" style="display:none;">Is the could easy to understand and logically laid out?</div>
				<div id="extensibilityDescription" style="display:none;">Can the code be easily extended and customized for future use?</div>
				<div id="testabilityDescription" style="display:none;">Is the code structured in such a way that it is easily unit tested?</div>	
				<div class="surveySliders">
				<form:form action="saveCodeDesign.html" commandName="codeDesign">
					<orca:targetSlider name="objectOriented" title="Object Oriented" value="${codeDesign.objectOriented}"/>				
					<orca:targetSlider name="understandability" title="Understandability" value="${codeDesign.understandability}"/>	
					<orca:targetSlider name="extensibility" title="Extensibility" value="${codeDesign.extensibility}"/>					    
					<orca:targetSlider name="testability" title="Testability" value="${codeDesign.testability}"/>
					<input name="surveyId" type="hidden" value="${survey.id}"/>
					<br><br>
					<input type="submit" name="submit" value="Next Metric" />  	or  
					<input type="submit" name="submit" value="Go to Summary" />				
				</form:form>
			</div>
		</div>
	</div>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>
