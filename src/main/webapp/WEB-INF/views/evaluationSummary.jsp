<%@ include file="include/JSTLsetup.jsp"%>
<%@ include file="include/summarySubMenu.jsp"%>
<div id="page">
<div id="noRightRailContent">
	<div class="post">
		<div class="evaluationSummary">
			<c:url value="editEvaluation.html" var="editEvaluation">
				<c:param name="evaluationId" value="${evaluation.id}" />
			</c:url>
			<h2><c:out value="Evaluation Summary - ${evaluation.number}"/></h2>
			<div><c:out value="Name:  ${evaluation.name} - "/><a href="${editEvaluation}">edit</a></div>
			<div><c:out value="Functionality weight:  ${evaluation.functionalityWeight} - "/><a href="${editEvaluation}">edit</a></div>
			<div><c:out value="License weight: ${evaluation.licenseWeight} - "/><a href="${editEvaluation}">edit</a></div>
			<div><c:out value="Code weight:  ${evaluation.codeWeight} - "/><a href="${editEvaluation}">edit</a></div>
 			<div><c:out value="Velocity weight: ${evaluation.velocityWeight} - "/><a href="${editEvaluation}">edit</a></div>
 			<div><c:out value="Pedigree weight: ${evaluation.pedigreeWeight} - "/><a href="${editEvaluation}">edit</a></div>
 			<div><c:out value="Community weight: ${evaluation.communityWeight} - "/><a href="${editEvaluation}">edit</a></div>
			<div><c:out value="Market weight: ${evaluation.marketWeight} - "/><a href="${editEvaluation}">edit</a></div>
			<div><c:out value="Documentation weight: ${evaluation.documentationWeight} - "/><a href="${editEvaluation}">edit</a></div>
			<div><c:out value="Support weight: ${evaluation.supportWeight} - "/><a href="${editEvaluation}">edit</a></div>
		</div>
		<c:forEach var="survey" items="${evaluation.surveyList}">
			<%@ include file="include/surveyLinks.jspf"%>
			<div class="evaluationSummary">
				<h2><c:out value="${survey.surveyName}"/> Summary - <a href="${removeSurvey}">remove</a></h2>
					<div><c:out value="Name: ${survey.surveyName} - "/><a href="${editSurveyName}">edit</a></div>
					<div><c:out value="Code Design: ${survey.codeDesign.calculatedValue} - "/><a href="${editCodeDesign}">edit</a></div>
					<div><c:out value="Code Runtime: ${survey.codeRuntime.calculatedValue} - "/><a href="${editCodeRuntime}">edit</a></div>
					<div><c:out value="Code Static: ${survey.codeStatic.calculatedValue} -  "/><a href="${editCodeStatic}">edit</a></div>	
					<div><c:out value="Code Community: ${survey.community.calculatedValue} - "/><a href="${editCommunity}">edit</a></div>
					<div><c:out value="Code Documentation: ${survey.documentation.calculatedValue} - "/><a href="${editDocumentation}">edit</a></div>
					<div><c:out value="Code License: ${survey.license.calculatedValue} - "/><a href="${editLicense}">edit</a></div>
					<div><c:out value="Market Penetration: ${survey.marketPenetration.calculatedValue} - "/><a href="${editMarketPenetration}">edit</a></div>
					<div><c:out value="Code Pedigree: ${survey.pedigree.calculatedValue} - "/><a href="${editPedigree}">edit</a></div>
					<div><c:out value="Code Support: ${survey.support.calculatedValue} - "/><a href="${editSupport}">edit</a></div>
					<div><c:out value="Code Velocity: ${survey.velocity.calculatedValue} - "/><a href="${editVelocity}">edit</a></div>
					<div><c:out value="Code Functionality: ${survey.functionality.calculatedValue} - "/><a href="${editFunctionality}">edit</a></div>
					<div><c:out value="Comments: ${survey.comments} - "/><a href="${editComments}">edit</a></div>
		</div>
		</c:forEach>
	</div>
</div>
<!-- end #content -->
<div style="clear: both; height: 40px;">&nbsp;</div>