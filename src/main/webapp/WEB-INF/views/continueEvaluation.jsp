<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/evaluationSubMenu.jsp"%>
<div id="content">
	<div class="post">
		<div class="entry">
		<c:if test="${evaluationNumber != null}">
			<h3>No results were found for evaluation number <c:out value="${evaluationNumber}"/>.</h3>
		</c:if>
			<p> Please enter your evaluation number to continue your software evaluation.  
			All public evaluations (those without an account) can be accessed by evaluation number.  
			Please note that if you wish to view a private evaluation you will need to
			log into your account.
			</p>
			<form action="getEvaluation.html" >
			  	<label for="evaluationNumber">Evaluation number:<</label>
				<input type="text" name="evaluationNumber" />
				<br><br>
				<input type="submit" value="Continue Evaluation" />
			</form>
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/aboutOrca.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>