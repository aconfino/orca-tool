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
					<input type="submit" name="submit" value="Begin Metrics" />  	or  
					<input type="submit" name="submit" value="Go to Summary" />		
					</form:form>
				<p>Sed vel quam. Vestibulum pellentesque. Morbi sit amet magna ac lacus dapibus interdum. Donec pede nisl, gravida iaculis, auctor vitae, bibendum sit amet, mauris. Cras adipiscing libero et risus. Donec rutrum tempus massa. Proin at mauris <a href="#">sed elit venenatis</a> porttitor. Morbi quam nisl, fringilla quis, sagittis nec, adipiscing at, elit. Maecenas sed sem sit amet lectus mattis molestie. Integer quis eros lorem ipsum dolor sit amet veroeros consequat.</p>
			</div>
		</div>
	</div>
	<%@ include file="include/evaluationRightRail.jsp"%>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>
