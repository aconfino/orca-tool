<%@ include file="include/JSTLsetup.jsp"%>

<div id="page">
<div id="content">
	<div class="post">	
		<div class="entry">			
			<form:form action="emailEvaluationVerify.html" commandName="emailEvaluationForm" >				
					<h2>Email an evaluation</h2>
					<div id="simpleCaptcha"><img src="/stickyImg" /></div><br/><br/>
					<form:label path="email">Email Address:</form:label>	
					<form:input path="email" />
					<form:errors path="email" cssClass="error" />
					<br><br> 
					<form:label path="answer">Security Image:</form:label>	
					<form:input path="answer" />
					<form:errors path="answer" cssClass="error" />
					<input name="evaluationNumber" type="hidden" value="${evaluation.number}">
					<br><br> 
						<input type="submit" name="submit" value="Send Email" />				
				</form:form>
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/myAccountRightRail.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>