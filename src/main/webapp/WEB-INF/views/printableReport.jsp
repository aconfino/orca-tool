<%@ include file="include/JSTLsetup.jsp"%>
<%@ include file="include/reportUrls.jspf"%>
<div id="printContainer">
	<div class="printHeader">
		<span id="printTitle">
			<h1><c:out value="Evaluation Name: ${evaluation.name}"/></h1>
			<form>
				<input type="button" onClick="window.print()" value="Print this page">
			</form>
		</span>
		<span id="printLogo"><img src="resources/images/orca_bw.gif" /></span>		
	</div>
	<div class="graph">
		<c:if test="${report.type == 'straightRadar'}">
			<p align="center"><img src="${StraightRadar}" width="600" height="400" alt=""  /></p>
		</c:if>	
		<c:if test="${report.type == 'curvedRadar'}">
			<p align="center"><img src="${CurvedRadar}" width="600" height="400" alt=""  /></p>
		</c:if>
		<c:if test="${report.type == 'barGraph'}">
			<p align="center"><img src="${ClassicBarGraph}" width="750" height="200" alt=""  /></p>
		</c:if>
		<c:if test="${report.type == 'overUnderBarGraph'}">
			<p align="center"><img src="${OverUnderBarGraph}" width="750" height="200" alt=""  /></p>
		</c:if>
	</div>
	<div class="evaluationDetails">
		<div class="printableColumn">
			<h2><c:out value="Evaluation Summary - ${evaluation.number}"/></h2>
			<div><c:out value="Name:  ${evaluation.name}"/></div>
			<div><c:out value="Functionality weight:  ${evaluation.functionalityWeight}"/></div>
			<div><c:out value="License weight: ${evaluation.licenseWeight}"/></div>
			<div><c:out value="Code weight:  ${evaluation.codeWeight}"/></div>
 			<div><c:out value="Velocity weight: ${evaluation.velocityWeight}"/></div>
	 		<div><c:out value="Pedigree weight: ${evaluation.pedigreeWeight}"/></div>
	 		<div><c:out value="Community weight: ${evaluation.communityWeight}"/></div>
			<div><c:out value="Market weight: ${evaluation.marketWeight}"/></div>
			<div><c:out value="Documentation weight: ${evaluation.documentationWeight}"/></div>
			<div><c:out value="Support weight: ${evaluation.supportWeight}"/></div>
		</div>
		<c:forEach var="survey" items="${evaluation.surveyList}">
			<div class="printableColumn">
				<h2><c:out value="${survey.surveyName}"/> Summary</h2>			
				<div><c:out value="Name: ${survey.surveyName}"/></div>
				<div><c:out value="Code Design: ${survey.codeDesign.calculatedValue}"/></div>
				<div><c:out value="Code Runtime: ${survey.codeRuntime.calculatedValue}"/></div>
				<div><c:out value="Code Static: ${survey.codeStatic.calculatedValue}"/></div>					
				<div><c:out value="Code Community: ${survey.community.calculatedValue}"/></div>
				<div><c:out value="Code Documentation: ${survey.documentation.calculatedValue}"/></div>
				<div><c:out value="Code License: ${survey.license.calculatedValue}"/></div>
				<div><c:out value="Market Penetration: ${survey.marketPenetration.calculatedValue}"/></div>
				<div><c:out value="Code Pedigree: ${survey.pedigree.calculatedValue}"/></div>
				<div><c:out value="Code Support: ${survey.support.calculatedValue}"/></div>
				<div><c:out value="Code Velocity: ${survey.velocity.calculatedValue}"/></div>
				<div><c:out value="Code Functionality: ${survey.functionality.calculatedValue}"/></div>
				<div><c:out value="Comments: ${survey.comments}"/></div>
			</div>
		</c:forEach>
	</div>
</div>