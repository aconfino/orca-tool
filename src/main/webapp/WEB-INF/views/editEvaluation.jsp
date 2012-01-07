<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/evaluationSubMenu.jsp"%>
<div id="noRightRailContent">
	<div class="post">
		<form:form action="saveEvaluation.html" commandName="evaluation" >
			<div class="evaluationSliders">
				<%@ include file="include/evaluationNameInput.jspf"%>
				<%@ include file="include/weightSliderLeft.jspf"%>
			</div>
			<div class="evaluationSliders">
				<%@ include file="include/weightSliderRight.jspf"%>
				<br><br>
				<input type="submit" name="submit" value="Save" />
			</div>
		</form:form>
	</div>
</div>
</div>
<!-- end #content -->
<div style="clear: both; height: 40px;">&nbsp;</div>