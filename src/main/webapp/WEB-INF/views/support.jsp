<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Support</h2>
					<p>It is also important to consider the aspect of support, both commercial and community, 
					available for the open source software under evaluation.  Commercial support may be provided by the author of 
					software or by a third party company.  While commercial support offerings vary, they generally include technical 
					support, such as answering questions and providing bug fixes, and indemnification.</p>  
					<p>Indemnification is legal or financial protection provided in the case of another party suing for intellectual property infringement or violating
					 licensing terms of the open source software.  Such indemnification gives organizations an extra measure of risk 
					 mitigation.</p>
					 <p>Community support is free support provided by the software's developers and by the user community.  
					 Evidence of community support is usually found on the project's website, mailing lists, defect tracking systems, 
					 and message boards.</p>
					
				</div>
				<div id="commercialSupportDescription" style="display:none;"> Commercial support may be provided by the author of software or by a third party company.</div>
				<div id="indemnificationDescription" style="display:none;">Indemnification is legal or financial protection provided in the case of another party suing for intellectual property infringement or violating
					 licensing terms of the open source software.</div>
				<div id="communitySupportDescription" style="display:none;">Community support is free support provided by the software's developers and by the user community.  
					 Evidence of community support is usually found on the project's website, mailing lists, defect tracking systems, 
					 and message boards.</div>
				<div class="surveySliders">
					<form:form action="saveSupport.html" commandName="support" >
						<orca:targetSlider name="commercialSupport" title="Commercial Support" value="${support.commercialSupport}"/>				
						<orca:targetSlider name="indemnification" title="Indemnification" value="${support.indemnification}"/>				
						<orca:targetSlider name="communitySupport" title="Community Support" value="${support.communitySupport}"/>				
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