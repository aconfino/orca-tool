<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<body>
<div id="header">
	<h1><a href="index.html">Orca<sup>1.0</sup></a></h1><img src="resources/images/icon.png" />
</div>
<div id="topLevelMenu">
	<ul>
		<li><a href="beginEvaluation.html">Begin an Evaluation</a></li>
		<li><a href="continueEvaluation.html">Continue Evaluation</a></li>
		<li><a href="#">Quick Start Guide</a></li>
		<li><a href="#">About Bubby Tootie</a></li>
		<li><a href="myAccount.html">My Account</a></li>
		<sec:authorize access="isAuthenticated()">
			<li><a href="j_spring_security_logout"> Logout</a></li>
		</sec:authorize>
	</ul>
</div>