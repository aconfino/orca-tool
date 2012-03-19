<%@ include file="include/JSTLsetup.jsp"%>
<div id="page">
	<%@ include file="include/surveySubMenu.jsp"%>
	<div id="noRightRailContent">
		<div class="post">
			<div class="metricContent">
				<h2>Code Runtime</h2>
				<p>The runtime analysis metric can be one of the more difficult metrics to capture.  Runtime analysis may require a custom 
				test program, a load generator, test data, instrumentation to gather the metrics, and an isolated test environment.  In addition, 
				the thresholds used for runtime analysis are highly dependent on the specific situation so even general guidelines are not 
				possible.
				</p>
				<p>The runtime analysis submetric is often omitted from evaluations because it is prohibitively time consuming to calculate.  
				If your project will be deployed in a highly demanding environment, the time investment in this metric could be well worth it.  
				We recommend using Bad Boy to record tests and Apache JMeter to generate load.  Recommended Tools:  <a href="http://www.badboy.com.au/">BadBoy </a> 
				and <a href="http://jmeter.apache.org/">Apache JMeter</a>
				  
				</p>
			</div>
			<div id="cpuThreshholdDescription" style="display:none;">Does the code remain under a specific CPU threshhold while under load?</div>
			<div id="memoryThreshholdDescription" style="display:none;">Does the code remain under a specific memory threshhold while under load?</div>
			<div id="IOThreshholdDescription" style="display:none;">Does the code remain under a specific IO threshhold while under load?</div>		
			<div class="surveySliders">
			<form:form action="saveCodeRuntime.html" commandName="codeRuntime" >
				<orca:targetSlider name="cpuThreshhold" title="CPU Threshhold" value="${codeRuntime.cpuThreshhold}"/>				
				<orca:targetSlider name="memoryThreshhold" title="Memory Threshhold" value="${codeRuntime.memoryThreshhold}"/>	
				<orca:targetSlider name="IOThreshhold" title="IO Threshhold" value="${codeRuntime.IOThreshhold}"/>					    
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
