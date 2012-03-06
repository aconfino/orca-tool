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
	<div id="evaluationWeightDescription" style="display:none;">Use this slider to weight metrics that are the most important to your evaluation.  If this is a key metric to your evaluation, give it a higher value.  Conversly, you can lower other metrics than are not as important.</div>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>