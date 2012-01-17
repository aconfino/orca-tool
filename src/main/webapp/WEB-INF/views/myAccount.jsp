<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<div id="content">
	<div class="post">
		<div class="entry">
			<h2>My Account</h2>
				<h3>Email:  <c:out value="${user.username}"/> - <a href="changePassword.html">change password</a></h3>
			<div class="evaluationList">	
			<h2>My Evaluations</h2>
				<ol>
					<c:forEach var="evaluation" items="${user.evaluationSet}">
					<li>
						<c:out value="${evaluation.name}"/> - <a href="evaluationSummary.html?evaluationId=<c:out value="${evaluation.id}"/>">Go to Summary</a> - <a href="editEvaluation.html?evaluationId=<c:out value="${evaluation.id}"/>">Edit</a> - <a href="removeEvaluation.html?evaluationId=<c:out value="${evaluation.id}"/>">Remove </a>
					</li>
					</c:forEach>
				</ol>
			</div>
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/myAccountRightRail.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>