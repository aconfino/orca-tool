<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Community</h2>
					<p>
					An open source project benefits greatly from an involved user community beyond the project's authors.  
					A vibrant community is a good sign of project health.  Signs of a good community include an updated 
					website, an active mailing list, and active message board or Wiki where information between 
					community members is being exchanged.  
					</p>
				</div>
				<div id="websiteDescription" style="display:none;">Is the project site updated on a regular basis?</div>
				<div id="mailingListDescription" style="display:none;">Does the project have an active mailing list?</div>
				<div id="bugTrackerDescription" style="display:none;">Does the project activity track and fix bugs?</div>
				<div class="surveySliders">
					<form:form action="saveCommunity.html" commandName="community" >
						<orca:targetSlider name="website" title="Website" value="${community.website}"/>				
						<orca:targetSlider name="mailingList" title="Mailing List" value="${community.mailingList}"/>	
						<orca:targetSlider name="bugTracker" title="Bug Tracker" value="${community.bugTracker}"/>					    
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