<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<div id="content">
	<div class="post">
		<div class="entry">
			<h2>Are you sure you want to remove <c:out value="${evaluation.name}"/> ?</h2>
				<div class="removeEvaluation">
				<a href="removeEvaluationConfirmed.html?evaluationId=<c:out value="${evaluation.id}"/>">YES...that's why I clicked "remove".</a><br><br>
				<a href="myAccount.html?evaluationId">NOPE...I was just being dumb.</a> 
				</div>
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/myAccountRightRail.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>