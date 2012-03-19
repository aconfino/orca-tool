<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
	<%@ include file="include/evaluationSubMenu.jsp"%>
	
	<div id="noRightRailContent">
		<div class="post">
		<div class="evaluationContent">
		<h2>Evaluation Weighting</h2>
		Your evaluation can be weighted to give priority to metrics that are important
		to your particular project.  Evaluation weightings help customize survey scores
		more appropriately.  If you are a new user, you can leave the default settings and
		easily adjust them later.  
		<i>Also please note that all code metrics (Code Design, Code Runtime, and Code Static) are 
		affected by the code quality weighting.</i>
		</div>
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
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>
