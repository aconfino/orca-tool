<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/evaluationSubMenu.jsp"%>
<div id="noRightRailContent">
	<div class="post">
		<form:form action="saveEvaluationWeight.html" commandName="evaluation" >
			<div class="evaluationSliders">
				<%@ include file="include/weightSliderLeft.jspf"%>
			</div>
			<div class="evaluationSliders">
				<%@ include file="include/weightSliderRight.jspf"%>
				<br><br>
				<input name="evaluationId" type="hidden" value="${evaluation.id}"/>
				<input type="submit" name="submit" value="Continue Survey" />  	or  
				<input type="submit" name="submit" value="Go to Summary" />		
			</div>
		</form:form>
	</div>
</div>
</div>
<!-- end #content -->
<div style="clear: both; height: 40px;">&nbsp;</div>