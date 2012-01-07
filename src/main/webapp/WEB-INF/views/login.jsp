<%@ include file="include/JSTLsetup.jsp"%>

<div id="page">
<div id="content">
	<div class="post">	
		<div class="entry">
			<c:if test="${not empty param.errors}">
 				<span class="loginError"><h3>We're sorry. Your user name \ password combination was not found.</h3></span>
 			</c:if>		
			<form action="<c:url value='j_spring_security_check' />" method="post" >
				<span class="loginColumn">
				<h2>Login</h2>
				<label path="username">User name:</label>	
				<input name="j_username"></input><br><br> 
				<label path="password">Password:</label>	
				<input type="password" name="j_password"></input><br><br> 
				<input type="submit" name="submit" value="Submit" /><br><br>
				</span>		
			</form>
			<span class="loginColumn">
				<form action="createAccount.html" method="post" >	
				<h2>Create An Account</h2>
				<input type="submit" name="submit" value="Create An Account" />
				</form>
			</span>	
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/myAccountRightRail.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>