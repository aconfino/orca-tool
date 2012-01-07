<c:url value="addSurvey.html" var="addSurvey">
	<c:param name="evaluationId" value="${evaluation.id}"/>
</c:url>
<c:url value="reportSummary.html" var="reportSummary">
	<c:param name="evaluationId" value="${evaluation.id}"/>
</c:url>
<c:url value="emailEvaluation.html" var="emailEvaluation">
	<c:param name="evaluationNumber" value="${evaluation.number}"/>
</c:url>

<div id="evaluationSubMenu">
	<span id="submenu"><a href="${addSurvey}">create a new survey</a></span>
	<span id="submenu"><a href="${reportSummary}">generate reports</a></span>
	<span id="submenu"><a href="${emailEvaluation}">email an evaluation</a></span>
</div>
