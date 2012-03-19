<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/evaluationSubMenu.jsp"%>
<div id="content">
	<div class="post">
		<div class="entry">
			<form:form action="evaluationWeight.html" commandName="evaluation" >
				<%@ include file="include/evaluationNameInput.jspf"%>
				<p>Give your evaluation a name -- for example -- <i>Mobile Framework Evaluation</p>
				<input type="submit" value="Start evaluation" />
			</form:form>
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/evaluationRightRail.jsp"%>
	<div style="clear: both; height: 0px;">&nbsp;</div>
</div>
