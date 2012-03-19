<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
				<div class="metricContent">
					<h2>Code Static</h2>
					<p>A static analysis is performed by running tools to calculate metrics, and then evaluating those metrics.  While the metrics themselves are completely objective, the analysis of the metrics is subjective.  It is generally accepted that a lower number is better, but there is not a clear cut upper limit that defines when a block of code is bad.</p>
					<p><b>Cyclomatic Complexity</b> -- Number of execution paths through a block of code.  The higher the number of paths, the more difficult the code is to write, test, and maintain.  Recommended Tool:  <a href="http://www.kclee.de/clemens/java/javancss/">JavaNCSS</a></p>
					<p><b>Method Count</b>  --  Number of methods in a class.  Classes with too many methods are difficult to write, test, and maintain.  Recommended Tool:  <a href="http://www.kclee.de/clemens/java/javancss/">JavaNCSS</a></p>
					<p><b>Dependency Cycles</b>  --  One package depends on a second package which in turn depends on the first package.  Dependency cycles mean packages are tightly coupled which means the packages must always be developed and released together.  Cycles should always be avoided. Recommended Tool:  <a href="http://clarkware.com/software/JDepend.html">JDepend</a></p>

				</div>
				<div id="cyclomaticComplexityDescription" style="display:none;">This is a description for the Cyclomatic Complexity metric</div>
				<div id="methodCountDescription" style="display:none;">This is a description for the Method Count metric</div>
				<div id="dependencyCyclesDescription" style="display:none;">This is a description for the Dependency Cycles metric</div>			
				<div class="surveySliders">
					<form:form action="saveCodeStatic.html" commandName="codeStatic" >
						<orca:targetSlider name="cyclomaticComplexity" title="Cyclomatic Complexity" value="${codeStatic.cyclomaticComplexity}"/>				
						<orca:targetSlider name="methodCount" title="Method Count" value="${codeStatic.methodCount}"/>	
						<orca:targetSlider name="dependencyCycles" title="Dependency Cycles" value="${codeStatic.dependencyCycles}"/>					    
						<input name="surveyId" type="hidden" value="${survey.id}"/>
						<br><br>
						<input type="submit" name="submit" value="Next Metric" />  	or  
						<input type="submit" name="submit" value="Go to Summary" />				
					</form:form>
				</div>
		</div>
	</div>
	<div style="clear: both; height: 40px;">&nbsp;</div>
</div>