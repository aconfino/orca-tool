<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
	<div id="content">
		<div class="post">
			<div class="entry">
				<h1>Create Account</h1>
					<form:form action="saveUser.html" commandName="user" >
						<span class="loginColumn">
							<form:label path="username">User name:</form:label>	
							<form:input path="username" />
							<form:errors path="username" cssClass="error" />
							<br><br> 
							<form:label path="password">Password:</form:label>	
							<form:password path="password" />
							<form:errors path="password" cssClass="error" />
							<br><br> 
							<form:label path="confirmPassword">Confirm Password:</form:label>	
							<form:password path="confirmPassword" />
							<form:errors path="confirmPassword" cssClass="error" />
							<br><br> 
							<input type="submit" name="submit" value="Create Account" />
						</span>
					</form:form>
			</div>
		</div>
	</div>
	<%@ include file="include/myAccountRightRail.jsp"%>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>