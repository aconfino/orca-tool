<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Documentation</h2>
					<p>
					Software documentation is a critical component to software fitness, and yet many open source software projects 
					have poor documentation.  There are many different types of documentation, and it is important to thoroughly 
					evaluate the documentation along with the actual source and binaries.  Documentation can be found in many places 
					including code comments, separate documentation files accompanying the software, help files within the application, 
					the project website, and message boards.
					</p>
				</div>
				<div id="userDocumentationDescription" style="display:none;">Does the software contain adequate documentation for the end user?</div>
				<div id="developerDocumentationDescription" style="display:none;">Does the software contain adequate documentation for developers?</div>
				<div id="codeCommentsDescription" style="display:none;">Does the code contain adequate and helpful comments?</div>
				<div id="installationDocumentationDescription" style="display:none;">Does the software contain adequate installation documentation?</div>
				<div id="administrationDocumentationDescription" style="display:none;">Does the software contain adequate administator documentation?</div>
				<div class="surveySliders">
					<form:form action="saveDocumentation.html" commandName="documentation" >
						<orca:targetSlider name="userDocumentation" title="User Documentation" value="${documentation.userDocumentation}"/>				
						<orca:targetSlider name="developerDocumentation" title="Developer Documentation" value="${documentation.developerDocumentation}"/>	
						<orca:targetSlider name="codeComments" title="Code Comments" value="${documentation.codeComments}"/>					    
						<orca:targetSlider name="installationDocumentation" title="Installation Documentation" value="${documentation.installationDocumentation}"/>					    
						<orca:targetSlider name="administrationDocumentation" title="Administration Documentation" value="${documentation.administrationDocumentation}"/>					    
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