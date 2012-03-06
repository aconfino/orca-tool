<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/evaluationSubMenu.jsp"%>
<div id="content">
	<div class="post">
		<div class="entry">
		<c:if test="${evaluationNumber != null}">
			<h3>No results were found for evaluation number <c:out value="${evaluationNumber}"/>.</h3>
		</c:if>
			<form action="getEvaluation.html" >
			  	<label for="evaluationNumber">Evaluation number:<</label>
				<input type="text" name="evaluationNumber" />
				<br><br>
				<input type="submit" value="Continue Evaluation" />
			</form>
			<p>Sed vel quam. Vestibulum pellentesque. Morbi sit amet magna ac lacus dapibus interdum. Donec pede nisl, gravida iaculis, auctor vitae, bibendum sit amet, mauris. Cras adipiscing libero et risus. Donec rutrum tempus massa. Proin at mauris <a href="#">sed elit venenatis</a> porttitor. Morbi quam nisl, fringilla quis, sagittis nec, adipiscing at, elit. Maecenas sed sem sit amet lectus mattis molestie. Integer quis eros lorem ipsum dolor sit amet veroeros consequat.</p>
		</div>
	</div>
</div>
<!-- end #content -->
<%@ include file="include/aboutOrca.jsp"%>
<div style="clear: both; height: 40px;">&nbsp;</div>