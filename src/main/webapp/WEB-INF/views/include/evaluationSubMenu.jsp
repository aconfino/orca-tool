<c:url value="surveyComments.html" var="editComments">
	<c:param name="evaluationId" value="${evaluation.id}"/>
</c:url>
<c:url value="editEvaluation.html" var="editEvaluation">
	<c:param name="evaluationId" value="${evaluation.id}"/>
</c:url>
<c:url value="evaluationSummary.html" var="evaluationSummary">
	<c:param name="evaluationId" value="${evaluation.id}"/>
</c:url>
<span id="submenu"><a href="beginEvaluation.html">create new evaluation</a></span>
<span id="submenu"><a href="${editEvaluation}">edit evaluation</a></span>
<span id="submenu"><a href="${evaluationSummary}">go to evaluation summary</a></span>


