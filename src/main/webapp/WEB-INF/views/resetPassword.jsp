<%@ include file="include/JSTLsetup.jsp"%>

<div id="page">
	<div id="content">
		<div class="post">
			<div class="entry">
				<form:form action="resetPasswordVerify.html" commandName="resetPasswordForm" >
					<h2>Reset your password</h2>
					<div id="simpleCaptcha"><img src="/stickyImg" /></div><br/><br/>
					<form:label path="email">Email Address:</form:label>
					<form:input path="email" />
					<form:errors path="email" cssClass="error" />
					<br><br>
					<form:label path="answer">Security Image:</form:label>
					<form:input path="answer" />
					<form:errors path="answer" cssClass="error" />
					<br><br>
					<input type="submit" name="submit" value="Reset my password" />
				</form:form>
			</div>
		</div>
	</div>
<!-- end #content -->
<%@ include file="include/myAccountRightRail.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>