<%@ include file="include/JSTLsetup.jsp"%>

<div id="page">
<div id="content">
	<div class="post">	
		<div class="entry">	
			<div class="changePasswordContainer">
				<form:form action="changePasswordVerify.html" commandName="user" >				
						<h2>Change your password</h2>
						<span class="basicForm">						
							<form:password path="password" />
							<form:label path="password">Password:</form:label>	
							<form:errors path="password" cssClass="error" />
							<br><br> 
							<form:password path="confirmPassword" />
							<form:label path="confirmPassword">Confirm Password:</form:label>	
							<form:errors path="confirmPassword" cssClass="error" />
							<br><br>					
							<input type="submit" name="submit" id="button" value="Change password" />
							<a href="myAccount.html" id="button">Return to account</a>		
						</span>
					</form:form>
			</div>
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/myAccountRightRail.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>