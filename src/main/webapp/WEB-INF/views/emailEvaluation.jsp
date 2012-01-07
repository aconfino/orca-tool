<%@ include file="include/JSTLsetup.jsp"%>

<div id="page">
<div id="content">
	<div class="post">	
		<div class="entry">	
			<form action="emailEvaluationConfirmation.html" method="post" >
				<h2>Email an evaluation</h2>
				<label for="emailRecepient" >Email Address:</label>
				<input name="emailRecepient" id="emailRecepient"><br><br>  	
				<input name="evaluationNumber" type="hidden" value="${evaluation.number}">
				<input type="submit" name="submit" value="Submit" /><br><br>			
			</form>	
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/myAccountRightRail.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>