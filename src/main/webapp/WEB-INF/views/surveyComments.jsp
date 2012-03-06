<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div id="content">
			<div class="post">
				<div class="entry">
					<p>Sed vel quam. Vestibulum pellentesque. Morbi sit amet magna ac lacus dapibus interdum. </p>
					<form:form action="saveSurveyComments.html" commandName="survey">
						<form:label path="comments">Comments:</form:label>
						<form:textarea path="comments" id="surveyComments"/><br><br>  
						<input name="surveyId" type="hidden" value="${survey.id}"/>
						<input type="submit" name="submit" value="Finish Survey" /> 		
					</form:form>
				</div>
			</div>
		</div>
 	</div>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>
