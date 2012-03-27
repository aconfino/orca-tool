<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Velocity</h2>
					<p>
					It is important to determine if an open source project is a healthy, growing project, or a stagnant, dying project.  
					Many open source projects grow stagnant after the initial author moves on to something else.   Release frequency
					 if often an accurate indicator of a project's velocity.
					 </p>
					 <p>
					 A healthy project will have regular software releases and a fairly constant pace.  
					Long periods of time without a release generally indicate a problem.  New major releases introduce a large 
					quantity of new features and potentially break backwards compatibility.  Minor releases add some new features, 
					but remain backward compatible with other minor releases.  Patch releases contain only bug fixes.  
					Totaling the major and minor releases per year indicates how quickly a project is adding new features.  
					Totaling the patch releases per year indicates how quickly a project is fixing bugs.
					</p>
					<p>
					There are multiple sources for gathering data about an open source project's releases including:
					</p>
						<ol>
							<li>A download page on the project's website will list at least the most current releases.</li>
							<li>A change log is often included in the current releases, and it often lists old releases.</li>
							<li>Repositories such as the Maven central repository (<a href="http://search.maven.org/#browse/">http://search.maven.org/#browse</a>) have release information that may extend back even further than what it available on a project's web site.</li>
							<li>The source code repository often will have labels or tags that indicate releases.</li>
						</ol>				
				</div>
				<div id="featureActualDescription" style="display:none;">Totaling the major and minor releases per year indicates how quickly a project is adding new features.  Indicate if this project has an adequate feature release schedule.</div>
				<div id="patchActualDescription" style="display:none;">Totaling the patch releases per year indicates how quickly a project is fixing bugs.  Indicate if this project release patches in a adequate time frame. </div>
				<div class="surveySliders">
					<form:form action="saveVelocity.html" commandName="velocity" >
						<orca:targetSlider name="featureActual" title="Features" value="${velocity.featureActual}"/>				
						<orca:targetSlider name="patchActual" title="Patches" value="${velocity.patchActual}"/>				
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