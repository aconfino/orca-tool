<c:url value="emailEvaluation.html" var="emailEvaluation">
	<c:param name="evaluationNumber" value="${evaluation.number}"/>
</c:url>
<div id="sidebar">
	<ul>
		<li>
			<h2><c:out value="Evaluation number: ${evaluation.number}"/></h2>
				<p>You don't need to have an account, but you do need to save your evaluation number 
				so you can continue an evaluation later.  You can also email this evaluation to a 
				co-worker or colleage.  <a href="${emailEvaluation}">Email this evaluation</a>.
				</p>
		</li>
	</ul>
</div>