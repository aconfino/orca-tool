<%@ include file="include/JSTLsetup.jsp"%>

<div id="page">
<div id="content">
	<div class="post">	
		<div class="entry">			
			<form:form action="changePasswordVerify.html" commandName="user" >				
					<h2>Change your password</h2>
					<form:label path="password">Password:</form:label>	
					<form:password path="password" />
					<form:errors path="password" cssClass="error" />
					<br><br> 
					<form:label path="confirmPassword">Confirm Password:</form:label>	
					<form:password path="confirmPassword" />
					<form:errors path="confirmPassword" cssClass="error" />
					<br><br> 
						<input type="submit" name="submit" value="Change password" />
					<a href="myAccount.html">Return to account</a>		
				</form:form>
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/myAccountRightRail.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>