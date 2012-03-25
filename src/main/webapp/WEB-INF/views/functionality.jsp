
<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Functionality</h2>
					<p>
					It is important to determine whether the open source software possesses the required features.  
					There is no magic formula that can determine whether software meets its requirements, but by using 	
					the same standard to evaluate multiple products some objective comparisons can be drawn.
					</p>
					<p>
					It is recommended that evaluators create a list of both functional and non-functional features should be included.  
					Examples of non-functional features include operating system and hardware requirements, meeting relevant standards, 
					data exchange formats such as XML, communication protocols such as Internet Inter-Orb Protocol (IIOP), and 
					database integration.
					</p>
					<p>The functionality criterion represents the percentage of desired features that software possesses.  A 100% feature satisfaction rate is not always necessary for an open source software solution to be adopted since missing features can be implemented by the adopting organization.  
					</p>

				</div>
				<div id="featureScoreDescription" style="display:none;">The feature score represents the percentage of desired features that the software possesses.  Does this software have an adequate feature set?</div>
				<div class="surveySliders">
					<form:form action="saveFunctionality.html" commandName="functionality" >
						<orca:targetSlider name="featureScore" title="Features" value="${functionality.featureScore}"/>				
						<br><br>
						<input name="surveyId" type="hidden" value="${survey.id}"/>
						<input type="submit" name="submit" value="Next Metric" />  	or  
						<input type="submit" name="submit" value="Go to Summary" />				
					</form:form>
				</div>
		</div>
	</div>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>