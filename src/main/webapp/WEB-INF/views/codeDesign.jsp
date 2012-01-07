<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
<div id="noRightRailContent">
	<div class="post">
			<div class="metricContent">
				<h2>Code Design</h2>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse tellus libero, luctus porta rhoncus eu, interdum et nisl. Proin sapien nisi, cursus quis mattis a, mattis non nibh. Aliquam erat volutpat. Nunc vitae tellus non dolor posuere consequat. Nullam scelerisque ipsum non enim hendrerit volutpat. Aenean nulla enim, facilisis eu luctus sit amet, facilisis sed tortor. Suspendisse ante leo, laoreet in suscipit et, viverra nec sapien. Mauris id laoreet purus. Duis nulla arcu, dapibus ac condimentum a, pretium vel orci. Nullam euismod est vitae libero commodo pulvinar. In ante metus, condimentum vel vulputate eget, tincidunt eget enim. Vivamus euismod, urna eu ornare bibendum, metus odio facilisis turpis, eu sollicitudin nunc lectus eu odio. Aenean fringilla, magna at adipiscing aliquam, nisl diam sodales eros, a vestibulum enim turpis eget enim. Integer non tortor eu lacus sodales bibendum. Proin imperdiet mollis elementum. Nulla vulputate mauris eget lacus euismod luctus. Nam a iaculis lectus. Maecenas dictum ante quis leo interdum aliquet. Integer facilisis molestie elit, in commodo ipsum ultrices a. 
			</div>
			<div id="objectOrientedDescription" style="display:none;">This is a description for the Object Oriented metric</div>
			<div id="understandabilityDescription" style="display:none;">This is a description for the Understandability metric</div>
			<div id="extensibilityDescription" style="display:none;">This is a description for the Extensibility metric</div>
			<div id="testabilityDescription" style="display:none;">This is a description for the Testability metric</div>	
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
</div>
<!-- end #content -->
<div style="clear: both; height: 40px;">&nbsp;</div>